package _DS06_201701971_����;

public class SortedArrayList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;

	private int _capacity; // �ν��Ͻ� ����
	private int _size;
	private E[] _elements;

	private int capacity() { // getter
		return this._capacity;
	}

	private void setCapacity(int newCapacity) { // setter
		this._capacity = newCapacity;
	}

	private int size() { // getter
		return this._size;
	}

	private void setSize(int newSize) { // setter
		this._size = newSize;
	}

	private E[] elements() { // getter
		return this._elements;
	}

	private void setElements(E[] newElements) { // setter
		this._elements = newElements;
	}

	public SortedArrayList() {
		this(SortedArrayList.DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public SortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
	}

	public boolean isFull() {
		return this._size == this._capacity;
	}

	public boolean isEmpty() { // size�� 0�̸� true�� return�Ѵ�
		return this._size == 0;
	}

	private void makeRoomAt(int aPosition) { // �� �����
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1]; // �ڷ� �� ĭ�� �̵��Ѵ�.
		}
	}

	public boolean add(E anElement) {
		if (this.isFull()) {
			return false;
		} else {
			int i = 0, aPosition = 0;
			while (i < this.size()) {
				if (this.elements()[i].compareTo(anElement) < 0) { // element()[i] > anElement�� ���
					i++; // i = i + 1;
				} else { // element()[i] <= anElement�� ���
					break;
				}
			}
			aPosition = i; // i���� ������ ��ġ
			this.makeRoomAt(aPosition); // i�� ��ġ�� ���� �����
			this.elements()[aPosition] = anElement; // �濡 ���Ҹ� �����Ѵ�.
			this.setSize(this.size() + 1); // ���Ҹ� �߰������Ƿ� size + 1�� �Ѵ�
			return true;
		}
	}

	public E max() {
		if (this.isEmpty()) { // ����Ʈ�� ���������
			return null;
		} else { // ����Ʈ�� ���Ұ� ������
			return this.elements()[this.size() - 1]; // �� �� ���Ұ� �ִ밪
		}
	}
}
