package uq.deco2800.ducktales.entities.worldentities;

/**
 * A House.
 * @author Leggy
 *
 */
public class House extends WorldEntity{
	
	private final static String TYPE = "house";
	private int Health =1000;

	public House(double x, double y) {
		super(x, y, 3, 3, TYPE);
	}
	
	public void ChangeHealth(int NewValue){
		if (NewValue >0){
			this.Health =NewValue;
		}
	}
	
	public int GetHealth(){
		return Health;
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}

}
