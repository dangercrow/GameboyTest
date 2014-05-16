package uk.ac.cam.sy321.gameboyTests;

import java.util.Random;

public class DialogueRandom extends Dialogue {

	public DialogueRandom(GameObject object, String[] dialogue) {
		super(object,dialogue);
	}

	@Override
	public void run(){
		int i = new Random().nextInt(dialogueArray.length);
		System.out.println(i);
	}
}
