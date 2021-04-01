package _DS11_201701971_고도현;

public class AppController {
	private static final int TEST_SIZE = 10000; // 배열의 크기
	private static final int FRIST_PART_SIZE = 5; // 배열의 앞부분을 표시할 원소의 개수
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();

	private Integer[] _list; // 인스턴스 변수
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

	public AppController() { // 생성자
	}

	public void run() {
		AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 시작합니다 >>>");
		AppView.outputLine("");

		AppView.outputLine("> 정렬 결과의 검증 : ");
		AppView.outputLine("");

		this.validateWithAscendingOrderList(); // 오름차순 리스트 실행
		this.validateWithDescendingOrderList(); // 내림차순 리스트 실행
		this.validateWithRandomOrderList(); // 무작위 리스트 실행

		AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 종료합니다 >>>");
	}

	private void validateWithAscendingOrderList() { // 오름차순 리스트
		this.setListOrder(ListOrder.Ascending); // 오름차순
		this.setList(DataGenerator.ascendingList(AppController.TEST_SIZE)); // TEST_SIZE의 배열에 오름차순 정렬
		this.showFirstPartOfDataList(); // 앞부분의 원소 5개 출력
		this.validateSortsAndShowResult(); // 삽입정렬과 퀵정렬 비교
	}

	private void validateWithDescendingOrderList() { // 내림차순 리스트
		this.setListOrder(ListOrder.Descending); // 내림차순
		this.setList(DataGenerator.descendingList(AppController.TEST_SIZE)); // TEST_SIZE의 배열에 내림차순 정렬
		this.showFirstPartOfDataList(); // 앞부분의 원소 5개 출력
		this.validateSortsAndShowResult(); // 삽입정렬과 퀵정렬 비교
	}

	private void validateWithRandomOrderList() { // 무작위 리스트
		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomList(AppController.TEST_SIZE)); // TEST_SIZE의 배열에 무작위 정렬
		this.showFirstPartOfDataList(); // 앞부분의 원소 5개 출력
		this.validateSortsAndShowResult(); // 삽입정렬과 퀵정렬 비교
	}

	private void showFirstPartOfDataList() { // 앞부분의 원소 5개
		AppView.output("[" + this.listOrder().orderName() + " 리스트] 의 앞부분 : ");
		for (int i = 0; i < FRIST_PART_SIZE; i++) { // FIRST_PART_SIZE만큼
			AppView.output(this.list()[i] + " "); // 원소 출력
		}
		AppView.outputLine("");
	}

	private void validateSortsAndShowResult() { // 정렬 결과
		this.validateSort(AppController.INSERTION_SORT); // 삽입정렬
		this.validateSort(AppController.QUICK_SORT); // 퀵소트정렬
		AppView.outputLine("");
	}

	private void validateSort(Sort<Integer> aSort) {
		Integer[] list = this.copyList(this._list);
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}

	private Integer[] copyList(Integer[] aList) { // 배열 복사
		Integer[] copiedList = new Integer[aList.length];	// aList의 크기와 같은 Integer[] 객체 생성
		for (int i = 0; i < aList.length; i++) { // aList의 원소들을 copiedList에 복사
			copiedList[i] = aList[i];
		}
		return copiedList; // copiedList
	}

	private boolean sortedListIsValid(Integer[] aList) { // 오름차순 판단
		for (int i = 0; i < (aList.length - 1); i++) {
			if (aList[i].compareTo(aList[i + 1]) > 0) { // 오름차순이 아닌 순서를 발견
				return false; // false
			}
		}
		return true; // 오름차순으로 정렬이 되어있으면 true
	}

	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) { // 리스트 정렬 결과
		AppView.output("[" + this.listOrder().orderName() + " 리스트]를 [" + aSort.getClass().getSimpleName() + "] 한 결과는 ");
		if (this.sortedListIsValid(aList)) { // 정렬이 되어있으면
			AppView.outputLine("올바릅니다.");
		} else { // 정렬이 되어있지 않으면
			AppView.outputLine("올바르지 않습니다.");
		}
	}
}
