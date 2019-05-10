package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddYoutubeDialog extends JDialog {
	private JLabel m_addUrlLabel;
	private JTextField m_addUrlTextField;
	private JButton m_add;
	private ConfirmDialogYoutubeListener m_confirmDialogYoutubeListener;
	
	public AddYoutubeDialog(JPanel parent) {
	//init components
		m_addUrlLabel = new JLabel("Add Youtube URL: ");
		m_addUrlTextField = new JTextField(30);
		m_add = new JButton("Confirm");
		
		//size of login pop up
		setSize(500, 150);
		setMinimumSize(new Dimension(500, 150));
		setLocationRelativeTo(parent);
		
		m_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (m_confirmDialogYoutubeListener != null) {
					m_confirmDialogYoutubeListener.onConfirmClicked();
				}
			}			
		});
		
		
		layoutComponents();
	}
	
	public JTextField getAddUrlTextField() {
		return m_addUrlTextField;
	}
	
	public void setTextAddUrlTextField(String i_stringToSet) {
		m_addUrlTextField.setText(i_stringToSet);
	}
	
	public void setConfirmDialogYoutubeListener(ConfirmDialogYoutubeListener i_listener) {
		m_confirmDialogYoutubeListener = i_listener;
	}

	private void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridy = 0;
		gc.insets = new Insets(0,0,0,5);
		
		////////////FIRST LINE - add label
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(m_addUrlLabel, gc);
		
		////////////FIRST LINE - add text field
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(m_addUrlTextField, gc);
		
		////////////FIRST LINE - add text field
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(m_add, gc);
	}
}
