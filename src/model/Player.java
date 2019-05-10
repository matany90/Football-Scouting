package model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Player implements Serializable {
	private String m_urlYoutube;
	private transient ImageIcon m_image; //ImageIcon do not support Serializable. will be upload with ImageIO.write/ImageIO.read
	private String m_playerName;
	private String m_id;
	private String m_playerAge;
	private boolean m_isFreeAgent;
	private String m_currentTeam;
	private String m_position;
	private String m_marketValue;
	private String m_favoriteLeg;
	private String m_playerWeight;
	private String m_playerHeight;
	private String m_paceRegularPlayer;
	private String m_shootRegularPlayer;
	private String m_passRegularPlayer;
	private String m_dribbleRegularPlayer;
	private String m_defenceRegularPlayer;
	private String m_powerRegularPlayer;
	private String m_divingGoalkeeper;
	private String m_handlingGoalkeeper;
	private String m_kickingGoalkeeper;
	private String m_reflexesGoalkeeper;
	private String m_speedGoalkeeper;
	private String m_positionGoalkeeper;
	private int m_overallSkills;
	



	public Player(String i_urlYoutube, ImageIcon i_image, String i_name, String i_id, String i_age, boolean i_isFreeAgent, String i_currentTeam, String i_position, 
			String i_marketValue, String i_favoriteLeg, String i_playerWeight, String i_playerHeight,
			String i_paceRegularPlayer, String i_shootRegularPlayer, String i_passRegularPlayer, String i_dribbleRegularPlayer,
			String i_defenceRegularPlayer, String i_powerRegularPlayer, String i_divingGoalkeeper, String i_handlingGoalkeeper,
			String i_kickingGoalkeeper, String i_reflexesGoalkeeper, String i_speedGoalkeeper, String i_positionGoalkeeper,
			int i_overallSkills
			) {
			this.m_urlYoutube = i_urlYoutube;
			this.m_image = i_image;
			this.m_playerName = i_name;
			this.m_playerAge = i_age;
			this.m_isFreeAgent = i_isFreeAgent;
			this.m_currentTeam = i_currentTeam;
			this.m_marketValue = i_marketValue;
			this.m_favoriteLeg = i_favoriteLeg;
			this.m_playerHeight = i_playerHeight;
			this.m_playerWeight = i_playerWeight;		
			this.m_position = i_position;
			this.m_divingGoalkeeper = i_divingGoalkeeper;
			this.m_handlingGoalkeeper = i_handlingGoalkeeper;
			this.m_kickingGoalkeeper = i_kickingGoalkeeper;
			this.m_reflexesGoalkeeper = i_reflexesGoalkeeper;
			this.m_speedGoalkeeper = i_speedGoalkeeper;
			this.m_positionGoalkeeper = i_positionGoalkeeper;
			this.m_paceRegularPlayer = i_paceRegularPlayer;
			this.m_shootRegularPlayer = i_shootRegularPlayer;
			this.m_passRegularPlayer = i_passRegularPlayer;
			this.m_dribbleRegularPlayer = i_dribbleRegularPlayer;
			this.m_defenceRegularPlayer = i_defenceRegularPlayer;
			this.m_powerRegularPlayer = i_powerRegularPlayer;
			this.m_overallSkills = i_overallSkills;
			
			this.m_id = i_id;
	}
	
	public String getUrlYoutube() {
		return m_urlYoutube;
	}

	public String getId() {
		return m_id;
	}

	public ImageIcon getImage() {
		return m_image;
	}


	public void setImage(ImageIcon i_image) {
		this.m_image = i_image;
	}


	public void setId(String m_id) {
		this.m_id = m_id;
	}

	public String getPlayerName() {
		return m_playerName;
	}

	public void setPlayerName(String i_playerName) {
		this.m_playerName = i_playerName;
	}

	public String getPlayerAge() {
		return m_playerAge;
	}

	public void setPlayerAge(String i_playerAge) {
		this.m_playerAge = i_playerAge;
	}

	public boolean getIsFreeAgent() {
		return m_isFreeAgent;
	}

	public void setIsFreeAgent(boolean i_isFreeAgent) {
		this.m_isFreeAgent = i_isFreeAgent;
	}

	public String getCurrentTeam() {
		return m_currentTeam;
	}

	public void setCurrentTeam(String i_currentTeam) {
		this.m_currentTeam = i_currentTeam;
	}

	public String getPosition() {
		return m_position;
	}

	public void setPosition(String i_position) {
		this.m_position = i_position;
	}

	public String getMarketValue() {
		return m_marketValue;
	}

	public void setMarketValue(String i_marketValue) {
		this.m_marketValue = i_marketValue;
	}

	public String getFavoriteLeg() {
		return m_favoriteLeg;
	}

	public void setFavoriteLeg(String i_favoriteLeg) {
		this.m_favoriteLeg = i_favoriteLeg;
	}

	public String getPlayerWeight() {
		return m_playerWeight;
	}

	public void setPlayerWeight(String i_playerWeight) {
		this.m_playerWeight = i_playerWeight;
	}

	public String getPlayerHeight() {
		return m_playerHeight;
	}

	public void setPlayerHeight(String i_playerHeight) {
		this.m_playerHeight = i_playerHeight;
	}

	public String getPaceRegularPlayer() {
		return m_paceRegularPlayer;
	}

	public void setPaceRegularPlayer(String i_paceRegularPlayer) {
		this.m_paceRegularPlayer = i_paceRegularPlayer;
	}

	public String getShootRegularPlayer() {
		return m_shootRegularPlayer;
	}

	public void setShootRegularPlayer(String i_shootRegularPlayer) {
		this.m_shootRegularPlayer = i_shootRegularPlayer;
	}

	public String getPassRegularPlayer() {
		return m_passRegularPlayer;
	}

	public void setPassRegularPlayer(String i_passRegularPlayer) {
		this.m_passRegularPlayer = i_passRegularPlayer;
	}

	public String getDribbleRegularPlayer() {
		return m_dribbleRegularPlayer;
	}

	public void setDribbleRegularPlayer(String i_dribbleRegularPlayer) {
		this.m_dribbleRegularPlayer = i_dribbleRegularPlayer;
	}

	public String getDefenceRegularPlayer() {
		return m_defenceRegularPlayer;
	}

	public void setDefenceRegularPlayer(String i_defenceRegularPlayer) {
		this.m_defenceRegularPlayer = i_defenceRegularPlayer;
	}

	public String getPowerRegularPlayer() {
		return m_powerRegularPlayer;
	}

	public void setPowerRegularPlayer(String i_powerRegularPlayer) {
		this.m_powerRegularPlayer = i_powerRegularPlayer;
	}

	public String getDivingGoalkeeper() {
		return m_divingGoalkeeper;
	}

	public void setDivingGoalkeeper(String i_divingGoalkeeper) {
		this.m_divingGoalkeeper = i_divingGoalkeeper;
	}

	public String getHandlingGoalkeeper() {
		return m_handlingGoalkeeper;
	}

	public void setHandlingGoalkeeper(String i_handlingGoalkeeper) {
		this.m_handlingGoalkeeper = i_handlingGoalkeeper;
	}

	public String getKickingGoalkeeper() {
		return m_kickingGoalkeeper;
	}

	public void setKickingGoalkeeper(String i_kickingGoalkeeper) {
		this.m_kickingGoalkeeper = i_kickingGoalkeeper;
	}

	public String getReflexesGoalkeeper() {
		return m_reflexesGoalkeeper;
	}

	public void setReflexesGoalkeeper(String i_reflexesGoalkeeper) {
		this.m_reflexesGoalkeeper = i_reflexesGoalkeeper;
	}

	public String getSpeedGoalkeeper() {
		return m_speedGoalkeeper;
	}

	public void setSpeedGoalkeeper(String i_speedGoalkeeper) {
		this.m_speedGoalkeeper = i_speedGoalkeeper;
	}

	public String getPositionGoalkeeper() {
		return m_positionGoalkeeper;
	}

	public void setPositionGoalkeeper(String i_positionGoalkeeper) {
		this.m_positionGoalkeeper = i_positionGoalkeeper;
	}
	public int getOverallSkills() {
		return m_overallSkills;
	}


	public void setOverallSkills(int m_overallSkills) {
		this.m_overallSkills = m_overallSkills;
	}

}
