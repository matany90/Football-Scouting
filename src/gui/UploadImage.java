package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class UploadImage extends JPanel {
	private JButton m_uploadButton;
	private JLabel m_imageLabel;
	private JFileChooser m_fileImageChooser;
	private ImageIcon m_imageToUpload;
	
	
	public UploadImage() {
			
		//init
		m_uploadButton = new JButton("Upload");
		m_imageLabel = new JLabel();
		m_fileImageChooser = new JFileChooser();
		
		//label size and border
		m_imageLabel.setPreferredSize(new Dimension(100, 100));
		m_imageLabel.setBorder(new LineBorder(Color.black, 1, true));
		
		//upload image filter file		
		String[] okFileExtensions = new String[] { "jpg", "jpeg", "png", "gif", "bmp" };
		CustomFileFilter perFileFilter = new CustomFileFilter(okFileExtensions, "Image files");
		m_fileImageChooser.addChoosableFileFilter(perFileFilter);
		m_fileImageChooser.setFileFilter(perFileFilter);
		
		//set hand pointer on hover
		m_imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//load default image
		loadDefaultImage();
		
		//upload listener
		m_imageLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
	                int result = m_fileImageChooser.showOpenDialog(null);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File file = m_fileImageChooser.getSelectedFile();
	                    try {
	                    	BufferedImage bufferdImg = ImageIO.read(file); //reading the file
	                    	Image dimg = bufferdImg.getScaledInstance(m_imageLabel.getWidth(), m_imageLabel.getHeight(),
	                    	        Image.SCALE_SMOOTH); //fix image size to fit label
	                    	m_imageToUpload = new ImageIcon(dimg);
	                    	m_imageLabel.setIcon(m_imageToUpload); //set image to label
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });
		
		
		//setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		add(m_imageLabel, BorderLayout.PAGE_START);
		//add(m_uploadButton, BorderLayout.PAGE_END);
	}


	public ImageIcon getImageToUpload() {
		return m_imageToUpload;
	}
	
	public void loadDefaultImage() {
		//load Default image
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/defaultProfilePhoto.jpg")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		m_imageLabel.setIcon(imageIcon);
	}


	public void setImageToUpload(ImageIcon m_imageToUpload) {
		this.m_imageToUpload = m_imageToUpload;
	}
	
}
