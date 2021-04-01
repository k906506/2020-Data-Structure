package _DS14_201701971_고도현;

public class BinaryNode<E> {
	// 인스턴스 변수
	private E _element;
	private BinaryNode<E> _left;
	private BinaryNode<E> _right;

	public E element() {	// getter
		return this._element;
	}

	public void setElement(E newElement) {	// setter
		this._element = newElement;
	}

	public BinaryNode<E> left() {	// getter
		return this._left;
	}

	public void setLeft(BinaryNode<E> newLeft) {	// setter
		this._left = newLeft;
	}

	public BinaryNode<E> right() {	// getter
		return this._right;
	}

	public void setRight(BinaryNode<E> newRight) {	// setter
		this._right = newRight;
	}

	public BinaryNode() {	// 생성자
		this.setElement(null);
		this.setLeft(null);
		this.setRight(null);
	}

	public BinaryNode(E givenElement, BinaryNode<E> givenLeft, BinaryNode<E> givenRight) {	// 생성자
		this.setElement(givenElement);
		this.setLeft(givenLeft);
		this.setRight(givenRight);
	}
}

