package _DS03_201701971_고도현;

public class ArrayBag<E> {
	private static final int DEFAULT_CAPACITY = 100; // 상수
	private int _capacity;	// 비공개 변수
	private int _size;
	private E _elements[];
	
	
	@SuppressWarnings("unchecked")
	public ArrayBag() {	// 가방 값이 주어지지 않은 경우
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY); // _capacity를 DEFAULT_CAPACITY로 초기화한다
		this.setElements((E[]) new Object [this.capacity()]);	// _elements를 capacity만큼 생성한다
		this.setSize(0);	// _size를 0으로 설정한다
	}
	@SuppressWarnings("unchecked")
	public ArrayBag(int givenCapacity) { // 가방 값이 주어진 경우
		this.setCapacity(givenCapacity); // _capacity를 givenCapacity로 초기화한다
		this.setElements((E[]) new Object[this.capacity()]);	// _elements를 capacity만큼 생성한다
		this.setSize(0);	// _size를 0으로 설정한다
	}
	
	public int capacity() {	// Getter - 가방의 크기를 알려준다.
		return this._capacity;
	}
	
	private void setCapacity (int newCapacity) {	// Setter - 가방의 크기를 newCapacity로 설정한다.
		this._capacity = newCapacity;
	}
	
	public int size() {	// Getter - 가방에 들어있는 원소의 개수를 알려준다.
		return this._size;
	}
	
	public void setSize(int newSize) {	// Setter - 가방의 원소의 개수를 newSize로 설정한다.
		this._size = newSize;
	}
	
	private E[] elements() {	// Getter
		return this._elements;
	}
	
	public void setElements(E[] newElements) {	// Setter
		this._elements = newElements;
	}
	
	public boolean isEmpty() {	// size가 0이면 true값 return한다
		return this._size == 0;
	}
	
	public boolean isFull() {	// size와 capacity가 같으면 true값 return한다
		return this._size == this._capacity;
	}
	
	public boolean doesContain(E anElement) {	// 원소를 찾는 메소드
		boolean foundIndex = false;	// 변수를 false로 초기화한다
		for (int i = 0; i<this.size(); i++) {	// 가방의 크기만큼 반복문을 돌린다
			if(this.elements()[i].equals(anElement)) {
				foundIndex = true;	// 원소를 찾으면 foundIndex에 true값 대입한다
			}
		}
		return foundIndex;	// foundIndex값 return한다
	}
	
	public int frequencyOf(E anElement) {	// 주어진 원소가 가방에 몇 개 있는지 알려주는 메소드
		int frequencyCount = 0;
		for (int i= 0; i<this._size; i++) {	// 가방의 크기만큼 반복물을 돌려서
			if(this.elements()[i].equals(anElement)) {	// 주어진 원소를 찾으면
				frequencyCount++;	// count한다
			}
		}
		return frequencyCount;	// frequencyCount값 return한다
	}
	
	public boolean add(E anElement) {	// 가방에 원소를 추가하는 메소드
		if(this.isFull()) {	// 이미 가득찬 경우
			return false;	// false값 return한다
		}
		else {	// 빈 공간이 있는 경우
			this.elements()[this.size()] = anElement; // 주어진 원소를 배열의 마지막에 저장
			this.setSize(this.size()+1);	// 원소를 넣어줬으므로 +1
			return true; // true값 return한다
		}
	}
	
	public boolean remove(E anElement) { // 가방에 원소를 제거하는 메소드
		if(this.isEmpty()) {	// 가방이 비어있으면 원소를 지울 수 없다
			return false;
		}
		else {	
			int foundIndex = 0;	// 원소 위치 저장 변수
			boolean found = false;	// found변수에 false값 대입한다
			for(int i=0; i<this.size(); i++) {	// 주어진 원소의 위치를 찾는다
				if(this.elements()[i].equals(anElement)) {	// 주어진 원소와 같은 값을 가진 원소를 찾는다
					foundIndex = i;	// 위치를 저장
					found = true;	// 원소를 찾았으므로 true값
					}
			}
			if(!found) {	// found가 false값이면
				return false; 	// false값 return
			}
			else {
				for(int i=foundIndex; i<this.size()-1; i++) {	// 삭제된 원소 이후의 모든 원소들을 앞으로 한 칸씩 이동한다
					this.elements()[i] = this.elements()[i+1];
				}
				this.elements()[this.size()] = null;	// 한 칸씩 당겨졌으므로 원래 마지막칸은 null값
				this.setSize(this.size()-1);	// 가방의 크기를 -1
				return true;	// true값 return
			}
			
		}
	}
	
	public void clear() {	// 가방을 비우는 메소드
		for(int i=0; i<this.size(); i++) {	// 가방의 크기만큼 반복문을 돌린다
			this.elements()[i]=null;	// 배열에 null값을 대입한다
		}
		this.setSize(0);	// 원소의 개수를 0개로 설정한다
	}
	
	public E elementAt(int order) {	// order에 있는 원소를 알려주는 메소드
		if(order<this.size()) {
			return this.elements()[order];
		}
		else {
			return null;
		}
	}
}

