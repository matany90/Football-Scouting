package gui;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.Components.Screens.MainFrame;
import gui.Listeners.FormEvent;

class AddPlayerToDatabaseJunitTest {

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
		//Checks if number of players increase by one
		assertEquals(numberOfPlayersBeforeAdd + 1, mainFrameTest.getController().getPlayers().size());
	}

}
