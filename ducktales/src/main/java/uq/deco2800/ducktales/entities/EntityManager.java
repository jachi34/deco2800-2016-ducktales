package uq.deco2800.ducktales.entities;

import java.util.ArrayList;
import java.util.List;

import uq.deco2800.ducktales.util.Tickable;

/**
 * Manager for all the entities in the game.
 * 
 * @author leggy
 *
 */
public class EntityManager implements Tickable {

	private static final EntityManager INSTANCE = new EntityManager();

	/**
	 * List of all entities in the game.
	 */
	private List<Entity> entities;

	/**
	 * Gets the instance of the EntityManager.
	 * 
	 * @return Returns the EntityManager instance.
	 */
	public static EntityManager getInstance() {
		return INSTANCE;
	}

	/**
	 * Initialises the EntityManager.
	 */
	private EntityManager() {
		entities = new ArrayList<Entity>();
	}

	/**
	 * Adds a new entity to the game.
	 * 
	 * @param entity
	 *            The entity to add.
	 */
	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	/**
	 * Returns a list of all the entities.
	 * 
	 * @return Returns a list of all entities.
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	@Override
	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}

	}

}
