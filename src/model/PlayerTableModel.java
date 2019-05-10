package model;

import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class PlayerTableModel extends AbstractTableModel {
	
	private List<Player> m_players;
	private String[] m_colNames = {"ID", "Name", "Age", /*"Height",*/ /*"Weight",*/ "Free Agent", "Current Team", 
			"Market Value", /*"Favotite Leg",*/ "Position on field", "Overall Skills","Profile Photo" /* "Pace", "Shooting", "Passing", "Dribbling", "Defence", "Power"*/
//			"Diving", "Handling", "Kicking", "Reflexes", "Speed", "Position"
	};
	
	
	public void setData(List <Player> i_players) {
		this.m_players = i_players;
	}
	
	@Override
	public String getColumnName(int column) {
		return m_colNames[column];
	}
	
	@Override
	public int getColumnCount() {
		return m_colNames.length;
	}

	@Override
	public int getRowCount() {
		return m_players.size();
	}
	
	@Override
	public Class getColumnClass(int column) {
		List<String> colNamesList  = Arrays.asList(m_colNames);
		if (column == colNamesList.indexOf("Profile Photo")) {
			return ImageIcon.class;
		}
		return Object.class;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Player player = m_players.get(row);
		switch (col) {
		case 0:
			return player.getId();
		case 1:
			return player.getPlayerName();
		case 2:
			return player.getPlayerAge();
		case 3:
			return player.getIsFreeAgent();
		case 4:
			return player.getCurrentTeam();
		case 5:
			return player.getMarketValue() + "€";
		case 6:
			return player.getPosition();
		case 7:
			return player.getOverallSkills();
		case 8:
			return player.getImage();
		}
		return null;
	}
	
	public Player getPlayer(int i_row) {
		Player player = m_players.get(i_row);
		return player;
	}
	
	public int columnIndexByName(String i_colname) {
		for (int i = 0; i < m_colNames.length; i++) {
			if (m_colNames[i].equals(i_colname)) {
				return i;
			}
		}
		return -1;
	}
}
