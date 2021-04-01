package _DS11_201701971_����;

public class AppController {
	private static final int TEST_SIZE = 10000; // �迭�� ũ��
	private static final int FRIST_PART_SIZE = 5; // �迭�� �պκ��� ǥ���� ������ ����
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();

	private Integer[] _list; // �ν��Ͻ� ����
	private ListOrder _listOrder;

	private Integer[] list() { // getter
		return this._list;
	}

	private void setList(Integer[] newList) { // setter
		this._list = newList;
	}

	private ListOrder listOrder() { // getter
		return this._listOrder;
	}

	private void setListOrder(ListOrder newListOrder) { // setter
		this._listOrder = newListOrder;
	}

	public AppController() { // ������
	}

	public void run() {
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");

		AppView.outputLine("> ���� ����� ���� : ");
		AppView.outputLine("");

		this.validateWithAscendingOrderList(); // �������� ����Ʈ ����
		this.validateWithDescendingOrderList(); // �������� ����Ʈ ����
		this.validateWithRandomOrderList(); // ������ ����Ʈ ����

		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
	}

	private void validateWithAscendingOrderList() { // �������� ����Ʈ
		this.setListOrder(ListOrder.Ascending); // ��������
		this.setList(DataGenerator.ascendingList(AppController.TEST_SIZE)); // TEST_SIZE�� �迭�� �������� ����
		this.showFirstPartOfDataList(); // �պκ��� ���� 5�� ���
		this.validateSortsAndShowResult(); // �������İ� ������ ��
	}

	private void validateWithDescendingOrderList() { // �������� ����Ʈ
		this.setListOrder(ListOrder.Descending); // ��������
		this.setList(DataGenerator.descendingList(AppController.TEST_SIZE)); // TEST_SIZE�� �迭�� �������� ����
		this.showFirstPartOfDataList(); // �պκ��� ���� 5�� ���
		this.validateSortsAndShowResult(); // �������İ� ������ ��
	}

	private void validateWithRandomOrderList() { // ������ ����Ʈ
		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomList(AppController.TEST_SIZE)); // TEST_SIZE�� �迭�� ������ ����
		this.showFirstPartOfDataList(); // �պκ��� ���� 5�� ���
		this.validateSortsAndShowResult(); // �������İ� ������ ��
	}

	private void showFirstPartOfDataList() { // �պκ��� ���� 5��
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ] �� �պκ� : ");
		for (int i = 0; i < FRIST_PART_SIZE; i++) { // FIRST_PART_SIZE��ŭ
			AppView.output(this.list()[i] + " "); // ���� ���
		}
		AppView.outputLine("");
	}

	private void validateSortsAndShowResult() { // ���� ���
		this.validateSort(AppController.INSERTION_SORT); // ��������
		this.validateSort(AppController.QUICK_SORT); // ����Ʈ����
		AppView.outputLine("");
	}

	private void validateSort(Sort<Integer> aSort) {
		Integer[] list = this.copyList(this._list);
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}

	private Integer[] copyList(Integer[] aList) { // �迭 ����
		Integer[] copiedList = new Integer[aList.length];	// aList�� ũ��� ���� Integer[] ��ü ����
		for (int i = 0; i < aList.length; i++) { // aList�� ���ҵ��� copiedList�� ����
			copiedList[i] = aList[i];
		}
		return copiedList; // copiedList
	}

	private boolean sortedListIsValid(Integer[] aList) { // �������� �Ǵ�
		for (int i = 0; i < (aList.length - 1); i++) {
			if (aList[i].compareTo(aList[i + 1]) > 0) { // ���������� �ƴ� ������ �߰�
				return false; // false
			}
		}
		return true; // ������������ ������ �Ǿ������� true
	}

	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) { // ����Ʈ ���� ���
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ]�� [" + aSort.getClass().getSimpleName() + "] �� ����� ");
		if (this.sortedListIsValid(aList)) { // ������ �Ǿ�������
			AppView.outputLine("�ùٸ��ϴ�.");
		} else { // ������ �Ǿ����� ������
			AppView.outputLine("�ùٸ��� �ʽ��ϴ�.");
		}
	}
}
