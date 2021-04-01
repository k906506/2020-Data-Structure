package _DS06_201701971_고도현;

public class SortedArrayList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;

	private int _capacity; // 인스턴스 변수
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

	public boolean isEmpty() { // size가 0이면 true값 return한다
		return this._size == 0;
	}

	private void makeRoomAt(int aPosition) { // 방 만들기
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1]; // 뒤로 한 칸씩 이동한다.
		}
	}

	public boolean add(E anElement) {
		if (this.isFull()) {
			return false;
		} else {
			int i = 0, aPosition = 0;
			while (i < this.size()) {
				if (this.elements()[i].compareTo(anElement) < 0) { // element()[i] > anElement인 경우
					i++; // i = i + 1;
				} else { // element()[i] <= anElement인 경우
					break;
				}
			}
			aPosition = i; // i값이 삽입할 위치
			this.makeRoomAt(aPosition); // i의 위치에 방을 만든다
			this.elements()[aPosition] = anElement; // 방에 원소를 삽입한다.
			this.setSize(this.size() + 1); // 원소를 추가했으므로 size + 1을 한다
			return true;
		}
	}

	public E max() {
		if (this.isEmpty()) { // 리스트가 비어있으면
			return null;
		} else { // 리스트에 원소가 있으면
			return this.elements()[this.size() - 1]; // 맨 뒤 원소가 최대값
		}
	}
}
