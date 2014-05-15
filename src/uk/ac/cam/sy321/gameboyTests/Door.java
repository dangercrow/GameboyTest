package uk.ac.cam.sy321.gameboyTests;

public class Door extends Tile {

	private char repr = '-';

	public Door(boolean locked){
		super();
		if (locked){
			super.setObject(new LockedDoor());
		}
	}

	@Override
	public char getRepr(){
		return (getObject() != null ? super.getObject().getRepr() : repr);
	}

	public void setRepr(char representation){
		repr = representation;
	}
}
