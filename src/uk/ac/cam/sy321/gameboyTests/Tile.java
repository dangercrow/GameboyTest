package uk.ac.cam.sy321.gameboyTests;

public class Tile {

	private GameObject relatedObject;
	private boolean hasObject = false;


	/**
	* Creates a blank tile with no object. 
	*/
	public Tile(){}

	/**
	* @param obj an object to be placed on the tile
	*/
	public Tile(GameObject obj){
		relatedObject = obj;
		hasObject = true;
	}


	/**
	* @return If the tile has an object on it
	*/
	public boolean hasObject(){
		return hasObject;
	}

	/**
	* @param obj an object to be placed on the tiel
	*/
	public void setObject(GameObject obj){
		relatedObject = obj;
		hasObject = true;
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
		relatedObject=null;
		hasObject=false;
	}

	/**
	* @param visible changes the objects visibility, allowing
	* you to hide or unhide the object
	*/
	public void setObjectVisibility(boolean visible){
		hasObject=visible;
	}

	/**
	* @return the character representation of the tile
	*/
	public char getRepr(){
		return (hasObject ? relatedObject.getRepr() : '.');
	}


	public void onStep(){ //TODO
		// Some form of interaction
	}
}
