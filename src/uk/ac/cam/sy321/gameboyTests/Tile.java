package uk.ac.cam.sy321.gameboyTests;

public class Tile {

	private GameObject relatedObject;

	/**
	 * Creates a blank tile with no object. 
	 */
	public Tile(){}

	/**
	 * @param obj an object to be placed on the tile
	 */
	public Tile(GameObject obj){
		relatedObject = obj;
	}

	/**
	 * @param obj an object to be placed on the tiel
	 */
	public void setObject(GameObject obj){
		relatedObject = obj;
	}

	/**
	 * @return the object on the tile
	 */
	public GameObject getObject(){
		return relatedObject;
	}

	/**
	 * Removes the object from the tile
	 */
	public void destroyObject(){
		relatedObject = null;
	}

	/**
	 * @return the character representation of the tile
	 */
	public char getRepr(){
		return (relatedObject != null ? relatedObject.getRepr() : '.');
	}


	public void onStep(){ //TODO
		// Some form of interaction
	}
}
