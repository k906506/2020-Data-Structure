package _DS05_02_201701971_����;

public class LinkedList<T> {
	private int _size;	// ������ ����
	private Node<T> _head;	// �� �� ���
	
	private boolean anElementDoesExistAt(int anOrder) {	// anOrder�� ��ȿ���� �Ǵ��ϱ� ���� �޼ҵ�
		return ((anOrder >= 0) && (anOrder < this._size));
	}

	public LinkedList() {	// ������
		this._head = null;
		this._size = 0;
	}
	
	public boolean isEmpty() {	// �� ��� �Ǵ�
		return (this._head == null);
	}

	public boolean isFull() {	// ���� ��� �Ǵ�
		return false;
	}

	public int size() {	// getter
		return this._size;
	}
	

	public T elementAt(int anOrder) {
		if (this.anElementDoesExistAt(anOrder)) {
			Node<T> currentNode = this._head;
			int nodeCount = 0;
			while (nodeCount < anOrder) {
				currentNode = currentNode.next();
				nodeCount++;
			}
			return currentNode.element();
		} else {
			return null;
		}
	}
	
	public T first() {
		if (this.isEmpty()) {	// ����Ʈ�� ���������
			return null;	
		} else {
			return elementAt(0);	// �� �� �� return
		}
	}

	public T last() {
		if (this.isEmpty()) {	// ����Ʈ�� ���������
			return null;
		} else {
			return elementAt(this._size - 1);	// (������ ���� -1)�� ��ġ
		}
	}

	public int orderOf(T anElement) {
		int order = 0;
		Node<T> currentNode = this._head;
		while (currentNode != null && (!currentNode.element().equals(anElement))) { // anElement�� ���� ���� ��� ��带 ã���� while�� Ż��
			order++;
			currentNode = currentNode.next();	// ����� �̵�
		}
		if (currentNode == null) { // ��忡 ��� ���� ���� ��
			return -1; // -1 return
		} else {
			return order; // order�� return
		}
	}

	public boolean doesContain(T anElement) {
		return (orderOf(anElement) != -1);
	}

	public boolean addTo (T anElement, int anOrder) {
		if ((anOrder <0) || (anOrder>this._size)) {	// anOrder�� ��ȿ �Ǵ�
			return false;
		}
		else if (this.isFull()) {
			return false;
		}
		else {
			Node <T> nodeForAdd = new Node <T> (anElement, null);
				if (anOrder == 0) {	// �� �� ������ ����
					nodeForAdd.setNext(this._head);
					this._head = nodeForAdd;
				}
				else {	// previous ��尡 �����Ѵ�
					Node <T> previous = this._head;
					for (int i = 1; i<anOrder;i++) {
						previous = previous.next();	// ������ ��ġ�� �� ��带 ã�´�
					}
					nodeForAdd.setNext(previous.next());
					previous.setNext(nodeForAdd);	
				}
				this._size++;
				return true;
			}
		}
	
	public boolean addToFirst (T anElement) {	// �� �� ����
		return this.addTo(anElement, 0);
	}
	
	public boolean addToLast (T anElement) {	// �� �� ����
		return this.addTo(anElement, this._size);
	}
	
	public boolean add(T anElement) {
		return this.addToFirst(anElement); // addToLast�� �ϰ� �Ǹ� ������ ������ �д� ������ �ʿ��ϴ�.
	}
	
	public T removeFrom (int anOrder) {
		if(!anElementDoesExistAt(anOrder)) {	// ��ȿ �Ǵ�
			return null;
			}
		else {	// ������ ���Ұ� �ִٸ�
			Node <T> removed = null;
			if(anOrder == 0) {	// ������ ���Ұ� �� �� ����
				removed =this._head;
				this._head = this._head.next();
			}
			else {	// ���Ұ� �� �� �̻�
				Node<T> previous = this._head;
				for (int i=0; i<anOrder; i++) {
					previous = previous.next();
				}
				removed = previous.next(); // anOrder�� �� ��� ���� previous�̹Ƿ� ������ anOrder�� ���� previous.next
				previous.setNext(removed.next());	// ������ ����� ���� ��带 previous.next�� ����
			}
			this._size--;	// �ϳ��� �����Ǿ����Ƿ� -1
			return removed.element(); // ������ ���� ����
		}
	}
	
	public T removeFirst() {
		return (this.removeFrom(0));	// ���� �� ��带 ���� (0��° ���)
	}
	
	public T removeLast() {
		return (this.removeFrom(this._size-1));	// ���� ������ ��带 ���� (element�� ����Ǿ��ִ� ������ ���� size-1��° ���)
	}
	
	public T removeAny() {
		return (this.removeFirst());	// ������ ������ �д� ���� ���ʿ�
	}
	
	public boolean replaceAt (T anElement, int anOrder) {
		if(!this.anElementDoesExistAt(anOrder)) {
			return false;
		}
		else {
			Node <T> current = this._head;
			for (int i = 0; i < anOrder; i ++) {
				current = current.next();
			}
			current.setElement(anElement);
			return true;
		}
	}
	
	public void clear() {	// clear
		this._head = null;
		this._size = 0;
	}
	
	public Iterator<T> iterator() {
		return (new ListIterator());
	}
	
	private class ListIterator implements Iterator<T>{
		private Node <T> _nextNode;		// ����ü�ο��� ���� ���Ҹ� �����ϰ� �ִ� ���
		
		private ListIterator() {	// ������
			this._nextNode = LinkedList.this._head;
		}
		
		public boolean hasNext() {	// ���� ���Ұ� �����ϴ����� �˾Ƴ���
			return (this._nextNode != null);
		}
		
		public T next() {	// ���� ���Ҹ� ����. ������ null�� ��´�
			if (this._nextNode == null) {
				return null;
			}
			else {
				T e = this._nextNode.element();
				this._nextNode = this._nextNode.next();
				return e;
			}
		}
	}
}

