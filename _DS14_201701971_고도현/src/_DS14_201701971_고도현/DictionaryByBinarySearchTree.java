package _DS14_201701971_����;

public class DictionaryByBinarySearchTree<Key extends Comparable<Key>, Obj extends Comparable<Obj>>
		extends Dictionary<Key, Obj> {
	private BinaryNode<DictionaryElement<Key, Obj>> _root;

	protected BinaryNode<DictionaryElement<Key, Obj>> root() { // getter
		return this._root;
	}

	protected void setRoot(BinaryNode<DictionaryElement<Key, Obj>> newRoot) { // setter
		this._root = newRoot;
	}

	public DictionaryByBinarySearchTree() { // ������
		this.clear();
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
	public boolean addKeyAndObject(Key aKey, Obj anObject) { // Key�� ���ҷ� ���� anObject�� ����
		if (aKey == null) { // Key���� ������
			return false; // false
		}
		DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject); // aKey�� ���ҷ� �ϴ�
																										// DictionaryElement
																										// ��ü ����
		BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,
				null, null); // aKey�� ���ҷ� �ϴ� anObject�� ���� BinaryNode��ü ����
		if (this.root() == null) { // ��Ʈ�� ��������� (���Ұ� 0���̸�)
			this.setRoot(nodeForAdd); // nodeForAdd�� ��Ʈ�� ����
			this.setSize(1); // Ʈ���� ���ԵǾ����Ƿ� +1
			return true; // return true;
		}

		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while (aKey.compareTo(current.element().key()) != 0) { // aKey�� current�� Key�� ���� ������ (���� ��尡 �ƴ� ���)
			if (aKey.compareTo(current.element().key()) < 0) { // aKey�� �� ������ (�����̵�)
				if (current.left() == null) { // ���� �ڽ� ��尡 ������
					current.setLeft(nodeForAdd); // nodeForAdd�� ����
					this.setSize(this.size() + 1); // Ʈ���� ���Ұ� ���Ե����Ƿ� size + 1
					return true;
				} else { // ���� �ڽ� ��尡 �����ϸ�
					current = current.left(); // ���� �̵�
				}
			} else { // aKey�� �� ũ�� (�����̵�)
				if (current.right() == null) { // ������ �ڽ� ��尡 ������
					current.setRight(nodeForAdd); // NoeForAdd�� ����
					this.setSize(this.size() + 1); // Ʈ���� ���Ұ� ���Ե����Ƿ� size + 1
					return true;
				} else { // ������ �ڽ� ��尡 �����ϸ�
					current = current.right(); // ���� �̵�
				}
			}
		}
		return false;
	}

	@Override
	public Obj removeObjectForKey(Key aKey) {	// aKey�� ���ҷ� ���� Obj ����
		if (aKey == null) {	// aKey�� ������
			return null;	// null
		}
		if (this.root() == null) {	// Ʈ���� ��尡 ���
			return null;	// null
		}
		if (aKey.compareTo(this.root().element().key()) == 0) {		// aKey�� ��Ʈ ����� Key�� ���Ͽ� ���� ���� ��� (������ ��尡 ���� ���)
			Obj objectForRemove = this.root().element().object();	// �� ����� object�� ���� ������� �����ϰ�
			if ((this.root().left() == null) && (this.root().right() == null)) {	// ����, ���� �ڽĳ�尡 ���� ��� (��Ʈ�� �ִ� Ʈ��)
				this.setRoot(null);	// null�� ����
			} else if (this.root().left() == null) {	// ���� ��尡 ����ִ� ���
				this.setRoot(this.root().right());	// �� ����� ���� �ڽ� ��帣 ���� ����
			} else if (this.root().right() == null) {	// ���� ��尡 ����ִ� ���
				this.setRoot(this.root().left());	// �� ����� ���� �ڽ� ��带 ���� ����
			} else {	// ����, ���� �ڽ� ��� �� �� �ִ� ���
				this.root().setElement(this.removeRightMostElementOfLeftSubTree(this.root()));
			}
			this.setSize(this.size() - 1);	// ��带 �� �� ���������� ũ�⸦ �ٿ��ش�
			return objectForRemove;	// ������ ����� object ��ȯ
		}
		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();	// ���� ��带 �����ϰ� current�� �����ϰ�
		BinaryNode<DictionaryElement<Key, Obj>> child = null;	// �ڽ� ��带 �����ϰ� null�� ����
		do {	
			if (aKey.compareTo(current.element().key()) < 0) {	// aKey�� ��Ʈ ����� Key�� ���Ͽ� ��Ʈ ����� Key�� �� ū ��� (������ ��尡 ���� ����� ���ʿ� ����)
				child = current.left();	// child ��带 ���� ����� ���� ���� ����
				if (child == null) {	// child ��尡 ���������
					return null;	// null
				}
				if (aKey.compareTo(child.element().key()) == 0) {	// aKey�� child ����� Key�� ���Ͽ� ���� ���� ��� (������ ��尡 child ���)
					Obj objectForRemove = child.element().object();		// objectForRemove�� child ����� object�� ����
					if ((child.left() == null) && (child.right() == null)) {	// child ����� �ڽ� ��尡 ���������
						current.setLeft(null);	// child ��� ���� �Ŀ� �ڽ� ��忡�� ������ ���� �����Ƿ� null�� ����
					} else if (child.left() == null) {	// ���� �ڽ� ��尡 ���������
						current.setLeft(child.right());	// ���� �ڽ� ��带 ���� ����� ���� �ڽ� ���� ����
					} else if (child.right() == null) {	// ���� �ڽ� ��尡 ���������
						current.setLeft(child.left());	// ���� �ڽ� ��带 ���� ���� ���� �ڽ� ���� ����
					} else {	// ���� ���� �ڽ� ��尡 ��� �ִ� ���
						child.setElement(this.removeRightMostElementOfLeftSubTree(child)); // child�� �ڽ� ��� �� ���� ���� ���� ����
					}
					this.setSize(this.size() - 1);	// ��带 �� �� ���������� ũ�⸦ �ٿ��ش�.
					return objectForRemove;	// ������ ����� object�� ��ȯ
				}
			} else {	// aKey�� ���� �� ū ��� (������ ��尡 ���� ����� �����ʿ� ����)
				child = current.right();	// child ��带 ���� ����� ���� ���� ����
				if (child == null) {	// child ��尡 ��� ������
					return null;	// null
				}
				if (aKey.compareTo(child.element().key()) == 0) {	// aKey�� child ����� Key�� ���Ͽ� ���� ���� ��� (������ ��尡 child ���)
					Obj objectForRemove = child.element().object();	// objectForRemoe�� child ����� object�� ����
					if ((child.left() == null) && (child.right() == null)) {	// child ����� �ڽ� ��尡 ���������
						current.setRight(null);	// child ��� ���� �Ŀ� �ڽ� ��忡�� ������ ���� �����Ƿ� null�� ����
					} else if (child.left() == null) {	// ���� �ڽ� ��尡 ���������
						current.setRight(child.right());	// ���� �ڽ� ��带 ���� ���� ����
					} else if (child.right() == null) {	// ���� �ڽ� ��尡 ���������
						current.setRight(child.left());	// ���� �ڽ� ��带 ���� ���� ����
					} else {	// ���� ���� �ڽ� ��尡 ��� �ִ� ���
						child.setElement(this.removeRightMostElementOfLeftSubTree(child));
					}
					this.setSize(this.size() - 1);	// ��带 ���������� ũ�⸦ �ٿ��ش�
					return objectForRemove;	// ������ ����� object�� ��ȯ
				}
			}
			current = child;	// child ��带 current ����
		} while (true);
	}

	private DictionaryElement<Key, Obj> removeRightMostElementOfLeftSubTree(	// root�� ���� Ʈ�� �߿� ���� ���� ��Ʈ�� ��ȯ
			BinaryNode<DictionaryElement<Key, Obj>> root) {
		BinaryNode<DictionaryElement<Key, Obj>> leftOfRoot = root.left();	// root�� ���� ��带 leftOfRoot�� �����ϰ�
		if (leftOfRoot.right() == null) {	//leftOfRoot�� ���� �ڽ� ��尡 ���������
			root.setLeft(leftOfRoot.left());	// root�� ���� ��带 leftOfRoot�� ���� ���� �����Ѵ�
			return leftOfRoot.element();	// leftOfRoot ����� ���Ұ��� ��ȯ�Ѵ�
		} else { // leftOfRoot�� ���� ��尡 ������
			BinaryNode<DictionaryElement<Key, Obj>> parentOfRightMost = leftOfRoot; 
			BinaryNode<DictionaryElement<Key, Obj>> rightMost = parentOfRightMost.right();
			while (rightMost.right() != null) {	// rightMost�� root�� ���� Ʈ�� �߿� ���� ���� ���
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			parentOfRightMost.setRight(rightMost.left());
			return rightMost.element();	// rightMost�� ���Ҹ� ��ȯ
		}
	}

	@Override
	public void scanInsortedOrder() {
		this.inorderRecursively(this.root(), 1);
	}

	private void inorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel) {
		if (aRootOfSubtree != null) {	// aRootOfSubtree�� ���Ұ� ������
			this.inorderRecursively(aRootOfSubtree.left(), aLevel + 1);	// �������� �̵� (���� �ڽ�Ʈ����)
			DictionaryElement<Key, Obj> visitedElement = aRootOfSubtree.element();	// aRootOfSubtree�� key�� object�� ����
			this.visitDelegate().visitForSortedOrder(visitedElement.key(), visitedElement.object(), aLevel);
			this.inorderRecursively(aRootOfSubtree.right(), aLevel + 1);	// �������� �̵� (���� �ڽ�Ʈ��)
		}

	}

	@Override
	public void scanInReverseOfSortedOrder() {	// 
		this.reverseOfInorderRecursively(this.root(), 1);
	}

	private void reverseOfInorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel) {
		if (aRootOfSubtree != null) {	// aRootOfSubtree�� ���Ұ� ������
			this.reverseOfInorderRecursively(aRootOfSubtree.right(), aLevel + 1);	// �������� �̵� (���� �ڽ�Ʈ����)
			this.visitDelegate().visitForReverseOfSortedOrder(aRootOfSubtree.element().key(), aRootOfSubtree.element().object(),
					aLevel);	// aRootOfSubtree�� key�� object�� ����
			this.reverseOfInorderRecursively(aRootOfSubtree.left(), aLevel + 1);	// �������� �̵� (���� �ڽ�Ʈ��)
		}
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