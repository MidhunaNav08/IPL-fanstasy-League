package com.Match.IPL.repository;

import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer> {

	
}
