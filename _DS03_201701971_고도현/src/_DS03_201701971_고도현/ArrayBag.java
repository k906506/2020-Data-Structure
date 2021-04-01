package _DS03_201701971_����;

public class ArrayBag<E> {
	private static final int DEFAULT_CAPACITY = 100; // ���
	private int _capacity;	// ����� ����
	private int _size;
	private E _elements[];
	
	
	@SuppressWarnings("unchecked")
	public ArrayBag() {	// ���� ���� �־����� ���� ���
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY); // _capacity�� DEFAULT_CAPACITY�� �ʱ�ȭ�Ѵ�
		this.setElements((E[]) new Object [this.capacity()]);	// _elements�� capacity��ŭ �����Ѵ�
		this.setSize(0);	// _size�� 0���� �����Ѵ�
	}
	@SuppressWarnings("unchecked")
	public ArrayBag(int givenCapacity) { // ���� ���� �־��� ���
		this.setCapacity(givenCapacity); // _capacity�� givenCapacity�� �ʱ�ȭ�Ѵ�
		this.setElements((E[]) new Object[this.capacity()]);	// _elements�� capacity��ŭ �����Ѵ�
		this.setSize(0);	// _size�� 0���� �����Ѵ�
	}
	
	public int capacity() {	// Getter - ������ ũ�⸦ �˷��ش�.
		return this._capacity;
	}
	
	private void setCapacity (int newCapacity) {	// Setter - ������ ũ�⸦ newCapacity�� �����Ѵ�.
		this._capacity = newCapacity;
	}
	
	public int size() {	// Getter - ���濡 ����ִ� ������ ������ �˷��ش�.
		return this._size;
	}
	
	public void setSize(int newSize) {	// Setter - ������ ������ ������ newSize�� �����Ѵ�.
		this._size = newSize;
	}
	
	private E[] elements() {	// Getter
		return this._elements;
	}
	
	public void setElements(E[] newElements) {	// Setter
		this._elements = newElements;
	}
	
	public boolean isEmpty() {	// size�� 0�̸� true�� return�Ѵ�
		return this._size == 0;
	}
	
	public boolean isFull() {	// size�� capacity�� ������ true�� return�Ѵ�
		return this._size == this._capacity;
	}
	
	public boolean doesContain(E anElement) {	// ���Ҹ� ã�� �޼ҵ�
		boolean foundIndex = false;	// ������ false�� �ʱ�ȭ�Ѵ�
		for (int i = 0; i<this.size(); i++) {	// ������ ũ�⸸ŭ �ݺ����� ������
			if(this.elements()[i].equals(anElement)) {
				foundIndex = true;	// ���Ҹ� ã���� foundIndex�� true�� �����Ѵ�
			}
		}
		return foundIndex;	// foundIndex�� return�Ѵ�
	}
	
	public int frequencyOf(E anElement) {	// �־��� ���Ұ� ���濡 �� �� �ִ��� �˷��ִ� �޼ҵ�
		int frequencyCount = 0;
		for (int i= 0; i<this._size; i++) {	// ������ ũ�⸸ŭ �ݺ����� ������
			if(this.elements()[i].equals(anElement)) {	// �־��� ���Ҹ� ã����
				frequencyCount++;	// count�Ѵ�
			}
		}
		return frequencyCount;	// frequencyCount�� return�Ѵ�
	}
	
	public boolean add(E anElement) {	// ���濡 ���Ҹ� �߰��ϴ� �޼ҵ�
		if(this.isFull()) {	// �̹� ������ ���
			return false;	// false�� return�Ѵ�
		}
		else {	// �� ������ �ִ� ���
			this.elements()[this.size()] = anElement; // �־��� ���Ҹ� �迭�� �������� ����
			this.setSize(this.size()+1);	// ���Ҹ� �־������Ƿ� +1
			return true; // true�� return�Ѵ�
		}
	}
	
	public boolean remove(E anElement) { // ���濡 ���Ҹ� �����ϴ� �޼ҵ�
		if(this.isEmpty()) {	// ������ ��������� ���Ҹ� ���� �� ����
			return false;
		}
		else {	
			int foundIndex = 0;	// ���� ��ġ ���� ����
			boolean found = false;	// found������ false�� �����Ѵ�
			for(int i=0; i<this.size(); i++) {	// �־��� ������ ��ġ�� ã�´�
				if(this.elements()[i].equals(anElement)) {	// �־��� ���ҿ� ���� ���� ���� ���Ҹ� ã�´�
					foundIndex = i;	// ��ġ�� ����
					found = true;	// ���Ҹ� ã�����Ƿ� true��
					}
			}
			if(!found) {	// found�� false���̸�
				return false; 	// false�� return
			}
			else {
				for(int i=foundIndex; i<this.size()-1; i++) {	// ������ ���� ������ ��� ���ҵ��� ������ �� ĭ�� �̵��Ѵ�
					this.elements()[i] = this.elements()[i+1];
				}
				this.elements()[this.size()] = null;	// �� ĭ�� ��������Ƿ� ���� ������ĭ�� null��
				this.setSize(this.size()-1);	// ������ ũ�⸦ -1
				return true;	// true�� return
			}
			
		}
	}
	
	public void clear() {	// ������ ���� �޼ҵ�
		for(int i=0; i<this.size(); i++) {	// ������ ũ�⸸ŭ �ݺ����� ������
			this.elements()[i]=null;	// �迭�� null���� �����Ѵ�
		}
		this.setSize(0);	// ������ ������ 0���� �����Ѵ�
	}
	
	public E elementAt(int order) {	// order�� �ִ� ���Ҹ� �˷��ִ� �޼ҵ�
		if(order<this.size()) {
			return this.elements()[order];
		}
		else {
			return null;
		}
	}
}

