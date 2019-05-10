package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;

public class SearchPlayerFormPanel extends JPanel {
	
	//name
	private JCheckBox m_searchByNameCheckBox;
	private JLabel m_searchByNameLabel;
	private JTextField m_searchByNameField;
	private JCheckBox m_searchByCurrentTeamCheckBox;
	private JLabel m_searchByCurrentTeamLabel;
	private JTextField m_searchByCurrentTeamField;
	//market value
	private JCheckBox m_searchByMarketValueCheckBox;
	private JLabel m_searchByMarketValueLabel;
	private JLabel m_searchByMinMarketValueLabel;
	private JTextField m_searchByMinMarketValueField;
	private JLabel m_searchByMaxMarketValueLabel;
	private JTextField m_searchByMaxMarketValueField;
	//age
	private JCheckBox m_searchByAgeCheckBox;
	private JLabel m_searchByplayerAgeLabel;
	private JLabel m_m_searchByplayerAgeLabelFrom;
	private JLabel m_m_searchByplayerAgeLabelTo;
	private SpinnerNumberModel m_ageMinModel;
	private JSpinner m_searchByMinAgeSpinner;
	private SpinnerNumberModel m_ageMaxModel;
	private JSpinner m_searchByMaxAgeSpinner;
	private JTextField m_minAgeSpinnerFormat;
	private JTextField m_maxAgeSpinnerFormat;
	//overall skill
	private JCheckBox m_searchByOverallCheckBox;
	private JLabel m_searchByMinOverallLabel;
	private JLabel m_searchByMinOverallLabelFrom;
	private JLabel m_searchByMinOverallLabelTo;
	private SpinnerNumberModel m_minOverallModel;
	private JSpinner m_searchByMinOverallSpinner;
	private SpinnerNumberModel m_maxOverallModel;
	private JSpinner m_searchByMaxOverallSpinner;
	private JTextField m_minOverallSpinnerFormat;
	private JTextField m_maxOverallSpinnerFormat;
	//free agents
	private JCheckBox m_searchByFreeAgentCheckBox;
	private JLabel m_searchByFreeAgentLabel;
	private JRadioButton m_searchByFreeAgentRadioButton;
	private JTextField m_freeAgentJRadioButtonFormat;
	//image
	private JLabel m_imageLabel;
	private DocumentListener m_fieldsListener;
	
