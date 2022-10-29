package com.example.exp4.state;

import com.example.exp4.entity.Role;

public class Running implements State {
    @Override
    public void handle(ControlType type, Role e) {
        switch (type) {
            case LEFT:
                left(e);
                break;
            case RIGHT:
                right(e);
                break;
            case RELEASE:
                release(e);
                break;
            default:
                break;
        }
    }
    public void left(Role role) {

    }
    public void right(Role role) {

    }
    public void release(Role role) {

    }
}
