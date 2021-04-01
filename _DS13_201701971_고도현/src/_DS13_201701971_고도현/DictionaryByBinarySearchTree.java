package _DS13_201701971_고도현;

public class DictionaryByBinarySearchTree<Key extends Comparable<Key>, Obj extends Comparable<Obj>>
		extends Dictionary<Key, Obj> {
	private BinaryNode<DictionaryElement<Key, Obj>> _root;

	protected BinaryNode<DictionaryElement<Key, Obj>> root() {	// getter
		return this._root;
	}

	protected void setRoot(BinaryNode<DictionaryElement<Key, Obj>> newRoot) {	// setter
		this._root = newRoot;
	}

	public DictionaryByBinarySearchTree() {	// 생성자
		this.clear();
	}

	private DictionaryElement<Key, Obj> elementForKey(Key aKey) {
		if (aKey != null) {	// aKey가 존재하면
			BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
			while (current != null) {	// 트리에 객체가 있으면
				if (current.element().key().compareTo(aKey) == 0) {	// current의 Key값과 aKey값이 같으면 (find)
					return current.element();	// current의 element 리턴
				} else if (current.element().key().compareTo(aKey) > 0) {	// aKey값이 더 작으면 (좌측이동)
					current = current.left();	// 좌측이동
				} else {	// aKey값이 더 크면 (우측이동)
					current = current.right();	// 우측이동
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
	public boolean keyDoesExist(Key aKey) {	// aKey의 존재여부
		return (this.elementForKey(aKey) != null);	// 존재하면 true
	}

	@Override
	public Obj objectForKey(Key aKey) {	// aKey를 원소로 갖는 Object
		DictionaryElement<Key, Obj> element = this.elementForKey(aKey);
		if (element != null) {
			return element.object();
		} else {
			return null;
		}
	}

	@Override
	public boolean addKeyAndObject(Key aKey, Obj anObject) {	// Key를 원소로 갖는 anObject를 삽입
		if (aKey == null) {	// Key값이 없으면
			return false;	// false
		}
		DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject);	// aKey를 원소로 하는 DictionaryElement 객체 생성
		BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,
				null, null);	// aKey를 원소로 하는 anObject를 갖는 BinaryNode객체 생성
		if (this.root() == null) {	// 루트가 비어있으면 (원소가 0개이면)
			this.setRoot(nodeForAdd);	// nodeForAdd를 루트로 설정
			this.setSize(1);	// 트리에 삽입되었으므로 +1
			return true;	// return true;
		}

		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while (aKey.compareTo(current.element().key()) != 0) {	// aKey와 current의 Key가 같지 않으면 (같은 노드가 아닐 경우)
			if (aKey.compareTo(current.element().key()) < 0) {	// aKey가 더 작으면 (좌측이동)
				if (current.left() == null) {	// 왼쪽 자식 노드가 없으면
					current.setLeft(nodeForAdd);	// nodeForAdd로 설정
					this.setSize(this.size() + 1);	// 트리에 원소가 삽입됐으므로 size + 1
					return true;
				} else {	// 왼쪽 자식 노드가 존재하면
					current = current.left();	// 좌측 이동
				}
			} else {	// aKey가 더 크면 (우측이동)
				if (current.right() == null) {	// 오른쪽 자식 노드가 없으면
					current.setRight(nodeForAdd);	// NoeForAdd로 설정
					this.setSize(this.size() + 1);	// 트리에 원소가 삽입됐으므로 size + 1	
					return true;
				} else {	// 오른쪽 자식 노드가 존재하면
					current = current.right();	// 우측 이동
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
