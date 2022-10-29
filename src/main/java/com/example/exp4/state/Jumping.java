package com.example.exp4.state;

import com.example.exp4.entity.Role;

public class Jumping implements State{

	@Override
	public void handle(ControlType type, Role role) {
		switch(type) {
			case LEFT: left(role); fly(role); break;
			case RIGHT: right(role); fly(role); break;
			default: fly(role); break;
		}
	}
	
	public void left(Role role) {
		role.setSpeedX(Role.SPEED_MAX);
		role.setDirectionX(-1);
		role.setIndex(-3);
	}
	
	public void right(Role role) {
		role.setSpeedX(Role.SPEED_MAX);
		role.setDirectionX(1);
		role.setIndex(3);
	}
	
	public void fly(Role role) {
		if(role.getY() < (Role.HORIZON_Y - role.getHeight())) {
			role.setSpeedY(role.getSpeedY() + role.getDirectionY() * Role.ACCELERATION);
		}else {
			role.setState(new Standing());
			role.setSpeedX(0);
			role.setSpeedY(0);
			role.setIndex(role.getDirectionX());
		}
	}
}
