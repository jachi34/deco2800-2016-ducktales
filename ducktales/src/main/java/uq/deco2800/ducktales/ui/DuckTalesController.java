package uq.deco2800.ducktales.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import uq.deco2800.ducktales.*;
import uq.deco2800.ducktales.tiles.*;
import uq.deco2800.ducktales.world.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

public class DuckTalesController implements Initializable {

	@FXML
	private AnchorPane gameWindow, rightPane;

	private ExecutorService executor;


	private boolean running = false;

	private TextureRegister tileRegister;
	private GameManager gameManager;

	private AtomicBoolean quit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tileRegister = TextureRegister.getInstance();
		gameManager = GameManager.getInstance(); 
	}

	@FXML
	public void startGame(ActionEvent event) throws Exception {
		if (!running) {
			/*
			 * Creating Canvas, and setting it to auto resize as rightPane is
			 * resized.
			 */
			Canvas canvas = new Canvas();
			rightPane.getChildren().add(canvas);
			canvas.widthProperty().bind(rightPane.widthProperty());
			canvas.heightProperty().bind(rightPane.heightProperty());

			GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

			createWorld();

			rightPane.setOnMousePressed(new MousePressedHandler());
			rightPane.setOnMouseReleased(new MouseReleasedHandler());
			rightPane.setOnMouseDragged(new MouseDraggedHandler());
			rightPane.setOnMouseMoved(new MouseMovedHandler());
			gameWindow.setOnKeyPressed(new KeyboardHandler());
			gameWindow.setOnKeyReleased(new KeyboardHandler());
			executor = Executors.newCachedThreadPool();

			quit = new AtomicBoolean(false);
			executor.execute(new GameLoop(quit, 50));
			new GameRenderer(graphicsContext).start();
			running = true;
		}
	}

	public void stopGame() {
		if (executor != null && quit != null) {
			quit.set(true);
			executor.shutdown();
		}
	}


	private void createWorld() {
		gameManager.setWorld(new World("DuckTales", 20, 20, tileRegister
				.getTileType("grass_2")));

	}


}
