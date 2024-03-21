package com.Match.IPL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Match.IPL.model.MatchStatsDto;
import com.Match.IPL.service.SystemService;

@RestController
public class SystemController {

	@Autowired
	SystemService systemService;
	
	@GetMapping("/home")
	public ResponseEntity<List<MatchStatsDto>> getMatchStats(){
		return new ResponseEntity<>(systemService.getTeamStats(),HttpStatus.OK);
	}	

}
