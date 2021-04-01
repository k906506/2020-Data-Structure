package _DS10_02_201701971_고도현;

public class CircularlyLinkedQueue<T> implements Queue<T> {
	// 인스턴스 변수
	private int _size;
	private LinkedNode<T> _rearNode;

	// 생성자
	public CircularlyLinkedQueue() {
		this._size = 0;
		this._rearNode = null;
	}

	public int size() {	// getter
		return this._size;
	}

	public int capacity() {	// getter
		return this._size;
	}

	public boolean isEmpty() { // rearNode가 null이면
		return this._rearNode == null;
	}

	public boolean isFull() { // 연결 체인이 가득 차는 경우는 메모리의 저장공간을 초과할 때임
		return false;
	}

	public T front() { // 맨 앞 노드
		T frontNode = null;
		if (!this.isEmpty()) { // 노드가 비어 있지 않으면
			frontNode = this._rearNode.next().element(); // 맨 앞 노드는 rear노드의 다음 노드
		}
		return frontNode;
	}

	public T rear() {	// 맨 뒤 노드
		T rearNode = null;
		if (!this.isEmpty()) {
			rearNode = this._rearNode.element();	// 맨 뒤 노드
		}
		return rearNode;
	}

	public boolean enQueue(T anElement) { // 큐에 원소 삽입
		LinkedNode<T> newRearNode = new LinkedNode<T>(anElement, null);
		if (!this.isFull()) { // 큐에 공간이 있으면
			if (this.isEmpty()) { // 큐가 비어있으면
				newRearNode.setNext(newRearNode); // 다음 노드가 자기 자신(self-loop)
			} else { // 큐가 원소가 1개 이상이면
				newRearNode.setNext(this._rearNode.next()); // 다음 노드를 rearNode의 다음노드로
				this._rearNode.setNext(newRearNode); // rearNode의 다음노드를 newRareNode로
			}
			this._rearNode = newRearNode; // rareNode에 newRareNode
			this._size++; // size + 1
			return true;
		} else {
			return false;
		}

	}

	public T deQueue() {	// 큐에서 원소 제거
		T frontElement = null;
		if (!this.isEmpty()) {	// 큐에 공간이 있으면
			frontElement = this._rearNode.next().element();
			if (this._rearNode == this._rearNode.next()) { // 노드가 한 개인 경우
				this._rearNode = null;	// 노드를 비운다
			} else { // 노드가 두 개 이상인 경우
				this._rearNode.setNext(this._rearNode.next().next()); // rearNode의 다음 노드를 다음 다음 노드로
			}
			this._size--;	// size - 1
		}
		return frontElement;
	}

	public void clear() {	// 초기화
		this._rearNode = null;
		this._size = 0;
	}

	public T elementAt(int anOrder) {	// anOrder번째 원소
		if (anOrder >= 0 && anOrder <= (this._size - 1)) {	// anOrder가 유효범위일때
			LinkedNode<T> frontNode = this._rearNode.next();	// frontNode는 큐의 맨 앞 값
			int nodeCount = 0;
			while (nodeCount < anOrder) {
				frontNode = frontNode.next();	// 한 노드씩 이동
				nodeCount++;	// count
			}
			return frontNode.element();	// 해당 번째의 원소 출력
		} else {
			return null;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularlyLinkedQueueIterator();
	}

	private class CircularlyLinkedQueueIterator implements Iterator<T> {
		private LinkedNode<T> _nextNode;
		private int _count;

		private LinkedNode<T> nextNode() {
			return this._nextNode;
		}

		private void setNextNode(LinkedNode<T> newNextNode) {
			this._nextNode = newNextNode;
		}

		private int count() {
			return this._count;
		}

		private void setCount(int newCount) {
			this._count = newCount;
		}

		private CircularlyLinkedQueueIterator() {
			this.setNextNode(CircularlyLinkedQueue.this._rearNode);
			this.setCount(CircularlyLinkedQueue.this.size());
		}

		@Override
		public boolean hasNext() {
			return (this.count() > 0);
		}

		@Override
		public T next() {
			if (this.hasNext()) {
				this.setNextNode(this.nextNode().next());
				T nextElement = this.nextNode().element();
				this.setCount(this.count() - 1);
				return nextElement;
			} else {
				return null;
			}
		}
	}

}
