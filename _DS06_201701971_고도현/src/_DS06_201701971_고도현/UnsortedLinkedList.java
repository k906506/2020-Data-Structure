package _DS06_201701971_고도현;

public class UnsortedLinkedList<E extends Comparable<E>> {
	private int _size; // 원소의 개수
	private LinkedNode<E> _head; // 맨 앞 노드

	public UnsortedLinkedList() { // 생성자
		this._head = null;
		this._size = 0;
	}

	private LinkedNode<E> head() { // 연결 체인의 맨 앞 노드를 얻는다 (getter)
		return this._head;
	}

	private void setHead(LinkedNode<E> newHead) { // 노드를 newHead로 설정한다 (setter)
		this._head = newHead;
	}

	private int size() {
		return this._size;
	}

	private void setSize(int newSize) {
		this._size = newSize;
	}

	public boolean isEmpty() { // 빈 노드 판단
		return (this._head == null);
	}

	public boolean isFull() { // 꽉찬 노드 판단
		return false;
	}

	public boolean addToFirst(E anElement) {
		if (this.isFull()) {
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			nodeForAdd.setElement(anElement); // anElment를 원소로 설정
			nodeForAdd.setNext(this.head()); // 기존의 맨 앞 노드를 다음 노드로 설정
			this.setHead(nodeForAdd); // newNode를 맨 앞 노드로 설정
			this.setSize(this.size() + 1); // size값 +1
			return true; // true값 리턴
		}
	}

	public E max() {
		if (this.isEmpty()) { // 리스트가 비어있으면
			return null;
		} else {
			LinkedNode<E> currentNode = this.head(); // 현재 노드를 head로
			LinkedNode<E> maxNode = currentNode; // 현재 노드를 maxNode로
			while (currentNode.next() != null) { // 다음 노드가 있을 때
				if (maxNode.element().compareTo(currentNode.next().element()) < 0) { // maxNode의 값이 currentNode.next값보다
																						// 크면
					maxNode = currentNode.next(); // maxNode를 currentNode.next로 설정
				}
				currentNode = currentNode.next(); // 다음 노드로 이동
			}
			return maxNode.element(); // maxNode의 원소값 return
		}
	}
}
