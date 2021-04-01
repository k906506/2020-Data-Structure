package _DS09_201701971_고도현;

public class ArrayList<E> implements Stack<E> {
	private static final int DEFAULT_CAPACITY = 100; // 상수

	private int _capacity; // 비공개 인스턴스 변수
	private int _size;
	protected E[] _elements;

	public int capacity() { // getter
		return this._capacity;
	}

	private void setCapacity(int newCapacity) { // setter
		this._capacity = newCapacity;
	}

	@Override
	public int size() { // getter
		return this._size;
	}

	private void setSize(int newSize) { // setter
		this._size = newSize;
	}

	protected E[] elements() { // getter
		return this._elements;
	}

	private void setElements(E[] elements) { // setter
		this._elements = elements;
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) { // 생성자
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]); // Generic Type E의 선언이 Comparable
	}

	public ArrayList() { // 생성자
		this(ArrayList.DEFAULT_CAPACITY);
	}

	private void makeRoomAt(int aPosition) { // 공간 만들기
		for (int i = this.size(); i > aPosition; i--) { // aPosition 이후의 원소들을 한 칸씩 뒤로 이동시킨다.
			this.elements()[i] = this.elements()[i - 1];
		}
	}

	private void removeGapAt(int aPosition) { // 공간 제거하기
		for (int i = aPosition + 1; i < this.size(); i++) { // aPosition의 원소를 제거하기 위해
			this.elements()[i - 1] = this.elements()[i]; // 이후의 원소들을 한 칸씩 앞으로 이동시킨다.
			this.elements()[this.size() - 1] = null; // 배열의 맨 뒤를 null로 초기화
		}
	}

	public boolean isEmpty() { // 비어있는지 확인
		return this.size() == 0;
	}

	public boolean isFull() { // 가득 차있는지 확인
		return this.size() == this.capacity();
	}

	public boolean doesContain(E anElement) { // 원소 탐색
		return (this.orderOf(anElement) >= 0); // orderOf(anElement)의 값이 0보다 크거나 같으면 true
	}

	public int orderOf(E anElement) { // 원소 위치 검색
		int order = -1;
		for (int index = 0; index < this.size() && order < 0; index++) { // 찾으면 for문 탈출
			if (this.elements()[index].equals(anElement)) { // anElement와 같은 값을 갖긴 원소가 있으면
				order = index; // order에 index값 저장
			}
		}
		return order; // order값 리턴
	}

	public E elementAt(int anOrder) { // anOrder의 순서의 원소 제공
		if (anOrder < 0 || anOrder > this.size()) { // anOrder가 0보다 작거나 원소의 개수값보다 큰 경우
			return null;
		} else {
			return this.elements()[anOrder]; // anOrder 위치의 원소값 리턴
		}
	}

	protected void setElementAt(int anOrder, E anElement) { // anOrder의 순서에 원소를 저장
		if (anOrder < 0 || anOrder > this.size()) { // anOrder가 0보다 작거나 원소의 개수값보다 큰 경우
			return;
		} else {
			this.elements()[anOrder] = anElement; // anOrder 위치에 anElement값 저장
		}
	}

	public boolean addTo(int anOrder, E anElement) { // 배열의 맨 뒤에 추가
		if (this.isFull()) { // 가득 차 있으면
			return false; // false값 리턴
		} else {
			this.makeRoomAt(anOrder); // anOrder에 공간을 만들고
			this.elements()[anOrder] = anElement; // 공간에 원소를 저장
			this.setSize(this.size() + 1); // size를 +1
			return true; // true값 리턴
		}
	}

	public boolean addToFirst(E anElement) { // 배열의 맨 앞에 추가
		if (this.isFull()) { // 가득 차 있으면
			return false; // false값 리턴
		} else {
			this.makeRoomAt(0); // 배열의 맨 앞에 공간을 만들고
			this.elements()[0] = anElement; // 공간에 원소를 저장
			this.setSize(this.size() + 1); // size를 +1
			return true; // true값 리턴
		}
	}

	public boolean addToLast(E anElement) { // 배열의 맨 뒤에 추가
		if (this.isFull()) { // 배열이 가득 차 있으면
			return false; // false값 리턴
		} else {
			this.elements()[this.size()] = anElement; // 배열의 맨 뒤에 anElement값 저장
			this.setSize(this.size() + 1); // size를 +1
			return true; // true값 리턴
		}
	}

	public E removeFirst() { // 배열의 맨 앞 원소 제거
		if (this.isEmpty()) { // 배열이 비어있으면
			return null; // null값 리턴
		} else {
			E removedElement = this.elements()[0]; // 맨 앞 원소값을 removedElement에 저장
			this.removeGapAt(0); // 원소 삭제
			this.setSize(this.size() - 1); // 배열 크기 -1
			return removedElement; // 삭제된 원소값 리턴
		}
	}

	public E removeLast() { // 배열의 맨 뒤 원소 제거
		if (this.isEmpty()) { // 배열이 비어있으면
			return null; // null값 리턴
		} else {
			E removedElement = this.elements()[this.size() - 1]; // 맨 뒤 원소값을 removedElement에 저장
			this.setSize(this.size() - 1); // 배열 크기 -1
			return removedElement; // 삭제된 원소값 리턴
		}
	}

	public E removeAny() { // 맨 뒤 원소 제거
		return this.removeLast();
	}

	public boolean remove(E anElement) { // 원소 삭제
		int foundIndex = this.orderOf(anElement); // anElement의 위치를 찾고

		if (foundIndex < 0) { // 없으면
			return false; // false값 리턴
		} else { // 있으면
			this.removeGapAt(foundIndex); // anElement 이후의 원소들을 한 칸씩 앞으로 이동시킨다
			this.setSize(this.size() - 1); // size를 -1
			this._elements[this.size()] = null; // 마지막 공간 null
			return true; // true값 리턴
		}
	}

	public void clear() { // 배열 초기화
		for (int i = 0; i < this.size(); i++) {
			this.elements()[i] = null;
		}
		this._size = 0;
	}

	@Override
	public boolean push(E anElement) { // Top에 원소 추가
		return this.addToLast(anElement);
	}

	@Override
	public E pop() { // Top 원소 삭제
		return this.removeLast();
	}

	@Override
	public E peek() { // Top 원소
		if (this.isEmpty()) { // 비어있으면
			return null;
		} else {
			return this.elementAt(this.size() - 1);
		}
	}
}
