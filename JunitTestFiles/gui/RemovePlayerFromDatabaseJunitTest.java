package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;

class RemovePlayerFromDatabaseJunitTest {

	MainFrame mainFrameTest;
	
	@BeforeEach
	public void setUp() {
		mainFrameTest = new MainFrame();
	}	
	@Test
	public void RemovePlayerTest() {
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
			mainFrameTest.getController().setPlayers(players);
			//get Current number of players Before Search (returns 2 - michael and matan)
			int sizeBeforeSearch = mainFrameTest.getController().getPlayers().size();
			//remove matan
			mainFrameTest.getController().removePlayer(0);
			int sizeAfterSearch = mainFrameTest.getController().getPlayers().size();
			
			System.out.println("Before: " + sizeBeforeSearch + " After: " + sizeAfterSearch);
			Assert.assertTrue(sizeBeforeSearch == 2 && sizeAfterSearch == 1);
			
	}

}
