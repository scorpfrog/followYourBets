package com.myprojects.followYourBets.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myprojects.followYourBets.utils.TournamentsToMysql;

@Controller
public class TournamentController {
	
	@Autowired
	TournamentsToMysql tournamentsToMysql;

	@RequestMapping(value = "/addTournamentsFromTxt", method = RequestMethod.GET)
	public void insertTournaments() throws IOException {
		
		tournamentsToMysql.insertTournaments();
	}
}
