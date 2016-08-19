package uq.deco2800.ducktales;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.worldentities.Box;
import uq.deco2800.ducktales.entities.worldentities.LongBox;

public class EntityTest {
	
	@Test
	public void basicTest(){
		Entity entity1 = new Box(2, 3);
		Entity entity2 = new Box(4, 5);
		Entity entity3 = new Box(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));	
	}
	
	
//	@Test
//	public void adjacentTest1(){
//		Entity entity1 = new Entity(3, 7, 1, 2);
//		Entity entity2 = new Entity(4, 6, 1, 2);
//		
//		
//		List<Entity> entities = new ArrayList<Entity>();
//		entities.add(entity1);
//		entities.add(entity2);
//		
//		assertTrue("Entity 1 incorrect!", entities.get(0).equals(entity1));
//		assertTrue("Entity 2 incorrect!", entities.get(1).equals(entity2));	
//		
//		Collections.sort(entities);
//		
//		assertTrue("Entity 1 incorrect!", entities.get(0).equals(entity2));
//		assertTrue("Entity 2 incorrect!", entities.get(1).equals(entity1));	
//	}
	
	@Test
	public void adjacentTest2(){
		Entity foreground = new LongBox(7, 3);
		Entity background = new LongBox(6, 4);
		
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);

		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(background));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground));	
	}

	
	@Test
	public void adjacentTestMiddle(){
		Entity foreground = new LongBox(6, 7);
		Entity background = new LongBox(7, 6);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(background));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground));	
	}
}
