package _DS05_01_201701971_고도현;

public class ArrayList<E> {
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

	public boolean isEmpty() { // size가 0이면 true값 return한다
		return this._size == 0;
	}

	public boolean isFull() { // size와 capacity가 같으면 true값 return한다
		return this._size == this._capacity;
	}

	public boolean doesContain(E anElement) {	// 원소 찾기
		for (int i = 0; i < this.size(); i++) {
			if (this.elements()[i].equals(anElement)) {	// 같은 값이 있으면
				return true;	// true
			}
		}
		return false;
	}

	public E elementAt(int anOrder) {	// 원소 찾기
		if ((anOrder >= 0) && (anOrder < this._size)) {
			return this._elements[anOrder];	// anOrder의 원소 return
		}
		return null;
	}
	
	public E first() {	// 맨 앞 원소
		if(this.isEmpty()) {	// 리스트가 비어있으면
			return null;
		}
		else {
			return this._elements[0];
		}
	}
	
	public E last() {	// 맨 뒤 원소
		if(this.isEmpty()) {	// 리스트가 비어있으면
			return null;
		}
		else {
			return this._elements[this._size-1];
		}
	}

	public int orderOf(E anElement) {	// 원소 찾기
		for (int order = 0; order < this.size(); order++) {
			if (this.elements()[order].equals(anElement)) {	// 주어진 순서에 원소가 있으면
				return order;
			}
		}
		return -1;
	}

	private void makeRoomAt(int aPosition) {	// 방 만들기
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1];
		}
	}

	public boolean addTo(E anElement, int anOrder) {	// 원소 삽입
		if (this.isFull()) {	// 리스트가 가득 차있으면
			return false;
		} else if (anOrder < 0 || anOrder > this.size()) {	// anOrder값이 유효 값이 아니면
			return false;
		} else {
			this.makeRoomAt(anOrder);	// 방 만들고
			this.elements()[anOrder] = anElement;	// 원소 삽입
			this.setSize(this.size() + 1);	// 크기 증가
			return true;
		}
	}

	public boolean addToFirst(E anElement) {	// 맨 앞 삽입
		return this.addTo(anElement, 0);
	}

	public boolean addToLast(E anElement) {		// 맨 뒤 삽입
		return this.addTo(anElement, this.size());
	}

	public boolean add(E anElement) {	 // 맨 뒤 삽입
		return this.addToLast(anElement); // 가장 효과적인 곳에 삽입
	}

	private void removeGapAt(int aPosition) {	// 삭제할 공간 제거
		for (int i = aPosition + 1; i < this.size(); i++) {
			this.elements()[i - 1] = this.elements()[i];
			this.elements()[this.size() - 1] = null;
		}
	}

	public E removeFrom(int anOrder) {
		if (anOrder < 0 || anOrder >= this.size()) {
			// anOrder가 유효하지 않다
			// 리스트가 empty이면, size가 0 이므로 이 조건은 anOrder의 값과 관계없이 true 이다.
			// 따라서 이 조건은 리스트의 empty 검사를 겸하고 있다.
			return null;
		} else {
			E removedElement = this.elements()[anOrder];
			this.removeGapAt(anOrder);
			this.setSize(this.size() - 1);
			return removedElement;
		}
	}

	public E removeFirst() {	// 맨 앞 제거
		return removeFrom(0);
	}

	public E removeLast() {		// 맨 뒤 제거
		return removeFrom(this._size - 1);
	}

	public E removeAny() {		// 임의 제거
		return removeLast();
	}

	public boolean replaceAt(E anElement, int anOrder) {	// 원소 변경
		if (this.isEmpty()) {	// 리스트가 비어있으면
			return false;
		} else if (anOrder < 0 || anOrder >= this.size()) { // anOrder가 유효값이 아니면
			return false;
		} else {
			this.elements()[anOrder] = anElement;
			return true;
		}
	}

	private class ListIterator implements Iterator<E> {	// 반복자 개체 선언
		private int _nextPosition;

		private int nextPosition() {
			return this._nextPosition;
		}

		private void setNextPosition(int newNextPosition) {
			this._nextPosition = newNextPosition;
		}

		private ListIterator() {
			this.setNextPosition(0);
		}

		@Override
		public boolean hasNext() {
			return (this.nextPosition() < ArrayList.this.size());
		}

		@Override
		public E next() {
			E nextElement = null;
			if (this.hasNext()) {
				nextElement = ArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition() + 1);
			}
			return nextElement;
		}
	}

	public Iterator<E> iterator() {
		return (new ListIterator());
	}

	@SuppressWarnings("unchecked")
	public ArrayList (int givenCapacity) {
		this.setCapacity (givenCapacity);
		this.setElements((E[]) new Object[ this.capacity()] );
	}

	public ArrayList () {
		this (ArrayList.DEFAULT_CAPACITY);
	}

}
