package com.wssht.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	/**
	 * 保存一条记录
	 */
	public void save(T t);

	/**
	 * 获取 Entity 的所有记录
	 */
	public <T> List<T> loadAll(Class<T> entityClass);
	
	/**
	 * 根据id获取 Entity 的一条记录
	 * @param entityClass
	 * @return
	 */
	public <T>T loadByid(Class<T> entityClass,Serializable id);
	
	/**
	 * 获得一个对象
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public <T>List<T> get(Class<T> entityClass, Map<Object, Object> vks);
	/**
	 * 查询一条记录
	 * @param entityClass
	 * @param vks
	 * @return
	 */
	public T fetch(Class<T> entityClass, Map<Object, Object> vks);
	
	/**
	 * 根据id获得某个对象
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T get(Class<T> entityClass ,Serializable  id);
	
	/**
	 * 融合一个对象，update失败改为insert
	 * @param o
	 */
	public void merge(T o);

}
