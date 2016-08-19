package uq.deco2800.ducktales.entities;

import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Models an entity in the game.
 * 
 * @author Leggy
 *
 */
public abstract class Entity implements Comparable<Entity>, Tickable{

	protected Point point;
	
	private String type;

	/**
	 * The length in the direction parallel to the x axis - right.
	 */
	private int lengthX;

	/**
	 * The length in the direction parallel to the y axis - left.
	 */
	private int lengthY;

	/**
	 * The distance from the closest point of the entity to the line where y=x.
	 */
	public double distanceInside;

	/**
	 * The distance from the top most point of the entity to the point (0, 0).
	 */
	private double distanceTop;

	/**
	 * The distance from the bottom most point of the entity to the point (0,
	 * 0).
	 */
	private double distanceBottom;

	public Entity(double x, double y, int lengthX, int lengthY, String type) {
		this.point = new Point(x, y);
		this.lengthX = lengthX;
		this.lengthY = lengthY;
		this.type = type;
		calculateRenderingOrderValues();
		
	}
	
	protected void calculateRenderingOrderValues(){
		if (point.getX() > point.getY()) {
			distanceInside = (point.getX() - point.getY() - lengthX);
		} else if (point.getY() > point.getX()) {
			distanceInside = (point.getY() - point.getX() - lengthY);
		} else {
			distanceInside = -Math.max(lengthY, lengthX);
		}

		this.distanceBottom = (point.getY() + point.getX());
		this.distanceTop = distanceBottom - (lengthX + lengthY);
	}

	@Override
	public int compareTo(Entity entity) {
		if (this.distanceTop == entity.distanceTop) {
			if (this.distanceBottom == entity.distanceBottom) {
				if (this.distanceInside == entity.distanceInside) {
					return 0;
				} else if (this.distanceInside < entity.distanceInside) {
					return -1;
				} else {
					return 1;
				}
			} else if (this.distanceBottom < entity.distanceBottom) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.distanceTop < entity.distanceTop) {
			return -1;
		} else {
			return 1;
		}
	}

	public boolean equals(Object object) {
		if (!(object instanceof Entity)) {
			return false;
		}

		Entity entity = (Entity) object;
		return this.point.getX() == entity.point.getX() && this.point.getY()== entity.point.getY()
				&& this.lengthX == entity.lengthX
				&& this.lengthY == entity.lengthY;
	}

	public int hashCode() {
		//TODO: fix this
		return 4;
	}

	public String toString() {
		return String.format("[%f %f %f %f    %f]", point.getX(), point.getY(), lengthX, lengthY,
				distanceInside);
	}

	public double getX() {
		return point.getX();
	}

	public double getY() {
		return point.getY();
	}

	public int getYLength() {
		return lengthY;
	}

	public int getXLength() {
		return lengthX;
	}
	
	public String getType(){
		return type;
	}
	
	protected void updateType(String newType){
		this.type = newType;
	}

}
