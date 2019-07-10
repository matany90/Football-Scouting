package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginDialogJunitTest {

	
	MainFrame mainFrameTest;
	
	@BeforeEach
	public void setUp() {
		mainFrameTest = new MainFrame();
	}
	
	@Test
	public void LoginUserTest() {
		String password = "123456";
		String user = "Agent User";
		assertTrue(mainFrameTest.LoginUser(user, password));
	}

}
