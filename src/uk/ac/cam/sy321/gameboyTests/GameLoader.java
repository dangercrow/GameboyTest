package uk.ac.cam.sy321.gameboyTests;

import java.io.IOException;

public class GameLoader {

	public static void main(String[] args) throws IOException{
		int input = 0;
		Room room = new Room();
		while (input!='q'){
			System.out.println("Press 'q' to quit or use 'W','A','S','D' to navigate"); // use the cursor keys to navigate.");
			input = System.in.read();
			switch (input){
			case 'w':
				room.movePlayer(Room.Direction.Up);
				drawRoom(room);
				break;
			case 'a':
				room.movePlayer(Room.Direction.Left);
				drawRoom(room);
				break;
			case 's':
				room.movePlayer(Room.Direction.Down);
				drawRoom(room);
				break;
			case 'd':
				room.movePlayer(Room.Direction.Right);
				drawRoom(room);
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
