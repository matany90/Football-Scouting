package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import gui.Components.JDialogs.AddYoutubeDialog;
import gui.Components.JDialogs.JDialogFactory;
import gui.Components.JDialogs.LoginDialog;
import gui.Components.JDialogs.PlayerDetailsDialog;
import gui.Components.JDialogs.WebBrowserDialog;
import gui.Listeners.FootballScoutingJDialogs;

class JDialogFactoryJunitTest {
	
	@Test
	public void CreateYoutubeJDialogTest() {
		FootballScoutingJDialogs YoutubeJDialog = JDialogFactory.CreateJDialog("Add Youtube JDialog", new JPanel(), "");
		
		Assert.assertTrue((AddYoutubeDialog)YoutubeJDialog != null);
	}
	
	@Test
	public void CreateLoginJDialogTest() {
		FootballScoutingJDialogs LoginJDialog = JDialogFactory.CreateJDialog("Login JDialog", new JFrame(), "");
		
		Assert.assertTrue((LoginDialog)LoginJDialog != null);
	}
	
	@Test
	public void CreatePlayerDetailsJDialogTest() {
		FootballScoutingJDialogs PlayerDetailsJDialog = JDialogFactory.CreateJDialog("Player Details JDialog", new JFrame(), "");
		
		Assert.assertTrue((PlayerDetailsDialog)PlayerDetailsJDialog != null);
	}
	
	@Test
	public void CreateWebBrowserJDialogTest() {
		NativeInterface.open();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				
				FootballScoutingJDialogs WebBrowserJDialog = JDialogFactory.CreateJDialog("Web Browser JDialog", new JDialog(), "https://www.youtube.com/watch?v=pq5-d9COvzw");
				Assert.assertTrue((WebBrowserDialog)WebBrowserJDialog != null);
			}		
		});       
	}

}
