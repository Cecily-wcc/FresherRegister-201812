package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.User;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(User user, HttpSession s) {
		if (user.equals(null)) // 确保user对象非空以免后续抛异常
			return "login";
		
		User return_user = userService.userCheck(user);

		// 判断数据库返回对象与表单提交对象密码一致
		if (return_user.getPwd().equals(user.getPwd())) {// 登录成功
			s.setAttribute("uid", user.getUid());
			if(user.getUid().equals("管理员用户"))return "redirect:/xxx/yyy";
			return "redirect:此处由你来完成 填你要跳的下一层 也可直接返回网页名字符串";
		} else {
			s.setAttribute("msg", "error");// 用户名不存在或密码错误
			return "login";
		}
	}
}
