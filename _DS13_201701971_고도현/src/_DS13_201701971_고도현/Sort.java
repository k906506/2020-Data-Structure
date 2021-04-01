package _DS13_201701971_����;

public abstract class Sort<E extends Comparable<E>>  {
	protected void swap(E[] aList, int i, int j) {	// ���Ұ� ����
		E tempElement = aList[i];	// i�� ���� tempElement�� ����
		aList[i] = aList[j];	// j�� ���� i�� ����
		aList[j] = tempElement;	// tempElement���� j�� ����
	}
	
	protected Sort() {	// ������
	}
	
	public abstract boolean sort(E[] aList, int aSize);
}
