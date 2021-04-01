package _DS08_201701971_����;

public class AppController {
	private static final int STACK_CAPACITY = 10; // ���

	private ArrayList<Character> _stack; // ����� �ν��Ͻ� ����

	private int _inputChars; // �Էµ� ������ ����
	private int _pushedChars; // ���Ե� ������ ����
	private int _ignoreChars; // ���õ� ������ ����

	private ArrayList<Character> stack() { // getter
		return this._stack;
	}

	private void setStack(ArrayList<Character> newStack) { // setter
		this._stack = newStack;
	}

	private int inputChars() { // getter
		return this._inputChars;
	}

	private void setInputChars(int newInputChars) { // setter
		this._inputChars = newInputChars;
	}

	private int pushedChars() { // getter
		return this._pushedChars;
	}

	private void setPushedChars(int newPushedChars) { // setter
		this._pushedChars = newPushedChars;
	}

	private int ignoredChars() { // getter
		return this._ignoreChars;
	}

	private void setIgnoredChars(int newIgnoredChars) { // setter
		this._ignoreChars = newIgnoredChars;
	}

	public AppController() { // ������
		this.setStack(new ArrayList<Character>(AppController.STACK_CAPACITY));
		this.setInputChars(0);
		this.setPushedChars(0);
		this.setIgnoredChars(0);
	}

	// Ƚ���Ի�
	private void countInputChar() { // �Էµ� Ƚ��
		this.setInputChars(this.inputChars() + 1);
	}

	private void countIgnoredChar() { // ���õ� Ƚ��
		this.setIgnoredChars(this.ignoredChars() + 1);
	}

	private void countPushedChar() { // ���Ե� Ƚ��
		this.setPushedChars(this.pushedChars() + 1);
	}

	// ���� ���� ����
	private void pushToStack(char aCharForPush) {	// ���ÿ� ����
		if (this.stack().isFull()) {	// ������ ���� �� ������
			AppView.outputLine("(����) ������ �� ����, �� �̻� ���� �� �����ϴ�.");
		} else {	// ���ÿ� ������ ������
			Character charObjectForAdd = Character.valueOf(aCharForPush); // ���� ��ü�� ��ȯ
			if (this.stack().push(charObjectForAdd)) {	// ���ÿ� charObjectForAdd ����
				AppView.outputLine("[Push] ���Ե� ���Ҵ� " + aCharForPush + " �Դϴ�.");
			} else {
				AppView.outputLine("(����) ���ÿ� �ִ� ���� ������ �߻��߽��ϴ�. ");
			}
		}
	}

	private void popOne() {		// ���ÿ��� ����
		if (this.stack().isEmpty()) {	// ������ ��� ������
			AppView.outputLine("[Pop.Empty] ���ÿ� ������ ���Ұ� �����ϴ�.");
		} else {	// ���ÿ� ���Ұ� ������
			Character poppedChar = this.stack().pop();	// �� �� ���� ����
			if (poppedChar == null) {
				AppView.outputLine("(����) ���ÿ��� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			} else {
				AppView.outputLine("[Pop] ������ ���Ҵ� '" + poppedChar + "'�Դϴ�.");
			}
		}
	}

	private void popN(int numberOfCharsToBePopped) {	// ���ÿ��� N�� ����
		if (numberOfCharsToBePopped == 0) {	// N�� 0�̸�
			AppView.outputLine("[Pops] ������ ������ ������ 0�� �Դϴ�.");
		} else {	// N�� 1�̻��̸�
			int count = 0;
			while (count < numberOfCharsToBePopped && (!this.stack().isEmpty())) {	// ������ ������� ������
				Character poppedChar = this.stack().pop();	// �� �� ���� ����
				if (poppedChar == null) {
					AppView.outputLine("(����) ���ÿ��� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
				} else {
					AppView.outputLine("[Pops] ������ ���Ҵ� '" + poppedChar + "'�Դϴ�.");
				}
				count++;
			}
			if (count < numberOfCharsToBePopped) {
				AppView.outputLine("[Pop.Empty] ���ÿ� ���̻� ������ ���Ұ� �����ϴ�.");
			}
		}
	}

	private void quitStackProcessing() {	// ���� ��� ����
		AppView.outputLine("");
		AppView.outputLine("<������ ���� ����� �����մϴ�.>");
		this.showAllFromBottom();	// Bottom���� �������� ���� ���
		this.popN(this.stack().size());	// ������ ����.
	}

	private char inputChar() {	// ���� �Է�
		AppView.output("? ���ڸ� �Է��Ͻÿ� : ");
		return AppView.inputChar();
	}

	private void showAllFromBottom() { // ������ ���Ҹ� bottom���� ���
		AppView.output("[Stack] <Bottom> ");
		for (int order = 0; order < this.stack().size(); order++) {
			AppView.output(this.stack().elementAt(order).toString() + "");
		}
		AppView.outputLine(" <Top> ");
	}

	private void showAllFromTop() { // ������ ���Ҹ� top���� ���
		AppView.output("[Stack] <Top> ");
		for (int order = this.stack().size() - 1; order >= 0; order--) {
			AppView.output(this.stack().elementAt(order).toString() + "");
		}
		AppView.outputLine(" <Bottom> ");
	}

	private void showTopElement() {	// ���� Top ���� ���
		if (this.stack().isEmpty()) {
			AppView.outputLine("[Top.Empty] ������ �� Top ���Ұ� �������� �ʽ��ϴ�.");
		} else {
			AppView.outputLine("[Top] ������ Top ���Ҵ�  '" + this.stack().peek().toString() + "' �Դϴ�.");
		}
	}

	private void showStackSize() {	// ���� ���� ���� ���� ���
		if (this.stack().isEmpty()) {
			AppView.outputLine("[Empty] ������ �� ���Ұ� �������� �ʽ��ϴ�.");
		} else {
			AppView.outputLine("[Size] ���ÿ��� ���� " + this.stack().size() + "���� ���Ұ� �ֽ��ϴ�.");
		}
	}

	private void showStatistics() {	// ��� ���
		AppView.outputLine("");
		AppView.outputLine("<���� ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� " + this.inputChars() + " �� �Դϴ�.");
		AppView.outputLine("- ���� ó���� ���ڴ� " + (this.inputChars() - this.ignoredChars()) + "�� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� " + this.ignoredChars() + "�� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� " + this.pushedChars() + "�� �Դϴ�.");
	}
	
	public void run() {
		AppView.outputLine("<<< ���� ��� Ȯ�� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("");
		
		char input = this.inputChar();
		while (input != '!') {
			this.countInputChar();
			if(Character.isAlphabetic(input)) {	// ���ĺ� �˻�
				this.pushToStack(input);
				this.countPushedChar();
			}
			else if(Character.isDigit(input)) {	// ���� ���� �˻�
				this.popN(Character.getNumericValue(input));	// ���� ���ڸ� ���������� ��ȯ
			}
			else if(input == '-') {
				this.popOne();
			}
			else if(input == '#') {
				this.showStackSize();
			}
			else if(input == '/') {	// bottom���� ���
				this.showAllFromBottom();
			}
			else if(input == '\\') {	// top���� ���
				this.showAllFromTop();
			}
			else if(input == '^') {
				this.showTopElement();
			}
			else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.");
				this.countIgnoredChar();
			}
			input = this.inputChar(); // ���� ���Է�
		}
		this.quitStackProcessing();
		
		this.showStatistics();	// ��� ���
		AppView.outputLine("");
		AppView.outputLine(" <<< ���ñ�� Ȯ�� ���α׷��� �����մϴ�. >>>");
	}
}
