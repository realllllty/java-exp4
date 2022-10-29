package com.example.exp4;


import aoop.exp4.game.GameLoop;


import com.example.exp4.entity.Role;
import com.example.exp4.game.GameView;
import com.example.exp4.state.ControlType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {
	ControlType current = ControlType.NOTHING;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Role mario = new Role("/Users/realllllty/IdeaProjects/exp4/src/mario");
		GameView.getView().setRole(mario);

		GameLoop gameLoop = new GameLoop() {			
			@Override
			public void preprocess() {
				
			}

			@Override
			public void refresh() {
				// System.out.println(current);
				mario.doHandle(current);
			}

			@Override
			public void display() {
				GameView.getView().render();
			}
		};
		
		gameLoop.start();
		GameView.getView().setWidth(1000);
		GameView.getView().setHeight(600);
		Pane backPane = new Pane(GameView.getView());

		Scene scene = new Scene(backPane);
		
		scene.setOnKeyPressed(e ->{
			switch(e.getCode()) {
				case LEFT: current = ControlType.LEFT;break;
				case RIGHT: current = ControlType.RIGHT;break;
				case SPACE: current = ControlType.JUMP;break;
				default:break;
			}
		});
		scene.setOnKeyReleased(e ->{
			current = ControlType.RELEASE;
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Game");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
