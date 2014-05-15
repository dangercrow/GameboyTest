package uk.ac.cam.sy321.gameboyTests;

public class GameObject {

	private char repr;
	private Interaction interaction;
	//TODO: Sprite
	protected String name;

	/**
	 * Creates a new game object with an interaction tied to it and
	 * a specified character representation
	 * @param interact An interaction class that shows what happens when
	 * the object is interacted with
	 * @param Representation A character to be used for the symbol
	 * of the object on the map
	 */
	public GameObject(Interaction interact, char Representation){
		repr = Representation;
		interaction = interact;
		name = new String();
	}

	/**
	 * Creates a new game object with an interaction and the default symbol.
	 * The default symbol is 'x'
	 * @param interact An interaction class that shows what happens when
	 * the object is interacted with
	 */
	public GameObject(Interaction interact){
		repr = 'x';
		interaction = interact;
		name = new String();
		repr = 'x';
		}

	/**
	 * Creates a new game object with no interaction and a specified character
	 * representation.
	 * @param Representation A character to be used for the symbol of the object
	 * on the map
	 */
	public GameObject(char Representation){
		repr = Representation;
		interaction = new Interaction(this);
		name = new String();
	}

	/**
	 * Creates a new game object with no interaction and the default symbol.
	 * The default symbol is 'x'
	 */
	public GameObject(){
		interaction = new Interaction(this);
		name = new String();
		repr = 'x';
	}

	public void setRepresentation(char c){
		repr=c;
	}



	/**
	 * @return The character symbol that represents the object on the map.
	 */
	public char getRepr() {
		return repr;
	}
	
	public String getName() {
		return name;
	}

	public Interaction getInteraction() {
		return interaction;
	}



	public void onInteract(){

	}
}
