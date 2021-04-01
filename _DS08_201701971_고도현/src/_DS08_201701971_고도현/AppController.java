package _DS08_201701971_고도현;

public class AppController {
	private static final int STACK_CAPACITY = 10; // 상수

	private ArrayList<Character> _stack; // 비공개 인스턴스 변수

	private int _inputChars; // 입력된 문자의 개수
	private int _pushedChars; // 삽입된 문자의 개수
	private int _ignoreChars; // 무시된 문자의 개수

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

	public AppController() { // 생성자
		this.setStack(new ArrayList<Character>(AppController.STACK_CAPACITY));
		this.setInputChars(0);
		this.setPushedChars(0);
		this.setIgnoredChars(0);
	}

	// 횟수게산
	private void countInputChar() { // 입력된 횟수
		this.setInputChars(this.inputChars() + 1);
	}

	private void countIgnoredChar() { // 무시된 횟수
		this.setIgnoredChars(this.ignoredChars() + 1);
	}

	private void countPushedChar() { // 삽입된 횟수
		this.setPushedChars(this.pushedChars() + 1);
	}

	// 스택 수행 관련
	private void pushToStack(char aCharForPush) {	// 스택에 삽입
		if (this.stack().isFull()) {	// 스택이 가득 차 있으면
			AppView.outputLine("(오류) 스택이 꽉 차서, 더 이상 넣을 수 없습니다.");
		} else {	// 스택에 공간이 있으면
			Character charObjectForAdd = Character.valueOf(aCharForPush); // 문자 객체로 변환
			if (this.stack().push(charObjectForAdd)) {	// 스택에 charObjectForAdd 삽입
				AppView.outputLine("[Push] 삽입된 원소는 " + aCharForPush + " 입니다.");
			} else {
				AppView.outputLine("(오류) 스택에 넣는 동안 오류가 발생했습니다. ");
			}
		}
	}

	private void popOne() {		// 스택에서 제거
		if (this.stack().isEmpty()) {	// 스택이 비어 있으면
			AppView.outputLine("[Pop.Empty] 스택에 삭제할 원소가 없습니다.");
		} else {	// 스택에 원소가 있으면
			Character poppedChar = this.stack().pop();	// 맨 위 원소 삭제
			if (poppedChar == null) {
				AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다.");
			} else {
				AppView.outputLine("[Pop] 삭제된 원소는 '" + poppedChar + "'입니다.");
			}
		}
	}

	private void popN(int numberOfCharsToBePopped) {	// 스택에서 N개 제거
		if (numberOfCharsToBePopped == 0) {	// N이 0이면
			AppView.outputLine("[Pops] 삭제할 원소의 개수가 0개 입니다.");
		} else {	// N이 1이상이면
			int count = 0;
			while (count < numberOfCharsToBePopped && (!this.stack().isEmpty())) {	// 스택이 비어있지 않으면
				Character poppedChar = this.stack().pop();	// 맨 위 원소 삭제
				if (poppedChar == null) {
					AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다.");
				} else {
					AppView.outputLine("[Pops] 삭제된 원소는 '" + poppedChar + "'입니다.");
				}
				count++;
			}
			if (count < numberOfCharsToBePopped) {
				AppView.outputLine("[Pop.Empty] 스택에 더이상 삭제할 원소가 없습니다.");
			}
		}
	}

	private void quitStackProcessing() {	// 스택 사용 종료
		AppView.outputLine("");
		AppView.outputLine("<스택을 비우고 사용을 종료합니다.>");
		this.showAllFromBottom();	// Bottom부터 오름차순 원소 출력
		this.popN(this.stack().size());	// 스택을 비운다.
	}

	private char inputChar() {	// 문자 입력
		AppView.output("? 문자를 입력하시오 : ");
		return AppView.inputChar();
	}

	private void showAllFromBottom() { // 스택의 원소를 bottom부터 출력
		AppView.output("[Stack] <Bottom> ");
		for (int order = 0; order < this.stack().size(); order++) {
			AppView.output(this.stack().elementAt(order).toString() + "");
		}
		AppView.outputLine(" <Top> ");
	}

	private void showAllFromTop() { // 스택의 원소를 top부터 출력
		AppView.output("[Stack] <Top> ");
		for (int order = this.stack().size() - 1; order >= 0; order--) {
			AppView.output(this.stack().elementAt(order).toString() + "");
		}
		AppView.outputLine(" <Bottom> ");
	}

	private void showTopElement() {	// 스택 Top 원소 출력
		if (this.stack().isEmpty()) {
			AppView.outputLine("[Top.Empty] 스택이 비어서 Top 원소가 존재하지 않습니다.");
		} else {
			AppView.outputLine("[Top] 스택의 Top 원소는  '" + this.stack().peek().toString() + "' 입니다.");
		}
	}

	private void showStackSize() {	// 스택 내부 원소 개수 출력
		if (this.stack().isEmpty()) {
			AppView.outputLine("[Empty] 스택이 비어서 원소가 존재하지 않습니다.");
		} else {
			AppView.outputLine("[Size] 스택에는 현재 " + this.stack().size() + "개의 원소가 있습니다.");
		}
	}

	private void showStatistics() {	// 통계 출력
		AppView.outputLine("");
		AppView.outputLine("<스택 사용 통계>");
		AppView.outputLine("- 입력된 문자는 " + this.inputChars() + " 개 입니다.");
		AppView.outputLine("- 정상 처리된 문자는 " + (this.inputChars() - this.ignoredChars()) + "개 입니다.");
		AppView.outputLine("- 무시된 문자는 " + this.ignoredChars() + "개 입니다.");
		AppView.outputLine("- 삽입된 문자는 " + this.pushedChars() + "개 입니다.");
	}
	
	public void run() {
		AppView.outputLine("<<< 스택 기능 확인 프로그램을 시작합니다. >>>");
		AppView.outputLine("");
		
		char input = this.inputChar();
		while (input != '!') {
			this.countInputChar();
			if(Character.isAlphabetic(input)) {	// 알파벳 검사
				this.pushToStack(input);
				this.countPushedChar();
			}
			else if(Character.isDigit(input)) {	// 숫자 문자 검사
				this.popN(Character.getNumericValue(input));	// 숫자 문자를 정수값으로 변환
			}
			else if(input == '-') {
				this.popOne();
			}
			else if(input == '#') {
				this.showStackSize();
			}
			else if(input == '/') {	// bottom부터 출력
				this.showAllFromBottom();
			}
			else if(input == '\\') {	// top부터 출력
				this.showAllFromTop();
			}
			else if(input == '^') {
				this.showTopElement();
			}
			else {
				AppView.outputLine("[Ignore] 의미 없는 문자가 입력되었습니다.");
				this.countIgnoredChar();
			}
			input = this.inputChar(); // 문자 재입력
		}
		this.quitStackProcessing();
		
		this.showStatistics();	// 통계 출력
		AppView.outputLine("");
		AppView.outputLine(" <<< 스택기능 확인 프로그램을 종료합니다. >>>");
	}
}
