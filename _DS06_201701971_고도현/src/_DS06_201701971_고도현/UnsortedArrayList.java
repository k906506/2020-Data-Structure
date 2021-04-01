package _DS06_201701971_����;

public class UnsortedArrayList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;

	private int _capacity;	// �ν��Ͻ� ����
	private int _size;
	private E[] _elements;

	public int capacity() {	// getter
		return this._capacity;
	}

	public void setCapacity(int newCapacity) {	// setter
		this._capacity = newCapacity;
	}

	public int size() {	// getter
		return this._size;
	}

	private void setSize(int newSize) { // setter
		this._size = newSize;
	}

	private E[] elements() {	// getter
		return this._elements;
	}

	private void setElements(E[] newElements) { // setter
		this._elements = newElements;
	}

	public UnsortedArrayList() {
		this(UnsortedArrayList.DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public UnsortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
	}
	
	public boolean isFull() { // size�� capacity�� ������ true�� return�Ѵ�
		return this._size == this._capacity;
	}
	public boolean isEmpty() { // size�� 0�̸� true�� return�Ѵ�
		return this._size == 0;
	}

	public boolean addToLast(E anElement) {	// ���� ����
		if (this.isFull()) {	// ����Ʈ�� ���� ��������
			return false;		// false
		} else {
			this.elements()[this.size()] = anElement;	// �迭�� �� �ڿ� ���� ����
			this.setSize(this.size() + 1);	// ũ�� ����
			return true;	// true
		}
	}
	
	public E max() {
		if (this.isEmpty()) {	// ����Ʈ�� ���������
			return null;
		} else {	// ����Ʈ�� ���Ұ� ������
			E maxElement = this.elements()[0];	// �ִ밪�� �迭�� �� �� ���ҷ� ����
			for (int i = 0; i< this.size(); i++) {	// �迭�� ũ�⸸ŭ �ݺ����� ����
				if(maxElement.compareTo(this.elements()[i]) < 0) { // maxElement���� element[i]�� ���� �� ũ��
					maxElement = this.elements()[i];	// maxElement�� element[i]������ ����
				}
			}
			return maxElement;	// maxElement�� return
		}
	}
}
