package _DS06_201701971_����;

public class SortedLinkedList<E extends Comparable<E>> {
	private int _size; // ������ ����
	private LinkedNode<E> _head; // �� �� ���

	public SortedLinkedList() { // ������
		this._head = null;
		this._size = 0;
	}

	private LinkedNode<E> head() { // ���� ü���� �� �� ��带 ��´� (getter)
		return this._head;
	}

	private void setHead(LinkedNode<E> newHead) { // ��带 newHead�� �����Ѵ� (setter)
		this._head = newHead;
	}

	private int size() {
		return this._size;
	}

	private void setSize(int newSize) {
		this._size = newSize;
	}

	public boolean isEmpty() { // �� ��� �Ǵ�
		return (this._head == null);
	}

	public boolean isFull() { // ���� ��� �Ǵ�
		return false;
	}

	public boolean add(E anElement) {
		if (this.isFull()) { // ����Ʈ�� ���� �� ������
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			if (this.isEmpty()) { // ����Ʈ�� ���������
				this.setHead(nodeForAdd); // nodeForAdd�� head�� ����
			} else { // ����Ʈ�� ���Ұ� ������
				LinkedNode<E> current = this.head(); // ���� ���ϴ� ���
				LinkedNode<E> previous = null; // current����� �ճ��
				while (current != null) { // ����Ʈ�� ���� ������ ������ �˻��Ѵ�.
					if (current.element().compareTo(anElement) > 0) { // current�� ���� anElement�� ���� ũ��
						break; // �ݺ��� ����
					}
					previous = current; // (�׷��� ���� ���) previous�� current��
					current = current.next(); // current�� next�� ����
				}
				if (previous == null) { // anElement�� ���� ������ �� �տ� �����Ѵ�.
					nodeForAdd.setNext(this.head());
					this.setHead(nodeForAdd);
				} else {
					nodeForAdd.setNext(current);
					previous.setNext(nodeForAdd);
				}
			}
			this.setSize(this.size() + 1); // size�� 1��ŭ ������Ų��.
			return true;
		}
	}

	public E max() {
		if (this.isEmpty()) { // ����Ʈ�� ���������
			return null;
		} else {
			LinkedNode<E> currentNode = this._head; // ���� ��带 �� �� ���� ����
			for (int i = 0; i < this.size() - 1; i++) {
				currentNode = currentNode.next(); // �� �� ������ �̵��Ѵ�.
			}
			return currentNode.element(); // �� �� ��� ���� return
		}
	}
}
