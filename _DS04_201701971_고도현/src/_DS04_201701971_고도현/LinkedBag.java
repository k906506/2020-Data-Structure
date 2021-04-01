package _DS04_201701971_����;

public class LinkedBag<E> {
	private int _size; // ������ ������ �ִ� ������ ����
	private LinkedNode<E> _head; // ���� ü���� �� �� ��带 ����

	public int size() { // ������ ������ ������ ��´� (getter)
		return this._size;
	}

	private void setSize(int newSize) { // ������ ������ ������ newSize�� �����Ѵ� (setter)
		this._size = newSize;
	}

	private LinkedNode<E> head() { // ���� ü���� �� �� ��带 ��´� (getter)
		return this._head;
	}

	private void setHead(LinkedNode<E> newHead) { // ��带 newHead�� �����Ѵ� (setter)
		this._head = newHead;
	}

	public LinkedBag() { // ������
		this.setSize(0); // size�� 0���� �ʱ�ȭ
		this.setHead(null); // head�� null�� �ʱ�ȭ
	}

	public boolean isFull() { // ������ ���� á���� Ȯ���Ѵ�
		return false; // �޸𸮰� ������ ���� ���ٰ� ����
	}

	public boolean isEmpty() { // ������ ����ִ��� Ȯ���Ѵ�
		return (this.size() == 0); // size�� 0�̸� true�� ����
	}

	public boolean doesContain(E anElement) { // ���濡 �־��� ������ ���翩�θ� Ȯ���Ѵ�
		LinkedNode<E> currentNode = this.head(); // currentNode�� �� �� ��尪���� �ʱ�ȭ
		while (currentNode != null) { // currentNode ���� ���� ��
			if (currentNode.element().equals(anElement)) { // �־��� anElement�� ���Ұ� ���� ���
				return true; // true�� ����
			}
			currentNode = currentNode.next(); // currentNode�� nextNode�� ����
		}
		return false; // false�� ����
	}

	public int frequencyOf(E anElement) { // ���濡 �־��� ������ ������ Ȯ���Ѵ�
		int frequencyCount = 0; // frequencyCount�� 0���� �ʱ�ȭ
		LinkedNode<E> currentNode = this._head; // currentNode�� �� �� ��尪���� �ʱ�ȭ
		while (currentNode != null) { // currentNode ���� ���� ��
			if (currentNode.element().equals(anElement)) { // �־��� anElement�� ���Ұ� ���� ���
				frequencyCount++; // frequencyCount 1�� ����
			}
			currentNode = currentNode.next(); // currentNode�� nextNode�� ����
		}
		return frequencyCount; // frequencyCount�� ����
	}

	public E elementAt(int anOrder) { // anOrder�� ������ ���Ҹ� ��´�
		if ((anOrder < 0) || (anOrder >= this.size())) { // �־��� anOrder���� ��ȿ������ �ƴҶ�
			return null; // null�� ����
		} else {
			LinkedNode<E> currentNode = this.head(); // currentNode�� �� �� ���� �ʱ�ȭ
			for (int i = 0; i < anOrder; i++) { // �־��� anOrder���� �ݺ����� ���� ã���� �ϴ� ������ ��� ��ġ�� ã�´�
				currentNode = currentNode.next();
			}
			return currentNode.element(); // ã�� ������ ��带 ����
		}
	}

	public boolean add(E anElement) { // ���� �߰�
		if (this.isFull()) { // ���� �� �ִ� ���� ���ٰ� ����
			return false;
		} else {
			LinkedNode<E> newNode = new LinkedNode<E>(); // LinkedNode�� ���ο� ��ü newNode ����
			newNode.setElement(anElement); // anElment�� ���ҷ� ����
			newNode.setNext(this.head()); // ������ �� �� ��带 ���� ���� ����
			this.setHead(newNode); // newNode�� �� �� ���� ����
			this.setSize(this.size() + 1); // size�� +1
			return true; // true�� ����
		}
	}

	public boolean remove(E anElement) { // ���� ����
		LinkedNode<E> previousNode = null; // previousNode���� null�� �ʱ�ȭ
		LinkedNode<E> currentNode = this._head; // currentNode���� �� �� ���� �ʱ�ȭ
		boolean found = false;
		while (currentNode != null && !found) { // ������ ������� ������
			if (currentNode.element().equals(anElement)) { // anElement�� ���ҷ� ���� ��� ���� ���� ���
				found = true; // true�� ����
			} else { // ���� ���
				previousNode = currentNode; // previousNode�� currentNode��
				currentNode = currentNode.next(); // currentNode�� nextNode�� (��� �� ĭ �̵�)
			}
		}
		if (!found) { // ������ ������� ���
			return false;
		} else { // found�� true�� �Ǿ� while������ ���Դ�
			if (currentNode == this.head()) { // currentNode(������ ���)�� �� �� ��� �϶�
				this.setHead(this.head().next()); // ���� ��带 head�� ����
			} else { // currentNode �տ� �ٸ� ��尡 ������ ��
				previousNode.setNext(currentNode.next()); // ���� ��带 previousNode�� ���� ���� ���� (currentNode�� ��������)
			}
			this.setSize(this.size() - 1); // size�� -1
			return true; // true�� ����
		}
	}

	public E removeAny() { // ������ �ƹ� ���ҳ� �����
		if (this.isEmpty()) { // ������ ������� ���
			return null;
		}
		E removedElement = this.head().element(); // �� �� ��带 ����
		this.setHead(this.head().next()); // ���� ��带 �� �� ����
		this.setSize(this.size() - 1);	// size -1
		return removedElement;
	}

	public void clear() {
		this.setSize(0); // size�� 0����
		this.setHead(null); // head�� null��
	}
}
