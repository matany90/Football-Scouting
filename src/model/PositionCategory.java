package model;

public class PositionCategory {
	
	private int id;
	private String position;
	
	public PositionCategory(int id, String position) {
		this.id = id;
		this.position = position;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
