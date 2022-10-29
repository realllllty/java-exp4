package aoop.exp4.game;

import javafx.animation.AnimationTimer;

public abstract class GameLoop extends AnimationTimer{
	private long startTime; // ѭ����ʼʱ��
	private long nextTick; // ��һ����Ϸ�߼�ˢ��ʱ��
	private final int TICKS_PER_SECOND = 10;  // Ĭ��ÿ���߼�ˢ�´���
	private final int SKIP_TICKS = 1000 / TICKS_PER_SECOND; // �߼�ˢ�¼��
	private final int MAX_FRAMESKIP = 10; // ÿ֡���ˢ�´���
	
	public GameLoop() {
		super();
		startTime = System.currentTimeMillis();
		nextTick = 0L;
	}
	
	/*
	 * ��Ϸѭ��һ�Σ���һ֡
	 */
	@Override
	public void handle(long now) {
		preprocess();
		int loops = 0;
		while((System.currentTimeMillis() - startTime) > nextTick && loops < MAX_FRAMESKIP) {
			refresh();
			nextTick += SKIP_TICKS;
			loops++;
		}
		display();
	}
	public abstract void preprocess(); // ������ص�Ԥ�������
	public abstract void refresh(); // ˢ��ҵ��״̬
	public abstract void display(); // ����ˢ��
}
