package com.myprojects.followYourBets.utils;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.myprojects.followYourBets.domain.Player;
import com.myprojects.followYourBets.service.PlayerService;

@Component
public class XmlPlayersToMysql {
	
	private static String xmlPlayers = "players_atp.xml";
	
	@Autowired
	PlayerService playerService ;

	public void insertPlayers() {
		
		try {
			playerService.deleteAll();
			
			InputStream xmlFileIs = XmlPlayersToMysql.class.getClassLoader().getResourceAsStream(xmlPlayers);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFileIs);
			
			// Normalize document
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Copia_x0020_de_x0020_Players_atp");
			
			for (int cont = 0 ; cont < nList.getLength() ; cont++) {
				
				Node nNode = nList.item(cont);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					Player player = new Player();
					
					/*
					 *  At least, a player must have a name
					 *  PlayerName contains "/" is for Doubles, at first instance i will ignore this.
					 */
					if (eElement.getElementsByTagName("NAME_P").item(0) != null && !eElement.getElementsByTagName("NAME_P").item(0).getTextContent().contains("/")) {
						
						player.setName(eElement.getElementsByTagName("NAME_P").item(0).getTextContent());
							
						if (eElement.getElementsByTagName("DATE_P").item(0) != null) {
							
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							Date d = formatter.parse(eElement.getElementsByTagName("DATE_P").item(0).getTextContent());
							player.setBornDate(d);
						}
						
						if (eElement.getElementsByTagName("COUNTRY_P").item(0) != null) 
							player.setCountry(eElement.getElementsByTagName("COUNTRY_P").item(0).getTextContent());
						
						playerService.savePlayer(player);
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
