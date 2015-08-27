package com.wssht.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.wssht.entity.TestEntity;
import com.wssht.service.TestService;

public class TestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private TestService testService;
	
	private TestEntity testEntity;
	
	
	

	public TestEntity getTestEntity() {
		return testEntity;
	}




	public void setTestEntity(TestEntity testEntity) {
		this.testEntity = testEntity;
	}




	public String find() {
		testService.query();
		System.out.println(testEntity.getId());
		System.out.println(testEntity.getAge());
		System.out.println(testEntity.getName());
		return SUCCESS;
	}

}
