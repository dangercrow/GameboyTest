package uk.ac.cam.sy321.gameboyTests;

class Room {
	
	private Tile[][] tiles;
	private int width;
	private int height;
	private Position playerPosition;
	
	/**
	 * Creates a new room with 20x6 tiles. Will add walls to the 4 edges
	 * and places the player object in position (1,1)
	 * 
	 */
	public Room() {
		tiles = new Tile[20][6];
		width = 20;
		height = 6;
		
		//Initialises tiles
		for(int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tiles[i][j] = new Tile();
			}
		}
		
		//sets the walls of the room
		for(int i = 0; i < width; i++) {
			//top and bottom rows
			tiles[i][0].setObject(new Wall());
			tiles[i][height-1].setObject(new Wall());
		}
		for(int j = 1; j < height-1; j++) {
			//left and right walls (skips corners)
			tiles[0][j].setObject(new Wall());
			tiles[width-1][j].setObject(new Wall());
		}
		
		//Place player object
		playerPosition = new Position(1,1);
		Player playerObject = Player.getPlayer();
		placeObject(playerObject, playerPosition);
	}
	
	/**
	 * @return The height of the room as an integer.
	 */
	public int getHeight() { return height; }
	
	/**
	 * @return The width of the room as an integer.
	 */
	public int getWidth()  { return width;  }
	
	public Tile getTile(Position c) {
		if(!validCoOrds(c)) return null;
		else return tileAt(c);
	}
	
	public void placeObject(GameObject go, CoOrds c) {
		if (!validCoOrds(c)) return;
		//Checks for empty tile
		if (tileAt(c).hasObject()) return;
		//Sets object if possible
		tileAt(c).setObject(go);
	}
	
	public void destroyObject(CoOrds c) {
		//TODO: Write method to delete object
		//		Change reference to null and change flag
		if (validCoOrds(c)) tileAt(c).destroyObject();
	}
	
	private boolean validCoOrds(CoOrds c) {
		//Checks for valid co-ordinates
		if (c.x < 0 || c.y < 0 || c.x >= width || c.y >= height) return false;
		else return true;
	}
	
	private Tile tileAt(CoOrds c) {
		if (validCoOrds(c)) return tiles[c.x][c.y];
		else return null;
	}
	
	public void movePlayer(CoOrds relativePosition) {
		CoOrds destination = new CoOrds(playerPosition.x + relativePosition.x,
										playerPosition.y + relativePosition.y);
		
		//Checks if co-ordinates are valid, and that destination tile is empty
		if(validCoOrds(destination) && !tileAt(destination).hasObject()) {
			//Destroys current instance and places new instance
			destroyObject(playerPosition);
			placeObject(Player.getPlayer(), destination);
			playerPosition = destination;
			
		}
	}
}