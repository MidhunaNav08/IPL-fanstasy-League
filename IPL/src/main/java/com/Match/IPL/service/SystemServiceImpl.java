package com.Match.IPL.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Match.IPL.model.MatchStatsDto;
import com.Match.IPL.repository.MatchDetailsRepository;
import com.Match.IPL.utils.TeamStatsUtils;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	MatchDetailsRepository matches;
	@Override
	public List<MatchStatsDto> getTeamStats() {
		List<MatchStatsDto> matchdto = TeamStatsUtils.convertToMatchStatsList(matches.findAll());
		return matchdto.stream().filter(e->e.getStatus().equals("finished")).collect(Collectors.toList());		
	}

}
