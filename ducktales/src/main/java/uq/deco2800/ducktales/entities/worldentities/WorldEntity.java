package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.entities.Entity;

/**
 * Abstract representation of all static world entities.
 * 
 * @author Leggy
 *
 */
public abstract class WorldEntity extends Entity {

	protected WorldEntity(double x, double y, int lengthX, int lengthY, String type) {
		super(x, y, lengthX, lengthY, type);
	}

	/**
	 * Returns true if this {@link WorldEntity} is passable.
	 * 
	 * @return Returns true if this WorldEntity is passable.
	 */
	public abstract boolean isPassable();

}
