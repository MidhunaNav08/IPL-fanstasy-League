package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.MatchScheduleEntity;


@Repository
public interface MatchScheduledRepository extends JpaRepository<MatchScheduleEntity,Integer> {

}