package uk.ac.cam.sy321.gameboyTests;

public class Interaction {
	GameObject obj;
	public Interaction(GameObject object){
		obj=object;
	}
	
	public void run(){
		System.out.println("You have interacted with a " + obj.getName() } ".");
	}
}
