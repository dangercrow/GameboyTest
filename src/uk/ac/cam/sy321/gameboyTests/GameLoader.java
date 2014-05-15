package uk.ac.cam.sy321.gameboyTests;

import java.io.IOException;

public class GameLoader {

	public static void main(String[] args) throws IOException{
		int input = 0;
		Room room = new Room();
		drawRoom(room);
		System.out.println("Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact"); // use the cursor keys to navigate.");
		while (input != 'q'){
			input = System.in.read();
			switch (input){
			case 'w':
				room.movePlayer(Room.Direction.Up);
				drawRoom(room);
				System.out.println("Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact"); // use the cursor keys to navigate.");
				break;
			case 'a':
				room.movePlayer(Room.Direction.Left);
				drawRoom(room);
				System.out.println("Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact"); // use the cursor keys to navigate.");
				break;
			case 's':
				room.movePlayer(Room.Direction.Down);
				drawRoom(room);
				System.out.println("Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact"); // use the cursor keys to navigate.");
				break;
			case 'd':
				room.movePlayer(Room.Direction.Right);
				drawRoom(room);
				System.out.println("Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact"); // use the cursor keys to navigate.");
				break;
			case 'e':
				room.interact();
				break;
			default:
				break;
			}		
		}
	}

	private static void drawRoom(Room r) {
		int roomHeight = r.getHeight();
		int roomWidth = r.getWidth();
		String s = "";

		for(int j = 0; j < roomHeight; j++) {
			for(int i = 0; i < roomWidth; i++) {
				Tile t = r.getTile(new Position(i,j));
				s += t.getRepr();
			}
			s += '\n';
		}

		System.out.println(s);
	}
}
