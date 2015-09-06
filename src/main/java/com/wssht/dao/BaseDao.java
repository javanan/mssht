package com.wssht.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存一条记录
	 */
	public void save(T t);

	/**
	 * 获取 Entity 的所有记录
	 */
	public <T> List<T> loadAll(Class<T> entityClass);
}
