package _DS06_201701971_고도현;

public class UnsortedArrayList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;

	private int _capacity;	// 인스턴스 변수
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
	
	public boolean isFull() { // size와 capacity가 같으면 true값 return한다
		return this._size == this._capacity;
	}
	public boolean isEmpty() { // size가 0이면 true값 return한다
		return this._size == 0;
	}

	public boolean addToLast(E anElement) {	// 원소 삽입
		if (this.isFull()) {	// 리스트가 가득 차있으면
			return false;		// false
		} else {
			this.elements()[this.size()] = anElement;	// 배열의 맨 뒤에 원소 삽입
			this.setSize(this.size() + 1);	// 크기 증가
			return true;	// true
		}
	}
	
	public E max() {
		if (this.isEmpty()) {	// 리스트가 비어있으면
			return null;
		} else {	// 리스트에 원소가 있으면
			E maxElement = this.elements()[0];	// 최대값을 배열의 맨 앞 원소로 설정
			for (int i = 0; i< this.size(); i++) {	// 배열의 크기만큼 반복문을 돌려
				if(maxElement.compareTo(this.elements()[i]) < 0) { // maxElement보다 element[i]의 값이 더 크면
					maxElement = this.elements()[i];	// maxElement를 element[i]값으로 변경
				}
			}
			return maxElement;	// maxElement값 return
		}
	}
}
