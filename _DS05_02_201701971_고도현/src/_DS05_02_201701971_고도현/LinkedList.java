package _DS05_02_201701971_고도현;

public class LinkedList<T> {
	private int _size;	// 원소의 개수
	private Node<T> _head;	// 맨 앞 노드
	
	private boolean anElementDoesExistAt(int anOrder) {	// anOrder의 유효값을 판단하기 위한 메소드
		return ((anOrder >= 0) && (anOrder < this._size));
	}

	public LinkedList() {	// 생성자
		this._head = null;
		this._size = 0;
	}
	
	public boolean isEmpty() {	// 빈 노드 판단
		return (this._head == null);
	}

	public boolean isFull() {	// 꽉찬 노드 판단
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
		if (this.isEmpty()) {	// 리스트가 비어있으면
			return null;	
		} else {
			return elementAt(0);	// 맨 앞 값 return
		}
	}

	public T last() {
		if (this.isEmpty()) {	// 리스트가 비어있으면
			return null;
		} else {
			return elementAt(this._size - 1);	// (원소의 개수 -1)의 위치
		}
	}

	public int orderOf(T anElement) {
		int order = 0;
		Node<T> currentNode = this._head;
		while (currentNode != null && (!currentNode.element().equals(anElement))) { // anElement와 같은 값이 담긴 노드를 찾으면 while문 탈출
			order++;
			currentNode = currentNode.next();	// 노드의 이동
		}
		if (currentNode == null) { // 노드에 담긴 값이 없을 때
			return -1; // -1 return
		} else {
			return order; // order값 return
		}
	}

	public boolean doesContain(T anElement) {
		return (orderOf(anElement) != -1);
	}

	public boolean addTo (T anElement, int anOrder) {
		if ((anOrder <0) || (anOrder>this._size)) {	// anOrder의 유효 판단
			return false;
		}
		else if (this.isFull()) {
			return false;
		}
		else {
			Node <T> nodeForAdd = new Node <T> (anElement, null);
				if (anOrder == 0) {	// 맨 앞 순서에 삽입
					nodeForAdd.setNext(this._head);
					this._head = nodeForAdd;
				}
				else {	// previous 노드가 존재한다
					Node <T> previous = this._head;
					for (int i = 1; i<anOrder;i++) {
						previous = previous.next();	// 삽입할 위치의 앞 노드를 찾는다
					}
					nodeForAdd.setNext(previous.next());
					previous.setNext(nodeForAdd);	
				}
				this._size++;
				return true;
			}
		}
	
	public boolean addToFirst (T anElement) {	// 맨 앞 저장
		return this.addTo(anElement, 0);
	}
	
	public boolean addToLast (T anElement) {	// 맨 뒤 저장
		return this.addTo(anElement, this._size);
	}
	
	public boolean add(T anElement) {
		return this.addToFirst(anElement); // addToLast를 하게 되면 마지막 노드까지 읽는 과정이 필요하다.
	}
	
	public T removeFrom (int anOrder) {
		if(!anElementDoesExistAt(anOrder)) {	// 유효 판단
			return null;
			}
		else {	// 삭제할 원소가 있다면
			Node <T> removed = null;
			if(anOrder == 0) {	// 삭제할 원소가 맨 앞 원소
				removed =this._head;
				this._head = this._head.next();
			}
			else {	// 원소가 두 개 이상
				Node<T> previous = this._head;
				for (int i=0; i<anOrder; i++) {
					previous = previous.next();
				}
				removed = previous.next(); // anOrder의 앞 노드 값이 previous이므로 삭제할 anOrder의 노드는 previous.next
				previous.setNext(removed.next());	// 삭제된 노드의 다음 노드를 previous.next로 설정
			}
			this._size--;	// 하나가 삭제되었으므로 -1
			return removed.element(); // 삭제된 값을 얻음
		}
	}
	
	public T removeFirst() {
		return (this.removeFrom(0));	// 제일 앞 노드를 지움 (0번째 노드)
	}
	
	public T removeLast() {
		return (this.removeFrom(this._size-1));	// 제일 마지막 노드를 지움 (element가 저장되어있는 마지막 노드는 size-1번째 노드)
	}
	
	public T removeAny() {
		return (this.removeFirst());	// 마지막 노드까지 읽는 과정 불필요
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
		private Node <T> _nextNode;		// 연결체인에서 다음 원소를 소유하고 있는 노드
		
		private ListIterator() {	// 생성자
			this._nextNode = LinkedList.this._head;
		}
		
		public boolean hasNext() {	// 다음 원소가 존재하는지를 알아낸다
			return (this._nextNode != null);
		}
		
		public T next() {	// 다음 원소를 얻어낸다. 없으면 null을 얻는다
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

