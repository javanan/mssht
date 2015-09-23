package com.wssht.service;

import org.springframework.transaction.annotation.Transactional;

import com.wssht.entity.UserEntity;

public interface UserService {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@Transactional
	public UserEntity login(UserEntity user);
	
	/**
	 * 根据用户id获得该用户对象
	 * @return
	 */
	@Transactional
	public UserEntity getUserById(String userId);
	
	/**
	 * 融合一个对象
	 * @param user
	 */
	@Transactional
	public void save(UserEntity user);
}
