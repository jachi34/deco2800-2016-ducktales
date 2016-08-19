package uq.deco2800.ducktales.ui;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.GameManager;

public class KeyboardHandler implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent event) {
		EventType<KeyEvent> eventType = event.getEventType();
		if (eventType == KeyEvent.KEY_PRESSED) {
			keyPressed(event.getCode());
		} else if (eventType == KeyEvent.KEY_RELEASED) {
			keyReleased(event.getCode());
		}
	}

	private void keyPressed(KeyCode code) {
		GameManager gameManager = GameManager.getInstance();
		switch (code) {
		case A:
			gameManager.pan(GameManager.Direction.LEFT);
			break;

		case D:
			gameManager.pan(GameManager.Direction.RIGHT);
			break;

		case W:
			gameManager.pan(GameManager.Direction.UP);
			break;

		case S:
			gameManager.pan(GameManager.Direction.DOWN);
			break;

		default:
			break;
		}
	}

	private void keyReleased(KeyCode code) {
		GameManager gameManager = GameManager.getInstance();
		switch (code) {
		case A:
			gameManager.stopPan(GameManager.Direction.LEFT);
			break;

		case D:
			gameManager.stopPan(GameManager.Direction.RIGHT);
			break;

		case W:
			gameManager.stopPan(GameManager.Direction.UP);
			break;

		case S:
			gameManager.stopPan(GameManager.Direction.DOWN);
			break;

		default:
			break;
		}
	}
}