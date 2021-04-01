package _DS05_02_201701971_����;

public class Node<T> {
	private T _element;	// �ν��Ͻ� ����
	private Node<T> _next;
	
	public Node() {	// ������
		this._element = null;
		this._next = null;
	}
	
	public Node(T givenElement, Node<T> givenNext) {	// ������
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
