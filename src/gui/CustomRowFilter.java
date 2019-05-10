package gui;

import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;

import model.Player;
import model.PlayerTableModel;

public class CustomRowFilter {
	private RowFilter<Object,Object> playerNameFilter;
	private RowFilter<Object,Object> currentTeamFitler;
	private RowFilter<Object,Object> maxMarketValueFilter;
	private RowFilter<Object,Object> minMarketValueFilter;
	private RowFilter<Object,Object> minAgeFilter;
	private RowFilter<Object,Object> maxAgeFilter;
	private RowFilter<Object,Object> minOverallFilter;
	private RowFilter<Object,Object> maxOverallFilter;
	private RowFilter<Object,Object> freeAgentOnlyFilter;
	
	public RowFilter<Object,Object> getPlayerNameFilter(String i_toFilter) {
			playerNameFilter = new RowFilter<Object,Object>() {
			   public boolean include(Entry<? extends Object, ? extends Object> entry) {
				   if (i_toFilter.isEmpty()) {
					   return true;
				   }
				   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
				   String identifier = entry.getIdentifier().toString();
				   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
				   return player.getPlayerName().toLowerCase().contains(i_toFilter.toLowerCase());
			   }
			 };
			 return playerNameFilter;
	}
	
	public RowFilter<Object,Object> getCurrentTeamFilter(String i_toFilter) {
		currentTeamFitler = new RowFilter<Object,Object>() {
			   public boolean include(Entry<? extends Object, ? extends Object> entry) {
				   if (i_toFilter.isEmpty()) {
					   return true;
				   }
				   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
				   String identifier = entry.getIdentifier().toString();
				   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
				   return player.getCurrentTeam().toLowerCase().contains(i_toFilter.toLowerCase());
			   }
			 };
			 return currentTeamFitler;
	}
	
	public RowFilter<Object,Object> getMaxMarketValueFilter(String i_toFilter) { 
			maxMarketValueFilter = new RowFilter<Object,Object>() {
			   public boolean include(Entry<? extends Object, ? extends Object> entry) {
				   if (i_toFilter.isEmpty()) {
					   return true;
				   }
				   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
				   String identifier = entry.getIdentifier().toString();
				   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
				   int playerMarketValue = Integer.parseInt(player.getMarketValue());
				   int maxValueUserTyped = Integer.parseInt(i_toFilter);
				   return playerMarketValue <= maxValueUserTyped;
			   }
			 };
			 return maxMarketValueFilter;		
	}
	
	public RowFilter<Object,Object> getMinMarketValueFilter(String i_toFilter) {
		  minMarketValueFilter = new RowFilter<Object,Object>() {
			   public boolean include(Entry<? extends Object, ? extends Object> entry) {
				   if (i_toFilter.isEmpty()) {
					   return true;
				   }
				   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
				   String identifier = entry.getIdentifier().toString();
				   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
				   int playerMarketValue = Integer.parseInt(player.getMarketValue());
				   int minValueUserTyped = Integer.parseInt(i_toFilter);
				   return playerMarketValue >= minValueUserTyped;
			   }
			 };
			 return minMarketValueFilter;
	}
	
	public RowFilter<Object,Object> getMinAgeFilter(String i_toFilter) {
		minAgeFilter = new RowFilter<Object,Object>() {
		   public boolean include(Entry<? extends Object, ? extends Object> entry) {
			   if (i_toFilter.isEmpty()) {
				   return true;
			   }
			   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
			   String identifier = entry.getIdentifier().toString();
			   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
			   int playerAge = Integer.parseInt(player.getPlayerAge());
			   int playerAgeUserTyped = Integer.parseInt(i_toFilter);
			   return playerAge >= playerAgeUserTyped;
		   }
		 };
		 return minAgeFilter;
}
	
	public RowFilter<Object,Object> getMaxAgeFilter(String i_toFilter) {
		maxAgeFilter = new RowFilter<Object,Object>() {
		   public boolean include(Entry<? extends Object, ? extends Object> entry) {
			   if (i_toFilter.isEmpty()) {
				   return true;
			   }
			   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
			   String identifier = entry.getIdentifier().toString();
			   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
			   int playerAge = Integer.parseInt(player.getPlayerAge());
			   int playerAgeUserTyped = Integer.parseInt(i_toFilter);
			   return playerAge <= playerAgeUserTyped;
		   }
		 };
		 return maxAgeFilter;
}
	
	public RowFilter<Object,Object> getMinOverallFilter(String i_toFilter) {
		minOverallFilter = new RowFilter<Object,Object>() {
		   public boolean include(Entry<? extends Object, ? extends Object> entry) {
			   if (i_toFilter.isEmpty()) {
				   return true;
			   }
			   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
			   String identifier = entry.getIdentifier().toString();
			   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
			   int playerOverall = player.getOverallSkills();
			   int playerOverallUserTyped = Integer.parseInt(i_toFilter);
			   return playerOverall >= playerOverallUserTyped;
		   }
		 };
		 return minOverallFilter;
}
	
	public RowFilter<Object,Object> getMaxOverallFilter(String i_toFilter) {
		maxOverallFilter = new RowFilter<Object,Object>() {
		   public boolean include(Entry<? extends Object, ? extends Object> entry) {
			   if (i_toFilter.isEmpty()) {
				   return true;
			   }
			   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
			   String identifier = entry.getIdentifier().toString();
			   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
			   int playerOverall = player.getOverallSkills();
			   int playerOverallUserTyped = Integer.parseInt(i_toFilter);
			   return playerOverall <= playerOverallUserTyped;
		   }
		 };
		 return maxOverallFilter;
}
	public RowFilter<Object,Object> getFreeAgentOnlyFilter(boolean i_isFreeAgentOnly) {
		freeAgentOnlyFilter = new RowFilter<Object,Object>() {
			   public boolean include(Entry<? extends Object, ? extends Object> entry) {
				   if (!i_isFreeAgentOnly) {
					   return true;
				   }
				   PlayerTableModel playerModel = (PlayerTableModel)entry.getModel();
				   String identifier = entry.getIdentifier().toString();
				   Player player = playerModel.getPlayer(Integer.parseInt(identifier));
				   boolean playerIsFreeAgent = player.getIsFreeAgent();
				   return playerIsFreeAgent == true;
			   }
			};
			return freeAgentOnlyFilter;
	}
	
}
