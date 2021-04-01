package _DS12_201701971_고도현;

public class Timer {
	private long _startTime; // 단위 : nano second
	private long _stopTime; // 단위 : nano second

	public Timer() {
		this._startTime = 0;
		this._stopTime = 0;
	}

	public void start() {	// 시작 시각
		this._startTime = System.nanoTime();
	}

	public void stop() {	// 종료  시각
		this._stopTime = System.nanoTime();
	}

	public long duration() {	// 종료 시각 - 시작 시각
		return (this._stopTime - this._startTime)/1000;
	}
}
