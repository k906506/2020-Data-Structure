package _DS06_201701971_고도현;

public class MeasuredResult {
	private int _size; // 인스턴스 변수
	private long _durationForAdd;
	private long _durationForMax;

	public int size() {	// getter
		return this._size;
	}

	public void setSize(int newSize) {	// setter
		this._size = newSize;
	}

	public long durationForAdd() {	// getter
		return this._durationForAdd;
	}

	public void setDurationForAdd(long newDurationForAdd) {	// setter
		this._durationForAdd = newDurationForAdd;
	}

	public long durationForMax() {	// getter
		return this._durationForMax;
	}

	public void setDurationForMax(long newDurationForMax) {	// setter
		this._durationForMax = newDurationForMax;
	}
	
	public MeasuredResult() {	// 생성자
		this (0,0,0);
	}
	
	public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax) {
		this.setSize(givenSize);
		this.setDurationForAdd(givenDurationForAdd);
		this.setDurationForMax(givenDurationForMax);
	}

}
