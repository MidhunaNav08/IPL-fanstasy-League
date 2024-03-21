package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.MatchDetailsEntity;
@Repository
public interface MatchDetailsRepository extends JpaRepository<MatchDetailsEntity, Integer> {

}
