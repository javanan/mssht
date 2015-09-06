package com.wssht.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wssht.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 保存一条记录
	 */
	@Override
	public void save(T t) {
		hibernateTemplate.save(t);
	}
	
	/**
	 * 获取 Entity 的所有记录
	 */
	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		return hibernateTemplate.loadAll(entityClass);
	}



	
	
	
	
}
