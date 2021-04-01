package _DS12_201701971_����;

public class ParameterSet {
	// �ν��Ͻ� ����
	private int _startingSize;
	private int _numberOfSizeIncreasingSteps;
	private int _incrementSize;

	// getter�� setter
	public int startingSize() {
		return this._startingSize;
	}

	public void setStartingSize(int newStartingSize) {
		this._startingSize = newStartingSize;
	}

	public int numberOfSizeIncreasingSteps() {
		return this._numberOfSizeIncreasingSteps;
	}

	public void setNumberOfSizeIncreasingSteps(int newNumberOfSizeIncreasingSteps) {
		this._numberOfSizeIncreasingSteps = newNumberOfSizeIncreasingSteps;
	}

	public int incrementSize() {
		return this._incrementSize;
	}

	public void setIncrementSize(int newIncrementSize) {
		this._incrementSize = newIncrementSize;
	}

	public int maxDataSize() {	// ���� ������ ũ��
		return (this.startingSize() + (this.incrementSize() * (this.numberOfSizeIncreasingSteps() - 1)));
	}

	// ������
	public ParameterSet(int givenStartingSize, int givenNumberOfSizeIncreasingSteps, int givenIncrementSize) {
		this.setStartingSize(givenStartingSize);
		this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
		this.setIncrementSize(givenIncrementSize);
	}

}
