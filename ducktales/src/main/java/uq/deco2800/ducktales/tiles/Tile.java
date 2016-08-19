package uq.deco2800.ducktales.tiles;

import uq.deco2800.ducktales.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Represents a square unit of the world.
 * 
 * @author Leggy
 *
 */
public class Tile implements Tickable {
	/**
	 * The type of this tile.
	 */
	private int tileType;

	private WorldEntity worldEntity;

	/**
	 * Initialises this Tile with a specified tile type.
	 * 
	 * @param tileType
	 *            The tile type to create this Tile with
	 */
	public Tile(int tileType) {
		this.tileType = tileType;
	}

	/**
	 * Sets the type of this Tile to the specified value.
	 * 
	 * @param tileType
	 *            The type to set this Tile to
	 */
	public void setTileType(int tileType) {
		this.tileType = tileType;
	}

	/**
	 * Gets the type of this Tile.
	 * 
	 * @return The type of the Tile
	 */
	public int getTileType() {
		return tileType;
	}

	/**
	 * Adds a world entity to this tile.
	 * 
	 * @param worldEntity
	 */
	public void addWorldEntity(WorldEntity worldEntity) {
		if (this.worldEntity != null) {
			this.worldEntity = worldEntity;
		}
	}

	/**
	 * Returns the {@link WorldEntity} at this location.
	 * 
	 * @return Returns the WorldEntity at this location.
	 */
	public WorldEntity getWorldEntity() {
		return worldEntity;
	}

	@Override
	public void tick() {
	}

}
