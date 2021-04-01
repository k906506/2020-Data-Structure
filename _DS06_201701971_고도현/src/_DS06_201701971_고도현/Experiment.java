package _DS06_201701971_����;

import java.util.Random;

public class Experiment {
	private static final int DEFAULT_NUMBER_OF_ITRATION = 5;	// ���� �������� ����
	private static final int DEFAULT_FIRST_SIZE = 10000;	// ù��° ���� �������� ũ��
	private static final int DEFAULT_SIZE_INCREMENT = 10000;	// ���� �������� ������

	private int _numberOfIteration;	// �ν��Ͻ� ����
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

	public Experiment() {	// ������
		this(DEFAULT_NUMBER_OF_ITRATION, DEFAULT_FIRST_SIZE, DEFAULT_SIZE_INCREMENT);
	}

	public Experiment(int givenNumberOfIteration, int givenFirstSize, int givenSizeIncrement) {
		this.setNumberOfIteration(givenNumberOfIteration);
		this.setFirstSize(givenFirstSize);
		this.setSizeIncrement(givenSizeIncrement);
		this.setData(new Coin[this.maxSize()]); // ���� �����͸� ���� �迭 ���� Ȯ��
		this.setMeasuredResults(new MeasuredResult[this.numberOfIteration()]); // ���� ����� ������ �迭 ���� Ȯ��
	}

	public void generateDate() {	// ���� ����
		Random random = new Random();
		for (int i = 0; i < this.maxSize(); i++) {
			int randomCoinValue = random.nextInt(this.maxSize());
			this.data()[i] = new Coin(randomCoinValue);
		}
	}

	public void measureForUnsortedArrayList() { // Sorted Array�� ������ List�� ������ �����Ѵ�.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // ���� ����

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnsortedArrayList<Coin> list = new UnsortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// ���� �ð�
				list.addToLast(this.data()[i]);
				stop = System.nanoTime();	// ���� �ð�
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// ���� �ð�
				maxCoin = list.max();
				stop = System.nanoTime();	// ���� �ð�
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForSortedArrayList() { // Sorted Array�� ������ List�� ������ �����Ѵ�.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // ���� ����

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedArrayList<Coin> list = new SortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// ���� �ð�
				list.add(this.data()[i]);
				stop = System.nanoTime();	// ���� �ð�
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// ���� �ð�
				maxCoin = list.max();
				stop = System.nanoTime();	// ���� �ð�
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}

	public void measureForUnsortedLinkedList() { // Sorted Array�� ������ List�� ������ �����Ѵ�.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // ���� ����

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnsortedLinkedList<Coin> list = new UnsortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// ���� �ð�
				list.addToFirst(this.data()[i]);
				stop = System.nanoTime();	// ���� �ð�
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// ���� �ð�
				maxCoin = list.max();
				stop = System.nanoTime();	// ���� �ð�
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForSortedLinkedList() { // Sorted Array�� ������ List�� ������ �����Ѵ�.
		@SuppressWarnings("unused")
		Coin maxCoin;

		long durationForAdd, durationForMax;
		long start, stop; // ���� ����

		int dataSize = this.firstSize();
		for (int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedLinkedList<Coin> list = new SortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i = 0; i < dataSize; i++) {
				start = System.nanoTime();	// ���� �ð�
				list.add(this.data()[i]);
				stop = System.nanoTime();	// ���� �ð�
				durationForAdd += (stop - start); // duration = duration + (stop - start)

				start = System.nanoTime();	// ���� �ð�
				maxCoin = list.max();
				stop = System.nanoTime();	// ���� �ð�
				durationForMax += (stop - start); // duration = duration + (stop - start)
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
}
