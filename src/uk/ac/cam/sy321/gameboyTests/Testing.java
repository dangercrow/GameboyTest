package uk.ac.cam.sy321.gameboyTests;

public class Testing {

	public static void main(String[] args) {
		Room r = new Room();
		drawRoom(r);
		
		System.out.println("Sticking in a door...");
		r.createDoor(new Position(0,2));
		
		drawRoom(r);
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
