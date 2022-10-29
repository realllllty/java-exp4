package com.example.exp4.entity;

import java.util.HashMap;
import java.util.Map;

import com.example.exp4.state.ControlType;
import com.example.exp4.state.Standing;
import com.example.exp4.state.State;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import com.example.exp4.tool.ImageTool;

public class Role {
	//最大速度
	public static final double SPEED_MAX = 12;
	//最大高度
	public static final double HEIGHT_MAX = 300;
	//地平线
	public static final double HORIZON_Y = 500;
	//跳跃速度
	public static final double SPEED_JUMPING = 15;
	//奔跑速度
	public static final double SPEED_RUNNING = 15;
	//加速度
	public static final double ACCELERATION = 1.0;

	// 位置
	private double x, y;
	// 尺寸
	private int height, width;
	// 速度
	private double speedX, speedY;
	// 方向
	private int directionX, directionY;

	// 皮肤与状态关系
	private Map<String, Image> map = new HashMap<>();
	private int index; // -1~-3 1~3

	// 状态处理
	State state;

	// 控制请求
	public void doHandle(ControlType type) {
		state.handle(type, this);
		move();
	}

	// 移动一次
	public void move() {
		this.setX(getX() + getSpeedX() * getDirectionX());
		this.setY(getY() + getSpeedY() * getDirectionY());
	}

	// 创建
	public Role(String path) {
		this.setWidth(32);
		this.setHeight(62);

		for (int i = 1; i <= 3; i++) {
			Image img = new Image("file:/" + path + "mario" + i + ".png");
			Image imgRev = ImageTool.rotate(img, 180, Rotate.Y_AXIS);
			map.put(String.valueOf(i), img);
			map.put(String.valueOf(-i), imgRev);
		}
		this.setSpeedY(0);
		this.setSpeedY(0);
		this.setIndex(1);
		this.setDirectionX(1);
		this.setState(new Standing());
		this.setX(200);
		this.setY(HORIZON_Y - getHeight());
	}

	// 获取外观
	public Image getLook() {
		return map.get(String.valueOf(getIndex()));
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
}