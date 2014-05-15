package uk.ac.cam.sy321.gameboyTests;

public class GameObject {

	private char repr;
	private Interaction interaction;
	//TODO: Sprite
	private String name;


	public GameObject(Interaction interact, char Representation){
		repr = Representation;
		interaction = interact;
		name = new String();
	}

	public GameObject(Interaction interact){
		interaction = interact;
		name = new String();
		repr = 'x';
		}

	public GameObject(char Representation){
		repr = Representation;
		interaction = new Interaction(this);
		name = new String();
	}

	public GameObject(){
		interaction = new Interaction(this);
		name = new String();
		repr = 'x';
	}

	public void setRepresentation(char c){
		repr=c;
	}

	public char getRepr() {
		return repr;
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
