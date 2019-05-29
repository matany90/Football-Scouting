package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import model.PositionCategory;

public class AddPlayerFormPanel extends JPanel {
	
	private JLabel m_uploadImageLabel;
	private UploadImage m_uploadImage; 
	private JLabel m_playerNameLabel;
	private JTextField m_playerNameField;
	private JLabel m_playerIdLabel;
	private JTextField m_playerIdField;
	private JLabel m_playerAgeLabel;
	private SpinnerNumberModel m_ageModel;
	private JSpinner m_ageSpinner;
	private JLabel m_freeAgentLabel;
	private JCheckBox m_freeAgentCheck;
	private JLabel m_currentTeam;
	private JTextField m_currentTeamField;
	private JLabel m_positionLabel;
	private JComboBox m_positionList;
	private JLabel m_playerMarketValueLabel;
	private JTextField m_playerMarketValueField;
	private JLabel m_favoriteLegLabel;
	private JRadioButton m_leftFooterButton;
	private JRadioButton m_rightFooterButton;
	private JRadioButton m_bothFooterButton;
	private ButtonGroup m_favoriteLegGroup;
	private JLabel m_playerHeightLabel;
	private SpinnerNumberModel m_playerHeightModel;
	private JSpinner m_playerHeightSpinner;
	private JLabel m_playerWeightLabel;
	private SpinnerNumberModel m_playerWeightModel;
	private JSpinner m_playerWeightSpinner;
	//Goalkeeper skills
	private JLabel m_divingGoalkeeperLabel;
	private SpinnerNumberModel m_divingGoalkeeperModel;
	private JSpinner m_divingGoalkeeperSpinner;
	private JLabel m_handlingGoalkeeperLabel;
	private SpinnerNumberModel m_handlingGoalKeeperModel;
	private JSpinner m_handlingGoalkeeperSpinner;
	private JLabel m_kickingGoalkeeperLabel;
	private SpinnerNumberModel m_kickingGoalKeeperModel;
	private JSpinner m_kickingGoalkeeperSpinner;
	private JLabel m_reflexesGoalkeeperLabel;
	private SpinnerNumberModel m_reflexesGoalKeeperModel;
	private JSpinner m_reflexesGoalkeeperSpinner;
	private JLabel m_speedingGoalkeeperLabel;
	private SpinnerNumberModel m_speedingGoalKeeperModel;
	private JSpinner m_speedingGoalkeeperSpinner;
	private JLabel m_positionGoalkeeperLabel;
	private SpinnerNumberModel m_positionGoalKeeperModel;
	private JSpinner m_positionGoalkeeperSpinner;
	//Regular Player skills
	private JLabel m_paceRegularLabel;
	private SpinnerNumberModel m_paceRegularModel;
	private JSpinner m_paceRegularSpinner;
	private JLabel m_shootRegularLabel;
	private SpinnerNumberModel m_shootRegularModel;
	private JSpinner m_shootRegularSpinner;
	private JLabel m_passRegularLabel;
	private SpinnerNumberModel m_passRegularModel;
	private JSpinner m_passRegularSpinner;
	private JLabel m_dribbleRegularLabel;
	private SpinnerNumberModel m_dribbleRegularModel;
	private JSpinner m_dribbleRegularSpinner;
	private JLabel m_defenceRegularLabel;
	private SpinnerNumberModel m_defenceRegularModel;
	private JSpinner m_defenceRegularSpinner;
	private JLabel m_powerRegularLabel;
	private SpinnerNumberModel m_powerRegularModel;
	private JSpinner m_powerRegularSpinner;
	//youtube link
	private JButton m_addYoutubeButton;
	private JLabel m_youtubeLinkLabel;
	private String m_urlYoutube;
	private FootballScoutingJDialogs m_addYoutubeDialog;
	//ok Button
	private JButton m_okButton;
	//ok Button form listener
	private FormListener m_okButtonFormListener;


	
	public AddPlayerFormPanel() {
		//set Size:
//		Dimension dim = getPreferredSize();
//		dim.width = 250;
//		setPreferredSize(dim);

		//Init Components:
		m_uploadImageLabel = new JLabel("Upload Profile Image: ");
		m_uploadImage = new UploadImage();
		m_playerNameLabel = new JLabel("Player Name: ");
		m_playerNameField = new JTextField(10);	
		m_playerIdLabel = new JLabel("ID: ");
		m_playerIdField = new JTextField(10);
		m_playerAgeLabel = new JLabel("Age: ");
		m_ageModel = new SpinnerNumberModel(16, 16, 40, 1);
		m_ageSpinner = new JSpinner(m_ageModel);
		m_freeAgentLabel = new JLabel("Free Agent: ");
		m_freeAgentCheck = new JCheckBox();
		m_currentTeam = new JLabel("Current Team: ");
		m_currentTeamField = new JTextField(10);
		m_positionLabel = new JLabel("Position: ");
		m_positionList = new JComboBox();
		m_playerMarketValueLabel = new JLabel("Market Value (€): ");
		m_playerMarketValueField = new JTextField(10);
		m_favoriteLegLabel = new JLabel("Strong leg: ");
		m_leftFooterButton = new JRadioButton("Left-footer");
		m_rightFooterButton = new JRadioButton("Right-footer");
		m_bothFooterButton = new JRadioButton("Both");
		m_favoriteLegGroup = new ButtonGroup();
		m_playerHeightLabel = new JLabel("Height (in Meters): ");
		m_playerHeightModel = new SpinnerNumberModel(1.75, 1.50, 2.20, 0.01);
		m_playerHeightSpinner = new JSpinner(m_playerHeightModel);
		m_playerWeightLabel = new JLabel("Weight (in Kg): ");
		m_playerWeightModel = new SpinnerNumberModel(60, 60, 120, 1);
		m_playerWeightSpinner = new JSpinner(m_playerWeightModel);
		m_divingGoalkeeperLabel = new JLabel("Diving: ");
		m_divingGoalkeeperModel = new SpinnerNumberModel(60, 1, 99, 1);
		m_divingGoalkeeperSpinner = new JSpinner(m_divingGoalkeeperModel);
		m_handlingGoalkeeperLabel = new JLabel("Handling: ");
		m_handlingGoalKeeperModel = new SpinnerNumberModel(60, 1, 99, 1);
		m_handlingGoalkeeperSpinner = new JSpinner(m_handlingGoalKeeperModel);
		m_kickingGoalkeeperLabel = new JLabel("Kicking: ");
		m_kickingGoalKeeperModel = new SpinnerNumberModel(60, 1, 99, 1);
		m_kickingGoalkeeperSpinner = new JSpinner(m_kickingGoalKeeperModel);
		m_reflexesGoalkeeperLabel = new JLabel("Reflexes: ");
		m_reflexesGoalKeeperModel = new SpinnerNumberModel(60, 1, 99, 1);
		m_reflexesGoalkeeperSpinner = new JSpinner(m_reflexesGoalKeeperModel);
		m_speedingGoalkeeperLabel = new JLabel("Speed: ");
		m_speedingGoalKeeperModel = new SpinnerNumberModel(60, 1, 99, 1);
		m_speedingGoalkeeperSpinner = new JSpinner(m_speedingGoalKeeperModel);
		m_positionGoalkeeperLabel = new JLabel("Position: ");
		m_positionGoalKeeperModel = new SpinnerNumberModel(60, 1, 99, 1);
		m_positionGoalkeeperSpinner = new JSpinner(m_positionGoalKeeperModel);
		m_paceRegularLabel = new JLabel("Pace: ");
		m_paceRegularModel = new SpinnerNumberModel(60, 1, 99, 1);;
		m_paceRegularSpinner = new JSpinner(m_paceRegularModel);
		m_shootRegularLabel = new JLabel("Shooting: ");
		m_shootRegularModel = new SpinnerNumberModel(60, 1, 99, 1);;
		m_shootRegularSpinner = new JSpinner(m_shootRegularModel);
		m_passRegularLabel = new JLabel("Passing: ");
		m_passRegularModel = new SpinnerNumberModel(60, 1, 99, 1);;
		m_passRegularSpinner = new JSpinner(m_passRegularModel);
		m_dribbleRegularLabel = new JLabel("Dribbling: ");
		m_dribbleRegularModel = new SpinnerNumberModel(60, 1, 99, 1);;
		m_dribbleRegularSpinner = new JSpinner(m_dribbleRegularModel);
		m_defenceRegularLabel = new JLabel("Defence: ");
		m_defenceRegularModel = new SpinnerNumberModel(60, 1, 99, 1);;
		m_defenceRegularSpinner = new JSpinner(m_defenceRegularModel);
		m_powerRegularLabel = new JLabel("Power: ");
		m_powerRegularModel = new SpinnerNumberModel(60, 1, 99, 1);;
		m_powerRegularSpinner = new JSpinner(m_powerRegularModel);
		m_addYoutubeButton = new JButton("Youtube video");
		m_youtubeLinkLabel = new JLabel("Add Youtube Video: ");
		m_addYoutubeDialog = JDialogFactory.CreateJDialog("Add Youtube JDialog", this, "");
		m_urlYoutube = new String();	
		m_okButton = new JButton("OK");
		//
		


	
		//set up Favorite leg radios group:
		m_favoriteLegGroup.add(m_rightFooterButton);
		m_favoriteLegGroup.add(m_leftFooterButton);
		m_favoriteLegGroup.add(m_bothFooterButton);
		m_rightFooterButton.setActionCommand("Right-footer");
		m_leftFooterButton.setActionCommand("Left-footer");
		m_bothFooterButton.setActionCommand("Both");
		m_rightFooterButton.setSelected(true);
	
		
		
		//set up Position Model
		DefaultComboBoxModel positionModel = new DefaultComboBoxModel();
		positionModel.addElement(new PositionCategory(0, "Goalkeeper").getPosition());
		positionModel.addElement(new PositionCategory(1, "Left-back").getPosition());
		positionModel.addElement(new PositionCategory(2, "Centre-back").getPosition());
		positionModel.addElement(new PositionCategory(3, "Right-back").getPosition());
		positionModel.addElement(new PositionCategory(4, "Centre-back").getPosition());
		positionModel.addElement(new PositionCategory(5, "Defensive-midfielder").getPosition());
		positionModel.addElement(new PositionCategory(6, "Centre-midfielder").getPosition());
		positionModel.addElement(new PositionCategory(7, "Attacking-midfielder").getPosition());
		positionModel.addElement(new PositionCategory(8, "Left-winger").getPosition());
		positionModel.addElement(new PositionCategory(9, "Right-winger").getPosition());
		positionModel.addElement(new PositionCategory(10, "Striker").getPosition());
		
		m_positionList.setModel(positionModel);
		m_positionList.setPreferredSize(new Dimension(150, 30));
		m_positionList.setBorder(BorderFactory.createEtchedBorder());
		m_positionList.setSelectedIndex(6);
		
		m_positionList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isGoalkeeper = m_positionList.getSelectedIndex() == 0;
				setSkillsEnabled(isGoalkeeper);
			}	
		});
		
		//youtube button - open url dialog
		m_addYoutubeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((AddYoutubeDialog)m_addYoutubeDialog).setVisible(true);
			}			
		});
		
		
		//confirm button in dialog youtube listener - close dialog then process data
		((AddYoutubeDialog)m_addYoutubeDialog).setConfirmDialogYoutubeListener(new ConfirmDialogYoutubeListener() {
			public void onConfirmClicked() {
				((AddYoutubeDialog)m_addYoutubeDialog).setVisible(false);
				m_urlYoutube = ((AddYoutubeDialog)m_addYoutubeDialog).getAddUrlTextField().getText();
			}			
		});
		
		
		//okButton add Action Listener
		m_okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String urlYoutube = m_urlYoutube; //TODO:: check validation
				ImageIcon uploadedImage = m_uploadImage.getImageToUpload();
				String name = m_playerNameField.getText();
				String id = m_playerIdField.getText();
				String age = m_ageSpinner.getValue().toString();
				boolean isFreeAgent = m_freeAgentCheck.isSelected();
				String currentTeam = isFreeAgent ? "" : m_currentTeamField.getText();
				String position = (String)m_positionList.getSelectedItem();
				String marketValue = m_playerMarketValueField.getText();
				String favoriteLeg = m_favoriteLegGroup.getSelection().getActionCommand();
				String weight = m_playerWeightSpinner.getValue().toString();
				String height = m_playerHeightSpinner.getValue().toString();
				String paceRegularPlayer = new String();
				String shootRegularPlayer = new String();;
				String passRegularPlayer = new String();;
				String dribbleRegularPlayer = new String();;
				String defenceRegularPlayer = new String();;
				String powerRegularPlayer = new String();;
				String divingGoalkeeper = new String();;
				String handlingGoalkeeper = new String();;
				String kickingGoalkeeper = new String();;
				String reflexesGoalkeeper = new String();;
				String speedGoalkeeper = new String();;
				String positionGoalkeeper = new String();;

				if (position.equals("Goalkeeper")) { //if Goalkeeper				
					divingGoalkeeper = m_divingGoalkeeperSpinner.getValue().toString();
					handlingGoalkeeper = m_handlingGoalkeeperSpinner.getValue().toString();
					kickingGoalkeeper = m_kickingGoalkeeperSpinner.getValue().toString();
					reflexesGoalkeeper = m_reflexesGoalkeeperSpinner.getValue().toString();
					speedGoalkeeper = m_speedingGoalkeeperSpinner.getValue().toString();
					positionGoalkeeper = m_positionGoalkeeperSpinner.getValue().toString();
				}
				else { // if NOT Goalkeeper
					paceRegularPlayer = m_paceRegularSpinner.getValue().toString();
					shootRegularPlayer = m_shootRegularSpinner.getValue().toString();
					passRegularPlayer = m_passRegularSpinner.getValue().toString();
					dribbleRegularPlayer = m_dribbleRegularSpinner.getValue().toString();
					defenceRegularPlayer = m_defenceRegularSpinner.getValue().toString();
					powerRegularPlayer = m_powerRegularSpinner.getValue().toString();
				}
				FormEvent ev = new FormEvent(this, urlYoutube, uploadedImage, name, id,  age, isFreeAgent, currentTeam, position, marketValue,
						favoriteLeg, weight, height, paceRegularPlayer, shootRegularPlayer,
						passRegularPlayer, dribbleRegularPlayer, defenceRegularPlayer,
						powerRegularPlayer, divingGoalkeeper, handlingGoalkeeper, kickingGoalkeeper, reflexesGoalkeeper,
						speedGoalkeeper, positionGoalkeeper);
				if (m_okButtonFormListener != null) {
					m_okButtonFormListener.formEventOccurred(ev);
				}
										
			}		
		});
		
		//TEST
		//setBackgroundImage();
		
		//Default set up for Goalkeeper skills
		setSkillsEnabled(false);
		
		//Default set up for current team
		m_currentTeam.setEnabled(true);
		m_currentTeamField.setEnabled(true);
		

		
		//free Agent check Action Listener
		m_freeAgentCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_freeAgentCheck.isSelected();
				m_currentTeam.setEnabled(!isClicked);
				m_currentTeamField.setEnabled(!isClicked);
				if (isClicked) {
					m_currentTeamField.setText("");
				}
			}		
		});
		
		//set Layout
		layoutComponents();
	}
	
	
	public void layoutComponents() {
		//set Border
		Border innerBorder = BorderFactory.createTitledBorder("Add Player");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		

		
		/////FIRST ROW////(youtube button)
		
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_youtubeLinkLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_addYoutubeButton, gc);
		
