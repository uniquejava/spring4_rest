package com.learn.cms.site.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learn.cms.site.util.CmsConstants;

/**
 * This controller will be handled by SecurityInterceptor first.
 * 
 * @author cyper
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * this goes to the back-end home page.
	 * 
	 * @param model
	 * @return
	 */	
	@RequestMapping(value = "")
	public String index(ModelMap model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		model.addAttribute("time", time);

		return "admin/index";
	}

	/**
	 * The logout.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute(CmsConstants.SESS_USER_KEY);
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "ajaxTimeout", method = RequestMethod.GET)
	public void ajaxTimeout() {
		// you should be blocked by SecurityInterceptor and won't come here.
	}

}
