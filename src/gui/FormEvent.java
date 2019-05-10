package gui;

import java.util.EventObject;

import javax.swing.ImageIcon;

public class FormEvent extends EventObject {	
	private ImageIcon m_image;
	private String m_urlYoutube;
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
	
	public FormEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent(Object arg0, String i_urlYoutube, ImageIcon i_image, String i_name, String i_id, String i_age, boolean i_isFreeAgent, String i_currentTeam, String i_position, 
			String i_marketValue, String i_favorietLeg, String i_playerWeight, String i_playerHeight,
			String i_paceRegularPlayer, String i_shootRegualrPlayer, String i_passRegularPlayer, String i_dribbleRegularPlayer,
			String i_defenceRegularPlayer, String i_powerRegularPlayer, String i_divingGoalkeeper, String i_handlingGoalkeeper,
			String i_kickingGoalkeeper, String i_reflexesGoalkeeper, String i_speedGoalkeeper, String i_positionGoalkeeper
			) {
			super(arg0);
			this.m_urlYoutube = i_urlYoutube;
			this.m_image = i_image;
			this.m_playerName = i_name;
			this.m_id = i_id;
			this.m_playerAge = i_age;
			this.m_isFreeAgent = i_isFreeAgent;
			this.m_currentTeam = i_currentTeam;
			this.m_marketValue = i_marketValue;
			this.m_playerHeight = i_playerHeight;
			this.m_playerWeight = i_playerWeight;		
			this.m_position = i_position;
			this.m_favoriteLeg = i_favorietLeg;
			this.m_divingGoalkeeper = i_divingGoalkeeper;
			this.m_handlingGoalkeeper = i_handlingGoalkeeper;
			this.m_kickingGoalkeeper = i_kickingGoalkeeper;
			this.m_reflexesGoalkeeper = i_reflexesGoalkeeper;
			this.m_speedGoalkeeper = i_speedGoalkeeper;
			this.m_positionGoalkeeper = i_positionGoalkeeper;
			this.m_paceRegularPlayer = i_paceRegularPlayer;
			this.m_shootRegularPlayer = i_shootRegualrPlayer;
			this.m_passRegularPlayer = i_passRegularPlayer;
			this.m_dribbleRegularPlayer = i_dribbleRegularPlayer;
			this.m_defenceRegularPlayer = i_defenceRegularPlayer;
			this.m_powerRegularPlayer = i_powerRegularPlayer;

	}
	
	
	public String getUrlYoutube() {
		return m_urlYoutube;
	}

	public void setUrlYoutube(String i_url) {
		this.m_urlYoutube = i_url;
	}
	
	public ImageIcon getImage() {
		return m_image;
	}

	public void setImage(ImageIcon m_image) {
		this.m_image = m_image;
	}

	public String getId() {
		return m_id;
	}

	public void setId(String m_id) {
		this.m_id = m_id;
	}

	public String getPlayerName() {
		return m_playerName;
	}

	public void setPlayerName(String m_playerName) {
		this.m_playerName = m_playerName;
	}

	public String getPlayerAge() {
		return m_playerAge;
	}

	public void setPlayerAge(String m_playerAge) {
		this.m_playerAge = m_playerAge;
	}

	public boolean isFreeAgent() {
		return m_isFreeAgent;
	}

	public void setIsFreeAgent(boolean m_isFreeAgent) {
		this.m_isFreeAgent = m_isFreeAgent;
	}

	public String getCurrentTeam() {
		return m_currentTeam;
	}

	public void setCurrentTeam(String m_currentTeam) {
		this.m_currentTeam = m_currentTeam;
	}

	public String getPosition() {
		return m_position;
	}

	public void setPosition(String m_position) {
		this.m_position = m_position;
	}

	public String getMarketValue() {
		return m_marketValue;
	}

	public void setMarketValue(String m_marketValue) {
		this.m_marketValue = m_marketValue;
	}

	public String getFavoriteLeg() {
		return m_favoriteLeg;
	}

	public void setFavoriteLeg(String m_favoriteLeg) {
		this.m_favoriteLeg = m_favoriteLeg;
	}

	public String getPlayerWeight() {
		return m_playerWeight;
	}

	public void setPlayerWeight(String m_playerWeight) {
		this.m_playerWeight = m_playerWeight;
	}

	public String getPlayerHeight() {
		return m_playerHeight;
	}

	public void setPlayerHeight(String m_playerHeight) {
		this.m_playerHeight = m_playerHeight;
	}

	public String getPaceRegularPlayer() {
		return m_paceRegularPlayer;
	}

	public void setPaceRegularPlayer(String m_paceRegularPlayer) {
		this.m_paceRegularPlayer = m_paceRegularPlayer;
	}

