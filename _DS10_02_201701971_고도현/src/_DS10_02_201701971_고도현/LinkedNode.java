package _DS10_02_201701971_고도현;

public class LinkedNode<T> {
	private T _element;		// 인스턴스 변수
	private LinkedNode<T> _next;
	
	public LinkedNode() {	// 생성자
		this._element = null;
		this._next = null;
	}
	
	public LinkedNode(T givenElement, LinkedNode<T> givenNext) {	// 생성자
		this._element = givenElement;
		this._next = givenNext;
	}
	
	public T element() {	// getter
		return this._element;
	}
	
	public void setElement(T newElement) {	// setter
		this._element = newElement;
	}
	
	public LinkedNode<T> next(){	// getter
		return this._next;
	}
	
	public void setNext(LinkedNode<T> newNext) {	// setter
		this._next = newNext;
	}
}
