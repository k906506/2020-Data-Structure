package _DS04_201701971_고도현;

public class LinkedNode<E> {
	private E _element;	// 현재 노드에 있는 코인
	private LinkedNode<E> _next; // 다음 노드
	
	public LinkedNode() {	// 생성자
		this.setElement(null);	//_element를 null로 초기화
		this.setNext(null);		//_next를 null로 초기화
	}
	
	public LinkedNode(E givenElement) {	// givenElement를 원소로 갖는 LinkedNode 객체를 생성
		this.setElement(givenElement);  // _element를 givenElment로 초기화
		this.setNext(null);				// _next를 null로 초기화
	}
	
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {	// givenElement를 원소로 givenNext를 다음 노드로 갖는 객체 생성
		this.setElement(givenElement);	// _element를 givenElment로 초기화
		this.setNext(givenNext);		// _next를 givenNext로 초기화
	}
	
	public E element() {	// element를 얻는다(getter)
		return this._element;	
	}
	
	public LinkedNode<E> next(){	// LinkedNode 객체의 다음 LinkedNode 객체를 얻는다 (getter)
		return this._next;	
	}

	public void setElement(E newElement) {	// LinkedNode에 있는 element를 newElement로 변경한다 (setter)
		this._element = newElement;
	}
	
	public void setNext(LinkedNode<E> newNext) { // LinkedNode 객체의 Next를 newNext로 변경한다 (setter)
		this._next = newNext;
	}
}
