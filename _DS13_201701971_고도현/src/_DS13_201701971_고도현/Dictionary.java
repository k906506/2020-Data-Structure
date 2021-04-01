package _DS13_201701971_����;

public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {	// �߻� Ŭ������ ���� ������ ��ӹ޴� Ŭ��������
	private int _size;
	public int size() {
		return this._size;
	}
	protected void setSize(int newSize) {
		this._size = newSize;
	}
	public Dictionary() {
		this.setSize(0);
	}
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	public abstract boolean isFull();
	public abstract boolean keyDoesExist(Key aKey);
	public abstract Obj objectForKey(Key akey);
	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);
	public abstract Obj removeObjectForKey(Key aKey);
	public abstract void clear();
	public abstract Iterator<DictionaryElement<Key,Obj>> iterator();
}
