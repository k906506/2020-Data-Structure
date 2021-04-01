package _DS12_201701971_����;

public class Experiment {
	private final ParameterSet _parameterSet;
	// Class�� �Լ����� �� ���� ������ �� ����.
	// ������ �ȿ����� ���� ���� �����ϴ�.
	// ��, ��ü�� ������ �� ������ ���� �״�� �����Ѵ�.

	private ParameterSet parameterSet() {	// getter
		return this._parameterSet;
	}

	public Experiment(ParameterSet givenParameterSet) {	// setter
		this._parameterSet = givenParameterSet;
	}

	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize) { // �迭 ����
		Integer[] copiedList = null;	// ���ο� �迭 copiedList�� ���� �� �ʱ�ȭ
		if (copiedSize <= aList.length) {	
			copiedList = new Integer[copiedSize];	// copiedSize ũ��
			for (int i = 0; i < copiedSize; i++) {	
				copiedList[i] = aList[i];	// copiedList�� aList ���Ҹ� �Ѱ��� ����
			}
		}
		return copiedList;
	}

	private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList) {	// ���� ���� �ð�
		Timer timer = new Timer(); // Timer ��ü ����
		timer.start();	// 	���۽ð�
		{
			aSort.sort(aList, aList.length);	// ���� ����
		}
		timer.stop();	// ����ð�
		return timer.duration();	// ����ð� - ���۽ð� = runtime
	}

	public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList) {
		int numberOfSteps = this.parameterSet().numberOfSizeIncreasingSteps();	// ������ ���� Ƚ��
		long[] durations = new long[numberOfSteps];	

		int sortingSize = this.parameterSet().startingSize();	// ���� �������� ���� ũ��
		int incrementSize = this.parameterSet().incrementSize();	// ���� ������ ���� ũ��

		for (int step = 0; step < numberOfSteps; step++) {
			Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize); // ������ ����� ������ ����Ʈ ����
			durations[step] = this.durationOfSingleSort(aSort, listForSorting); // �����Ͽ� �� ����� ����
			sortingSize += incrementSize; // ���� �ܰ��� ���� ������ ũ�⸦ ����
		}
		return durations;
	}
}
