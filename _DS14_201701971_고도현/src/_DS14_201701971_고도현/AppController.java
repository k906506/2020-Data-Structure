package _DS14_201701971_����;

public class AppController implements VisitDelegate<Integer, Integer> {
	private static final int DAFAULT_DATA_SIZE = 10;

	private Dictionary<Integer, Integer> _dictionary;
	private Integer[] _list;

	private Dictionary<Integer, Integer> dictionary() {
		return this._dictionary;
	}

	private void setDictionary(Dictionary<Integer, Integer> newDictionary) {
		this._dictionary = newDictionary;
	}

	private Integer[] list() {
		return this._list;
	}

	private void setList(Integer[] newList) {
		this._list = newList;
	}

	public void run() {
		this.setList(DataGenerator.randomList(DAFAULT_DATA_SIZE));

		AppView.outputLine("<<< �����˻�Ʈ���� ������ ���������� ���԰� ���� >>>");
		AppView.outputLine("");
		
		this.setDictionary(new DictionaryByBinarySearchTree<Integer, Integer>());
		this.dictionary().setVisitDelegate(this);

		this.setList(DataGenerator.randomList(DAFAULT_DATA_SIZE));
		this.addToDictinaryAndShowShape();
		
		this.showDictionaryInSortedOrderbyCallBack();
		this.showDictinaryInSortedOrderByIterator();
		
		this.setList(DataGenerator.randomList(DAFAULT_DATA_SIZE));
		this.removeFromDictionaryAndShowShape();
		AppView.outputLine("<<< ���� >>>");
	}

	private void showDictionary(String aTitlePrefix) {
		AppView.outputLine(" > " + aTitlePrefix + "�����˻�Ʈ�� ���� : ");
		if (this.dictionary().isEmpty()) {
			AppView.outputLine("  Empty");
		} else {
			this.dictionary().scanInReverseOfSortedOrder();
		}
		AppView.outputLine("");
	}

	private void addToDictinaryAndShowShape() {
		AppView.outputLine("[���� ���������� �����˻�Ʈ�� ������ ��ȭ]");
		this.showDictionary("������ �����ϱ� ���� ");
		for (int i = 0; i < this.list().length; i++) {
			Integer currentKey = this.list()[i];
			Integer currentObj = Integer.valueOf(i);
			this.dictionary().addKeyAndObject(currentKey, currentObj);
			this.showDictionary(String.format("Key = %d (Object = %d) ���Ҹ� ������ ���� ", currentKey, currentObj));
		}
	}

	private void removeFromDictionaryAndShowShape() {
		AppView.outputLine("[���� ���������� �����˻�Ʈ�� ������ ��ȭ]");
		this.showDictionary("������ �����ϱ� ���� ");
		for (int i = 0; i < this.list().length; i++) {
			Integer currentKey = this.list()[i];
			Integer currentObj = Integer.valueOf(i);
			this.dictionary().removeObjectForKey(currentKey);
			this.showDictionary(String.format("Key = %d (Object = %d) ���Ҹ� ������  ���� ", currentKey, currentObj));
		}
	}

	private void showDictionaryInSortedOrderbyCallBack() {
		AppView.outputLine("[\"Call Back\"�� ����Ͽ� ������ ������ ����]");
		this.dictionary().scanInsortedOrder();
		AppView.outputLine("");
	}

	private void showDictinaryInSortedOrderByIterator() {
		AppView.outputLine("[\"Iterator\"�� ����Ῡ ������ ������ ����]");
		Iterator<DictionaryElement<Integer, Integer>> iterator = this.dictionary().iterator();
		while (iterator.hasNext()) {
			DictionaryElement<Integer, Integer> dictionaryElement = iterator.next();
			AppView.outputLine(String.format("%3d (%2d )", dictionaryElement.key(), dictionaryElement.object()));
		}
		AppView.outputLine("");
	}

	@Override
	public void visitForSortedOrder(Integer aKey, Integer anObj, int aLevel) {
		AppView.outputLine(String.format("%3d (%2d )", aKey, anObj));
	}

	@Override
	public void visitForReverseOfSortedOrder(Integer aKey, Integer anObj, int aLevel) {
		if (aLevel == 1) {	// Ʈ���� ���̰� 1
			AppView.output(String.format("%7s", "Root : ", aKey, anObj));	// Root �޼����� �Բ� aKey�� anObj ���
		} else {	// Ʈ���� ���̰� 2 �̻�
			AppView.output(String.format("%7s", ""));	// �ٹٲ�
		}
		for (int i = 1; i < aLevel; i++) {
			AppView.output(String.format("%7s", ""));
		}
		AppView.outputLine(String.format("%3d (%2d )", aKey, anObj));
	}

}
