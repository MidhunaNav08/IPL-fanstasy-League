package com.Match.IPL.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Match.IPL.entity.BidEntity;
import com.Match.IPL.repository.BidDetailsRepository;
import com.Match.IPL.repository.BidRepository;
import com.Match.IPL.repository.LeaderBoardRepository;
import com.Match.IPL.repository.MatchDetailsRepository;
import com.Match.IPL.repository.MatchScheduledRepository;
import com.Match.IPL.repository.TeamPointsRepository;
import com.Match.IPL.repository.UserRepository;
import com.Match.IPL.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@Mock
	BidDetailsRepository bidDetailsrepo;
	@Mock
	UserRepository userrepo;

	@Mock
	LeaderBoardRepository leaderboardrepo;
	@Mock
	TeamPointsRepository teampoints;

	@Mock
	MatchDetailsRepository matchdetailrepo;

	@Mock
	MatchScheduledRepository matchrepo;

	@Mock
	BidRepository bidrepo;
	
	private UserServiceImpl userService;

	@AfterEach
	void tearDown() throws Exception {
	}
	@BeforeEach
    void setUp() {
        this.userService = new UserServiceImpl(this.bidDetailsrepo,
		this.userrepo,this.leaderboardrepo,this.teampoints,
		this.matchdetailrepo ,this.matchrepo,
		this.bidrepo);
    }

	@Test
	void getBidders() {
		userService.getBidders();
        verify(userrepo).findAll();
        
	}
	@Test
	void getMatchsScheduled() {
		userService.getMatchsScheduled();
        verify(matchrepo).findAll();
        
	}
	@Test
	void getMatchDetails() {
		userService.getMatchsDetails();
        verify(matchdetailrepo).findAll();        
	}
	@Test
	void cancelBid(Integer id) {
		BidEntity bid = bidDetailsrepo.getById(id);
		verify(bidDetailsrepo).delete(bid);
	}
	
	

}
