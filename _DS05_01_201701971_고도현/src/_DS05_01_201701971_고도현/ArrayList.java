package _DS05_01_201701971_����;

public class ArrayList<E> {
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

	public boolean isEmpty() { // size�� 0�̸� true�� return�Ѵ�
		return this._size == 0;
	}

	public boolean isFull() { // size�� capacity�� ������ true�� return�Ѵ�
		return this._size == this._capacity;
	}

	public boolean doesContain(E anElement) {	// ���� ã��
		for (int i = 0; i < this.size(); i++) {
			if (this.elements()[i].equals(anElement)) {	// ���� ���� ������
				return true;	// true
			}
		}
		return false;
	}

	public E elementAt(int anOrder) {	// ���� ã��
		if ((anOrder >= 0) && (anOrder < this._size)) {
			return this._elements[anOrder];	// anOrder�� ���� return
		}
		return null;
	}
	
	public E first() {	// �� �� ����
		if(this.isEmpty()) {	// ����Ʈ�� ���������
			return null;
		}
		else {
			return this._elements[0];
		}
	}
	
	public E last() {	// �� �� ����
		if(this.isEmpty()) {	// ����Ʈ�� ���������
			return null;
		}
		else {
			return this._elements[this._size-1];
		}
	}

	public int orderOf(E anElement) {	// ���� ã��
		for (int order = 0; order < this.size(); order++) {
			if (this.elements()[order].equals(anElement)) {	// �־��� ������ ���Ұ� ������
				return order;
			}
		}
		return -1;
	}

	private void makeRoomAt(int aPosition) {	// �� �����
		for (int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i - 1];
		}
	}

	public boolean addTo(E anElement, int anOrder) {	// ���� ����
		if (this.isFull()) {	// ����Ʈ�� ���� ��������
			return false;
		} else if (anOrder < 0 || anOrder > this.size()) {	// anOrder���� ��ȿ ���� �ƴϸ�
			return false;
		} else {
			this.makeRoomAt(anOrder);	// �� �����
			this.elements()[anOrder] = anElement;	// ���� ����
			this.setSize(this.size() + 1);	// ũ�� ����
			return true;
		}
	}

	public boolean addToFirst(E anElement) {	// �� �� ����
		return this.addTo(anElement, 0);
	}

	public boolean addToLast(E anElement) {		// �� �� ����
		return this.addTo(anElement, this.size());
	}

	public boolean add(E anElement) {	 // �� �� ����
		return this.addToLast(anElement); // ���� ȿ������ ���� ����
	}

	private void removeGapAt(int aPosition) {	// ������ ���� ����
		for (int i = aPosition + 1; i < this.size(); i++) {
			this.elements()[i - 1] = this.elements()[i];
			this.elements()[this.size() - 1] = null;
		}
	}

	public E removeFrom(int anOrder) {
		if (anOrder < 0 || anOrder >= this.size()) {
			// anOrder�� ��ȿ���� �ʴ�
			// ����Ʈ�� empty�̸�, size�� 0 �̹Ƿ� �� ������ anOrder�� ���� ������� true �̴�.
			// ���� �� ������ ����Ʈ�� empty �˻縦 ���ϰ� �ִ�.
			return null;
		} else {
			E removedElement = this.elements()[anOrder];
			this.removeGapAt(anOrder);
			this.setSize(this.size() - 1);
			return removedElement;
		}
	}

	public E removeFirst() {	// �� �� ����
		return removeFrom(0);
	}

	public E removeLast() {		// �� �� ����
		return removeFrom(this._size - 1);
	}

	public E removeAny() {		// ���� ����
		return removeLast();
	}

	public boolean replaceAt(E anElement, int anOrder) {	// ���� ����
		if (this.isEmpty()) {	// ����Ʈ�� ���������
			return false;
		} else if (anOrder < 0 || anOrder >= this.size()) { // anOrder�� ��ȿ���� �ƴϸ�
			return false;
		} else {
			this.elements()[anOrder] = anElement;
			return true;
		}
	}

	private class ListIterator implements Iterator<E> {	// �ݺ��� ��ü ����
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
