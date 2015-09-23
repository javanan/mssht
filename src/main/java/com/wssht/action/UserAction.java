package com.wssht.action;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.wssht.entity.UserEntity;
import com.wssht.service.UserService;
import com.wssht.utils.ResponseUtil;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	private UserEntity user;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Resource(name = "userService")
	private UserService userService;

	public String login() {
		UserEntity currUser = userService.login(user);
		if (currUser != null) {
			request.getSession().setAttribute("currUser", currUser);
			return "adminok";
		} else {
			return "adminerr";
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String modifyPassword() throws IOException {
		UserEntity u = userService.getUserById(user.getUserid());
		u.setPassword(user.getPassword());
		userService.save(u);
		Gson gson = new Gson();
		HashMap<String, Boolean> ret = new HashMap<String, Boolean>();
		ret.put("success", true);
		String reString = gson.toJson(ret);
		ResponseUtil.write(ServletActionContext.getResponse(), reString);
		return null;
	}
}
