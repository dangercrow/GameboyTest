package uk.ac.cam.sy321.gameboyTests;

public class GameObject {

	private char Repr='x';
	private Interaction interaction;



	public GameObject(Interaction interact, char Representation){
		Repr=Representation;
		interaction = interact;
	}

	public GameObject(Interaction interact){
		interaction = interact;
	}

	public GameObject(char Representation){
		Repr=Representation;
		interaction = new Interaction();
	}

	public GameObject(){
		interaction = new Interaction();
	}



	public char getRepr() {
		return Repr;
	}

	public Interaction getInteraction() {
		return interaction;
	}



	public void onInteract(){

	}
}
