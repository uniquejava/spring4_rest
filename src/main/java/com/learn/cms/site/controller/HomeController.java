package com.learn.cms.site.controller;

import com.learn.cms.site.model.Admin;
import com.learn.cms.site.service.AdminService;
import com.learn.cms.site.util.CmsConstants;
import com.learn.cms.site.util.MD5Util;
import com.learn.cms.site.util.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * This controller bypass SecurityInterceptor, because the URL not begin with
 * `/admin`, it's a ROOT controller.<br>
 * 
 * When a class level RequestMapping is provided, it specifies a prefix to the
 * URL at method level.
 * 
 * @author cyper
 * 
 */
@Controller
@RequestMapping("/")
public class HomeController {
	/**
	 * use Slf4j API here instead of log4j API, because SLF4j is the interface.
	 */
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AdminService adminService;

	/**
	 * the URL at method level may or may not begin with a slash, their effect
	 * is the same.<br>
	 * This url/value will be appended to the url/value at class level.
	 * 
	 * @return
	 */
	@RequestMapping(value = "")
	public String index() {
		return "index";
	}

	/**
	 * the default view name is URL pattern specified in RequestMapping, so the
	 * handler method does not require a return value, recommend we specify the
	 * return value explicitly.
	 * 
	 * @deprecated not recommended.
	 */
	@RequestMapping(value = "test")
	public void test() {
		// this method will go to /pages/test.jsp
	}

	/**
	 * this goes to the login page.
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = GET)
	public String login() {
		logger.debug("GET /login");
		return "login";
	}

	/**
	 * This method process user's login.
	 * 
	 * @param user
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login", method = POST)
	public @ResponseBody
	Result doLogin(@RequestParam String user, @RequestParam String pwd, HttpSession session) {
		boolean loginOk = false;
		if (StringUtils.isNotBlank(user) && StringUtils.isNotBlank(pwd)) {

			try {

				// mimic unexpected system exception here
				if (new Random().nextBoolean()) {
					Thread.sleep(1000);
					throw new Exception("bad luck, try again.");
				}

				// check from the database.
				Admin admin = adminService.findById(1L);
				pwd = MD5Util.md5Encode(pwd);

				if (user.equals(admin.getAdminUser()) && pwd.equals(admin.getAdminPwd())) {
					session.setAttribute(CmsConstants.SESS_USER_KEY, admin);
					loginOk = true;
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);

				return Result.error("Login failed:" + e.getMessage());
			}
		}

		if (loginOk) {
			return Result.OK;
		} else {
			return Result.error("Invalid credentials.");
		}
	}
}
