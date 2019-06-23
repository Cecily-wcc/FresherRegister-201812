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
		if (user.equals(null)) // ȷ��user����ǿ�����������쳣
			return "login";
		
		User return_user = userService.userCheck(user);

		// �ж����ݿⷵ�ض�������ύ��������һ��
		if (return_user.getPwd().equals(user.getPwd())) {// ��¼�ɹ�
			s.setAttribute("uid", user.getUid());
			if(user.getUid().equals("����Ա�û�"))return "redirect:/xxx/yyy";
			return "redirect:�˴���������� ����Ҫ������һ�� Ҳ��ֱ�ӷ�����ҳ���ַ���";
		} else {
			s.setAttribute("msg", "error");// �û��������ڻ��������
			return "login";
		}
	}
}
