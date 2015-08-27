package com.wssht.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wssht.entity.TestEntity;
import com.wssht.service.TestService;


@Service("testService")
public class TestServiceImpl implements TestService{

	public List<TestEntity> query() {
		System.out.println("===============================");
		return null;
	}



}