//		/////////NEXT ROW///////////////(IMAGE)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_uploadImageLabel, gc);
			
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_uploadImage, gc);
		
				
		/////FIRST ROW////(Player Name)
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);		
		add(m_playerNameLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(m_playerNameField, gc);
		
		
		/////////NEXT ROW///////////////(id)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerIdLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerIdField, gc);
		
		/////////NEXT ROW///////////////(Age)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerAgeLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_ageSpinner, gc);
		
		
		//////NEXT ROW///////////(Height)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerHeightLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerHeightSpinner, gc);
		
		//////NEXT ROW///////////(Weight)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerWeightLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerWeightSpinner, gc);
		
		/////////NEXT ROW///////////////(Free Agent)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
			
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_freeAgentLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_freeAgentCheck, gc);
		
		/////////NEXT ROW///////////////(Current Team)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_currentTeam, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_currentTeamField, gc);
		
		//////NEXT ROW///////////(Market Value)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerMarketValueLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_playerMarketValueField, gc);
		
		
		//////NEXT ROW///////////(Favorite leg RIGHT)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_favoriteLegLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_rightFooterButton, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0,100,0,5);
		add(m_leftFooterButton, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_bothFooterButton, gc);
		
		
		/////////NEXT ROW///////////////(Position)
		gc.gridy++;
			
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_positionLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_positionList, gc);
		
		
		/////////NEXT ROW///////////////(Skills Model - Diving)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_divingGoalkeeperLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_divingGoalkeeperSpinner, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_paceRegularLabel, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_paceRegularSpinner, gc);
		
		/////////NEXT ROW///////////////(Skills Model -Handling)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_handlingGoalkeeperLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_handlingGoalkeeperSpinner, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_shootRegularLabel, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_shootRegularSpinner, gc);
		
		/////////NEXT ROW///////////////(Skills Model - Kicking)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_kickingGoalkeeperLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_kickingGoalkeeperSpinner, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_passRegularLabel, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_passRegularSpinner, gc);
		
		/////////NEXT ROW///////////////(Skills Model - Reflexes)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_reflexesGoalkeeperLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_reflexesGoalkeeperSpinner, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_dribbleRegularLabel, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_dribbleRegularSpinner, gc);
		
		/////////NEXT ROW///////////////(Skills Model - Speeding)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_speedingGoalkeeperLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_speedingGoalkeeperSpinner, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_defenceRegularLabel, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_defenceRegularSpinner, gc);
		
		/////////NEXT ROW///////////////(Skills Model - Position)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_positionGoalkeeperLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_positionGoalkeeperSpinner, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(m_powerRegularLabel, gc);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(m_powerRegularSpinner, gc);
		
		/////////NEXT ROW///////////////OK Button
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
			
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0,0,0,5);
		add(m_okButton, gc);
				
	}
	
	public void setSkillsEnabled(boolean isGoalkeeper) {
		m_divingGoalkeeperSpinner.setEnabled(isGoalkeeper);
		m_handlingGoalkeeperSpinner.setEnabled(isGoalkeeper);
		m_kickingGoalkeeperSpinner.setEnabled(isGoalkeeper);
		m_reflexesGoalkeeperSpinner.setEnabled(isGoalkeeper);
		m_speedingGoalkeeperSpinner.setEnabled(isGoalkeeper);
		m_positionGoalkeeperSpinner.setEnabled(isGoalkeeper);
		
		m_divingGoalkeeperLabel.setEnabled(isGoalkeeper);
		m_handlingGoalkeeperLabel.setEnabled(isGoalkeeper);
		m_kickingGoalkeeperLabel.setEnabled(isGoalkeeper);
		m_reflexesGoalkeeperLabel.setEnabled(isGoalkeeper);
		m_speedingGoalkeeperLabel.setEnabled(isGoalkeeper);
		m_positionGoalkeeperLabel.setEnabled(isGoalkeeper);
		
		m_paceRegularSpinner.setEnabled(!isGoalkeeper);
		m_shootRegularSpinner.setEnabled(!isGoalkeeper);
		m_passRegularSpinner.setEnabled(!isGoalkeeper);
		m_dribbleRegularSpinner.setEnabled(!isGoalkeeper);
		m_defenceRegularSpinner.setEnabled(!isGoalkeeper);
		m_powerRegularSpinner.setEnabled(!isGoalkeeper);
		
		m_paceRegularLabel.setEnabled(!isGoalkeeper);
		m_shootRegularLabel.setEnabled(!isGoalkeeper);
		m_passRegularLabel.setEnabled(!isGoalkeeper);
		m_dribbleRegularLabel.setEnabled(!isGoalkeeper);
		m_defenceRegularLabel.setEnabled(!isGoalkeeper);
		m_powerRegularLabel.setEnabled(!isGoalkeeper);
	}
	
	public void setOkButtonFormListener(FormListener i_listener) {
		this.m_okButtonFormListener = i_listener;
	}
	
	public void clearFormData() {
		m_uploadImage.loadDefaultImage();
		m_playerNameField.setText("");
		m_playerIdField.setText("");
		m_ageSpinner.setValue(16);
		m_freeAgentCheck.setSelected(false);
		m_currentTeamField.setText("");
		m_currentTeam.setEnabled(true);
		m_currentTeamField.setEnabled(true);
		m_positionList.setSelectedIndex(6); //centre midelfier
		m_playerMarketValueField.setText("");
		//m_favoriteLegGroup.s
		m_playerHeightSpinner.setValue(1.75);
		m_playerWeightSpinner.setValue(60);
		m_divingGoalkeeperSpinner.setValue(60);
		m_handlingGoalkeeperSpinner.setValue(60);
		m_kickingGoalkeeperSpinner.setValue(60);
		m_reflexesGoalkeeperSpinner.setValue(60);
		m_speedingGoalkeeperSpinner.setValue(60);
		m_positionGoalkeeperSpinner.setValue(60);
		m_paceRegularSpinner.setValue(60);
		m_passRegularSpinner.setValue(60);
		m_dribbleRegularSpinner.setValue(60);
		m_defenceRegularSpinner.setValue(60);
		m_powerRegularSpinner.setValue(60);
		m_shootRegularSpinner.setValue(60);
		m_urlYoutube = new String("");
		((AddYoutubeDialog)m_addYoutubeDialog).setTextAddUrlTextField("");
	}
		
	
	public boolean checkUserInputValidation(FormEvent i_event, StringBuilder  i_error) {
		if (i_event.getPlayerName().isEmpty()) {
			i_error.append("Name field can't remain empty");
			return false;
		}
		else if (i_event.getMarketValue().isEmpty()) {
			i_error.append("Market Value field can't remain empty");
			return false;
		}
		else if (i_event.getCurrentTeam().isEmpty() && !i_event.isFreeAgent()) { //if NOT free agent and current value is null - error
			i_error.append("If the player is not a free agent, the current team field can not remain empty ");
			return false;
		}
		else if (Utils.isNotOnlyNumbersInString(i_event.getMarketValue())) {
			i_error.append("Market Value should only contain numbers");
			return false;
		}
		else if (!isValidYoutubeUrl(i_event)) {
			i_error.append("The link to the Youtube video inserted is invalid.\r\n" + 
					"Only links to YouTube videos are accepted");
			return false;
		}
		else if (i_event.getImage() == null) {
			i_error.append("You must upload a profile photo for the player");
			return false;
		}
		else return true;
	}
	
	public boolean isValidYoutubeUrl(FormEvent i_event) {
		String regex = "^(https?\\:\\/\\/)?((www\\.)?youtube\\.com|youtu\\.?be)\\/.+$";
		String urlYoutube = i_event.getUrlYoutube();
		 // Create a Pattern object
		 boolean isMatch = Pattern.matches(regex, urlYoutube);
		 //if the string is valid youtube video
		 if (isMatch) {
			 //add "_popup" to url
		        String watchWord = "watch";
		        int startIndex = urlYoutube.indexOf(watchWord);
		        int endIndex = startIndex + watchWord.length();
		        StringBuffer newYoutubeUrl = new StringBuffer(urlYoutube); 
		        newYoutubeUrl.insert(endIndex, "_popup"); 
		        //set new url to event
		        i_event.setUrlYoutube(newYoutubeUrl.toString());
		        return true;		        
		 }
		 return false;		
	}
		
}
