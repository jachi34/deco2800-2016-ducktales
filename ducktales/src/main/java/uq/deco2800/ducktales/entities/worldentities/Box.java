package uq.deco2800.ducktales.entities.worldentities;

/**
 * Representation of a basic box.
 * 
 * @author Leggy
 *
 */
public class Box extends WorldEntity {

	private final static String TYPE = "box";

	protected Box(int x, int y, int lengthX, int lengthY) {
		super(x, y, lengthX, lengthY, TYPE);
	}

	public Box(int x, int y) {
		this(x, y, 1, 1);
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}
}
