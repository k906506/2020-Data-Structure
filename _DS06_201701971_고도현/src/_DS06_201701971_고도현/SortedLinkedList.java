package _DS06_201701971_고도현;

public class SortedLinkedList<E extends Comparable<E>> {
	private int _size; // 원소의 개수
	private LinkedNode<E> _head; // 맨 앞 노드

	public SortedLinkedList() { // 생성자
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

	public boolean add(E anElement) {
		if (this.isFull()) { // 리스트가 가득 차 있으면
			return false;
		} else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			if (this.isEmpty()) { // 리스트가 비어있으면
				this.setHead(nodeForAdd); // nodeForAdd를 head로 설정
			} else { // 리스트에 원소가 있으면
				LinkedNode<E> current = this.head(); // 현재 비교하는 노드
				LinkedNode<E> previous = null; // current노드의 앞노드
				while (current != null) { // 리스트의 끝에 도달할 때까지 검색한다.
					if (current.element().compareTo(anElement) > 0) { // current의 값이 anElement값 보다 크면
						break; // 반복문 종료
					}
					previous = current; // (그렇지 않은 경우) previous를 current로
					current = current.next(); // current를 next로 변경
				}
				if (previous == null) { // anElement가 가장 작으면 맨 앞에 삽입한다.
					nodeForAdd.setNext(this.head());
					this.setHead(nodeForAdd);
				} else {
					nodeForAdd.setNext(current);
					previous.setNext(nodeForAdd);
				}
			}
			this.setSize(this.size() + 1); // size를 1만큼 증가시킨다.
			return true;
		}
	}

	public E max() {
		if (this.isEmpty()) { // 리스트가 비어있으면
			return null;
		} else {
			LinkedNode<E> currentNode = this._head; // 현재 노드를 맨 앞 노드로 설정
			for (int i = 0; i < this.size() - 1; i++) {
				currentNode = currentNode.next(); // 맨 뒤 노드까지 이동한다.
			}
			return currentNode.element(); // 맨 뒤 노드 원소 return
		}
	}
}
