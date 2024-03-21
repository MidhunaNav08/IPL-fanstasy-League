package com.Match.IPL.service;

import java.util.List;

import com.Match.IPL.model.MatchStatsDto;

public interface SystemService {

	List<MatchStatsDto> getTeamStats();

	
}
