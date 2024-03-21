package com.Match.IPL.service;

import java.util.Comparator;
import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Match.IPL.entity.BidEntity;
import com.Match.IPL.entity.LeaderBoard;
import com.Match.IPL.entity.MatchDetailsEntity;
import com.Match.IPL.entity.TeamPoints;
import com.Match.IPL.entity.UserEntity;
import com.Match.IPL.model.BidDTO;
import com.Match.IPL.model.MatchScheduleDTO;
import com.Match.IPL.model.UserCridentials;
import com.Match.IPL.model.UserDTO;
import com.Match.IPL.repository.BidDetailsRepository;
import com.Match.IPL.repository.BidRepository;
import com.Match.IPL.repository.LeaderBoardRepository;
import com.Match.IPL.repository.MatchDetailsRepository;
import com.Match.IPL.repository.MatchScheduledRepository;
import com.Match.IPL.repository.TeamPointsRepository;
import com.Match.IPL.repository.UserRepository;
import com.Match.IPL.utils.BidUtils;
import com.Match.IPL.utils.IncorrectPasswordException;
import com.Match.IPL.utils.MatchSheduleUtils;
import com.Match.IPL.utils.UserAlreadyExistException;
import com.Match.IPL.utils.UserNameAlreadyExistException;
import com.Match.IPL.utils.UserUtils;
import com.Match.IPL.utils.UsernameNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	 
	@Autowired
	BidDetailsRepository bidDetailsrepo;
	@Autowired
	UserRepository userrepo;

	@Autowired
	LeaderBoardRepository leaderboardrepo;
	@Autowired
	TeamPointsRepository teampoints;

	@Autowired
	MatchDetailsRepository matchdetailrepo;

	@Autowired
	MatchScheduledRepository matchrepo;

	@Autowired
	BidRepository bidrepo;
	


	public UserServiceImpl(BidDetailsRepository bidDetailsrepo, UserRepository userrepo,
			LeaderBoardRepository leaderboardrepo, TeamPointsRepository teampoints,
			MatchDetailsRepository matchdetailrepo, MatchScheduledRepository matchrepo, BidRepository bidrepo) {
		
		this.bidDetailsrepo = bidDetailsrepo;
		this.userrepo = userrepo;
		this.leaderboardrepo = leaderboardrepo;
		this.teampoints = teampoints;
		this.matchdetailrepo = matchdetailrepo;
		this.matchrepo = matchrepo;
		this.bidrepo = bidrepo;
	}

	@Override
	public void userRegistration(UserDTO userdto) throws UserAlreadyExistException, UserNameAlreadyExistException {
		PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
		if (userrepo.findByEmail(userdto.getEmail()) != null) {
			throw new UserAlreadyExistException("User already exist by this email");
		} else if (userrepo.findByUsername(userdto.getUsername()) != null) {
			throw new UserNameAlreadyExistException("Username already Exist!");
		}
		UserEntity userEntity = new UserEntity();
		userEntity = UserUtils.convertTouserEntity(userdto);
		userrepo.save(userEntity);
	}

	@Override
	public List<UserDTO> getBidders() {
		return UserUtils.convertToUserDtoList(userrepo.findAll());
	}

	@Override
	public List<MatchScheduleDTO> getMatchsScheduled() {
		return MatchSheduleUtils.convertToMatchScheduleDtoList(matchrepo.findAll());
	}

	@Override
	public void userBid(BidDTO biddto) {
		bidrepo.save(BidUtils.convertToBidEntity(biddto));

	}

	@Override
	public List<MatchDetailsEntity> getMatchsDetails() {
		return matchdetailrepo.findAll();
	}

	@Override
	public void cancelBid(Integer b_id) {
		BidEntity bid = bidDetailsrepo.getById(b_id);
		bidDetailsrepo.delete(bid);

	}

	@Override
	public List<TeamPoints> getTeamPoints() {
		return teampoints.findAll().stream().sorted(Comparator.comparingInt(TeamPoints::getTeam_id)).limit(3)
				.collect(Collectors.toList());
	}

	@Override
	public List<LeaderBoard> getBidderBoard() {
		return leaderboardrepo.findAll();
	}

	@Override
	public Boolean userlogin(UserCridentials login) throws UsernameNotFoundException ,IncorrectPasswordException {
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
		String userpassword = login.getPassword();
		UserEntity userEntity = userrepo.findByUsername(login.getUsername());
		if (userrepo.findByUsername(login.getUsername()) == null) {
			throw new UsernameNotFoundException("Invalid username unable to login");			
		}
		else{			
		if(!passencoder.matches(userpassword, userEntity.getPassword())){
			throw new IncorrectPasswordException("incorrrect password");
		}		
		return true;
	}
	}
}


