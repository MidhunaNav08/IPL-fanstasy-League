package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.UserEntity;

@Repository
public interface UserRepository extends  JpaRepository<UserEntity,Integer> {
	public UserEntity findByEmail(String email);
	UserEntity findByUsername(String username);
}
