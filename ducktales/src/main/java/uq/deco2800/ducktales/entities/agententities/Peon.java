package uq.deco2800.ducktales.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.util.Point;

/**
 * Class representing the worker.
 * 
 * @author Leggy
 *
 */
public class Peon extends AgentEntity {

	private final static String TYPE = "peon";
	
	private Point goalPoint;
	
	private double speed;
	
	private int Health =1000;

	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
		this.speed = 0.05;
		newGoalPoint();
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
		if(point.distance(goalPoint) < speed) {
			point = goalPoint;
			newGoalPoint();
		} else {
			point.moveToward(goalPoint, speed);
		}
		calculateRenderingOrderValues();
		
	}
	
	private void newGoalPoint(){
		Random random = new Random();
		goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
	}
}
