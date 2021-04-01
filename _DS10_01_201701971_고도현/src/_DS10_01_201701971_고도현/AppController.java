package _DS10_01_201701971_����;

public class AppController {
	// ���
	private static final int QUEUE_CAPACITY = 10; // ť�� �ִ� ��

	// �ν��Ͻ� ����
	private Queue<Character> _queue;

	private int _inputChars;
	private int _addedChars;
	private int _ignoredChars;

	// ������
	private Queue<Character> queue() { // getter
		return this._queue;
	}

	private void setQueue(Queue<Character> newQueue) { // setter
		this._queue = newQueue;
	}

	private int inputChars() { // getter
		return this._inputChars;
	}

	private void setInputChars(int newInputChars) { // setter
		this._inputChars = newInputChars;
	}

	private int addedChars() { // getter
		return this._addedChars;
	}

	private void setAddedChars(int newAddedChars) { // setter
		this._addedChars = newAddedChars;
	}

	private int ignoredChars() { // getter
		return this._ignoredChars;
	}

	private void setIgnoredChars(int newIgnoredChars) { // setter
		this._ignoredChars = newIgnoredChars;
	}

	public AppController() {
		this.setQueue(new CircularArrayQueue<Character>(AppController.QUEUE_CAPACITY));
		this.setInputChars(0);
		this.setAddedChars(0);
		this.setIgnoredChars(0);
	}

	// Ƚ�� ���
	private void countInputChar() {	// �Էµ� ���� ����
		this.setInputChars(this.inputChars() + 1);
	}

	private void countIgnoredChar() {	// ���õ� ���� ����
		this.setIgnoredChars(this.ignoredChars() + 1);
	}

	private void countAddedChar() {	// ���Ե� ���� ����
		this.setAddedChars(this.addedChars() + 1);
	}

	private void addToQueue(char aCharForAdd) {	// ť�� ����
		if (this.queue().enQueue(aCharForAdd)) {	// aCharForAdd ����
			AppView.outputLine("[EnQ] ���Ե� ���Ҵ� '" + aCharForAdd + "' �Դϴ�.");
			this.countAddedChar();	// ���Ե� ���� ����
		} else {
			AppView.outputLine("[EnQ.Empty] ť�� �� ���� �� �̻� ���� ���� �����ϴ�.");
		}
	}

	private void removeOne() {	// ť���� ����
		if (this.queue().isEmpty()) {	// ť�� ��� ������
			AppView.outputLine("[DeQ.Empty] ť�� ������ ���Ұ� �����ϴ�.");
		} else {	// ť�� ���Ұ� ������
			Character removedChar = this.queue().deQueue();	// removedChar�� ������ ���� ����
			if (removedChar == null) {
				AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			} else {
				AppView.outputLine("[DeQ] ������ ���Ҵ� '" + removedChar + "' �Դϴ�.");
			}
		}

	}

	private void removeN(int numberOfCharsToBeRemoved) {	// N����ŭ ť���� ����
		if (numberOfCharsToBeRemoved == 0) {	// ���� 0 �̸�
			AppView.outputLine("[DeQs] ������ ������ ������ 0�� �Դϴ�.");
		} else {	// 0�� �ƴϸ�
			int count = 0;
			while (count < numberOfCharsToBeRemoved && (!this.queue().isEmpty())) { // ������ ������� ������
				Character removedQueue = this.queue().deQueue(); // �� �� ���� ����
				if (removedQueue == null) {	// ���Ұ� ������
					AppView.outputLine("[DeQs.Empty] ť�� ���̻� ������ ���Ұ� �����ϴ�.");
				} else {	// ���Ұ� ������
					AppView.outputLine("[DeQs] ������ ���Ҵ� '" + removedQueue + "'�Դϴ�.");
				}
				count++;	// count = count + 1
			}
			if (count < numberOfCharsToBeRemoved) {
				AppView.outputLine("(����) ���ÿ��� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			}
		}
	}

	private void quitQueuePrecessing() {
		AppView.outputLine("<ť�� ���� ����� �����մϴ�>");
		this.showAllFromFront();
		this.removeN(this.queue().size());
	}

	private void showAllFromFront() { // ť�� ��� ���Ҹ� Front���� Rear���� ���
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator = this.queue().iterator();
		while (queueIterator.hasNext()) {
			Character element = queueIterator.next();
			AppView.output(element.toString() + " ");
		}
		AppView.outputLine("<Rear>");
	}

	private void showAllFromRear() { // ť�� ��� ���Ҹ� Rear���� Front���� ���
		AppView.output("[Queue] <Rear> ");
		for (int order = this.queue().size() - 1; order >= 0; order--) {
			AppView.output(this.queue().elementAt(order).toString() + " ");
		}
		AppView.outputLine("<Front>");
	}

	private void showFrontElement() { // ť�� �� �� ���Ҹ� ���
		if (this.queue().isEmpty()) {
			AppView.outputLine("[Front.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		} else {
			AppView.outputLine("[Front] �� �� ���Ҵ� '" + this.queue().front() + "' �Դϴ�.");
		}
	}

	private void showRearElement() { // ť�� ������ ���Ҹ� ���
		if (this.queue().isEmpty()) {
			AppView.outputLine("[Rear.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		} else {
			AppView.outputLine("[Rear] �� �� ���Ҵ� '" + this.queue().rear() + "' �Դϴ�.");
		}
	}

	private void showQueueSize() { // ť�� ��� ������ ���� ���
		AppView.outputLine("[Size] ť���� ����  " + this.queue().size() + " ���� ���Ұ� �ֽ��ϴ�.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<ť ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� " + this.inputChars() + " �� �Դϴ�.");
		AppView.outputLine("- ���� ó���� ���ڴ� " + (this.inputChars() - this.ignoredChars()) + " �� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� " + this.ignoredChars() + " �� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� " + this.addedChars() + " �� �Դϴ�.");
	}

	private char inputChar() {
		AppView.outputLine("? ���ڸ� �Է��Ͻÿ� : ");
		return AppView.inputLine();

	}

	public void run() {
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");

		char input = this.inputChar();
		while (input != '!') {	// !�� �ԷµǸ� ��� ������� ��ȯ
			this.countInputChar();	// ���� �Է�
			if ((Character.isAlphabetic(input))) {
				this.addToQueue(Character.valueOf(input));
			} else if (Character.isDigit(input)) {
				this.removeN(Character.getNumericValue(input));
			} else if (input == '-') {
				this.removeOne();
			} else if (input == '#') {
				this.showQueueSize();
			} else if (input == '/') {
				this.showAllFromFront();
			} else if (input == '\\') {
				this.showAllFromRear();
			} else if (input == '<') {
				this.showFrontElement();
			} else if (input == '>') {
				this.showRearElement();
			} else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.");
				this.countIgnoredChar();
			}
			input = this.inputChar();
		}

		this.quitQueuePrecessing();
		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<<ť ��� Ȯ�� ���α׷��� �����մϴ�>>>");
	}
}
