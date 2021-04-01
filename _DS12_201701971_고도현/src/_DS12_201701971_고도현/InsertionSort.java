package _DS12_201701971_고도현;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
	public InsertionSort() {
	}

	public boolean sort(E[] aList, int aSize) {
		if ((aSize < 1) || (aSize > aList.length)) { // aSize가 1보다 작거나 배열의 크기보다 큰 경우
			return false; // false
		}
		int minLoc = 0; // 현재위치가 최소값
		for (int i = 1; i < aSize; i++) { // 배열 내부 탐색
			if (aList[i].compareTo(aList[minLoc]) < 0) { // aList[i] < aList[min]인 경우
				minLoc = i; // i번째 위치가 최소값
			}
		}
		this.swap(aList, 0, minLoc); // 위치 변경
		for (int i = 2; i < aSize; i++) {
			E insertedElement = aList[i]; // 삽입될 원소는 현재위치(i)의 원소
			int insertionLoc = i - 1; // 삽입될 위치는 현재 위치 - 1
			while (aList[insertionLoc].compareTo(insertedElement) > 0) { // aList[insertionLoc] > insertedElement인 경우
																			// (삽입될 위치의 원소 > 현재 위치의 원소)
				aList[insertionLoc + 1] = aList[insertionLoc]; // 현재 위치의 원소에 삽입될 위치의 원소를 저장
				insertionLoc--; // 앞으로 이동
			}
			aList[insertionLoc + 1] = insertedElement; //
		}
		return true;
	}
}
