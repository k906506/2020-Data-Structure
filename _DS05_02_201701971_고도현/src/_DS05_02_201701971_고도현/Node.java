package _DS05_02_201701971_고도현;

public class Node<T> {
	private T _element;	// 인스턴스 변수
	private Node<T> _next;
	
	public Node() {	// 생성자
		this._element = null;
		this._next = null;
	}
	
	public Node(T givenElement, Node<T> givenNext) {	// 생성자
		this._element = givenElement;
		this._next = givenNext;
	}
	
	public T element() {	// getter
		return this._element;
	}
	
	public Node<T> next(){	// getter
		return this._next;
	}
	
	public void setElement(T newElement) { // setter
		this._element = newElement;
	}
	
	public void setNext (Node<T> newNext) { // setter
		this._next = newNext;
	}
}
