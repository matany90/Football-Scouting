package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Utils {
	
	public static boolean isNotOnlyNumbersInString(String i_stringToCheck) {
		return !i_stringToCheck.matches("[0-9]+"); //check if there are only numbers and then return with !
	}
	
	public static String getFileExtension(String name) {
		int pointIndex = name.lastIndexOf(".");
		
		if (pointIndex == -1) {
			return null;
		}
		
		if (pointIndex == name.length() - 1) {
			return null;
		}
		
		return name.substring(pointIndex + 1, name.length());
	}
	
	public static BufferedImage convertImageIconToBufferedImage(ImageIcon image) {
		BufferedImage bi =  new BufferedImage(
				image.getIconWidth(),
				image.getIconHeight(),
			    BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.createGraphics();
			// paint the Icon to the BufferedImage.
			image.paintIcon(null, g, 0,0);
			g.dispose();
			
			return bi;
	}
	
	public static JLabel resourceImageToJLabel(Dimension i_dimension, String i_resourcePath) {
		JLabel imageLabel = new JLabel();
		imageLabel.setPreferredSize(i_dimension);
		
		ImageIcon imageIcon = new ImageIcon(Utils.class.getResource(i_resourcePath)); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance((int)i_dimension.getWidth(), (int)i_dimension.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		imageLabel.setIcon(imageIcon);
		
		return imageLabel;
	}


}

