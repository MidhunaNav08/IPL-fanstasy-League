package com.Match.IPL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Match.IPL.entity.AdminEntity;
import com.Match.IPL.entity.BidEntity;
import com.Match.IPL.entity.MatchScheduleEntity;
import com.Match.IPL.entity.TeamDetails;
import com.Match.IPL.entity.TeamPoints;
import com.Match.IPL.entity.Tournament;
import com.Match.IPL.model.AdminLogin;
import com.Match.IPL.repository.AdminRepository;
import com.Match.IPL.repository.BidDetailsRepository;
import com.Match.IPL.repository.MatchScheduledRepository;
import com.Match.IPL.repository.TeamPointsRepository;
import com.Match.IPL.repository.TeamRepository;
import com.Match.IPL.repository.TournamentRepository;
import com.Match.IPL.utils.IncorrectPasswordException;
import com.Match.IPL.utils.UsernameNotFoundException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	TournamentRepository tourrepo;

	@Autowired
	TeamPointsRepository pointsrepo;
	@Autowired
	TeamRepository teams;
	@Autowired
	MatchScheduledRepository matchschedule;
	@Autowired
	BidDetailsRepository bids;
	
	@Autowired
	AdminRepository adminLogin;

	@Override
	public void createTournament(Tournament tournament) {
		tourrepo.save(tournament);
	}

	@Override
	public void createTeam(TeamDetails team) {
		teams.save(team);
	}

	@Override
	public void scheduleMatch(MatchScheduleEntity match) {
		matchschedule.save(match);

	}

	@Override
	public void rescheduleMatch(Integer id) {		
		matchschedule.save(matchschedule.getById(id));		
	}

	@Override
	public void matchResult(TeamPoints points) {
		pointsrepo.save(points);
		
	}

	@Override
	public List<BidEntity> getBiddings() {
		return bids.findAll();
	}

	@Override
	public Boolean loginAdmin(AdminLogin login) throws UsernameNotFoundException, IncorrectPasswordException {
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
		AdminEntity adment = adminLogin.findByUsername(login.getUsername());
		if(adment==null) {
			throw new UsernameNotFoundException("username not found");
		}
		else{			
			if(!passencoder.matches(login.getPassword(), adment.getPassword())){
				throw new IncorrectPasswordException("incorrrect password");
			}
		return null;
	}
	}

	@Override
	public void updateTeam(Integer t_id) {
		TeamDetails teamDetails = teams.getById(t_id);
		teams.save(teamDetails);		
	}

	@Override
	public void cancelMatch(Integer match_id) {
		matchschedule.delete(matchschedule.getById(match_id));		
	}

}
