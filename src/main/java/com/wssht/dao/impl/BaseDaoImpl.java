package com.wssht.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public <T> T loadByid(Class<T> entityClass, Serializable id) {

		return hibernateTemplate.load(entityClass, id);

	}

	@Override
	public <T> List<T> get(Class<T> entityClass, Map<Object, Object> vks) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		Condition(vks, criteria);
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public T fetch(Class<T> entityClass, Map<Object, Object> vks) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		Condition(vks, criteria);
		List<T> retlist=(List<T>) hibernateTemplate.findByCriteria(criteria,0,1);
		if(retlist!=null && retlist.size()>0){
			return retlist.get(0);
		}
		return null;
	}

	private void Condition(Map<Object, Object> vks, DetachedCriteria criteria) {
		if (vks != null) {
			for (Map.Entry<Object, Object> vk : vks.entrySet()) {
				criteria.add(Restrictions.eq(String.valueOf(vk.getKey()),
						vk.getValue()));
			}	
		}
	}
	
	public T get(Class<T> entityClass ,Serializable  id){
		return hibernateTemplate.get(entityClass, id);
	}

	@Override
	public void merge(T o) {
		hibernateTemplate.merge(o);
	}
	
}
