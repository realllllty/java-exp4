package com.example.exp4.game;


import com.example.exp4.entity.Role;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameView extends Canvas{
	private static GameView view = new GameView();
	private Role role;

	private GameView() {}
	
	public static GameView getView() {
		return view;
	}
	
	public void render() {
		this.getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
		draw(role);
	}
	
	private void draw(Role r) {
		GraphicsContext gc = this.getGraphicsContext2D();
		double w = r.getWidth();
		double h = r.getHeight();
		
		//gc.drawImage gc.fill
		gc.drawImage(r.getLook(), r.getX(), r.getY(), w, h);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

}
