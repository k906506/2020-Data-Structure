package _DS13_201701971_����;

public class DictionaryByBinarySearchTree<Key extends Comparable<Key>, Obj extends Comparable<Obj>>
		extends Dictionary<Key, Obj> {
	private BinaryNode<DictionaryElement<Key, Obj>> _root;

	protected BinaryNode<DictionaryElement<Key, Obj>> root() {	// getter
		return this._root;
	}

	protected void setRoot(BinaryNode<DictionaryElement<Key, Obj>> newRoot) {	// setter
		this._root = newRoot;
	}

	public DictionaryByBinarySearchTree() {	// ������
		this.clear();
	}

	private DictionaryElement<Key, Obj> elementForKey(Key aKey) {
		if (aKey != null) {	// aKey�� �����ϸ�
			BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
			while (current != null) {	// Ʈ���� ��ü�� ������
				if (current.element().key().compareTo(aKey) == 0) {	// current�� Key���� aKey���� ������ (find)
					return current.element();	// current�� element ����
				} else if (current.element().key().compareTo(aKey) > 0) {	// aKey���� �� ������ (�����̵�)
					current = current.left();	// �����̵�
				} else {	// aKey���� �� ũ�� (�����̵�)
					current = current.right();	// �����̵�
				}
			}
		}
		return null;
	}

	@Override
	public void clear() {
		this.setSize(0);
		this.setRoot(null);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean keyDoesExist(Key aKey) {	// aKey�� ���翩��
		return (this.elementForKey(aKey) != null);	// �����ϸ� true
	}

	@Override
	public Obj objectForKey(Key aKey) {	// aKey�� ���ҷ� ���� Object
		DictionaryElement<Key, Obj> element = this.elementForKey(aKey);
		if (element != null) {
			return element.object();
		} else {
			return null;
		}
	}

	@Override
	public boolean addKeyAndObject(Key aKey, Obj anObject) {	// Key�� ���ҷ� ���� anObject�� ����
		if (aKey == null) {	// Key���� ������
			return false;	// false
		}
		DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject);	// aKey�� ���ҷ� �ϴ� DictionaryElement ��ü ����
		BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,
				null, null);	// aKey�� ���ҷ� �ϴ� anObject�� ���� BinaryNode��ü ����
		if (this.root() == null) {	// ��Ʈ�� ��������� (���Ұ� 0���̸�)
			this.setRoot(nodeForAdd);	// nodeForAdd�� ��Ʈ�� ����
			this.setSize(1);	// Ʈ���� ���ԵǾ����Ƿ� +1
			return true;	// return true;
		}

		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while (aKey.compareTo(current.element().key()) != 0) {	// aKey�� current�� Key�� ���� ������ (���� ��尡 �ƴ� ���)
			if (aKey.compareTo(current.element().key()) < 0) {	// aKey�� �� ������ (�����̵�)
				if (current.left() == null) {	// ���� �ڽ� ��尡 ������
					current.setLeft(nodeForAdd);	// nodeForAdd�� ����
					this.setSize(this.size() + 1);	// Ʈ���� ���Ұ� ���Ե����Ƿ� size + 1
					return true;
				} else {	// ���� �ڽ� ��尡 �����ϸ�
					current = current.left();	// ���� �̵�
				}
			} else {	// aKey�� �� ũ�� (�����̵�)
				if (current.right() == null) {	// ������ �ڽ� ��尡 ������
					current.setRight(nodeForAdd);	// NoeForAdd�� ����
					this.setSize(this.size() + 1);	// Ʈ���� ���Ұ� ���Ե����Ƿ� size + 1	
					return true;
				} else {	// ������ �ڽ� ��尡 �����ϸ�
					current = current.right();	// ���� �̵�
				}
			}
		}
		return false;
	}

	@Override
	public Obj removeObjectForKey(Key aKey) {
		return null;
	}

	@Override
	public Iterator<DictionaryElement<Key, Obj>> iterator() {
		return new DictionaryIterator();
	}

	private class DictionaryIterator implements Iterator<DictionaryElement<Key, Obj>> {
		private BinaryNode<DictionaryElement<Key, Obj>> _nextNode;
		private Stack<BinaryNode<DictionaryElement<Key, Obj>>> _stack;

		private BinaryNode<DictionaryElement<Key, Obj>> nextNode() {
			return this._nextNode;
		}

		private void setNextNode(BinaryNode<DictionaryElement<Key, Obj>> newNextNode) {
			this._nextNode = newNextNode;
		}

		private Stack<BinaryNode<DictionaryElement<Key, Obj>>> stack() {
			return this._stack;
		}

		private void setStack(Stack<BinaryNode<DictionaryElement<Key, Obj>>> newStack) {
			this._stack = newStack;
		}

		private DictionaryIterator() {
			this.setStack(new LinkedStack<BinaryNode<DictionaryElement<Key, Obj>>>());
			this.setNextNode(DictionaryByBinarySearchTree.this.root());
		}

		@Override
		public boolean hasNext() {
			return (this.nextNode() != null) || (!this.stack().isEmpty());
		}

		@Override
		public DictionaryElement<Key, Obj> next() {
			if (!this.hasNext()) {
				return null;
			} else {
				while (this.nextNode() != null) {
					this.stack().push(this.nextNode());
					this.setNextNode(this.nextNode().left());
				}
				BinaryNode<DictionaryElement<Key, Obj>> poppedNode = this.stack().pop();
				DictionaryElement<Key, Obj> nextElement = poppedNode.element();
				this.setNextNode(poppedNode.right());
				return nextElement;
			}
		}
	}
}
