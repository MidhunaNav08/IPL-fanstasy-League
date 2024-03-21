package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.TeamDetails;

@Repository
public interface TeamRepository extends JpaRepository<TeamDetails, Integer>{

}
