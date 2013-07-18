package com.myprojects.followYourBets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myprojects.followYourBets.service.PlayerService;
import com.myprojects.followYourBets.utils.XmlPlayersToMysql;

@Controller
public class PlayerController {
	
	@Autowired
	XmlPlayersToMysql xmlPlayersToMysql;

	@RequestMapping(value = "/addPlayersFromXml", method = RequestMethod.GET)
	public void insertPlayers() {

		xmlPlayersToMysql.insertPlayers();
	}
	
}
