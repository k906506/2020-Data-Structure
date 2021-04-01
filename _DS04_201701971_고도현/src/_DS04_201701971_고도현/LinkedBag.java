package _DS04_201701971_고도현;

public class LinkedBag<E> {
	private int _size; // 가방이 가지고 있는 원소의 개수
	private LinkedNode<E> _head; // 연결 체인의 맨 앞 노드를 소유

	public int size() { // 가방의 원소의 개수를 얻는다 (getter)
		return this._size;
	}

	private void setSize(int newSize) { // 가방의 원소의 개수를 newSize로 설정한다 (setter)
		this._size = newSize;
	}

	private LinkedNode<E> head() { // 연결 체인의 맨 앞 노드를 얻는다 (getter)
		return this._head;
	}

	private void setHead(LinkedNode<E> newHead) { // 노드를 newHead로 설정한다 (setter)
		this._head = newHead;
	}

	public LinkedBag() { // 생성자
		this.setSize(0); // size를 0으로 초기화
		this.setHead(null); // head를 null로 초기화
	}

	public boolean isFull() { // 가방이 가득 찼는지 확인한다
		return false; // 메모리가 부족한 경우는 없다고 가정
	}

	public boolean isEmpty() { // 가방이 비어있는지 확인한다
		return (this.size() == 0); // size가 0이면 true값 리턴
	}

	public boolean doesContain(E anElement) { // 가방에 주어진 원소의 존재여부를 확인한다
		LinkedNode<E> currentNode = this.head(); // currentNode를 맨 앞 노드값으로 초기화
		while (currentNode != null) { // currentNode 값이 있을 때
			if (currentNode.element().equals(anElement)) { // 주어진 anElement와 원소가 같을 경우
				return true; // true값 리턴
			}
			currentNode = currentNode.next(); // currentNode에 nextNode값 대입
		}
		return false; // false값 리턴
	}

	public int frequencyOf(E anElement) { // 가방에 주어진 원소의 개수를 확인한다
		int frequencyCount = 0; // frequencyCount를 0으로 초기화
		LinkedNode<E> currentNode = this._head; // currentNode를 맨 앞 노드값으로 초기화
		while (currentNode != null) { // currentNode 값이 있을 때
			if (currentNode.element().equals(anElement)) { // 주어진 anElement와 원소가 같을 경우
				frequencyCount++; // frequencyCount 1씩 증가
			}
			currentNode = currentNode.next(); // currentNode에 nextNode값 대입
		}
		return frequencyCount; // frequencyCount값 리턴
	}

	public E elementAt(int anOrder) { // anOrder의 순서의 원소를 얻는다
		if ((anOrder < 0) || (anOrder >= this.size())) { // 주어진 anOrder값이 유효범위가 아닐때
			return null; // null값 리턴
		} else {
			LinkedNode<E> currentNode = this.head(); // currentNode를 맨 앞 노드로 초기화
			for (int i = 0; i < anOrder; i++) { // 주어진 anOrder까지 반복문을 돌려 찾고자 하는 원소의 노드 위치를 찾는다
				currentNode = currentNode.next();
			}
			return currentNode.element(); // 찾은 원소의 노드를 리턴
		}
	}

	public boolean add(E anElement) { // 원소 추가
		if (this.isFull()) { // 가득 차 있는 경우는 없다고 가정
			return false;
		} else {
			LinkedNode<E> newNode = new LinkedNode<E>(); // LinkedNode의 새로운 객체 newNode 생성
			newNode.setElement(anElement); // anElment를 원소로 설정
			newNode.setNext(this.head()); // 기존의 맨 앞 노드를 다음 노드로 설정
			this.setHead(newNode); // newNode를 맨 앞 노드로 설정
			this.setSize(this.size() + 1); // size값 +1
			return true; // true값 리턴
		}
	}

	public boolean remove(E anElement) { // 원소 삭제
		LinkedNode<E> previousNode = null; // previousNode값을 null로 초기화
		LinkedNode<E> currentNode = this._head; // currentNode값을 맨 앞 노드로 초기화
		boolean found = false;
		while (currentNode != null && !found) { // 가방이 비어있지 않으면
			if (currentNode.element().equals(anElement)) { // anElement를 원소로 가진 노드 값이 있을 경우
				found = true; // true값 리턴
			} else { // 없을 경우
				previousNode = currentNode; // previousNode를 currentNode로
				currentNode = currentNode.next(); // currentNode를 nextNode로 (노드 한 칸 이동)
			}
		}
		if (!found) { // 가방이 비어있을 경우
			return false;
		} else { // found가 true가 되어 while문에서 나왔다
			if (currentNode == this.head()) { // currentNode(삭제할 노드)가 맨 앞 노드 일때
				this.setHead(this.head().next()); // 다음 노드를 head로 설정
			} else { // currentNode 앞에 다른 노드가 존재할 때
				previousNode.setNext(currentNode.next()); // 다음 노드를 previousNode의 다음 노드로 설정 (currentNode가 없어진다)
			}
			this.setSize(this.size() - 1); // size값 -1
			return true; // true값 리턴
		}
	}

	public E removeAny() { // 가방의 아무 원소나 지운다
		if (this.isEmpty()) { // 가방이 비어있을 경우
			return null;
		}
		E removedElement = this.head().element(); // 맨 앞 노드를 삭제
		this.setHead(this.head().next()); // 다음 노드를 맨 앞 노드로
		this.setSize(this.size() - 1);	// size -1
		return removedElement;
	}

	public void clear() {
		this.setSize(0); // size를 0으로
		this.setHead(null); // head를 null로
	}
}
