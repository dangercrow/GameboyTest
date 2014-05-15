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

	/**
	 * Overrides the default symbol for a door. Can be used for creating hidden doors/teleporters
	 * @param representation The new symbol to be used for the door
	 */
	public void setRepr(char representation){
		repr = representation;
	}
}
