package _DS12_201701971_����;

public class ExperimentManager {
	// ���
	private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS = 10;
	private static final int DEFAULT_INCREMENT_SIZE = 1000;
	private static final int DEFAULT_STARTING_SIZE = DEFAULT_INCREMENT_SIZE;

	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();

	// �ν��Ͻ� ����
	private Experiment _experiment;		// ���� ������ �ǽ��� ��ü
	private ParameterSet _parameterSet;	// ���� ���迡 ����� �Ű����� ����
	private Integer[] _ascendingList;	// �������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _descendingList;	// �������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _randomList;		// �������� ���Ŀ� ����� ������ ������ ����Ʈ
	private long[] _measuredResultForInsertionSort;	// ���� ������ ���� ����� ������ ��
	private long[] _measuredResultForQuickSort;	// �� ������ ���� ����� ������ ��

	// getter�� setter
	private Experiment experiment() {
		return this._experiment;
	}

	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}

	public ParameterSet parameterSet() {
		return this._parameterSet;
	}

	private void setParameterSet(ParameterSet newParameterSet) {
		this._parameterSet = newParameterSet;
	}

	private Integer[] ascendingList() {
		return this._ascendingList;
	}

	private void setAscendingList(Integer[] newAscendingList) {
		this._ascendingList = newAscendingList;
	}

	private Integer[] descendingList() {
		return this._descendingList;
	}

	private void setDescendingList(Integer[] newDescendingList) {
		this._descendingList = newDescendingList;
	}

	private Integer[] randomList() {
		return this._randomList;
	}

	private void setRandomList(Integer[] newLandomList) {
		this._randomList = newLandomList;
	}

	private long[] measuredResultForInsertionSort() {
		return this._measuredResultForInsertionSort;
	}

	private void setMeasuredResultForInsertionSort(long[] newMeasuredResultForInsertionSort) {
		this._measuredResultForInsertionSort = newMeasuredResultForInsertionSort;
	}

	private long[] measuredResultForQuickSort() {
		return this._measuredResultForQuickSort;
	}

	private void setMeasuredResltForQuickSort(long[] newMeasuredResultForQuickSort) {
		this._measuredResultForQuickSort = newMeasuredResultForQuickSort;
	}
	
	// ������
	public ExperimentManager() {
		this.setParameterSetWithDefaults();
	}

	private void prepareExperimentLists() {
		int maxDataSize = this.parameterSet().maxDataSize();
		this.setAscendingList(DataGenerator.ascendingList(maxDataSize));
		this.setDescendingList(DataGenerator.descendingList(maxDataSize));
		this.setRandomList(DataGenerator.randomList(maxDataSize));
	}

	private void setParameterSetWithDefaults() {
		this.setParameterSet(new ParameterSet(DEFAULT_STARTING_SIZE, DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS,
				DEFAULT_INCREMENT_SIZE));
	}

	private Integer[] experimentListOfOrder(ListOrder anOrder) { // �־��� anOrder�� �ش��ϴ� ����Ʈ�� �����ش�.
		switch (anOrder) {
		case Ascending:
			return this.ascendingList();
		case Descending:
			return this.descendingList();
		default:
			return this.randomList();
		}
	}

	public void prepareExperiment(ParameterSet aParameterSet) {
		if (aParameterSet != null) {
			// ��ü ������ ��, �Ű����� ������ �⺻ ������ �����Ǿ� �ִ�..
			// ���� �غ� �ܰ迹��, �̷��� ���ο� �Ű����� ������ �־� ������ �� �ִ�.
			this.setParameterSet(aParameterSet);
		}
		this.setExperiment(new Experiment(this.parameterSet()));
		// ���� ������ �Ű����� ������ ����Ͽ� Experiment ��ü�� �����Ѵ�.
		this.prepareExperimentLists();
		// ���� ���迡�� ���Ŀ� ����� ������ ����Ʈ�� �����Ͽ� �����Ѵ�.
		this.performExperiment(ListOrder.Random);
		this.performExperiment(ListOrder.Random);
	}

	public long measuredResultForInsertionSortAt(int sizeStep) {
		return this.measuredResultForInsertionSort()[sizeStep];
	}

	public long measuredResultForQuickSortAt(int sizeStep) {
		return this.measuredResultForQuickSort()[sizeStep];
	}

	public void performExperiment(ListOrder anOrder) {
		Integer[] experimentList = this.experimentListOfOrder(anOrder); // �־��� anOrder�� ���踮��Ʈ�� ��´�.
		this.setMeasuredResultForInsertionSort(this.experiment().durationsOfSort(INSERTION_SORT, experimentList));
		this.setMeasuredResltForQuickSort(this.experiment().durationsOfSort(QUICK_SORT, experimentList));

	}
}
