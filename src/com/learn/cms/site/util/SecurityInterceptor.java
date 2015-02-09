package com.learn.cms.site.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.cms.site.model.Admin;
import com.learn.cms.site.service.AdminService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * This security interceptor will intercept http request coming from browser or mobile if
 * the request url starts with '/admin'. It will send a json response if
 * request comes from ajax or mobile, otherwise it will send a login page.
 *
 * @author cyper
 *
 */
@Service
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

	@Autowired
	private AdminService adminService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("=============== headers start ============");
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			logger.debug("{}:{}", header, request.getHeader(header));
		}
		logger.debug("=============== headers end ============");

		String ajaxHeader = request.getHeader("x-requested-with");
		logger.debug("x-requested-with=" + ajaxHeader);

		String authHeader = request.getHeader("Authorization");
		logger.debug("Authorization=" + authHeader);

		HttpSession session = request.getSession(true);
		Object userObj = session.getAttribute(CmsConstants.SESS_USER_KEY);

		if (userObj == null) {
			logger.debug("userObj is null.");

			// handle AJAX request from browser
			if ("XMLHttpRequest".equalsIgnoreCase(ajaxHeader)) {
				logger.debug("Ajax request.");

				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(Result.error("session is timeout."));
				response.setHeader("Content-Type", "application/json");

				try {
					response.getOutputStream().write(jsonString.getBytes());
				} catch (IOException e) {
					logger.error("This could never happen.", e);
				}

				return false;

				// handle BASIC authentication, this could come from either
				// RESTClient or mobile device.
			} else if (authHeader != null) {
				final int index = authHeader.indexOf(' ');
				if (index > 0) {
					final String[] credentials = StringUtils.split(
							new String(Base64.decodeBase64(authHeader.substring(index)), "UTF-8"), ':');

					String user = credentials[0];
					String pwd = credentials[1];

					// check from the database.
					Admin admin = adminService.findById(1L);
					pwd = MD5Util.md5Encode(pwd);

					if (user.equals(admin.getAdminUser()) && pwd.equals(admin.getAdminPwd())) {
						return true;
					} else {

						return false;
					}

				}

				return false;

			} else {

				logger.debug("Browser request.");
				logger.debug("FORWARD /login");

				// this will dispatch to HomeController.login(..)
				request.getRequestDispatcher("/login").forward(request, response);

				// or you can just go to the jsp page directly.
				// request.getRequestDispatcher("/pages/login.jsp").forward(request,
				// response);

				return false;
			}

		} else {

			// the session has user object, pass.

			return true;
		}

	}
}
