package model;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import gui.Utils;


public class Database {
	private List <Player> m_players;
	private static Database SingletonDatabase = null;
	
	private Database() {
		m_players = new LinkedList<Player>();
	}
	
	public static Database getInstance() { //Singleton Design pattern
		if (SingletonDatabase == null) {
			SingletonDatabase = new Database();
		}
		
		return SingletonDatabase;
	}
	
	public void setPlayers(List<Player> players) {
		m_players = players;
	}
	
	public void addPlayer(Player player) {
		m_players.add(player);
	}
	
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(m_players);
	}
	
	public boolean isPlayerNotExists(String i_idToSearch) {
		for (Player player : m_players) {
			if (i_idToSearch.equals(player.getId())) {
				return false;
			}
		}
		return true;
	}
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Player[] players = m_players.toArray(new Player[m_players.size()]);
		List<BufferedImage> imageSelection= new ArrayList<BufferedImage>();
		for (Player player : m_players) {
			BufferedImage bi = Utils.convertImageIconToBufferedImage(player.getImage());
				imageSelection.add(bi);
			}
		oos.writeObject(players);
		oos.writeInt(players.length);
		for (BufferedImage eachImage : imageSelection) {
	        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	        ImageIO.write(eachImage, "png", buffer);
	        oos.writeInt(buffer.size()); // Prepend image with byte count
	        buffer.writeTo(oos);         // Write image
		}
		oos.close();
	}
	
	public void loadFromFile(InputStream is) throws IOException {
		ObjectInputStream ois = new ObjectInputStream(is);
		try {
			Player[] players = (Player[])ois.readObject();
			int imageCount = ois.readInt();
		    for (Player player : players) {
		        int size = ois.readInt(); // Read byte count
		        byte[] buffer = new byte[size];
		        ois.readFully(buffer); // Make sure you read all bytes of the image
		        player.setImage(new ImageIcon(ImageIO.read(new ByteArrayInputStream(buffer))));
		    }
			m_players.clear();
			m_players.addAll(Arrays.asList(players));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void removePlayer(int rowToRemove) {
		m_players.remove(rowToRemove);
	}
	
}
