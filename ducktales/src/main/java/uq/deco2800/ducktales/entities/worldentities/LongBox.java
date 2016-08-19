package uq.deco2800.ducktales.entities.worldentities;

/**
 * Representation of a longer box.
 * @author Leggy
 *
 */
public class LongBox extends WorldEntity {
	
	private final static String TYPE = "long_box";

	public LongBox(int x, int y) {
		super(x, y, 2, 1, TYPE);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public boolean isPassable() {
		return false;
	}

}
