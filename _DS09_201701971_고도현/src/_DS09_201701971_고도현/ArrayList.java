package _DS09_201701971_����;

public class ArrayList<E> implements Stack<E> {
	private static final int DEFAULT_CAPACITY = 100; // ���

	private int _capacity; // ����� �ν��Ͻ� ����
	private int _size;
	protected E[] _elements;

	public int capacity() { // getter
		return this._capacity;
	}

	private void setCapacity(int newCapacity) { // setter
		this._capacity = newCapacity;
	}

	@Override
	public int size() { // getter
		return this._size;
	}

	private void setSize(int newSize) { // setter
		this._size = newSize;
	}

	protected E[] elements() { // getter
		return this._elements;
	}

	private void setElements(E[] elements) { // setter
		this._elements = elements;
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) { // ������
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]); // Generic Type E�� ������ Comparable
	}

	public ArrayList() { // ������
		this(ArrayList.DEFAULT_CAPACITY);
	}

	private void makeRoomAt(int aPosition) { // ���� �����
		for (int i = this.size(); i > aPosition; i--) { // aPosition ������ ���ҵ��� �� ĭ�� �ڷ� �̵���Ų��.
			this.elements()[i] = this.elements()[i - 1];
		}
	}

	private void removeGapAt(int aPosition) { // ���� �����ϱ�
		for (int i = aPosition + 1; i < this.size(); i++) { // aPosition�� ���Ҹ� �����ϱ� ����
			this.elements()[i - 1] = this.elements()[i]; // ������ ���ҵ��� �� ĭ�� ������ �̵���Ų��.
			this.elements()[this.size() - 1] = null; // �迭�� �� �ڸ� null�� �ʱ�ȭ
		}
	}

	public boolean isEmpty() { // ����ִ��� Ȯ��
		return this.size() == 0;
	}

	public boolean isFull() { // ���� ���ִ��� Ȯ��
		return this.size() == this.capacity();
	}

	public boolean doesContain(E anElement) { // ���� Ž��
		return (this.orderOf(anElement) >= 0); // orderOf(anElement)�� ���� 0���� ũ�ų� ������ true
	}

	public int orderOf(E anElement) { // ���� ��ġ �˻�
		int order = -1;
		for (int index = 0; index < this.size() && order < 0; index++) { // ã���� for�� Ż��
			if (this.elements()[index].equals(anElement)) { // anElement�� ���� ���� ���� ���Ұ� ������
				order = index; // order�� index�� ����
			}
		}
		return order; // order�� ����
	}

	public E elementAt(int anOrder) { // anOrder�� ������ ���� ����
		if (anOrder < 0 || anOrder > this.size()) { // anOrder�� 0���� �۰ų� ������ ���������� ū ���
			return null;
		} else {
			return this.elements()[anOrder]; // anOrder ��ġ�� ���Ұ� ����
		}
	}

	protected void setElementAt(int anOrder, E anElement) { // anOrder�� ������ ���Ҹ� ����
		if (anOrder < 0 || anOrder > this.size()) { // anOrder�� 0���� �۰ų� ������ ���������� ū ���
			return;
		} else {
			this.elements()[anOrder] = anElement; // anOrder ��ġ�� anElement�� ����
		}
	}

	public boolean addTo(int anOrder, E anElement) { // �迭�� �� �ڿ� �߰�
		if (this.isFull()) { // ���� �� ������
			return false; // false�� ����
		} else {
			this.makeRoomAt(anOrder); // anOrder�� ������ �����
			this.elements()[anOrder] = anElement; // ������ ���Ҹ� ����
			this.setSize(this.size() + 1); // size�� +1
			return true; // true�� ����
		}
	}

	public boolean addToFirst(E anElement) { // �迭�� �� �տ� �߰�
		if (this.isFull()) { // ���� �� ������
			return false; // false�� ����
		} else {
			this.makeRoomAt(0); // �迭�� �� �տ� ������ �����
			this.elements()[0] = anElement; // ������ ���Ҹ� ����
			this.setSize(this.size() + 1); // size�� +1
			return true; // true�� ����
		}
	}

	public boolean addToLast(E anElement) { // �迭�� �� �ڿ� �߰�
		if (this.isFull()) { // �迭�� ���� �� ������
			return false; // false�� ����
		} else {
			this.elements()[this.size()] = anElement; // �迭�� �� �ڿ� anElement�� ����
			this.setSize(this.size() + 1); // size�� +1
			return true; // true�� ����
		}
	}

	public E removeFirst() { // �迭�� �� �� ���� ����
		if (this.isEmpty()) { // �迭�� ���������
			return null; // null�� ����
		} else {
			E removedElement = this.elements()[0]; // �� �� ���Ұ��� removedElement�� ����
			this.removeGapAt(0); // ���� ����
			this.setSize(this.size() - 1); // �迭 ũ�� -1
			return removedElement; // ������ ���Ұ� ����
		}
	}

	public E removeLast() { // �迭�� �� �� ���� ����
		if (this.isEmpty()) { // �迭�� ���������
			return null; // null�� ����
		} else {
			E removedElement = this.elements()[this.size() - 1]; // �� �� ���Ұ��� removedElement�� ����
			this.setSize(this.size() - 1); // �迭 ũ�� -1
			return removedElement; // ������ ���Ұ� ����
		}
	}

	public E removeAny() { // �� �� ���� ����
		return this.removeLast();
	}

	public boolean remove(E anElement) { // ���� ����
		int foundIndex = this.orderOf(anElement); // anElement�� ��ġ�� ã��

		if (foundIndex < 0) { // ������
			return false; // false�� ����
		} else { // ������
			this.removeGapAt(foundIndex); // anElement ������ ���ҵ��� �� ĭ�� ������ �̵���Ų��
			this.setSize(this.size() - 1); // size�� -1
			this._elements[this.size()] = null; // ������ ���� null
			return true; // true�� ����
		}
	}

	public void clear() { // �迭 �ʱ�ȭ
		for (int i = 0; i < this.size(); i++) {
			this.elements()[i] = null;
		}
		this._size = 0;
	}

	@Override
	public boolean push(E anElement) { // Top�� ���� �߰�
		return this.addToLast(anElement);
	}

	@Override
	public E pop() { // Top ���� ����
		return this.removeLast();
	}

	@Override
	public E peek() { // Top ����
		if (this.isEmpty()) { // ���������
			return null;
		} else {
			return this.elementAt(this.size() - 1);
		}
	}
}
