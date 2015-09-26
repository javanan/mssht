package com.wssht.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wssht.dao.BaseDao;
import com.wssht.entity.UserEntity;
import com.wssht.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDao<UserEntity> baseDao;
	
	
	@Override
	public UserEntity login(UserEntity user) {
		Map<Object, Object> vks=new HashMap<Object, Object>();
		vks.put("lodname", user.getLodname());
		vks.put("password", user.getPassword());
		return  baseDao.fetch(UserEntity.class, vks); 
	}



	@Override
	public UserEntity getUserById(String userId) {
		return  baseDao.get(UserEntity.class, userId);
	}



	@Override
	public void save(UserEntity user) {
		baseDao.merge(user);
	}

}
