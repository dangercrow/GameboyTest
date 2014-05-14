package uk.ac.cam.sy321.gameboyTests;

public class Player extends GameObject{

	static Player player;



	private Player(){
		super('O');
	}



	public static Player getPlayer(){
		if(player == null){
			player = new Player();
		}
		return player;
	}
}
