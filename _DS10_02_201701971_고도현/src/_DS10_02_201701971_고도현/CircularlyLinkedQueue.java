package _DS10_02_201701971_����;

public class CircularlyLinkedQueue<T> implements Queue<T> {
	// �ν��Ͻ� ����
	private int _size;
	private LinkedNode<T> _rearNode;

	// ������
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

	public boolean isEmpty() { // rearNode�� null�̸�
		return this._rearNode == null;
	}

	public boolean isFull() { // ���� ü���� ���� ���� ���� �޸��� ��������� �ʰ��� ����
		return false;
	}

	public T front() { // �� �� ���
		T frontNode = null;
		if (!this.isEmpty()) { // ��尡 ��� ���� ������
			frontNode = this._rearNode.next().element(); // �� �� ���� rear����� ���� ���
		}
		return frontNode;
	}

	public T rear() {	// �� �� ���
		T rearNode = null;
		if (!this.isEmpty()) {
			rearNode = this._rearNode.element();	// �� �� ���
		}
		return rearNode;
	}

	public boolean enQueue(T anElement) { // ť�� ���� ����
		LinkedNode<T> newRearNode = new LinkedNode<T>(anElement, null);
		if (!this.isFull()) { // ť�� ������ ������
			if (this.isEmpty()) { // ť�� ���������
				newRearNode.setNext(newRearNode); // ���� ��尡 �ڱ� �ڽ�(self-loop)
			} else { // ť�� ���Ұ� 1�� �̻��̸�
				newRearNode.setNext(this._rearNode.next()); // ���� ��带 rearNode�� ��������
				this._rearNode.setNext(newRearNode); // rearNode�� ������带 newRareNode��
			}
			this._rearNode = newRearNode; // rareNode�� newRareNode
			this._size++; // size + 1
			return true;
		} else {
			return false;
		}

	}

	public T deQueue() {	// ť���� ���� ����
		T frontElement = null;
		if (!this.isEmpty()) {	// ť�� ������ ������
			frontElement = this._rearNode.next().element();
			if (this._rearNode == this._rearNode.next()) { // ��尡 �� ���� ���
				this._rearNode = null;	// ��带 ����
			} else { // ��尡 �� �� �̻��� ���
				this._rearNode.setNext(this._rearNode.next().next()); // rearNode�� ���� ��带 ���� ���� ����
			}
			this._size--;	// size - 1
		}
		return frontElement;
	}

	public void clear() {	// �ʱ�ȭ
		this._rearNode = null;
		this._size = 0;
	}

	public T elementAt(int anOrder) {	// anOrder��° ����
		if (anOrder >= 0 && anOrder <= (this._size - 1)) {	// anOrder�� ��ȿ�����϶�
			LinkedNode<T> frontNode = this._rearNode.next();	// frontNode�� ť�� �� �� ��
			int nodeCount = 0;
			while (nodeCount < anOrder) {
				frontNode = frontNode.next();	// �� ��徿 �̵�
				nodeCount++;	// count
			}
			return frontNode.element();	// �ش� ��°�� ���� ���
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
