package uk.ac.cam.sy321.gameboyTests;

public class WillybeansPlaypen {

	public static void main(String[] args) {
		System.out.println((char)(4 + (int)'0'));
		
		WB_RoomsList.initialiseRooms();
		System.out.println("Attempting to add object to room 0");
		WB_RoomsList.placeObjectInRoom(0, new GameObject('a'), new Position(8,2));
		WB_RoomsList.placeObjectInRoom(1, new GameObject('y'), new Position(6,3));
		
		Room s = WB_RoomsList.getRoom(0);
		drawRoom(s);
		
		System.out.println("Redirecting s to another room");
		s = WB_RoomsList.getRoom(1);
		drawRoom(s);
		
		System.out.println("Drawing original room without using room reference");
		drawRoom(WB_RoomsList.getRoom(0));
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