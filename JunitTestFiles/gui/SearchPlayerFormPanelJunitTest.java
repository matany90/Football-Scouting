package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.Components.Screens.MainFrame;
import gui.Components.Screens.SearchPlayerFormPanel;
import model.Player;

class SearchPlayerFormPanelJunitTest {

	MainFrame mainFrameTest;
	
	@BeforeEach
	public void setUp() {
		mainFrameTest = new MainFrame();
	}
	
	@Test
	public void SearchPlayerByNameTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "33", false, "team", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "11", "33", false, "team", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		//set Players ArrayList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 2 - michael and matan)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getModel().getData().size();
		//Type in Name Search field the word Matan
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByNameField("Michael");
		//Checks current number of players after search (should return 1 - just Matan)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 2 && sizeAfterSearch == 1);
	}
	
	@Test
	public void SearchPlayerByMaxAgeTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "44", false, "Netanya", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "33", false, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 2 - michael and matan)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//Type in Name Search field the word Matan
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByMaxAgeField("35");
		//Checks current number of players after search (should return 1 - just Michael)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 2 && sizeAfterSearch == 1);
	}
	
	@Test
	public void SearchPlayerByTeamTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "44", false, "Netanya", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "33", false, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 2 - michael and matan)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//Type in current team Search field the word HIT
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByCurrentTeamField("HIT");
		//Checks current number of players after search (should return 1 - just Michael)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 2 && sizeAfterSearch == 1);
	}
	
	@Test
	public void SearchPlayerByIsFreeAgentTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "44", false, "Netanya", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "33", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Hershi", "22", "33", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 3 - michael, matan and Hershi)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//set is free Agent true
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByIsFreeAgent(true);
		//Checks current number of players after search (should return 2 - just Michael and hershi)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 3 && sizeAfterSearch == 2);
	}
	
	@Test
	public void SearchPlayerByMinAgeTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "18", false, "Netanya", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "20", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Hershi", "22", "26", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		 players.add(
					new Player("test", new ImageIcon(), "Rexi", "22", "30", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 60));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 4 - michael, matan ,Hershi and Rexi)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//set 25 to min age
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByMinAge("25");
		//Checks age bigger then 25 (should return 2 - just Hershi and Rexi - 26 and 30)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 4 && sizeAfterSearch == 2);
	}
	
	@Test
	public void SearchPlayerByMinOverallSkillsTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "18", false, "Netanya", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 70));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "20", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 80));
		 players.add(
					new Player("test", new ImageIcon(), "Hershi", "22", "26", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 90));
		 players.add(
					new Player("test", new ImageIcon(), "Rexi", "22", "30", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 95));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 4 - michael, matan ,Hershi and Rexi)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//set 89 to min overall
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByMinOverall("89");
		//Checks overall bigger then 89 (should return 2 - just Hershi and Rexi - 90 and 95)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 4 && sizeAfterSearch == 2);
	}
	
	@Test
	public void SearchPlayerByMaxOverallSkillsTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "18", false, "Netanya", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 70));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "20", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 80));
		 players.add(
					new Player("test", new ImageIcon(), "Hershi", "22", "26", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 90));
		 players.add(
					new Player("test", new ImageIcon(), "Rexi", "22", "30", true, "HIT", "position",
								"0", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 95));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 4 - michael, matan ,Hershi and Rexi)
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//set 65 to max overall
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByMaxOverall("65");
		//Checks overall smaller then 65 (should return 0)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 4 && sizeAfterSearch == 0);
	}
	
	@Test
	public void SearchPlayerByMaxMarketValueTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "18", false, "Netanya", "position",
							"100000", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 70));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "20", true, "HIT", "position",
								"200000", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 80));
		 players.add(
					new Player("test", new ImageIcon(), "Hershi", "22", "26", true, "HIT", "position",
								"300000", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 90));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 3 - michael, matan ,Hershi )
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//set 250000 to max market value
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByMaxMarketValue("250000");
		//Checks market value smaller then 250000 (should return 2)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 3 && sizeAfterSearch == 2);
	}
	
	@Test
	public void SearchPlayerByMinMarketValueTest() {
		 List <Player> players = new LinkedList();
		 //Define Player list to search - Matan and Michael
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "18", false, "Netanya", "position",
							"100000", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 70));
		 players.add(
					new Player("test", new ImageIcon(), "Michael", "22", "20", true, "HIT", "position",
								"200000", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 80));
		 players.add(
					new Player("test", new ImageIcon(), "Hershi", "22", "26", true, "HIT", "position",
								"300000", "Right", "60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", "60", "60",
								"60", "60", 90));
		//set Players LinkedList to table Model
		mainFrameTest.getTablePanel().getModel().setData(players);
		mainFrameTest.getTablePanel().refresh();
		//get Current number of players Before Search (returns 3 - michael, matan ,Hershi )
		int sizeBeforeSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		//set 250000 to max market value
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByMinMarketValue("250000");
		//Checks market value smaller then 250000 (should return 1)
		int sizeAfterSearch = mainFrameTest.getTablePanel().getTable().getRowCount();
		
		System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
		Assert.assertTrue(sizeBeforeSearch == 3 && sizeAfterSearch == 1);
	}

}
