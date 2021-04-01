package _DS12_201701971_����;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
	public InsertionSort() {
	}

	public boolean sort(E[] aList, int aSize) {
		if ((aSize < 1) || (aSize > aList.length)) { // aSize�� 1���� �۰ų� �迭�� ũ�⺸�� ū ���
			return false; // false
		}
		int minLoc = 0; // ������ġ�� �ּҰ�
		for (int i = 1; i < aSize; i++) { // �迭 ���� Ž��
			if (aList[i].compareTo(aList[minLoc]) < 0) { // aList[i] < aList[min]�� ���
				minLoc = i; // i��° ��ġ�� �ּҰ�
			}
		}
		this.swap(aList, 0, minLoc); // ��ġ ����
		for (int i = 2; i < aSize; i++) {
			E insertedElement = aList[i]; // ���Ե� ���Ҵ� ������ġ(i)�� ����
			int insertionLoc = i - 1; // ���Ե� ��ġ�� ���� ��ġ - 1
			while (aList[insertionLoc].compareTo(insertedElement) > 0) { // aList[insertionLoc] > insertedElement�� ���
																			// (���Ե� ��ġ�� ���� > ���� ��ġ�� ����)
				aList[insertionLoc + 1] = aList[insertionLoc]; // ���� ��ġ�� ���ҿ� ���Ե� ��ġ�� ���Ҹ� ����
				insertionLoc--; // ������ �̵�
			}
			aList[insertionLoc + 1] = insertedElement; //
		}
		return true;
	}
}
