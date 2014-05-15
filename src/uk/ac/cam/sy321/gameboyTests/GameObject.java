package uk.ac.cam.sy321.gameboyTests;

public class GameObject {

	private char repr;
	private Interaction interaction;
	//TODO: Sprite
	protected String name;


	/**
	 * Creates a new game object with default interaction and a specified character
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
	 * Creates a new game object with default interaction and the default symbol.
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
	
	public void setInteraction(Interaction i){
		interaction=i;
	}
	
	public void setName(String n){
		name=n;
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
		interaction.run();
	}
}
