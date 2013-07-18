package com.myprojects.followYourBets.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myprojects.followYourBets.domain.Bet;
import com.myprojects.followYourBets.domain.Player;
import com.myprojects.followYourBets.domain.Tournament;
import com.myprojects.followYourBets.service.BetService;
import com.myprojects.followYourBets.service.PlayerService;
import com.myprojects.followYourBets.service.TournamentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BetController {
	
	@Autowired
	BetService betService;
	
	@Autowired
	TournamentService tournamentService;
	
	@Autowired
	PlayerService playerService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "bet";
	}
	
	@RequestMapping(value = "/bet/addBetForm")
	public ModelAndView addBetForm(ModelMap modelMap) throws Exception {		
		
		modelMap.put("playerList", playerService.getAll());
		modelMap.put("tournamentList", tournamentService.getAll());
		modelMap.put("bet", new Bet());
	
		return new ModelAndView("bet/addBet");
	}
	
	@RequestMapping(value = "/bet/filterTournaments", method = RequestMethod.POST)
	public @ResponseBody List<Tournament> filterTournaments(@RequestParam String name ) throws Exception {
		
		return tournamentService.getTournamentsLikeName(name);
		
	}
	
	@RequestMapping(value = "/bet/filterPlayerOne", method = RequestMethod.POST)
	public @ResponseBody List<Player> filterPlayerOne(@RequestParam String name ) throws Exception {
		
		return playerService.getPlayersLikeName(name);
		
	}
	
	@RequestMapping(value = "/bet/filterPlayerTwo", method = RequestMethod.POST)
	public @ResponseBody List<Player> filterPlayerTwo(@RequestParam String name ) throws Exception {
		 
		return playerService.getPlayersLikeName(name);
		
	}
	
	@RequestMapping(value = "/bet/saveBet", method = RequestMethod.POST)
	public String saveBet(@ModelAttribute("bet") Bet bet, BindingResult result) {		
		
		betService.saveBet(bet);
		
		return "redirect:showBets.jsp";
	}
	
}
