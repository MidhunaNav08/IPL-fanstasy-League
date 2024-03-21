package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.TeamPoints;
@Repository
public interface TeamPointsRepository extends JpaRepository<TeamPoints, Integer> {

}
