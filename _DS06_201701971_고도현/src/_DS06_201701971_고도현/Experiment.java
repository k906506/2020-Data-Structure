package _DS06_201701971_고도현;

import java.util.Random;

public class Experiment {
	private static final int DEFAULT_NUMBER_OF_ITRATION = 5;	// 실험 데이터의 개수
	private static final int DEFAULT_FIRST_SIZE = 10000;	// 첫번째 실험 데이터의 크기
	private static final int DEFAULT_SIZE_INCREMENT = 10000;	// 실험 데이터의 증가량

	private int _numberOfIteration;	// 인스턴스 변수
	private int _firstSize;
	private int _sizeIncrement;
	private Coin[] _data;
	private MeasuredResult[] _measuredResults;

	// Getters/Setters
	public int numberOfIteration() {	// getter
		return this._numberOfIteration;
	}

	public void setNumberOfIteration(int newNumberOfIteration) {
		this._numberOfIteration = newNumberOfIteration;
	}

	public int firstSize() {	// getter
		return this._firstSize;
	}

	public void setFirstSize(int newFirstSize) {	// setter
		this._firstSize = newFirstSize;
	}

	public int sizeIncrement() {	// getter
		return this._sizeIncrement;
	}

	public void setSizeIncrement(int newSizeIncrement) {	// setter
		this._sizeIncrement = newSizeIncrement;
	}

	public int maxSize() {	// getter
		return this.firstSize() + this.sizeIncrement() * (this.numberOfIteration() - 1);
	}

	public Coin[] data() {	// getter
		return this._data;
	}

	public void setData (Coin[] newData) {	// setter
		this._data = newData;
	}

	public MeasuredResult[] measuredResults() {	// getter
		return this._measuredResults;
	}

	public void setMeasuredResults (MeasuredResult[] newMeasuredResults) {	// setter
		this._measuredResults = newMeasuredResults;
	}

	public Experiment() {	// 생성자
		this(DEFAULT_NUMBER_OF_ITRATION, DEFAULT_FIRST_SIZE, DEFAULT_SIZE_INCREMENT);
	}

	public Experiment(int givenNumberOfIteration, int givenFirstSize, int givenSizeIncrement) {
		this.setNumberOfIteration(givenNumberOfIteration);
		this.setFirstSize(givenFirstSize);
		this.setSizeIncrement(givenSizeIncrement);
		this.setData(new Coin[this.maxSize()]); // 실험 데이터를 담을 배열 공간 확보
		this.setMeasuredResults(new MeasuredResult[this.numberOfIteration()]); // 실험 결과를 저장할 배열 공간 확보
	}

	public void generateDate() {	// 난수 생성
		Random random = new Random();
		for (int i = 0; i < this.maxSize(); i++) {
			int randomCoinValue = random.nextInt(this.maxSize());
			this.data()[i] = new Coin(randomCoinValue);
		}
	}

	public void measureForUnsortedArrayList() { // Sorted Array로 구현한 List의 성능을 측정한다.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // 변수 선언

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnsortedArrayList<Coin> list = new UnsortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// 시작 시간
				list.addToLast(this.data()[i]);
				stop = System.nanoTime();	// 종료 시간
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// 시작 시간
				maxCoin = list.max();
				stop = System.nanoTime();	// 종료 시간
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForSortedArrayList() { // Sorted Array로 구현한 List의 성능을 측정한다.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // 변수 선언

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedArrayList<Coin> list = new SortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// 시작 시간
				list.add(this.data()[i]);
				stop = System.nanoTime();	// 종료 시간
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// 시작 시간
				maxCoin = list.max();
				stop = System.nanoTime();	// 종료 시간
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}

	public void measureForUnsortedLinkedList() { // Sorted Array로 구현한 List의 성능을 측정한다.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // 변수 선언

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnsortedLinkedList<Coin> list = new UnsortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// 시작 시간
				list.addToFirst(this.data()[i]);
				stop = System.nanoTime();	// 종료 시간
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// 시작 시간
				maxCoin = list.max();
				stop = System.nanoTime();	// 종료 시간
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForSortedLinkedList() { // Sorted Array로 구현한 List의 성능을 측정한다.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // 변수 선언

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedLinkedList<Coin> list = new SortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// 시작 시간
				list.add(this.data()[i]);
				stop = System.nanoTime();	// 종료 시간
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// 시작 시간
				maxCoin = list.max();
				stop = System.nanoTime();	// 종료 시간
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
}
