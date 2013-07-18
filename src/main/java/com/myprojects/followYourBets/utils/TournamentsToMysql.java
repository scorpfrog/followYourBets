package com.myprojects.followYourBets.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprojects.followYourBets.domain.Tournament;
import com.myprojects.followYourBets.domain.TournamentLevel;
import com.myprojects.followYourBets.domain.TournamentSurface;
import com.myprojects.followYourBets.service.TournamentService;
import com.myprojects.followYourBets.service.TournamentSurfaceService;

@Component
public class TournamentsToMysql {

	private static String atpTournaments = "atp_tournaments.txt";
	private static String challengerTournaments = "challenger_tournaments.txt";

	@Autowired
	TournamentService tournamentService;

	@Autowired
	TournamentSurfaceService tournamentSurfaceService;
	
	// Array to add all surfaces and compare if it is persisted or not
	ArrayList<TournamentSurface> surfaces = new ArrayList<TournamentSurface>();

	public void insertTournaments() throws IOException {

		try {

			tournamentService.deleteAll();
			tournamentSurfaceService.deleteAll();

			insertTournaments(atpTournaments, TournamentLevel.ATP);
			insertTournaments(challengerTournaments, TournamentLevel.Challenger);

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	private void insertTournaments(String fileName, TournamentLevel level) throws IOException {
		
		BufferedReader br = null;
		
		try {
			String currentLine = null ;
			
			InputStream is = TournamentsToMysql.class.getClassLoader().getResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			while ((currentLine = br.readLine()) != null) {
				
				/*
				 * Fields are separated by four spaces with rare chars.
				 */
				String fieldsSeparated[] = currentLine.split("  	 ");
				if (fieldsSeparated != null && fieldsSeparated.length == 2) {
					
					TournamentSurface tournamentSurface = new TournamentSurface();
					tournamentSurface.setName(fieldsSeparated[0]);		
					
					if (!surfaces.contains(tournamentSurface)) {
						surfaces.add(new TournamentSurface(tournamentSurface));
						tournamentSurfaceService.save(tournamentSurface);
					} else {
						tournamentSurface = tournamentSurfaceService.getByName(fieldsSeparated[0]);
					}
					
					Tournament tournament = new Tournament();
					tournament.setName(fieldsSeparated[1]);
					tournament.setSurface(tournamentSurface);
					tournament.setTournamentLevel(level);
					
					tournamentService.save(tournament);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		
	}
}
