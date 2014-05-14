package uk.ac.cam.sy321.gameboyTests;

public class Tile {

	private GameObject relatedObject;
	private boolean hasObject = false;



	public Tile(){}

	public Tile(GameObject obj){
		relatedObject = obj;
		hasObject = true;
	}



	public boolean hasObject(){
		return hasObject;
	}

	public void setObject(GameObject obj){
		relatedObject = obj;
		hasObject = true;
	}

	public GameObject getObject(){
		return relatedObject;
	}

	public void destroyObject(){

		hasObject=false;
	}

	public void setObjectVisibility(boolean visible){
		hasObject=visible;
	}

	public char getRepr(){
		return (hasObject ? relatedObject.getRepr() : '.');
	}


	public void onStep(){
		// Some form of interaction
	}
}
