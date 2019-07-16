package gui.Components.JDialogs;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Listeners.FootballScoutingJDialogs;

public class JDialogFactory {
	
	public static FootballScoutingJDialogs CreateJDialog(String i_identifier, Object i_Parent, String i_youtubeURL) {
		FootballScoutingJDialogs m_JdialogToCreate = null;
		
		switch (i_identifier) {
		case "Add Youtube JDialog":
			m_JdialogToCreate = new AddYoutubeDialog((JPanel)i_Parent);
			break;
		case "Login JDialog":
			m_JdialogToCreate = new LoginDialog((JFrame)i_Parent);
			break;
		case "Player Details JDialog":
			m_JdialogToCreate = new PlayerDetailsDialog((JFrame)i_Parent);
			break;
		case "Web Browser JDialog":
			m_JdialogToCreate = new WebBrowserDialog((JDialog)i_Parent, i_youtubeURL);
			break;
		default:
			break;				
		}
		
		return m_JdialogToCreate;
	}
}
