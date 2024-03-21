package com.Match.IPL.service;

import java.util.List;

import com.Match.IPL.entity.BidEntity;
import com.Match.IPL.entity.MatchScheduleEntity;
import com.Match.IPL.entity.TeamDetails;
import com.Match.IPL.entity.TeamPoints;
import com.Match.IPL.entity.Tournament;
import com.Match.IPL.model.AdminLogin;
import com.Match.IPL.utils.IncorrectPasswordException;
import com.Match.IPL.utils.UsernameNotFoundException;

public interface AdminService {

	void createTournament(Tournament tournament);

	void createTeam(TeamDetails team);

	void scheduleMatch(MatchScheduleEntity match);

	void rescheduleMatch(Integer match_id);

	void matchResult(TeamPoints points);

	List<BidEntity> getBiddings();

	Boolean loginAdmin(AdminLogin login) throws UsernameNotFoundException ,IncorrectPasswordException;

	void updateTeam(Integer t_id);

	void cancelMatch(Integer match_id);

}
