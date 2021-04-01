package _DS14_201701971_고도현;

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

		AppView.outputLine("<<< 이진검색트리로 구현된 사전에서의 삽입과 삭제 >>>");
		AppView.outputLine("");
		
		this.setDictionary(new DictionaryByBinarySearchTree<Integer, Integer>());
		this.dictionary().setVisitDelegate(this);

		this.setList(DataGenerator.randomList(DAFAULT_DATA_SIZE));
		this.addToDictinaryAndShowShape();
		
		this.showDictionaryInSortedOrderbyCallBack();
		this.showDictinaryInSortedOrderByIterator();
		
		this.setList(DataGenerator.randomList(DAFAULT_DATA_SIZE));
		this.removeFromDictionaryAndShowShape();
		AppView.outputLine("<<< 종료 >>>");
	}

	private void showDictionary(String aTitlePrefix) {
		AppView.outputLine(" > " + aTitlePrefix + "이진검색트리 사전 : ");
		if (this.dictionary().isEmpty()) {
			AppView.outputLine("  Empty");
		} else {
			this.dictionary().scanInReverseOfSortedOrder();
		}
		AppView.outputLine("");
	}

	private void addToDictinaryAndShowShape() {
		AppView.outputLine("[삽입 과정에서의 이진검색트리 사전의 변화]");
		this.showDictionary("삽입을 시작하기 전의 ");
		for (int i = 0; i < this.list().length; i++) {
			Integer currentKey = this.list()[i];
			Integer currentObj = Integer.valueOf(i);
			this.dictionary().addKeyAndObject(currentKey, currentObj);
			this.showDictionary(String.format("Key = %d (Object = %d) 원소를 삽입한 후의 ", currentKey, currentObj));
		}
	}

	private void removeFromDictionaryAndShowShape() {
		AppView.outputLine("[삭제 과정에서의 이진검색트리 사전의 변화]");
		this.showDictionary("삭제를 시작하기 전의 ");
		for (int i = 0; i < this.list().length; i++) {
			Integer currentKey = this.list()[i];
			Integer currentObj = Integer.valueOf(i);
			this.dictionary().removeObjectForKey(currentKey);
			this.showDictionary(String.format("Key = %d (Object = %d) 원소를 삭제한  후의 ", currentKey, currentObj));
		}
	}

	private void showDictionaryInSortedOrderbyCallBack() {
		AppView.outputLine("[\"Call Back\"을 사용하여 보여준 사전의 내용]");
		this.dictionary().scanInsortedOrder();
		AppView.outputLine("");
	}

	private void showDictinaryInSortedOrderByIterator() {
		AppView.outputLine("[\"Iterator\"를 사용햐여 보여준 사전의 내용]");
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
		if (aLevel == 1) {	// 트리의 높이가 1
			AppView.output(String.format("%7s", "Root : ", aKey, anObj));	// Root 메세지와 함께 aKey와 anObj 출력
		} else {	// 트리의 높이가 2 이상
			AppView.output(String.format("%7s", ""));	// 줄바꿈
		}
		for (int i = 1; i < aLevel; i++) {
			AppView.output(String.format("%7s", ""));
		}
		AppView.outputLine(String.format("%3d (%2d )", aKey, anObj));
	}

}
