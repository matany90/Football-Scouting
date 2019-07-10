package gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;

class MainFrameJunitTest {
	
	MainFrame mainFrameTest;
	
	@BeforeEach
	public void setUp() {
		mainFrameTest = new MainFrame();
	}
	
	@Test
	public void AddPlayerTest() {
		int numberOfPlayersBeforeAdd = mainFrameTest.getController().getPlayers().size();
		FormEvent event = new FormEvent(this, "https://www.youtube.com/watch?v=I8XXfgF9GSc", new ImageIcon(), "test", "2323",  "22", false, "test", "test", "0",
				"test", "test", "test", "60", "60",
				"60", "60", "60",
				"60", "60", "60", "60", "60",
				"60", "60");
		mainFrameTest.AddPlayerToTable(event);
		assertEquals(numberOfPlayersBeforeAdd + 1, mainFrameTest.getController().getPlayers().size());
	}
	
	@Test
	public void LoginUserTest() {
		String password = "123456";
		String user = "Agent User";
		assertTrue(mainFrameTest.LoginUser(user, password));
	}
	
	@Test
	public void SearchPlayerTest() {
		 List <Player> players = new LinkedList();
		 players.add(
				new Player("test", new ImageIcon(), "Matan", "11", "33", false, "team", "position",
							"0", "Right", "60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", "60", "60",
							"60", "60", 60));
		mainFrameTest.getController().setPlayers(players);
		int sizeBeforeSearch = mainFrameTest.getController().getPlayers().size();
		SearchPlayerFormPanel searchPlayerFormPanel = mainFrameTest.getSearchPlayerFormPanel();
		searchPlayerFormPanel.setSearchByNameField("M");
		int sizeAfterSearch = mainFrameTest.getController().getPlayers().size();
		
		assertEquals(sizeBeforeSearch, sizeAfterSearch);
	}
	
	
	

}
