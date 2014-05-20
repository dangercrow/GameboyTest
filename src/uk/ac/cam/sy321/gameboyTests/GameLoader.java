package uk.ac.cam.sy321.gameboyTests;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class GameLoader extends JFrame{
	private static final long serialVersionUID = -7818961225873543644L;

	private GameLoader(){ // Don't call me until I'm completed! TODO
		super("The Game Game");
		setLayout(new BorderLayout());
		add(new GuiLogPanel(), BorderLayout.EAST);
		add(new GuiMapPanel(), BorderLayout.CENTER);
		//TODO: Make listeners
	}
	
	public static void main(String[] args) throws IOException{
		String helpString=new String("Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact"); // use the cursor keys to navigate.");
		int input = 0;
		Room room = new Room();
		GameObject cat = new GameObject('c');
		Dialogue interact = new Dialogue(cat,new String[] {"Cat!","I'm a kitty cat!","And I dance dance dance,","And I dance dance dance."});
		cat.setInteraction(interact);
		cat.setName("cat");
		room.placeObject(cat, new Position(3,3));
		drawRoom(room);
		System.out.println(helpString);
		while (input != 'q'){
			input = System.in.read();
			switch (input){
			case 'w':
				room.movePlayer(Room.Direction.Up);
				drawRoom(room);
				System.out.println(helpString);
				break;
			case 'a':
				room.movePlayer(Room.Direction.Left);
				drawRoom(room);
				System.out.println(helpString);
				break;
			case 's':
				room.movePlayer(Room.Direction.Down);
				drawRoom(room);
				System.out.println(helpString);
				break;
			case 'd':
				room.movePlayer(Room.Direction.Right);
				drawRoom(room);
				System.out.println(helpString);
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
