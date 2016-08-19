package uq.deco2800.ducktales;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.tiles.TextureRegister;
import uq.deco2800.ducktales.world.World;

import java.util.Collections;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * GameRenderer renders the {@link World}.
 * 
 * @author Leggy
 */
public class GameRenderer extends AnimationTimer {

	private GraphicsContext graphicsContext;
	private World world;
	private TextureRegister tileRegister;
	private int tileHeight;
	private int tileWidth;
	
	private GameManager gameManager = GameManager.getInstance();
	private EntityManager entityManager = EntityManager.getInstance();

	/** The scale/zoom factor */
	private double scale = 0.3;

	private int baseX;
	private int baseY;

	public GameRenderer(GraphicsContext graphicsContext) {
		super();

		this.graphicsContext = graphicsContext;
		this.world = GameManager.getInstance().getWorld();
		this.tileRegister = TextureRegister.getInstance();
		this.tileHeight = TextureRegister.TEXTURE_HEIGHT;
		this.tileWidth = TextureRegister.TEXTURE_WIDTH;
		this.baseX = (int) (world.getWidth() * tileWidth * scale * 0.5);
		this.baseY = 0;
	}

	@Override
	public void handle(long arg0) {
		baseX += gameManager.getXPan();
		baseY += gameManager.getYPan();
		renderWorld();
		renderCanvas();
		renderEntities();
	}

	/**
	 * Renders the world to the canvas.
	 * This method also handles scaling of the world
	 */
	private void renderWorld() {
		Tile tile;

		int scaledWidth = (int) (tileWidth * scale);
		int scaledHeight = (int) (tileHeight * scale);

		for (int i = 0; i < world.getWidth(); i++) {
			for (int j = 0; j < world.getHeight(); j++) {
				tile = world.getTile(i, j);
				int x = baseX + (j - i) * scaledWidth / 2;
				int y = baseY + (j + i) * scaledHeight / 2;
				graphicsContext.drawImage(
						// Draw the image at position x, y, and scaled to the box with given
						// scaledWidth and scaledHeight
						tileRegister.getTileImage(tile.getTileType()), x, y,
						scaledWidth, scaledHeight);
			}
		}
	}
	
	/**
	 * Re-renders the canvas around the world to ensure that no previous world
	 * state artifacts are visible. Only renders a border of width
	 * borderThickness tiles around the world.
	 * 
	 * Note: Will most likely need to increase borderThickness to accomodate for
	 * tall entities (eg. buildings, trees etc.) that would otherwise draw
	 * beyond the reach of the border.
	 * @author Oliver Yule
	 */
	private void renderCanvas() {
		int scaledWidth = (int) (tileWidth * scale);
		int scaledHeight = (int) (tileHeight * scale);
		int borderThickness = 3;
		int length;
		// Loop over 4 sides of world.
		for (int n = 0; n < 4; n++) {
			if (n % 2 == 0) length = world.getWidth();
			else length = world.getHeight();
			// Loop over length of side.
			for (int i = -borderThickness; i < length + borderThickness; i++) {
				// Loop over thickness of border.
				for (int k = borderThickness; k > 0; k--) {
					int j;
					if (n < 2) {
						// The top sides.
						j = -k;
					} else {
						// The bottom sides.
						if (n == 2) j = k + world.getHeight() - 1;
						else j = k + world.getWidth() - 1;
					}
					int x;
					if (n % 2 == 0) {
						x = baseX + (j - i) * scaledWidth / 2;
					} else {
						x = baseX + (i - j) * scaledWidth / 2;
					}
					int y = baseY + (j + i) * scaledHeight / 2;
					graphicsContext.drawImage(tileRegister.getTileImage(
							"blank"), x, y, scaledWidth, scaledHeight);
				}
			}
		}
	}

	/**
	 * Renders entities on the canvas.
	 * @author Leggy, Wondertroy
	 */
	private void renderEntities() {
		List<Entity> entities = entityManager.getEntities();
		Collections.sort(entities);
		for (int index = 0; index < entities.size(); index++) {
			Entity box = entities.get(index);

			int scaledWidth = (int) (tileWidth * scale);
			int scaledHeight = (int) (tileHeight * scale);

			Image image = tileRegister.getTileImage(box.getType());
			int x = baseX + (int)((box.getY() - box.getX()) * scaledWidth / 2.0);
			int y = baseY + (int)((box.getY() + box.getX()) * scaledHeight / 2.0);

			int anchorY = (int) ((image.getHeight() - tileHeight) * scale);
			int anchorX = (int) ((box.getYLength() - 1) / 2.0 * tileWidth * scale);

			graphicsContext.drawImage(image, x - anchorX, y - anchorY,
					scaledWidth * image.getWidth() / tileWidth,
					(int) (scaledHeight * image.getHeight() / tileHeight));
		}

	}
}
