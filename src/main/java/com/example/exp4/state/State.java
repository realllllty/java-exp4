package com.example.exp4.state;

import com.example.exp4.entity.Role;

public interface State {
	public abstract void handle(ControlType type, Role e);
}
