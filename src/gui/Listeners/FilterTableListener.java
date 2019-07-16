package gui.Listeners;

import java.util.List;

import javax.swing.RowFilter;

public interface FilterTableListener {
	public void changeTextOccurred(List<RowFilter<Object,Object>> filters);
}
