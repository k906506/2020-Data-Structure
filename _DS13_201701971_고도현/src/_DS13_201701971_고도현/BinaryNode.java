package _DS13_201701971_°íµµÇö;

public class BinaryNode<E> {
	private E _element;
	private BinaryNode<E> _left;
	private BinaryNode<E> _right;

	public E element() {
		return this._element;
	}

	public void setElement(E newElement) {
		this._element = newElement;
	}

	public BinaryNode<E> left() {
		return this._left;
	}

	public void setLeft(BinaryNode<E> newLeft) {
		this._left = newLeft;
	}

	public BinaryNode<E> right() {
		return this._right;
	}

	public void setRight(BinaryNode<E> newRight) {
		this._right = newRight;
	}

	public BinaryNode() {
		this.setElement(null);
		this.setLeft(null);
		this.setRight(null);
	}

	public BinaryNode(E givenElement, BinaryNode<E> givenLeft, BinaryNode<E> givenRight) {
		this.setElement(givenElement);
		this.setLeft(givenLeft);
		this.setRight(givenRight);
	}
}
