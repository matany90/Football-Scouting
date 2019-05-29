package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class LoginDialog extends JDialog implements FootballScoutingJDialogs {
	private JLabel m_userLabel;
	private JLabel m_passwordLabel;
	private JButton m_okButton;
	private JComboBox m_userType;
	private JPasswordField m_passwordField;
	private Font m_userAndPasswordFont;
	private JLabel m_imageLabel;
	final private String k_passwordAgentUser = new String("123456");
	private LoginDialogListener m_loginListener;
	
	public LoginDialog(JFrame parent) {
		super(parent, "Login User", false);
		
		//init components
		m_okButton = new JButton("Login");
		m_userType = new JComboBox();
		m_passwordField = new JPasswordField(15);
		m_userLabel = new JLabel("User Type: ");
		m_passwordLabel = new JLabel("Password: ");
		m_userAndPasswordFont = new Font(m_userLabel.getFont().getName(), m_userLabel.getFont().getStyle(), 15);
		m_imageLabel = new JLabel();
		
		//show * insted of points
		m_passwordField.setEchoChar('*');
		
		//set default password for agent
		m_passwordField.setText(k_passwordAgentUser);
		
		//load Default image
		m_imageLabel = Utils.resourceImageToJLabel(new Dimension(160, 140), "/img/logoNoBack.png");
		
		//set fonts user and password label
		m_userLabel.setFont(m_userAndPasswordFont);
		m_passwordLabel.setFont(m_userAndPasswordFont);
		
		//user type model and font for user type model
		DefaultComboBoxModel userModel = new DefaultComboBoxModel();
		Font fontForComboBox = m_userType.getFont();
		m_userType.setFont(fontForComboBox.deriveFont(15.0f));
		userModel.addElement("Agent User");
		m_userType.setPreferredSize(new Dimension(200, 50));
		m_userType.setBorder(BorderFactory.createEtchedBorder());
		m_userType.setModel(userModel);
		
		
		//size of login pop up
		setSize(500, 220);
		setMinimumSize(new Dimension(500, 220));
		setLocationRelativeTo(parent);
		
		//border to login dialog
		Border innerBorder = BorderFactory.createTitledBorder("User and Password: ");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		getRootPane().setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		//okButton listener
		m_okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = (String)m_userType.getSelectedItem();
				char[] password = m_passwordField.getPassword();
				if (m_loginListener != null) {
					boolean isLoginSucceed = m_loginListener.LoginDialogChange(user, new String(password));
					if (isLoginSucceed) {
						setVisible(false);
					} 
					else {
						m_passwordField.setText("");
					}
				}
			}			
		});		
		layoutComponentsInJDialog();
	}
	
//	private void layoutComponents() {
//
//	}
	
	public void setLoginListener(LoginDialogListener i_listener) {
		m_loginListener = i_listener;
	}

	@Override
	public void layoutComponentsInJDialog() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridy = 0;
		gc.insets = new Insets(0,0,0,5);
		
		////////////FIRST LINE - USER TYPE
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(m_userLabel, gc);
		
		gc.gridx++;
		gc.weightx = 6;
		gc.anchor = GridBagConstraints.LINE_START;
		add(m_userType, gc);
		
		
		///////////////NEW LINE -PASSWORD
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(m_passwordLabel, gc);
		
		gc.gridx++;
		gc.weightx = 6;
		gc.anchor = GridBagConstraints.LINE_START;
		add(m_passwordField, gc);
		
		
		///////////////NEW LINE -OK BUTTON
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 3;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(10,0,0,5);
		add(m_okButton, gc);	
		
		//////////////////////IMAGE/
        gc.gridx++;
        gc.weightx = 0;
        gc.gridy = 0;
        gc.weighty = 1;
        gc.gridheight = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.insets = new Insets(0,0,0,5);
        add(m_imageLabel, gc);
		
	}
}
