package _DS14_201701971_고도현;

public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>> { // 추상 클래스로 실제 구현은 상속받는 클래스에서
	private int _size;
	private VisitDelegate<Key, Obj> _visitDelegate;

	public int size() {
		return this._size;
	}

	protected void setSize(int newSize) {
		this._size = newSize;
	}

	public VisitDelegate<Key, Obj> visitDelegate() {
		return this._visitDelegate;
	}

	public void setVisitDelegate(VisitDelegate<Key, Obj> newVisitDelegate) {
		this._visitDelegate = newVisitDelegate;
	}

	public Dictionary() {
		this.setSize(0);
	}

	public boolean isEmpty() {
		return (this.size() == 0);
	}
	public abstract boolean isFull();
	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);
	public abstract Obj removeObjectForKey(Key aKey);
	public abstract void scanInsortedOrder();
	public abstract void scanInReverseOfSortedOrder();
	public abstract void clear();
	public abstract Iterator<DictionaryElement<Key, Obj>> iterator();
}
