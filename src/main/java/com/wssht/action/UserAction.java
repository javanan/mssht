package com.wssht.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wssht.entity.UserEntity;
import com.wssht.service.UserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ServletRequestAware{

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


	@Resource(name="userService")
	private UserService userService;
	
	public String login(){
		if(userService.login(user)!=null){
			return "adminok";
		}else{
			return "adminerr";
		}
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

}
