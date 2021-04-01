package _DS12_201701971_고도현;

public class ParameterSet {
	// 인스턴스 변수
	private int _startingSize;
	private int _numberOfSizeIncreasingSteps;
	private int _incrementSize;

	// getter와 setter
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

	public int maxDataSize() {	// 최종 데이터 크기
		return (this.startingSize() + (this.incrementSize() * (this.numberOfSizeIncreasingSteps() - 1)));
	}

	// 생성자
	public ParameterSet(int givenStartingSize, int givenNumberOfSizeIncreasingSteps, int givenIncrementSize) {
		this.setStartingSize(givenStartingSize);
		this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
		this.setIncrementSize(givenIncrementSize);
	}

}
