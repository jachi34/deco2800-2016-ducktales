package uq.deco2800.ducktales.ui;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.tiles.TextureRegister;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles Mouse press events.
 * 
 * @author Leggy
 *
 */
public class MousePressedHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		int tileX = (int) (event.getX() / TextureRegister.TEXTURE_WIDTH);
		int tileY = (int) (event.getY() / TextureRegister.TEXTURE_HEIGHT);
		GameManager.getInstance().setPressed(tileX, tileY);
	}

}
