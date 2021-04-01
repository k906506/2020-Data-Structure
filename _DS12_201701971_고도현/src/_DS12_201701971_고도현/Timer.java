package _DS12_201701971_����;

public class Timer {
	private long _startTime; // ���� : nano second
	private long _stopTime; // ���� : nano second

	public Timer() {
		this._startTime = 0;
		this._stopTime = 0;
	}

	public void start() {	// ���� �ð�
		this._startTime = System.nanoTime();
	}

	public void stop() {	// ����  �ð�
		this._stopTime = System.nanoTime();
	}

	public long duration() {	// ���� �ð� - ���� �ð�
		return (this._stopTime - this._startTime)/1000;
	}
}