	public String getShootRegularPlayer() {
		return m_shootRegularPlayer;
	}

	public void setShootRegularPlayer(String m_shootRegularPlayer) {
		this.m_shootRegularPlayer = m_shootRegularPlayer;
	}

	public String getPassRegularPlayer() {
		return m_passRegularPlayer;
	}

	public void setPassRegularPlayer(String m_passRegularPlayer) {
		this.m_passRegularPlayer = m_passRegularPlayer;
	}

	public String getDribbleRegularPlayer() {
		return m_dribbleRegularPlayer;
	}

	public void setDribbleRegularPlayer(String m_dribbleRegularPlayer) {
		this.m_dribbleRegularPlayer = m_dribbleRegularPlayer;
	}

	public String getDefenceRegularPlayer() {
		return m_defenceRegularPlayer;
	}

	public void setDefenceRegularPlayer(String m_defenceRegularPlayer) {
		this.m_defenceRegularPlayer = m_defenceRegularPlayer;
	}

	public String getPowerRegularPlayer() {
		return m_powerRegularPlayer;
	}

	public void setPowerRegularPlayer(String m_powerRegularPlayer) {
		this.m_powerRegularPlayer = m_powerRegularPlayer;
	}

	public String getDivingGoalkeeper() {
		return m_divingGoalkeeper;
	}

	public void setDivingGoalkeeper(String m_divingGoalkeeper) {
		this.m_divingGoalkeeper = m_divingGoalkeeper;
	}

	public String getHandlingGoalkeeper() {
		return m_handlingGoalkeeper;
	}

	public void setHandlingGoalkeeper(String m_handlingGoalkeeper) {
		this.m_handlingGoalkeeper = m_handlingGoalkeeper;
	}

	public String getKickingGoalkeeper() {
		return m_kickingGoalkeeper;
	}

	public void setKickingGoalkeeper(String m_kickingGoalkeeper) {
		this.m_kickingGoalkeeper = m_kickingGoalkeeper;
	}

	public String getReflexesGoalkeeper() {
		return m_reflexesGoalkeeper;
	}

	public void setReflexesGoalkeeper(String m_reflexesGoalkeeper) {
		this.m_reflexesGoalkeeper = m_reflexesGoalkeeper;
	}

	public String getSpeedGoalkeeper() {
		return m_speedGoalkeeper;
	}

	public void setSpeedGoalkeeper(String m_speedGoalkeeper) {
		this.m_speedGoalkeeper = m_speedGoalkeeper;
	}

	public String getPositionGoalkeeper() {
		return m_positionGoalkeeper;
	}

	public void setPositionGoalkeeper(String m_positionGoalkeeper) {
		this.m_positionGoalkeeper = m_positionGoalkeeper;
	}

//	private void setSkillsToGoalkeeper(String i_divingGoalkeeper, String i_handlingGoalkeeper, String i_kickingGoalkeeper, 
//			String i_reflexesGoalkeeper, String i_speedGoalkeeper, String i_positionGoalkeeper) {
//		this.m_divingGoalkeeper = i_divingGoalkeeper;
//		this.m_handlingGoalkeeper = i_handlingGoalkeeper;
//		this.m_kickingGoalkeeper = i_kickingGoalkeeper;
//		this.m_reflexesGoalkeeper = i_reflexesGoalkeeper;
//		this.m_speedGoalkeeper = i_speedGoalkeeper;
//		this.m_positionGoalkeeper = i_positionGoalkeeper;
//		this.m_paceRegularPlayer = null;
//		this.m_shootRegularPlayer = null;
//		this.m_passRegularPlayer = null;
//		this.m_dribbleRegularPlayer = null;
//		this.m_defenceRegularPlayer = null;
//		this.m_powerRegularPlayer = null;
//	}
//	
//	private void setSkillsToRegularPlayer(String i_paceRegularPlayer, String i_shootRegualrPlayer, String i_passRegularPlayer,
//			String i_dribbleRegularPlayer, String i_defenceRegularPlayer, String i_powerRegularPlayer) {
//		this.m_divingGoalkeeper = null;
//		this.m_handlingGoalkeeper = null;
//		this.m_kickingGoalkeeper = null;
//		this.m_reflexesGoalkeeper = null;
//		this.m_speedGoalkeeper = null;
//		this.m_positionGoalkeeper = null;
//		this.m_paceRegularPlayer = i_paceRegularPlayer;
//		this.m_shootRegularPlayer = i_shootRegualrPlayer;
//		this.m_passRegularPlayer = i_passRegularPlayer;
//		this.m_dribbleRegularPlayer = i_dribbleRegularPlayer;
//		this.m_defenceRegularPlayer = i_defenceRegularPlayer;
//		this.m_powerRegularPlayer = i_powerRegularPlayer;
//	}
	
	
}
