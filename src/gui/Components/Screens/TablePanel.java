package gui.Components.Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import gui.Listeners.PlayerDetailsListener;
import gui.Listeners.PlayerTableListener;
import model.Player;
import model.PlayerTableModel;

public class TablePanel extends JPanel {
	private JTable m_table;
	private PlayerTableModel m_tableModel;
	private JPopupMenu m_popup;
	private TableRowSorter<PlayerTableModel> m_sorter;
	private JTableHeader m_header;
	private PlayerTableListener m_playerTableListener;
	private PlayerDetailsListener m_playerDetailsListener;

	public TablePanel() {
		m_tableModel = new PlayerTableModel();
		m_table = new JTable(m_tableModel);
		m_popup = new JPopupMenu();
		m_header = m_table.getTableHeader();
		
		//set Header
		m_header.setBackground(Color.BLUE);
		m_header.setForeground(Color.WHITE);
		m_header.setFont(new Font("Arial", Font.BOLD, 15));
		
		//set cells font
		m_table.setFont(new Font("Arial", Font.BOLD, 13));

		//set Cols+Row size
		m_table.getColumn("Position on field").setMinWidth(100);
		m_table.getColumn("Market Value").setMinWidth(100);
		m_table.getColumn("Current Team").setMinWidth(100);
		m_table.getColumn("Name").setMinWidth(100);
		m_table.getColumn("Profile Photo").setMinWidth(100);
		m_table.setRowHeight(100);
		
		   
		//add delete item option to the popup menu
		JMenuItem removeItem = new JMenuItem("Delete Item");
		m_popup.add(removeItem);
		
		//press on table action listener
		m_table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int rowPressed = m_sorter.convertRowIndexToModel(m_table.rowAtPoint(e.getPoint())); //take the right row index after possible sorting
				int rowToBold = m_sorter.convertRowIndexToView(rowPressed);
				m_table.getSelectionModel().setSelectionInterval(rowToBold, rowToBold);
				if (e.getButton() == MouseEvent.BUTTON3) {
					m_popup.show(m_table, e.getX(), e.getY());
				}
				if (e.getClickCount() == 2 && m_playerDetailsListener != null) {
					m_playerDetailsListener.showPlayerDetails(m_tableModel.getPlayer(rowPressed));
				}
			}		
		});
		
		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowPressed = m_sorter.convertRowIndexToModel(m_table.getSelectedRow());
				if (m_playerTableListener != null) {
					m_playerTableListener.rowDeleted(rowPressed);
					m_tableModel.fireTableRowsDeleted(rowPressed, rowPressed);
				}			
			}
		});
			
		
		setLayout(new BorderLayout());
		add(new JScrollPane(m_table), BorderLayout.CENTER);
		
	}
	
	public void setPlayerTableListener(PlayerTableListener i_listener) {
		this.m_playerTableListener = i_listener;
	}
	
	public PlayerTableListener getPlayerTableListener() {
		return m_playerTableListener;
	}
	
	public void setPlayerDetailsListener(PlayerDetailsListener i_listener) {
		m_playerDetailsListener = i_listener;
	}

	public void setData(List<Player> players) {
		m_tableModel.setData(players);
	}
	
	public void refresh() {
		m_tableModel.fireTableDataChanged();
	}
	
	public PlayerTableModel getModel() {
		return m_tableModel;
	}
	
	public JTable getTable() {
		return m_table;
	}
		
	public void setRowFilter(List<RowFilter<Object,Object>> i_filters) {
		if (m_sorter != null ) {
			m_sorter.setRowFilter(RowFilter.andFilter(i_filters));
		}
	}
	
	public void initTableSorter() {
		m_sorter = new TableRowSorter<PlayerTableModel>(m_tableModel);		
		m_table.setRowSorter(m_sorter);
		
		///set default sort by skills
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();		 
		sortKeys.add(new RowSorter.SortKey(m_tableModel.columnIndexByName("Overall Skills"), SortOrder.DESCENDING));
		m_sorter.setSortKeys(sortKeys);
		m_sorter.sort();
	}
}
