package _DS10_01_201701971_고도현;

public class CircularArrayQueue<E> implements Queue<E> {
	// 상수
	private static final int DEFAULT_CAPACITY = 100;

	private int _maxLength;
	private int _frontPosition;
	private int _rearPosition;
	private E[] _elements;

	// 생성자
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
	public int size() {	// 큐의 size
		if (this.rearPosition() >= this.frontPosition()) {	// rear >= front
			return (this.rearPosition() - this.frontPosition());
		} else {	// front > rear
			return (this.rearPosition() + this.maxLength() - this.frontPosition());	// maxlength를 더한 값에 front를 빼준다
		}
	}

	public int capacity() {
		return (this.maxLength() + 1);
	}

	public boolean isEmpty() {	// 큐가 비어있는지
		return this.frontPosition() == this.rearPosition();	// rear == front 비어있는 상태
	}

	public boolean isFull() {	// 큐가 가득 차 있는지
		int nextRearPosition = (this._rearPosition + 1) % this._maxLength;	// 다음 위치가 rear == front 인경우
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

	public E front() {	// 큐의 맨 앞 원소
		E frontElement = null;
		if (!this.isEmpty()) {	// 큐가 비어 있지 않으면
			frontElement = this._elements[this._frontPosition + 1];	// 맨 앞 원소는 frontPosition의 원소
		}
		return frontElement;
	}

	public E rear() {	// 큐의 맨 뒤 원소
		E rearElement = null;
		if (!this.isEmpty()) {	// 큐가 비어 있지 않으면
			rearElement = this._elements[this._rearPosition];	// 맨 뒤 원소는 rearPosition의 원소
		}
		return rearElement;
	}

	public boolean enQueue(E anElement) {	// 큐에 원소 삽입
		if (this.isFull()) {	// 큐가 카득 차 있으면
			return false;	// false
		} else {	// 큐에 공간이 있으면
			this.setRearPosition((this.rearPosition() + 1) % this.maxLength());	// 0 ~ (maxLength-1)까지의 공간에 저장
			this.elements()[this.rearPosition()] = anElement;	// 원소 삽입
			return true;	// true
		}
	}

	public E deQueue() {	// 큐에 원소 제거
		E frontElement = null;
		if (this.isEmpty()) {	// 큐가 비어 있으면
			return null;	// false
		} else {	// 큐가 원소가 있으면
			this._frontPosition = (this._frontPosition+1) % this._maxLength;
			frontElement = this._elements[this._frontPosition];
			this._elements[this._frontPosition] = null;
			return frontElement;
		}
	}

	public void clear() {	// 큐 초기화
		this._frontPosition = 0;	// 맨 앞 값 0
		this._rearPosition = 0;		// 맨 뒤 값 0
		for (int i = 0; i < this.maxLength(); i++) {	// 큐를 초기화
			this._elements[i] = null;
		}
	}

	public E elementAt(int anOrder) {	// 큐 내부의 위치 제공
		if (anOrder >= 0 && anOrder < this.maxLength()) {
			return this.elements()[(this.frontPosition() + 1 + anOrder) % this.maxLength()];	// 환형이기 때문에 anOrder를 더해줘야한다
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
