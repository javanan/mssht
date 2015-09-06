package com.wssht.service;

import java.util.List;

import com.wssht.entity.TestEntity;

public interface TestService {

	
	/**
	 * 获取 TestEntity 的所有记录
	 */
	public List<TestEntity> loadAll();
	public void save(TestEntity testEntity);
}
