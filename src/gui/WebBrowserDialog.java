package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserCommandEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserListener;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowOpeningEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowWillOpenEvent;

public class WebBrowserDialog extends JDialog {

	private JPanel m_wbPanel;
	private JPanel m_loadingPanel;
	private JWebBrowser m_webBrowser;
	private JLabel m_loadingGif;
	private int m_loadingCounterEntries = 0;
	
	public WebBrowserDialog(JDialog i_parent, String i_urlYoutube) {
		super(i_parent, "Highlight Video", false);
		
		m_wbPanel = new JPanel(new BorderLayout());
		m_webBrowser = new JWebBrowser();
		m_loadingPanel = new JPanel(new BorderLayout());
		
		//load loading gif
		m_loadingGif = new JLabel(new ImageIcon(getClass().getResource("/img/loading.gif")));

		
		setOnCloseDialog(i_parent);
		
		//no bar to dialog
		m_webBrowser.setBarsVisible(false);
		
		//load youtube
		m_webBrowser.navigate(i_urlYoutube);
		
		//load webBrowser and loadingGif to their panels
		m_wbPanel.add(m_webBrowser, BorderLayout.CENTER);
		m_loadingPanel.add(m_loadingGif, BorderLayout.CENTER);
		
		//add webBrowser Panel		
		add(m_wbPanel, BorderLayout.CENTER);
		
		//set WebBrower visibale
		m_wbPanel.setVisible(true);
		
		//set Dialog visible
		setVisible(true);
		
		
		m_webBrowser.addWebBrowserListener(new WebBrowserListener() {

			@Override
			public void commandReceived(WebBrowserCommandEvent arg0) {
				//System.out.println("test9");
				
			}

			@Override
			public void loadingProgressChanged(WebBrowserEvent arg0) {	
				//when still loading, show loading GIF
				m_loadingCounterEntries++;
						if (m_webBrowser.getLoadingProgress() < 100 && m_loadingCounterEntries == 1) {	// if thats the first we open youtube dialog - show loading
								m_wbPanel.setVisible(false);	
								add(m_loadingPanel, BorderLayout.CENTER);
								m_loadingPanel.setVisible(true);
						}
			}

			@Override
			public void locationChangeCanceled(WebBrowserNavigationEvent arg0) {
				//System.out.println("test8");
				
			}

			@Override
			public void locationChanged(WebBrowserNavigationEvent arg0) {
				//when video ready, make 3 seconds delay and show video
				makeDelayUntilVideoReady(3000);
				
			}

			@Override
			public void locationChanging(WebBrowserNavigationEvent arg0) {
				//System.out.println("test6");
				
			}

			@Override
			public void statusChanged(WebBrowserEvent arg0) {
				//System.out.println("test5");
				
			}

			@Override
			public void titleChanged(WebBrowserEvent arg0) {
				//System.out.println("test4");
				
			}

			@Override
			public void windowClosing(WebBrowserEvent arg0) {
				//System.out.println("test3");
				
			}

			@Override
			public void windowOpening(WebBrowserWindowOpeningEvent arg0) {
				//System.out.println("test1");
				
			}

			@Override
			public void windowWillOpen(WebBrowserWindowWillOpenEvent arg0) {
				//System.out.println("test2");
				
			}
			
		});
		
		
		setSize(550, 400);
		setMinimumSize(new Dimension(550, 400));
		setLocationRelativeTo(i_parent);	
	}
	
	private void makeDelayUntilVideoReady(int i_msecDelay) {
	    ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
				m_loadingPanel.setVisible(false);
				m_wbPanel.setVisible(true);
	        }
	    };
	    Timer t = new Timer(i_msecDelay, taskPerformer); // msec delay
	    t.setRepeats(false);
	    t.start();      
	}
	
	private void setOnCloseDialog(JDialog i_parent) {
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	i_parent.setEnabled(true);
		    	dispose();
		    }
		});
	}
}