	public SearchPlayerFormPanel() {
		//set Size:
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		//init:
		
		//by name:
		m_searchByNameCheckBox = new JCheckBox();
		m_searchByNameLabel = new JLabel("Player Name: ");
		m_searchByNameField = new JTextField(10);
		//by current team:
		m_searchByCurrentTeamCheckBox = new JCheckBox();
		m_searchByCurrentTeamLabel = new JLabel("Current Team: ");
		m_searchByCurrentTeamField = new JTextField(10);
		//by market value:
		m_searchByMarketValueCheckBox = new JCheckBox();;
		m_searchByMarketValueLabel = new JLabel("Market Value:");
		m_searchByMinMarketValueLabel = new JLabel("  From:  "); 
		m_searchByMinMarketValueField = new JTextField(8);
		m_searchByMaxMarketValueLabel = new JLabel("  To:  "); 
		m_searchByMaxMarketValueField = new JTextField(8);
		//by age:
		m_searchByAgeCheckBox = new JCheckBox(); 
		m_searchByplayerAgeLabel = new JLabel("Age: ");
		m_m_searchByplayerAgeLabelFrom = new JLabel("  From:  ");
		m_m_searchByplayerAgeLabelTo = new JLabel("  To:  ");
		m_ageMinModel = new SpinnerNumberModel(15, 15, 41, 1);
		m_searchByMinAgeSpinner = new JSpinner(m_ageMinModel);
		m_ageMaxModel = new SpinnerNumberModel(41, 15, 41, 1);
		m_searchByMaxAgeSpinner = new JSpinner(m_ageMaxModel);
		//by overall:
		 m_searchByOverallCheckBox = new JCheckBox(); 
		 m_searchByMinOverallLabel= new JLabel("Overall Skills: ");
		 m_searchByMinOverallLabelFrom = new JLabel("  From:  "); 
		 m_searchByMinOverallLabelTo = new JLabel("  To:  "); 
		 m_minOverallModel = new SpinnerNumberModel(1, 1, 99, 1);;
		 m_searchByMinOverallSpinner = new JSpinner(m_minOverallModel);;
		 m_maxOverallModel = new SpinnerNumberModel(99, 1, 99, 1);
		 m_searchByMaxOverallSpinner = new JSpinner(m_maxOverallModel);	
		 //by free agent
		 m_searchByFreeAgentCheckBox = new JCheckBox();
		 m_searchByFreeAgentLabel = new JLabel("Free Agents: ");
		 m_searchByFreeAgentRadioButton = new JRadioButton("Free Agents Only");
		 m_freeAgentJRadioButtonFormat = new JTextField("");
		 //image
		 m_imageLabel = new JLabel();
		 
		 //load image
		 m_imageLabel = Utils.resourceImageToJLabel(new Dimension(200, 160), "/img/logoNoBack.png");
		 			
		setDefaultsSearchForm();

		
		//search by player name checkBox Action Listener
		m_searchByNameCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_searchByNameCheckBox.isSelected();
					m_searchByNameLabel.setEnabled(isClicked);
					m_searchByNameField.setEnabled(isClicked);
			}		
		});
		
		//search by current Team checkBox Action Listener
		m_searchByCurrentTeamCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_searchByCurrentTeamCheckBox.isSelected();
				m_searchByCurrentTeamLabel.setEnabled(isClicked);
				m_searchByCurrentTeamField.setEnabled(isClicked);
			}		
		});
		
		//search by market value checkBox Action Listener
		m_searchByMarketValueCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_searchByMarketValueCheckBox.isSelected();
				m_searchByMarketValueLabel.setEnabled(isClicked);
				m_searchByMarketValueLabel.setEnabled(isClicked);
				m_searchByMinMarketValueField.setEnabled(isClicked);
				m_searchByMaxMarketValueField.setEnabled(isClicked);
				m_searchByMinMarketValueLabel.setEnabled(isClicked);
				m_searchByMaxMarketValueLabel.setEnabled(isClicked);
			}		
		});
		
		//search by age checkBox Action Listener
		m_searchByAgeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_searchByAgeCheckBox.isSelected();
				m_searchByplayerAgeLabel.setEnabled(isClicked);
				m_searchByMinAgeSpinner.setEnabled(isClicked);
				m_searchByMaxAgeSpinner.setEnabled(isClicked);
				m_m_searchByplayerAgeLabelFrom.setEnabled(isClicked);
				m_m_searchByplayerAgeLabelTo.setEnabled(isClicked);
			}		
		});
		
		//search by overall checkBox Action Listener
		m_searchByOverallCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_searchByOverallCheckBox.isSelected();
				m_searchByMinOverallLabel.setEnabled(isClicked);
				m_searchByMinOverallSpinner.setEnabled(isClicked);
				m_searchByMaxOverallSpinner.setEnabled(isClicked);
				m_searchByMinOverallLabelFrom.setEnabled(isClicked);
				m_searchByMinOverallLabelTo.setEnabled(isClicked);
			}		
		});
		
		//search by free agents checkBox Action Listener
		m_searchByFreeAgentCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicked = m_searchByFreeAgentCheckBox.isSelected();
				m_searchByFreeAgentRadioButton.setEnabled(isClicked);
				m_searchByFreeAgentLabel.setEnabled(isClicked);
			}		
		});
		
		//jRadio button action command
		m_searchByFreeAgentRadioButton.setActionCommand("Free Agents Only");
		
		//
		m_searchByFreeAgentRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isClicled = m_searchByFreeAgentRadioButton.isSelected();
				if (isClicled) {
					m_freeAgentJRadioButtonFormat.setText("1");
				}
				else {
					m_freeAgentJRadioButtonFormat.setText("0");
				}
				
			}			
		});
		
		
		//set Layout
		layoutComponents();
	}
	
	private void layoutComponents() {
		//set Border
		Border innerBorder = BorderFactory.createTitledBorder("Search by");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		JPanel namePanel = new JPanel();
		JPanel marketValuePanel = new JPanel();
		JPanel ageSpinnerPanel = new JPanel();
		JPanel overallPanel = new JPanel();
		JPanel currentTeamPanel = new JPanel();
		JPanel isFreeAgentPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		namePanel.add(m_searchByNameCheckBox);
		namePanel.add(m_searchByNameLabel);
		namePanel.add(m_searchByNameField);
		

		marketValuePanel.add(m_searchByMarketValueCheckBox);
		marketValuePanel.add(m_searchByMarketValueLabel);
		marketValuePanel.add(m_searchByMinMarketValueLabel);
		marketValuePanel.add(m_searchByMinMarketValueField);
		marketValuePanel.add(m_searchByMaxMarketValueLabel);
		marketValuePanel.add(m_searchByMaxMarketValueField);
		   
		ageSpinnerPanel.add(m_searchByAgeCheckBox);
		ageSpinnerPanel.add(m_searchByplayerAgeLabel);
		ageSpinnerPanel.add(m_m_searchByplayerAgeLabelFrom);
		ageSpinnerPanel.add(m_searchByMinAgeSpinner);
		ageSpinnerPanel.add(m_m_searchByplayerAgeLabelTo);
		ageSpinnerPanel.add(m_searchByMaxAgeSpinner);
		   
		overallPanel.add(m_searchByOverallCheckBox);
		overallPanel.add(m_searchByMinOverallLabel);
		overallPanel.add(m_searchByMinOverallLabelFrom);
		overallPanel.add(m_searchByMinOverallSpinner);
		overallPanel.add(m_searchByMinOverallLabelTo);
		overallPanel.add(m_searchByMaxOverallSpinner);
		  
		currentTeamPanel.add(m_searchByCurrentTeamCheckBox);
		currentTeamPanel.add(m_searchByCurrentTeamLabel);
		currentTeamPanel.add(m_searchByCurrentTeamField);
		  
		isFreeAgentPanel.add(m_searchByFreeAgentCheckBox);
		isFreeAgentPanel.add(m_searchByFreeAgentLabel);
		isFreeAgentPanel.add(m_searchByFreeAgentRadioButton);
		
		imagePanel.add(m_imageLabel);
		 
		 
		
		////////////FIRST ROW/////// Search by player name
		
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(namePanel, gc);
		//add(test2);
		
		////////////Second ROW/////// MarketValue
		
		gc.gridy++;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(marketValuePanel, gc);
		
		////////////NEXT ROW/////// age
		
		gc.gridy++;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(ageSpinnerPanel, gc);
		
		////////////NEXT ROW/////// overall
		gc.gridy++;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(overallPanel, gc);
		
		////////////NEXT ROW/////// current team
		gc.gridy++;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(currentTeamPanel, gc);
		
		////////////NEXT ROW/////// is free agent
		gc.gridy++;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(isFreeAgentPanel, gc);
		
		////////////NEXT ROW/////// is free agent
		gc.gridy++;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill =  GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.weightx = 0.1;
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(0,0,0,5);
		add(imagePanel, gc);
		
		
	}
	

	public void setFieldsListener(DocumentListener i_listener) {
		this.m_fieldsListener = i_listener;
	}
	
	public JTextField getSearchByNameField() {
		return m_searchByNameField;
	}

	public JTextField getSearchByCurrentTeamField() {
		return m_searchByCurrentTeamField;
	}
	
	public JTextField getSearchByMaxMarketValueField() {
		return m_searchByMaxMarketValueField;
	}
	
	public JTextField getSearchByMinMarketValueField() {
		return m_searchByMinMarketValueField;
	}
	
	public JTextField getSearchByMinAgeField() {
		return m_minAgeSpinnerFormat;
	}
		
	public JTextField getSearchByMaxAgeField() {
		return m_maxAgeSpinnerFormat;
	}
	
	public JTextField getSearchByMinOverallField() {
		return m_minOverallSpinnerFormat;
	}
	
	public JTextField getSearchByMaxOverallField() {
		return m_maxOverallSpinnerFormat;
	}
	
	public JTextField getSearchByFreeAgentOnlyField() {
		return m_freeAgentJRadioButtonFormat;
	}
	
	

	public void setFieldsAttachedListener(DocumentListener i_listener) {		
		m_searchByNameField.getDocument().addDocumentListener(i_listener);
		m_searchByCurrentTeamField.getDocument().addDocumentListener(i_listener);
		m_searchByMaxMarketValueField.getDocument().addDocumentListener(i_listener);
		m_searchByMinMarketValueField.getDocument().addDocumentListener(i_listener);
		//format JSpinners to work with DocumentListeners
		JSpinner.DefaultEditor editorMinAge = (JSpinner.DefaultEditor)m_searchByMinAgeSpinner.getEditor();
		m_minAgeSpinnerFormat = editorMinAge.getTextField();
		m_minAgeSpinnerFormat.getDocument().addDocumentListener(i_listener);
		
		JSpinner.DefaultEditor editorMaxAge = (JSpinner.DefaultEditor)m_searchByMaxAgeSpinner.getEditor();
		m_maxAgeSpinnerFormat = editorMaxAge.getTextField();
		m_maxAgeSpinnerFormat.getDocument().addDocumentListener(i_listener);
		
		JSpinner.DefaultEditor editorMinOverall = (JSpinner.DefaultEditor)m_searchByMinOverallSpinner.getEditor();
		m_minOverallSpinnerFormat = editorMinOverall.getTextField();
		m_minOverallSpinnerFormat.getDocument().addDocumentListener(i_listener);
		
		JSpinner.DefaultEditor editorMaxOverall = (JSpinner.DefaultEditor)m_searchByMaxOverallSpinner.getEditor();
		m_maxOverallSpinnerFormat = editorMaxOverall.getTextField();
		m_maxOverallSpinnerFormat.getDocument().addDocumentListener(i_listener);
		
		//format JRadioButton to work with DocumentListeners
		m_freeAgentJRadioButtonFormat.getDocument().addDocumentListener(i_listener);
		
	}
	

	public void setDefaultsSearchForm() {
		//set defaults for search by name checkBox 	
		m_searchByNameCheckBox.setSelected(true);
		
		//set disabled for all labels before checkbox clicked
		//current team
		m_searchByCurrentTeamCheckBox.setSelected(false);
		m_searchByCurrentTeamLabel.setEnabled(false);
		m_searchByCurrentTeamField.setEnabled(false);
		
		//market value
		m_searchByMarketValueCheckBox.setSelected(false);
		m_searchByMarketValueLabel.setEnabled(false);
		m_searchByMinMarketValueLabel.setEnabled(false);
		m_searchByMinMarketValueField.setEnabled(false);
		m_searchByMaxMarketValueField.setEnabled(false);
		m_searchByMaxMarketValueLabel.setEnabled(false);
		
		//age
		m_searchByAgeCheckBox.setSelected(false);
		m_searchByplayerAgeLabel.setEnabled(false);
		m_searchByMinAgeSpinner.setEnabled(false);
		m_searchByMaxAgeSpinner.setEnabled(false);
		m_m_searchByplayerAgeLabelFrom.setEnabled(false);
		m_m_searchByplayerAgeLabelTo.setEnabled(false);
		
		//overall
		m_searchByOverallCheckBox.setSelected(false);
		m_searchByMinOverallLabel.setEnabled(false);
		m_searchByMinOverallSpinner.setEnabled(false);
		m_searchByMaxOverallSpinner.setEnabled(false);
		m_searchByMinOverallLabelFrom.setEnabled(false);
		m_searchByMinOverallLabelTo.setEnabled(false);
		
		//free agent
		m_searchByFreeAgentCheckBox.setSelected(false);
		m_searchByFreeAgentRadioButton.setSelected(false);
		m_searchByFreeAgentRadioButton.setEnabled(false);
		m_searchByFreeAgentLabel.setEnabled(false);
		m_freeAgentJRadioButtonFormat.setText("");
				
		//clear Jtext
		m_searchByNameField.setText("");
		m_searchByCurrentTeamField.setText("");
		m_searchByMinMarketValueField.setText("");
		m_searchByMaxMarketValueField.setText("");
		m_searchByMaxAgeSpinner.setValue(41);
		m_searchByMinAgeSpinner.setValue(15);
		m_searchByMinOverallSpinner.setValue(1);
		m_searchByMaxOverallSpinner.setValue(99);
		
	}

}
