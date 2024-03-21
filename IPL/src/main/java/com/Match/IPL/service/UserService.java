package com.Match.IPL.service;

import java.util.List;
//import java.util.Optional;

import com.Match.IPL.entity.LeaderBoard;
import com.Match.IPL.entity.MatchDetailsEntity;
import com.Match.IPL.entity.TeamPoints;
import com.Match.IPL.model.BidDTO;
import com.Match.IPL.model.MatchScheduleDTO;
import com.Match.IPL.model.UserCridentials;
//import com.Match.IPL.entity.UserEntity;
import com.Match.IPL.model.UserDTO;
import com.Match.IPL.utils.IncorrectPasswordException;
import com.Match.IPL.utils.UserAlreadyExistException;
import com.Match.IPL.utils.UserNameAlreadyExistException;
import com.Match.IPL.utils.UsernameNotFoundException;

public interface UserService {

	public void userRegistration(UserDTO userdto) throws UserAlreadyExistException,UserNameAlreadyExistException;

	public List<UserDTO> getBidders();

	public List<MatchScheduleDTO> getMatchsScheduled();

	public void userBid(BidDTO biddto);

	public List<MatchDetailsEntity> getMatchsDetails();

	public void cancelBid(Integer b_id);

	public List<TeamPoints> getTeamPoints();

	public List<LeaderBoard> getBidderBoard();

	public Boolean userlogin(UserCridentials login)throws UsernameNotFoundException,IncorrectPasswordException;
	

}
