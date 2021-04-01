package _DS14_201701971_고도현;

public class DictionaryByBinarySearchTree<Key extends Comparable<Key>, Obj extends Comparable<Obj>>
		extends Dictionary<Key, Obj> {
	private BinaryNode<DictionaryElement<Key, Obj>> _root;

	protected BinaryNode<DictionaryElement<Key, Obj>> root() { // getter
		return this._root;
	}

	protected void setRoot(BinaryNode<DictionaryElement<Key, Obj>> newRoot) { // setter
		this._root = newRoot;
	}

	public DictionaryByBinarySearchTree() { // 생성자
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
	public boolean addKeyAndObject(Key aKey, Obj anObject) { // Key를 원소로 갖는 anObject를 삽입
		if (aKey == null) { // Key값이 없으면
			return false; // false
		}
		DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject); // aKey를 원소로 하는
																										// DictionaryElement
																										// 객체 생성
		BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,
				null, null); // aKey를 원소로 하는 anObject를 갖는 BinaryNode객체 생성
		if (this.root() == null) { // 루트가 비어있으면 (원소가 0개이면)
			this.setRoot(nodeForAdd); // nodeForAdd를 루트로 설정
			this.setSize(1); // 트리에 삽입되었으므로 +1
			return true; // return true;
		}

		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while (aKey.compareTo(current.element().key()) != 0) { // aKey와 current의 Key가 같지 않으면 (같은 노드가 아닐 경우)
			if (aKey.compareTo(current.element().key()) < 0) { // aKey가 더 작으면 (좌측이동)
				if (current.left() == null) { // 왼쪽 자식 노드가 없으면
					current.setLeft(nodeForAdd); // nodeForAdd로 설정
					this.setSize(this.size() + 1); // 트리에 원소가 삽입됐으므로 size + 1
					return true;
				} else { // 왼쪽 자식 노드가 존재하면
					current = current.left(); // 좌측 이동
				}
			} else { // aKey가 더 크면 (우측이동)
				if (current.right() == null) { // 오른쪽 자식 노드가 없으면
					current.setRight(nodeForAdd); // NoeForAdd로 설정
					this.setSize(this.size() + 1); // 트리에 원소가 삽입됐으므로 size + 1
					return true;
				} else { // 오른쪽 자식 노드가 존재하면
					current = current.right(); // 우측 이동
				}
			}
		}
		return false;
	}

	@Override
	public Obj removeObjectForKey(Key aKey) {	// aKey를 원소로 갖는 Obj 삭제
		if (aKey == null) {	// aKey가 없으면
			return null;	// null
		}
		if (this.root() == null) {	// 트리에 노드가 없어도
			return null;	// null
		}
		if (aKey.compareTo(this.root().element().key()) == 0) {		// aKey와 루트 노드의 Key를 비교하여 값이 같은 경우 (삭제할 노드가 현재 노드)
			Obj objectForRemove = this.root().element().object();	// 이 노드의 object를 삭제 대상으로 설정하고
			if ((this.root().left() == null) && (this.root().right() == null)) {	// 좌측, 우측 자식노드가 없는 경우 (루트만 있는 트리)
				this.setRoot(null);	// null로 설정
			} else if (this.root().left() == null) {	// 좌측 노드가 비어있는 경우
				this.setRoot(this.root().right());	// 이 노드의 우측 자식 노드르 노드로 설정
			} else if (this.root().right() == null) {	// 우측 노드가 비어있는 경우
				this.setRoot(this.root().left());	// 이 노드의 좌측 자식 노드를 노드로 설정
			} else {	// 좌측, 우측 자식 노드 둘 다 있는 경우
				this.root().setElement(this.removeRightMostElementOfLeftSubTree(this.root()));
			}
			this.setSize(this.size() - 1);	// 노드를 한 개 삭제했으니 크기를 줄여준다
			return objectForRemove;	// 삭제한 노드의 object 반환
		}
		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();	// 현재 노드를 생성하고 current로 설정하고
		BinaryNode<DictionaryElement<Key, Obj>> child = null;	// 자식 노드를 생성하고 null로 설정
		do {	
			if (aKey.compareTo(current.element().key()) < 0) {	// aKey와 루트 노드의 Key를 비교하여 루트 노드의 Key가 더 큰 경우 (삭제할 노드가 현재 노드의 왼쪽에 있음)
				child = current.left();	// child 노드를 현재 노드의 좌측 노드롤 설정
				if (child == null) {	// child 노드가 비어있으면
					return null;	// null
				}
				if (aKey.compareTo(child.element().key()) == 0) {	// aKey와 child 노드의 Key를 비교하여 값이 같은 경우 (삭제할 노드가 child 노드)
					Obj objectForRemove = child.element().object();		// objectForRemove에 child 노드의 object값 저장
					if ((child.left() == null) && (child.right() == null)) {	// child 노드의 자식 노드가 비어있으면
						current.setLeft(null);	// child 노드 삭제 후에 자식 노드에서 가져올 값이 없으므로 null로 설정
					} else if (child.left() == null) {	// 좌측 자식 노드가 비어있으면
						current.setLeft(child.right());	// 우측 자식 노드를 현재 노드의 좌측 자식 노드로 설정
					} else if (child.right() == null) {	// 우측 자식 노드가 비어있으면
						current.setLeft(child.left());	// 좌측 자식 노드를 현재 노드로 좌측 자식 노드로 설정
					} else {	// 좌측 우측 자식 노드가 모두 있는 경우
						child.setElement(this.removeRightMostElementOfLeftSubTree(child)); // child의 자식 노드 중 가장 우측 노드로 설정
					}
					this.setSize(this.size() - 1);	// 노드를 한 개 삭제했으니 크기를 줄여준다.
					return objectForRemove;	// 삭제한 노드의 object값 반환
				}
			} else {	// aKey의 값이 더 큰 경우 (삭제할 노드가 현재 노드의 오른쪽에 있음)
				child = current.right();	// child 노드를 현재 노드의 우측 노드로 설정
				if (child == null) {	// child 노드가 비어 있으면
					return null;	// null
				}
				if (aKey.compareTo(child.element().key()) == 0) {	// aKey와 child 노드의 Key를 비교하여 값이 같은 경우 (삭제할 노드가 child 노드)
					Obj objectForRemove = child.element().object();	// objectForRemoe에 child 노드의 object값 저장
					if ((child.left() == null) && (child.right() == null)) {	// child 노드의 자식 노드가 비어있으면
						current.setRight(null);	// child 노드 삭제 후에 자식 노드에서 가져올 값이 없으므로 null로 설정
					} else if (child.left() == null) {	// 좌측 자식 노드가 비어있으면
						current.setRight(child.right());	// 우측 자식 노드를 현재 노드로 설정
					} else if (child.right() == null) {	// 우측 자식 노드가 비어있으면
						current.setRight(child.left());	// 좌측 자식 노드를 현재 노드로 설정
					} else {	// 좌측 우측 자식 노드가 모두 있는 경우
						child.setElement(this.removeRightMostElementOfLeftSubTree(child));
					}
					this.setSize(this.size() - 1);	// 노드를 삭제했으니 크기를 줄여준다
					return objectForRemove;	// 삭제한 노드의 object값 반환
				}
			}
			current = child;	// child 노드를 current 노드로
		} while (true);
	}

	private DictionaryElement<Key, Obj> removeRightMostElementOfLeftSubTree(	// root의 왼쪽 트리 중에 가장 우측 노트를 반환
			BinaryNode<DictionaryElement<Key, Obj>> root) {
		BinaryNode<DictionaryElement<Key, Obj>> leftOfRoot = root.left();	// root의 좌측 노드를 leftOfRoot로 설정하고
		if (leftOfRoot.right() == null) {	//leftOfRoot의 우측 자식 노드가 비어있으면
			root.setLeft(leftOfRoot.left());	// root의 좌측 노드를 leftOfRoot의 좌측 노드로 설정한다
			return leftOfRoot.element();	// leftOfRoot 노드의 원소값을 반환한다
		} else { // leftOfRoot의 우측 노드가 있으면
			BinaryNode<DictionaryElement<Key, Obj>> parentOfRightMost = leftOfRoot; 
			BinaryNode<DictionaryElement<Key, Obj>> rightMost = parentOfRightMost.right();
			while (rightMost.right() != null) {	// rightMost가 root의 왼쪽 트리 중에 가장 우측 노드
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			parentOfRightMost.setRight(rightMost.left());
			return rightMost.element();	// rightMost의 원소를 반환
		}
	}

	@Override
	public void scanInsortedOrder() {
		this.inorderRecursively(this.root(), 1);
	}

	private void inorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel) {
		if (aRootOfSubtree != null) {	// aRootOfSubtree에 원소가 있으면
			this.inorderRecursively(aRootOfSubtree.left(), aLevel + 1);	// 좌측으로 이동 (좌측 자식트리로)
			DictionaryElement<Key, Obj> visitedElement = aRootOfSubtree.element();	// aRootOfSubtree의 key와 object를 저장
			this.visitDelegate().visitForSortedOrder(visitedElement.key(), visitedElement.object(), aLevel);
			this.inorderRecursively(aRootOfSubtree.right(), aLevel + 1);	// 우측으로 이동 (우측 자식트리)
		}

	}

	@Override
	public void scanInReverseOfSortedOrder() {	// 
		this.reverseOfInorderRecursively(this.root(), 1);
	}

	private void reverseOfInorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel) {
		if (aRootOfSubtree != null) {	// aRootOfSubtree에 원소가 있으면
			this.reverseOfInorderRecursively(aRootOfSubtree.right(), aLevel + 1);	// 좌측으로 이동 (좌측 자식트리로)
			this.visitDelegate().visitForReverseOfSortedOrder(aRootOfSubtree.element().key(), aRootOfSubtree.element().object(),
					aLevel);	// aRootOfSubtree의 key와 object를 저장
			this.reverseOfInorderRecursively(aRootOfSubtree.left(), aLevel + 1);	// 우측으로 이동 (우측 자식트리)
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