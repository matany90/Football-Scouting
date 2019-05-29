package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.Player;

public class PlayerDetailsDialog extends JDialog implements FootballScoutingJDialogs {
	
	private JLabel m_imageProfileLabel;
	private JLabel m_playerName;
	private JLabel m_idPlayer;
	private JLabel m_agePlayer;
	private JLabel m_heightPlayer;
	private JLabel m_weightPlayer;
	private JLabel m_isFreeAgent;
	private JLabel m_currentTeam;
	private JLabel m_marketValue;
	private JLabel m_favoriteLeg;
	private JLabel m_positionOnField;
	private JLabel m_pace;
	private JLabel m_shooting;
	private JLabel m_passing;
	private JLabel m_dribbling;
	private JLabel m_defence;
	private JLabel m_power;
	private JLabel m_diving;
	private JLabel m_hadling;
	private JLabel m_kicking;
	private JLabel m_reflexes;
	private JLabel m_speed;
	private JLabel m_position;
	private JLabel m_overall;
	private JButton m_testYoutube;
	private FootballScoutingJDialogs m_webBrowserDialog;
	private String m_urlYoutube;
	private ClosePlayerDialogListener m_closePlayerDialogListener;
	//private
	
	public PlayerDetailsDialog(JFrame parent) {
		super(parent, "Player Info", false);
		
		//init components
		m_imageProfileLabel = new JLabel();
		m_playerName = new JLabel();
		m_agePlayer = new JLabel();
		m_heightPlayer = new JLabel();
		m_weightPlayer = new JLabel();
		m_isFreeAgent = new JLabel();
		m_currentTeam = new JLabel();
		m_marketValue = new JLabel();
		m_favoriteLeg = new JLabel();
		m_positionOnField = new JLabel();
		m_pace = new JLabel();
		m_shooting = new JLabel();
		m_passing = new JLabel();
		m_dribbling = new JLabel();
		m_defence = new JLabel();
		m_power = new JLabel();
		m_diving = new JLabel();
		m_hadling = new JLabel();
		m_kicking = new JLabel();
		m_reflexes = new JLabel();
		m_speed = new JLabel();
		m_position = new JLabel();
		m_diving = new JLabel();
		m_hadling = new JLabel();
		m_kicking = new JLabel();
		m_reflexes = new JLabel();
		m_speed = new JLabel();
		m_position = new JLabel();
		m_overall = new JLabel();
		//youtube
		m_testYoutube = new JButton("Youtube");
		//m_webBrowser = new JWebBrowser();
		m_urlYoutube = new String();

		
//		Border border = BorderFactory.createLineBorder(Color.BLACK);
//		m_playerName.setBorder(BorderFactory.createCompoundBorder(border,
//	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		
		//set fonts
		m_imageProfileLabel.setFont(setTextSize(15));
		m_playerName.setFont(setTextSize(30));
		m_agePlayer.setFont(setTextSize(15));
		m_heightPlayer.setFont(setTextSize(15));
		m_weightPlayer.setFont(setTextSize(15));
		m_isFreeAgent.setFont(setTextSize(15));
		m_currentTeam.setFont(setTextSize(15));
		m_marketValue.setFont(setTextSize(15));
		m_favoriteLeg.setFont(setTextSize(15));
		m_positionOnField.setFont(setTextSize(15));
		m_pace.setFont(setTextSize(15));
		m_shooting.setFont(setTextSize(15));
		m_passing.setFont(setTextSize(15));
		m_dribbling.setFont(setTextSize(15));
		m_defence.setFont(setTextSize(15));
		m_power.setFont(setTextSize(15));
		m_diving.setFont(setTextSize(15));
		m_hadling.setFont(setTextSize(15));
		m_kicking.setFont(setTextSize(15));
		m_reflexes.setFont(setTextSize(15));
		m_speed.setFont(setTextSize(15));
		m_position.setFont(setTextSize(15));
		m_diving.setFont(setTextSize(15));
		m_hadling.setFont(setTextSize(15));
		m_kicking.setFont(setTextSize(15));
		m_reflexes.setFont(setTextSize(15));
		m_speed.setFont(setTextSize(15));
		m_position.setFont(setTextSize(15));
		m_overall.setFont(setTextSize(28));
		
		//border to player dialog
		Border innerBorder = BorderFactory.createTitledBorder("Player Info: ");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		getRootPane().setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		//close dialog listener
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        remove(m_diving);
		        remove(m_pace);
		        remove(m_hadling);
		        remove(m_shooting);
		        remove(m_kicking);
		        remove(m_passing);
		        remove(m_speed);
		        remove(m_defence);
		        remove(m_position);
		        remove(m_power);
		        if (m_closePlayerDialogListener != null) {
		        	m_closePlayerDialogListener.onCloseDialog();
		        }
		    }		    
		    public void windowActivated(WindowEvent e) {
		        if (m_closePlayerDialogListener != null) {
		    	m_closePlayerDialogListener.onOpenDialog();
		        }
		    }
		});

		setBackgroundImage();	
		setSize(600, 500);
		setMinimumSize(new Dimension(600, 500));
		setLocationRelativeTo(parent);
		
		
		//youtube player button
		m_testYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerDetailsDialog.this.setEnabled(false); //TODO:: uncomment when bag finish
				m_webBrowserDialog = JDialogFactory.CreateJDialog("Web Browser JDialog", PlayerDetailsDialog.this, m_urlYoutube);
			}		
		});
	
	}
	
	
	public void setPlayerToShow(Player i_player) {
		m_urlYoutube = i_player.getUrlYoutube();
		m_playerName.setText(i_player.getPlayerName());
		loadImageInDialog(i_player.getImage());
		m_agePlayer.setText("Age: " + i_player.getPlayerAge());
		m_heightPlayer.setText("Height: " + i_player.getPlayerHeight());
		m_weightPlayer.setText("Weight: " + i_player.getPlayerWeight());
		m_isFreeAgent.setText("Free agent: " + (i_player.getIsFreeAgent() ? "Yes" : "No"));
		m_currentTeam.setText("Current Team: " + i_player.getCurrentTeam() );
		m_marketValue.setText("Market Value: " + i_player.getMarketValue() + "€");
		m_favoriteLeg.setText("Favorite Leg: " + i_player.getFavoriteLeg());
		m_positionOnField.setText("Position on field: " + i_player.getPosition());
		m_pace.setText("Pace: " + i_player.getPaceRegularPlayer());
		m_shooting.setText("Shooting: " + i_player.getShootRegularPlayer());
		m_passing.setText("Passing: " + i_player.getPassRegularPlayer());
		m_dribbling.setText("Dribbling: " + i_player.getDribbleRegularPlayer());
		m_defence.setText("Defence: " + i_player.getDefenceRegularPlayer());
		m_power.setText("Power: " + i_player.getPowerRegularPlayer());
		m_diving.setText("Diving: " + i_player.getDivingGoalkeeper());
		m_hadling.setText("Handling: " + i_player.getHandlingGoalkeeper());
		m_kicking.setText("Kicking: " + i_player.getKickingGoalkeeper());
		m_reflexes.setText("Reflexes: " + i_player.getReflexesGoalkeeper());
		m_speed.setText("Speed: " + i_player.getSpeedGoalkeeper());
		m_position.setText("Position: " + i_player.getPositionGoalkeeper());
		m_overall.setText("" + i_player.getOverallSkills());
		JLabel[] toShow = {m_playerName, m_agePlayer, m_heightPlayer, m_weightPlayer, m_isFreeAgent, m_currentTeam, m_marketValue,
				m_favoriteLeg, m_positionOnField, m_pace, m_shooting, m_passing, m_dribbling, m_defence, m_power, m_diving, 
				m_hadling, m_kicking, m_reflexes, m_speed, m_position, m_overall};
		for (JLabel label : toShow) {
			label.setForeground(Color.white);
		}
		layoutComponentsInJDialog();
	}
	
	private void loadImageInDialog(ImageIcon i_imageToLoad) {
		if (i_imageToLoad != null) {
			ImageIcon imageIcon = i_imageToLoad; // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			m_imageProfileLabel.setIcon(imageIcon);
			m_imageProfileLabel.setBorder(new LineBorder(Color.black, 1, true)); //set border around image
		}
		else {
			m_imageProfileLabel.setIcon(new ImageIcon()); //if user do not have profile image
		}
	}
	
	private Font setTextSize(int i_size) {
		return new Font(m_playerName.getFont().getName(), m_playerName.getFont().getStyle(), i_size);
	}
	
	private void setBackgroundImage() {
//		//background image		
		try {
			Image image = ImageIO.read(PlayerDetailsDialog.class.getResource("/img/back3.jpg"));
			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				}
			};
			setContentPane(panel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private void layoutComponents() {
//
//
//	}
	
	public void setClosePlayerDialogListener(ClosePlayerDialogListener i_listener) {
		m_closePlayerDialogListener = i_listener;
	}


	@Override
	public void layoutComponentsInJDialog() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		boolean isGoalkeeper = m_positionOnField.getText().substring(19, m_positionOnField.getText().length()).equals("Goalkeeper");
		gc.gridy = 0;
		gc.insets = new Insets(0,0,0,5);
		
		////////////FIRST LINE - IMAGE
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_imageProfileLabel, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        add(m_testYoutube, gc);
					
		///////////////NEW LINE - NAME
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_playerName, gc);	
		
		////Overall skill
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        add(m_overall, gc);
		
		///////////////NEW LINE - AGE
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_agePlayer, gc);
		
		///////////////NEW LINE - HEIGHT
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_heightPlayer, gc);
		
		///////////////NEW LINE - WEIGHT
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_weightPlayer, gc);
		
		///////////////NEW LINE - FREE AGENT
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_isFreeAgent, gc);
		
		///////////////NEW LINE - currentTeam
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_currentTeam, gc);		
		
		///////////////NEW LINE - m_marketValue
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_marketValue, gc);		
		
		///////////////NEW LINE - m_favoriteLeg
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_favoriteLeg, gc);		
		
		///////////////NEW LINE - m_positionOnField
		gc.gridy++;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(m_positionOnField, gc);		
		
		///////////////NEW LINE - PACE
		gc.gridy++;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
		add(isGoalkeeper ? m_diving : m_pace, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        add(isGoalkeeper ? m_hadling : m_shooting, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        add(isGoalkeeper ? m_kicking : m_passing, gc);
		
		///////////////NEW LINE - PACE
		gc.gridy++;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        remove(m_reflexes);
        remove(m_dribbling);
        add(isGoalkeeper ? m_reflexes : m_dribbling, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        add(isGoalkeeper ? m_speed : m_defence, gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        add(isGoalkeeper ? m_position : m_power, gc);
		
	}
}
