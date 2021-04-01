package _DS06_201701971_����;

public class UnsortedLinkedList<E extends Comparable<E>> {
	private int _size; // ������ ����
	private LinkedNode<E> _head; // �� �� ���

	public UnsortedLinkedList() { // ������
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

	public boolean addToFirst(E anElement) {
		if (this.isFull()) {
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			nodeForAdd.setElement(anElement); // anElment�� ���ҷ� ����
			nodeForAdd.setNext(this.head()); // ������ �� �� ��带 ���� ���� ����
			this.setHead(nodeForAdd); // newNode�� �� �� ���� ����
			this.setSize(this.size() + 1); // size�� +1
			return true; // true�� ����
		}
	}

	public E max() {
		if (this.isEmpty()) { // ����Ʈ�� ���������
			return null;
		} else {
			LinkedNode<E> currentNode = this.head(); // ���� ��带 head��
			LinkedNode<E> maxNode = currentNode; // ���� ��带 maxNode��
			while (currentNode.next() != null) { // ���� ��尡 ���� ��
				if (maxNode.element().compareTo(currentNode.next().element()) < 0) { // maxNode�� ���� currentNode.next������
																						// ũ��
					maxNode = currentNode.next(); // maxNode�� currentNode.next�� ����
				}
				currentNode = currentNode.next(); // ���� ���� �̵�
			}
			return maxNode.element(); // maxNode�� ���Ұ� return
		}
	}
}
