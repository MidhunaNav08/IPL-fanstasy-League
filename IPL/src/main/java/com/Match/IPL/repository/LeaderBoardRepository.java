package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.LeaderBoard;

@Repository
public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Integer>{

}
