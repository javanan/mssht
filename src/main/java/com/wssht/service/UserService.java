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
}
