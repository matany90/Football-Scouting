package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Controller;
import model.Player;

public class MainFrame extends JFrame {
	private AddPlayerFormPanel m_addPlayerFormPanel;
	private SearchPlayerFormPanel m_searchPlayerFormPanel;
	private JSplitPane m_splitPane;
	private JTabbedPane m_Tabs;
	private TablePanel m_tablePanel;
	private Controller m_controller;
	private JFileChooser m_fileChooser;
	private LoginDialog m_loginDialog;
	private PlayerDetailsDialog  m_playerDetailsDialog;
	final private String k_passwordAgentUser = new String("123456");
	final private String[] k_userTypeOptions = {"Agent User"}; 

	public MainFrame() {
		//Call base Class
		super("Football Scouting");
		
		//Set logo TODO: check if work
			try {
				setIconImage(ImageIO.read(getClass().getResource("/img/logoNoBack.png")));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		//Init Components:
		m_addPlayerFormPanel = new AddPlayerFormPanel();
		m_searchPlayerFormPanel = new SearchPlayerFormPanel();
		m_tablePanel = new TablePanel();
		m_Tabs = new JTabbedPane();
		m_controller = new Controller();
		m_splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, m_Tabs, m_tablePanel);
		m_fileChooser = new JFileChooser();
		m_loginDialog = new LoginDialog(this);
		m_playerDetailsDialog = new PlayerDetailsDialog(this);

		
		////show login page
		m_loginDialog.setVisible(true);
		setEnabled(false); //set MainFrame disabled when login pop up
		m_loginDialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
		//set login ok button listener
		m_loginDialog.setLoginListener(new LoginDialogListener() {
			public boolean LoginDialogChange(String user, String password) {
				if (Arrays.asList(k_userTypeOptions).contains(user) && password.equals(k_passwordAgentUser)) {
					showMessageDialog("Login successful!",
							"Login", JOptionPane.INFORMATION_MESSAGE);
					MainFrame.this.setEnabled(true);
					return true;
				} 
				else {
					showMessageDialog("Username or password is incorrect. Please try again",
							"Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}				
			}
		});

		
		//set Tabs:
		m_splitPane.setOneTouchExpandable(true);
		m_Tabs.addTab("Add Player", m_addPlayerFormPanel);
		m_Tabs.addTab("Search Players", m_searchPlayerFormPanel);
		
		//tab switch - clear data of the previus 
		m_Tabs.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {		
				 if (m_Tabs.getSelectedIndex() == 0) {
					 m_searchPlayerFormPanel.setDefaultsSearchForm();
				 }
			}	
		});

		//set table
		m_tablePanel.setData(m_controller.getPlayers());
		
		//set row sorter
		m_tablePanel.initTableSorter();
		
	
		
		//set table listener for delete row
		m_tablePanel.setPlayerTableListener(new PlayerTableListener() {
			public void rowDeleted(int row) {
				m_controller.removePlayer(row);
			}
		});
		
		//set table listener for open dialog player details
		m_tablePanel.setPlayerDetailsListener(new PlayerDetailsListener() {
			public void showPlayerDetails(Player player) {
				m_playerDetailsDialog.setPlayerToShow(player);
				m_playerDetailsDialog.setVisible(true);
			}		
		});
		
		
		//set player detialis dialog
		m_playerDetailsDialog.setClosePlayerDialogListener(new ClosePlayerDialogListener() {
			public void onCloseDialog() {
				MainFrame.this.setEnabled(true);
			}
			@Override
			public void onOpenDialog() {
				MainFrame.this.setEnabled(false);				
			}			
		});		
		
		//load default file;
		try {
			//FOR PRODUCTION - jar file need to be in the project folder:
			InputStream is = new FileInputStream("testFiles/defaultFile.fer");
			//FOR DEVELOPMENT:
			//InputStream is = getClass().getResourceAsStream("/testFiles/defaultFile.fer");
			//FOR BOTH:
			m_controller.loadFromFile(is);
			m_tablePanel.refresh();
		}
			catch (IOException e) {
			showConfirmDialog(e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		
		
		//filter the Files types - use PlayerFileFilter class that extends FileFilter abstract class
		String[] okFileExtensions = new String[] {"fer"};
		CustomFileFilter perFileFilter = new CustomFileFilter(okFileExtensions, "Football Scouting database files (*.fer)");
		m_fileChooser.addChoosableFileFilter(perFileFilter);
		m_fileChooser.setFileFilter(perFileFilter);
		
		
		//set form ok button listener
		m_addPlayerFormPanel.setOkButtonFormListener(new FormListener() {
			public void formEventOccurred(FormEvent event) {
				StringBuilder  error = new StringBuilder ();
				if (m_addPlayerFormPanel.checkUserInputValidation(event, error)) {
						if (showConfirmDialog("Are you sure you want to add the player to Table?",
								"Save", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)
								&& m_controller.isPlayerNotExists(event.getId())) {
							m_controller.addPlayer(event);
							m_tablePanel.refresh();
							m_addPlayerFormPanel.clearFormData();
						} 
						else if (!m_controller.isPlayerNotExists(event.getId())) { //id's player exists
							showConfirmDialog( 
			                "A player with ID: " + event.getId() + " already exists. "
			                + "If you want to re-create the player, please delete the current one", "Error",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
				}
				else {
					JOptionPane.showConfirmDialog(MainFrame.this, 
			                error, "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}	
		});

			
		//set ALL search listeners
		setSearchListeners();
		
		//Adding Components:
		add(m_splitPane, BorderLayout.CENTER);
		
		setSize(1350,725);
		setJMenuBar(createMenuBar());
		setMinimumSize(new Dimension(1200, 675));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	private JMenuBar createMenuBar() {
		//init Menu
		JMenuBar menuBar = new JMenuBar();
		//First Level
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//init FileMenu items
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
	
		
		//add Mnemonic (Key control) to Menu
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		
		//add Accelerators (Key shortcut) to exit
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		//Add functional - exportData from Menu
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (m_fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						File fileAfterExtentionCheck = m_fileChooser.getSelectedFile(); //check if need to add ".fer" extention
						String filePath = fileAfterExtentionCheck.getAbsolutePath();
						if (!filePath.endsWith(".fer")) {
							fileAfterExtentionCheck = new File(filePath + ".fer");
						}	
						 if (fileAfterExtentionCheck.exists()) {
							 if (showConfirmDialog("The file exists, Do you want to overwrite?", "Existing file" 
							 		,JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {
								 m_controller.saveToFile(fileAfterExtentionCheck); // save the file
							 } 
						 }	
						 else {
								m_controller.saveToFile(fileAfterExtentionCheck); // save the file
						 }
					} catch (IOException e1) {
						showMessageDialog("Could not save data to file.",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}	
		});
		
		//Add functional - importData from Menu
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (m_fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
					    InputStream targetStream = new FileInputStream(m_fileChooser.getSelectedFile());
						m_controller.loadFromFile(targetStream);
						m_tablePanel.refresh();
					} catch (IOException e1) {
						showMessageDialog("Could not load data from file.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}	
		});
		
		//Add functional - exit from Menu
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showConfirmDialog("Do you really want to Exit?", "Confirm Exit",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE))  {
					System.exit(0);
				}
			}
		});
		
		return menuBar;
	}
	
	
	private boolean showConfirmDialog(String i_message, String i_header, final int i_answersType, final int i_icon) {
		int answer = JOptionPane.showConfirmDialog(MainFrame.this, 
				i_message, i_header, i_answersType, i_icon);
			return answer == 0;
	}
	
	private void showMessageDialog(String i_message, String i_header, final int i_icon) {
		JOptionPane.showMessageDialog(MainFrame.this, 
				i_message, i_header, i_icon);
	}
	
	
	private void setSearchListeners() {
		//invoke with every change on search's state
		 DocumentListener fieldsListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				updateFilter();				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				updateFilter();				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				updateFilter();				
			}		
		};
				
		m_searchPlayerFormPanel.setFieldsListener(fieldsListener); //set listener to SearchForm
		m_searchPlayerFormPanel.setFieldsAttachedListener(fieldsListener); //attached TextFields to listener
	}
	

    private void updateFilter() {
    	//getting the current search state after change made
    	String nameValueUserTyped = m_searchPlayerFormPanel.getSearchByNameField().getText();
    	String currentTeamUserTyped = m_searchPlayerFormPanel.getSearchByCurrentTeamField().getText();
    	String minMarketValueUserTyped = m_searchPlayerFormPanel.getSearchByMinMarketValueField().getText();
    	String maxMarketValueUserTyped = m_searchPlayerFormPanel.getSearchByMaxMarketValueField().getText();
    	String minAgeValueUserTyped = m_searchPlayerFormPanel.getSearchByMinAgeField().getText();
    	String maxAgeValueUserTyped = m_searchPlayerFormPanel.getSearchByMaxAgeField().getText();
    	String minOverallUserTyped = m_searchPlayerFormPanel.getSearchByMinOverallField().getText();
    	String maxOverallUserTyped = m_searchPlayerFormPanel.getSearchByMaxOverallField().getText();
    	boolean isFreeAgentOnly = m_searchPlayerFormPanel.getSearchByFreeAgentOnlyField().getText().equals("1");
    	
    	//create filters array and init rowFilters
	List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
		CustomRowFilter customRowFilter = new CustomRowFilter();
		
		filters.add(customRowFilter.getPlayerNameFilter(nameValueUserTyped));
		filters.add(customRowFilter.getCurrentTeamFilter(currentTeamUserTyped));
		filters.add(customRowFilter.getMaxMarketValueFilter(maxMarketValueUserTyped));
		filters.add(customRowFilter.getMinMarketValueFilter(minMarketValueUserTyped));
		filters.add(customRowFilter.getMinAgeFilter(minAgeValueUserTyped));
		filters.add(customRowFilter.getMaxAgeFilter(maxAgeValueUserTyped));
		filters.add(customRowFilter.getMinOverallFilter(minOverallUserTyped));
		filters.add(customRowFilter.getMaxOverallFilter(maxOverallUserTyped));
		filters.add(customRowFilter.getFreeAgentOnlyFilter(isFreeAgentOnly));
		m_tablePanel.setRowFilter(filters);
    }

}


	
	

