package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.ImageIcon;

import gui.FormEvent;
import model.Database;
import model.Player;

public class Controller {
	 private Database db;
	 
	 public Controller() {
		 db = Database.getInstance(); //using Singleton design pattern
	 }
	 
	 public List<Player> getPlayers() {
		 return db.getPlayers();
	 }
	 
	 public void setPlayers(List<Player> players) {
		 db.setPlayers(players);
	 }
	 
	 public void addPlayer(FormEvent i_event) {
		 	
		 	String urlYoutube = i_event.getUrlYoutube();
		 	ImageIcon image = i_event.getImage();
			String name = i_event.getPlayerName();
			String id = i_event.getId();
			String age = i_event.getPlayerAge();
			boolean isFreeAgent = i_event.isFreeAgent();
			String currentTeam = i_event.getCurrentTeam();
			String position = i_event.getPosition();
			String marketValue = i_event.getMarketValue();
			String favoriteLeg = i_event.getFavoriteLeg();
			String weight = i_event.getPlayerWeight();
			String height = i_event.getPlayerHeight();
			String paceRegularPlayer = i_event.getPaceRegularPlayer();
			String shootRegularPlayer = i_event.getShootRegularPlayer();
			String passRegularPlayer = i_event.getPassRegularPlayer();
			String dribbleRegularPlayer = i_event.getDribbleRegularPlayer();
			String defenceRegularPlayer = i_event.getDefenceRegularPlayer();
			String powerRegularPlayer = i_event.getPowerRegularPlayer();
			String divingGoalkeeper = i_event.getDivingGoalkeeper();
			String handlingGoalkeeper = i_event.getHandlingGoalkeeper();
			String kickingGoalkeeper = i_event.getKickingGoalkeeper();
			String reflexesGoalkeeper = i_event.getReflexesGoalkeeper();
			String speedGoalkeeper = i_event.getSpeedGoalkeeper();
			String positionGoalkeeper = i_event.getPositionGoalkeeper();
			
			String[] allSkills = {paceRegularPlayer , shootRegularPlayer, passRegularPlayer,
					dribbleRegularPlayer, defenceRegularPlayer	,powerRegularPlayer, divingGoalkeeper,
					divingGoalkeeper, handlingGoalkeeper, kickingGoalkeeper, kickingGoalkeeper, reflexesGoalkeeper,
					speedGoalkeeper, positionGoalkeeper	};
			int overallSkills = calcAvgSkills(allSkills);
			
			Player playerToAdd = new Player(urlYoutube, image, name, id, age, isFreeAgent, currentTeam, position,
					marketValue, favoriteLeg, weight, height, paceRegularPlayer, shootRegularPlayer,
					passRegularPlayer, dribbleRegularPlayer, defenceRegularPlayer, powerRegularPlayer,
					divingGoalkeeper, handlingGoalkeeper, kickingGoalkeeper, reflexesGoalkeeper,
					speedGoalkeeper, positionGoalkeeper, overallSkills);
			
			db.addPlayer(playerToAdd);			
	 }
	 
	 
		public void saveToFile(File file) throws IOException {
			db.saveToFile(file);
		}
		
		public void loadFromFile(InputStream is) throws IOException {
			db.loadFromFile(is);
		}
		
		public void removePlayer(int rowToRemove) {
			db.removePlayer(rowToRemove);
		}
	 
		public boolean isPlayerNotExists(String i_idToSearch) {
			return db.isPlayerNotExists(i_idToSearch);
		}
	 
	 public int calcAvgSkills(String[] allSkills) {
		 int sum = 0;
		 int releventSkills = 0;
		 for (String skill : allSkills) {
			 if (!skill.isEmpty()) {
				 sum += Integer.parseInt(skill);
				 releventSkills++;
			 }
		 }
		 return sum/releventSkills;
	 }
}
