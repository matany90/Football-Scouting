package gui;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.filechooser.FileFilter;

public class CustomFileFilter extends FileFilter {
	
	private List<String> m_legalExtensions;
	private String m_description;
 
	public CustomFileFilter(String[] i_legalExtensions, String i_description) {
		this.m_legalExtensions = Arrays.asList(i_legalExtensions);
		this.m_description = i_description;
	}
	
	public boolean accept(File file) {
		
		if (file.isDirectory()) { //can go into directories
			return true;
		}
		String name = file.getName();
		String extension = Utils.getFileExtension(name);
		
		if (extension == null) {
			return false;
		}
		
		for (String legelEx : m_legalExtensions) {
			if (extension.equals(legelEx)) {
				return true;
			}
		}

		return false;
	}

	public String getDescription() {
		return this.m_description;
	}
}
