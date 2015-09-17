package com.wssht.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wssht.entity.TestEntity;
import com.wssht.service.TestService;

@Controller("testAction")
// spring管理注解
@Scope("prototype")
// 多态
public class TestAction extends ActionSupport implements ServletRequestAware {

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

		testService.save(testEntity);
		System.out.println("-------------------" + request);
		System.out.println("-------------------" + testEntity.getId());
		System.out.println("-------------------" + testEntity.getAge());
		System.out.println("-------------------" + testEntity.getName());
		return SUCCESS;
	}

	
	public String loadAll() {
		List<TestEntity> TestEntitys = testService.loadAll();


		List<TestEntity> TestEntitys2 = testService.loadAll();

		for (TestEntity testEntity : TestEntitys) {
			System.out.println("--11--"+testEntity.getId());
			System.out.println("--11--"+testEntity.getName());
		}
		for (TestEntity testEntity1 : TestEntitys2) {
			System.out.println("--22--"+testEntity1.getId());
			System.out.println("--22--"+testEntity1.getName());
		}
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	

}
