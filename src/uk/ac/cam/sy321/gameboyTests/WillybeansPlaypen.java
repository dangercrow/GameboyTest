package uk.ac.cam.sy321.gameboyTests;

import java.io.IOException;

public class WillybeansPlaypen {
	static Room currentRoom;

	public static void main(String[] args) {		
		GameObject myCat = new GameObject('c');
		myCat.setInteraction(new Interaction(myCat) {
			public void run() {
				System.out.println("Let us go on a journey through time and space");
				System.out.println("You teleported!");
				currentRoom = WB_RoomsList.getRoom(1);
			}
		});
		
		GameObject plant = new GameObject('p');
		plant.setInteraction(new Interaction(plant) {
			public void run() {
				System.out.println("Howdy! Let's go see the cat again");
				currentRoom = WB_RoomsList.getRoom(0);
			}
		});
		
		WB_RoomsList.initialiseRooms();
		currentRoom = WB_RoomsList.getRoom(0);
		WB_RoomsList.placeObjectInRoom(0, myCat, new Position(8,2));
		WB_RoomsList.placeObjectInRoom(1, plant, new Position(3,3));
		
		inputLoop();
	}
	
	private static void inputLoop() {
		String friendlyMessage = "Press 'q' to quit or use 'w','a','s','d' to navigate. 'e' to interact";
		
		drawRoom(currentRoom);
		System.out.println(friendlyMessage);
		
		try {
			int input = 's';
			while (input != 'q'){
				input = System.in.read();
				switch (input){
				case 'w':
					currentRoom.movePlayer(Room.Direction.Up);
					drawRoom(currentRoom);
					System.out.println(friendlyMessage); // use the cursor keys to navigate.");
					break;
				case 'a':
					currentRoom.movePlayer(Room.Direction.Left);
					drawRoom(currentRoom);
					System.out.println(friendlyMessage); // use the cursor keys to navigate.");
					break;
				case 's':
					currentRoom.movePlayer(Room.Direction.Down);
					drawRoom(currentRoom);
					System.out.println(friendlyMessage); // use the cursor keys to navigate.");
					break;
				case 'd':
					currentRoom.movePlayer(Room.Direction.Right);
					drawRoom(currentRoom);
					System.out.println(friendlyMessage); // use the cursor keys to navigate.");
					break;
				case 'e':
					currentRoom.interact();
					drawRoom(currentRoom);
					System.out.println(friendlyMessage);
					break;
				default:
					break;
				}
			}
		}
		catch (IOException io) {
			System.err.println("Whoopsey daisey");
		}
	}

	private static void drawRoom(Room r) {
		if (r == null) System.out.println("The room appears to be empty...");
		else {
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

}

class WB_RoomsList {
	private static Room[] myRooms = new Room[4];

	private WB_RoomsList() {
		//Pls don't instantiate me :)
	}

	public static void initialiseRooms() {
		for(int i = 0; i < myRooms.length; i++) {
			myRooms[i] = new Room();
			myRooms[i].destroyObject(new Position(0,0));
			myRooms[i].placeObject(new GameObject((char)(i + (int)'0')), new Position(0,0));
		}
	}

	private static boolean validIndex(int testIndex) {
		if (testIndex < 0 || testIndex >= myRooms.length) return false;
		else return true;
	}

	public static Room getRoom(int index) {
		if (validIndex(index)) return myRooms[index];
		else return null;
	}

	public static void placeObjectInRoom(int roomIndex, GameObject object, Position pos) {
		if (validIndex(roomIndex)) myRooms[roomIndex].placeObject(object, pos);
		}
	}