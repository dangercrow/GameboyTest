package uk.ac.cam.sy321.gameboyTests;

public class Dialogue extends Interaction {

	protected String[] dialogueArray; 
	
	public Dialogue(GameObject object, String[] dialogue) {
		super(object);
		dialogueArray=dialogue;
	}
	
	@Override
	public void run(){
		for (String i : dialogueArray){
			System.out.println(i);
		}
	}

}
