package com.wssht.service.impl;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wssht.dao.BaseDao;
import com.wssht.entity.TestEntity;
import com.wssht.service.TestService;


@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private BaseDao baseDao;
	
	
	/**
	 * 获取 TestEntity 的所有记录
	 */
	@Transactional
	
	public List<TestEntity> loadAll() {
		return baseDao.loadAll(TestEntity.class);
		
		
	}
	
	@Transactional
	public void save(TestEntity testEntity){
		baseDao.save(testEntity);
	}



}
