package _DS04_201701971_����;

public class LinkedNode<E> {
	private E _element;	// ���� ��忡 �ִ� ����
	private LinkedNode<E> _next; // ���� ���
	
	public LinkedNode() {	// ������
		this.setElement(null);	//_element�� null�� �ʱ�ȭ
		this.setNext(null);		//_next�� null�� �ʱ�ȭ
	}
	
	public LinkedNode(E givenElement) {	// givenElement�� ���ҷ� ���� LinkedNode ��ü�� ����
		this.setElement(givenElement);  // _element�� givenElment�� �ʱ�ȭ
		this.setNext(null);				// _next�� null�� �ʱ�ȭ
	}
	
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {	// givenElement�� ���ҷ� givenNext�� ���� ���� ���� ��ü ����
		this.setElement(givenElement);	// _element�� givenElment�� �ʱ�ȭ
		this.setNext(givenNext);		// _next�� givenNext�� �ʱ�ȭ
	}
	
	public E element() {	// element�� ��´�(getter)
		return this._element;	
	}
	
	public LinkedNode<E> next(){	// LinkedNode ��ü�� ���� LinkedNode ��ü�� ��´� (getter)
		return this._next;	
	}

	public void setElement(E newElement) {	// LinkedNode�� �ִ� element�� newElement�� �����Ѵ� (setter)
		this._element = newElement;
	}
	
	public void setNext(LinkedNode<E> newNext) { // LinkedNode ��ü�� Next�� newNext�� �����Ѵ� (setter)
		this._next = newNext;
	}
}
