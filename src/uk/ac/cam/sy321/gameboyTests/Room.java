package uk.ac.cam.sy321.gameboyTests;

public class Room {
	
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
	
	/**
	 * @param c The position of the required tile.
	 * @return The tile at the specified location.
	 */
	public Tile getTile(Position c) {
		if(!validPosition(c)) return null;
		else return tileAt(c);
	}
	
	/**
	 * Places a game object at the specified location in the room.
	 * Checks if the requested position is valid, and checks if that
	 * tile has an object already. Will place the object on an empty
	 * tile in a valid position.
	 * 
	 * @param gameObject The game object to be placed
	 * @param pos  The position to place the object
	 */
	public void placeObject(GameObject gameObject, Position pos) {
		if (!validPosition(pos)) return;
		//Checks for empty tile
		if (tileAt(pos).hasObject()) return;
		//Sets object if possible
		tileAt(pos).setObject(gameObject);
	}
	
	/**
	 * Creates a door at the specified location. Any current
	 * gameObjects at that position will be deleted.
	 * Default is locked door.
	 * @param pos Position to create the door at
	 */
	public void createDoor(Position pos) {
		if (validPosition(pos)) {
			tiles[pos.x][pos.y] = new Door(false);
		}
	}
	
	/**
	 * Deletes an object that is currently on the specified tile.
	 * Will not do anything if that tile is currently empty or an
	 * invalid position is given
	 * @param pos Position of tile to delete object from
	 */
	public void destroyObject(Position pos) {
		if (validPosition(pos)) tileAt(pos).destroyObject();
	}
	
	/**
	 * Checks that the passed position is valid. A valid position
	 * will be within the range [0, width-1] for x and
	 * [0, height-1] for y.
	 * @param pos Position to be checked
	 * @return Boolean showing whether the position is valid
	 */
	private boolean validPosition(Position pos) {
		//Checks for valid co-ordinates
		if (pos.x < 0 || pos.y < 0 || pos.x >= width || pos.y >= height) return false;
		else return true;
	}
	
	/**
	 * @param pos Position of tile to be returned
	 * @return The tile at the requested position
	 */
	private Tile tileAt(Position pos) {
		if (validPosition(pos)) return tiles[pos.x][pos.y];
		else return null;
	}
	
	/**
	 * Moves the player object relative to its current position. Will
	 * destroy the player object on the old tile and place it in its
	 * new position. Will automatically check for objects at the destination
	 * and whether the new position is valid. Will do nothing if there is
	 * already an object there, or the move would leave player object in an invalid
	 * position.
	 * @param relativePosition The movement of the player object relative to its current position
	 */
	public void movePlayer(Position relativePosition) {
		Position destination = new Position(playerPosition.x + relativePosition.x,
										playerPosition.y + relativePosition.y);
		
		//Checks if co-ordinates are valid, and that destination tile is empty
		if(validPosition(destination) && !tileAt(destination).hasObject()) {
			//Destroys current instance and places new instance
			destroyObject(playerPosition);
			placeObject(Player.getPlayer(), destination);
			playerPosition = destination;
			
		}
	}
}