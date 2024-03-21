package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.AdminEntity;
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
       public AdminEntity findByUsername(String user_name);
}
