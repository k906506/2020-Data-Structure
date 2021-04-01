package _DS10_01_201701971_����;

public class CircularArrayQueue<E> implements Queue<E> {
	// ���
	private static final int DEFAULT_CAPACITY = 100;

	private int _maxLength;
	private int _frontPosition;
	private int _rearPosition;
	private E[] _elements;

	// ������
	private int maxLength() { // getter
		return _maxLength;
	}

	private void setMaxLength(int newMaxLength) { // setter
		this._maxLength = newMaxLength;
	}

	private int frontPosition() { // getter
		return this._frontPosition;
	}

	private void setFrontPosition(int newFrontPosition) { // setter
		this._frontPosition = newFrontPosition;
	}

	private int rearPosition() { // getter
		return this._rearPosition;
	}

	private void setRearPosition(int newRearPosition) { // setter
		this._rearPosition = newRearPosition;
	}

	private E[] elements() {
		return this._elements;
	}

	private void setElement(E[] newElement) {
		this._elements = newElement;
	}

	@Override
	public int size() {	// ť�� size
		if (this.rearPosition() >= this.frontPosition()) {	// rear >= front
			return (this.rearPosition() - this.frontPosition());
		} else {	// front > rear
			return (this.rearPosition() + this.maxLength() - this.frontPosition());	// maxlength�� ���� ���� front�� ���ش�
		}
	}

	public int capacity() {
		return (this.maxLength() + 1);
	}

	public boolean isEmpty() {	// ť�� ����ִ���
		return this.frontPosition() == this.rearPosition();	// rear == front ����ִ� ����
	}

	public boolean isFull() {	// ť�� ���� �� �ִ���
		int nextRearPosition = (this._rearPosition + 1) % this._maxLength;	// ���� ��ġ�� rear == front �ΰ��
		return nextRearPosition == this._frontPosition;
	}

	public CircularArrayQueue() {
		this(CircularArrayQueue.DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int givenCapacity) {
		this.setMaxLength(givenCapacity + 1);
		this.setFrontPosition(0);
		this.setRearPosition(0);
		this.setElement((E[]) new Object[this.maxLength()]);
	}

	public E front() {	// ť�� �� �� ����
		E frontElement = null;
		if (!this.isEmpty()) {	// ť�� ��� ���� ������
			frontElement = this._elements[this._frontPosition + 1];	// �� �� ���Ҵ� frontPosition�� ����
		}
		return frontElement;
	}

	public E rear() {	// ť�� �� �� ����
		E rearElement = null;
		if (!this.isEmpty()) {	// ť�� ��� ���� ������
			rearElement = this._elements[this._rearPosition];	// �� �� ���Ҵ� rearPosition�� ����
		}
		return rearElement;
	}

	public boolean enQueue(E anElement) {	// ť�� ���� ����
		if (this.isFull()) {	// ť�� ī�� �� ������
			return false;	// false
		} else {	// ť�� ������ ������
			this.setRearPosition((this.rearPosition() + 1) % this.maxLength());	// 0 ~ (maxLength-1)������ ������ ����
			this.elements()[this.rearPosition()] = anElement;	// ���� ����
			return true;	// true
		}
	}

	public E deQueue() {	// ť�� ���� ����
		E frontElement = null;
		if (this.isEmpty()) {	// ť�� ��� ������
			return null;	// false
		} else {	// ť�� ���Ұ� ������
			this._frontPosition = (this._frontPosition+1) % this._maxLength;
			frontElement = this._elements[this._frontPosition];
			this._elements[this._frontPosition] = null;
			return frontElement;
		}
	}

	public void clear() {	// ť �ʱ�ȭ
		this._frontPosition = 0;	// �� �� �� 0
		this._rearPosition = 0;		// �� �� �� 0
		for (int i = 0; i < this.maxLength(); i++) {	// ť�� �ʱ�ȭ
			this._elements[i] = null;
		}
	}

	public E elementAt(int anOrder) {	// ť ������ ��ġ ����
		if (anOrder >= 0 && anOrder < this.maxLength()) {
			return this.elements()[(this.frontPosition() + 1 + anOrder) % this.maxLength()];	// ȯ���̱� ������ anOrder�� ��������Ѵ�
		} else {
			return null;
		}
	}

	public Iterator<E> iterator() {
		return (new CircularArrayQueueIterator());
	}

	private class CircularArrayQueueIterator implements Iterator<E> {
		private int _nextOrder;

		private int nextOrder() {
			return this._nextOrder;
		}

		private void setNextOrder(int newNextOrder) {
			this._nextOrder = newNextOrder;
		}

		private CircularArrayQueueIterator() {
			this.setNextOrder(0);
		}

		@Override
		public boolean hasNext() {
			return (this.nextOrder() < CircularArrayQueue.this.size());
		}

		@Override
		public E next() {
			E nextElement = null;
			if (this.hasNext()) {
				nextElement = CircularArrayQueue.this.elementAt(this.nextOrder());
				this.setNextOrder(this.nextOrder() + 1);
			}
			return nextElement;
		}

	}
}
