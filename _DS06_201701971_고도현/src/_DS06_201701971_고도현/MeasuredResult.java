package _DS06_201701971_����;

public class MeasuredResult {
	private int _size; // �ν��Ͻ� ����
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
	
	public MeasuredResult() {	// ������
		this (0,0,0);
	}
	
	public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax) {
		this.setSize(givenSize);
		this.setDurationForAdd(givenDurationForAdd);
		this.setDurationForMax(givenDurationForMax);
	}

}
