package com.wssht.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wssht.entity.TestEntity;
import com.wssht.service.TestService;

@Controller("testAction")//spring管理注解
@Scope("prototype") //多态
public class TestAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TestService testService;

	private TestEntity testEntity;

	private HttpServletRequest request;

	public TestEntity getTestEntity() {
		return testEntity;
	}

	public void setTestEntity(TestEntity testEntity) {
		this.testEntity = testEntity;
	}

	public String find() {
		testService.query();
		System.out.println("-------------------" + request);
		System.out.println("-------------------" + testEntity.getId());
		System.out.println("-------------------" + testEntity.getAge());
		System.out.println("-------------------" + testEntity.getName());
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}



}
