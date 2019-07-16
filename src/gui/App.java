package gui;


//import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import gui.Components.Screens.MainFrame;

public class App {

	public static void main(String[] args) {

		NativeInterface.open();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();	
			}				
		});
        NativeInterface.runEventPump();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				NativeInterface.close();
				
			}        	
        }));		
	}
}
