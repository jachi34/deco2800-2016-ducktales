package uq.deco2800.ducktales.world;

import java.util.Random;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.entities.agententities.AnimalDuck;
import uq.deco2800.ducktales.entities.agententities.Peon;
import uq.deco2800.ducktales.entities.worldentities.Box;
import uq.deco2800.ducktales.entities.worldentities.House;
import uq.deco2800.ducktales.entities.worldentities.LongBox;
import uq.deco2800.ducktales.entities.worldentities.Tree;
import uq.deco2800.ducktales.tiles.TextureRegister;
import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Models the game's physical environment.
 * 
 * @author Leggy
 *
 */
public class World implements Tickable {
	private Array2D<Tile> tiles;
	private String name;
	private static TextureRegister tileRegister = TextureRegister.getInstance();

	/**
	 * Instantiates a World object with the specified parameters.
	 * 
	 * @param name
	 *            The name of the World
	 * @param width
	 *            The width of the World
	 * @param height
	 *            The height of the World
	 * @param baseTileType
	 *            The initial tile type to set every tile to
	 */
	public World(String name, int width, int height, int baseTileType) {
		tiles = new Array2D<Tile>(width, height);

		int[] tileTypes = { tileRegister.getTileType("grass_1"), tileRegister.getTileType("grass_2"),
				tileRegister.getTileType("grass_3") };

		Random random = new Random();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (Math.sqrt(Math.pow(y + 1, 2) + Math.pow(x + 1, 2)) < 5) {
					// Make a basic lake.
					tiles.set(x, y, new Tile(tileRegister.getTileType("water")));
				} else {
					tiles.set(x, y, new Tile(tileTypes[random.nextInt(3)]));
				}
			}
		}
		
		EntityManager manager = EntityManager.getInstance();
		manager.addEntity(new Box(5, 5));
		manager.addEntity(new Box(9, 7));

		manager.addEntity(new LongBox(12, 15));
		
		manager.addEntity(new Peon(10, 10));
		
		manager.addEntity(new Tree(4, 4));
		manager.addEntity(new Tree(6, 4));
		manager.addEntity(new Tree(8, 4));
		manager.addEntity(new Tree(10, 4));
		manager.addEntity(new Tree(12, 4));
		manager.addEntity(new Tree(14, 4));
		
		manager.addEntity(new House(16, 19));

		manager.addEntity(new AnimalDuck(10, 11));


	}

	/**
	 * Instantiates a World object with the specified parameters, with the tile
	 * type defaulting to Tile.VOID.
	 * 
	 * @param name
	 *            The name of the World
	 * @param width
	 *            The width of the World
	 * @param height
	 *            The height of the World
	 */
	public World(String name, int width, int height) {
		this(name, width, height, tileRegister.getTileType("void"));
	}

	/**
	 * @return The name of the world.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieves a Tile at the specified coordinates.
	 * 
	 * @param x
	 *            The x-coordinate of the Tile to retrieve
	 * @param y
	 *            The y-coordinate of the Tile to retrieve
	 * @return The Tile at the specified coordinates
	 */
	public Tile getTile(int x, int y) {
		return tiles.get(x, y);
	}

	public Tile getTile(Point point) {
		return tiles.get((int) point.getX(), (int) point.getY());
	}

	/**
	 * @return The width of the World
	 */
	public int getWidth() {
		return tiles.getWidth();
	}

	/**
	 * @return The height of the World
	 */
	public int getHeight() {
		return tiles.getHeight();
	}

	@Override
	public void tick() {
		for (int y = 0; y < tiles.getHeight(); y++) {
			for (int x = 0; x < tiles.getWidth(); x++) {
				tiles.get(x, y).tick();
			}
		}
	}

	public void setTile(int x, int y, int tileType) {
		getTile(x, y).setTileType(tileType);
	}
}
