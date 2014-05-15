package uk.ac.cam.sy321.gameboyTests;

public class GameObject {

	private char Repr = 'x';
	private Interaction interaction;
	//TODO: Sprite
	private String name=new String();


	public GameObject(Interaction interact, char Representation){
		Repr = Representation;
		interaction = interact;
	}

	public GameObject(Interaction interact){
		interaction = interact;
	}

	public GameObject(char Representation){
		Repr = Representation;
		interaction = new Interaction(this);
	}

	public GameObject(){
		interaction = new Interaction(this);
	}



	public char getRepr() {
		return Repr;
	}

	public Interaction getInteraction() {
		return interaction;
	}

	public String getName(){
		return name;
	}

	public void onInteract(){

	}
}
