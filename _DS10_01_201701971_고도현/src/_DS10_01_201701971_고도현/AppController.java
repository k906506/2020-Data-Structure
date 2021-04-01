package _DS10_01_201701971_고도현;

public class AppController {
	// 상수
	private static final int QUEUE_CAPACITY = 10; // 큐의 최대 값

	// 인스턴스 변수
	private Queue<Character> _queue;

	private int _inputChars;
	private int _addedChars;
	private int _ignoredChars;

	// 생성자
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

	// 횟수 계산
	private void countInputChar() {	// 입력된 문자 세기
		this.setInputChars(this.inputChars() + 1);
	}

	private void countIgnoredChar() {	// 무시된 문자 세기
		this.setIgnoredChars(this.ignoredChars() + 1);
	}

	private void countAddedChar() {	// 삽입된 문자 세기
		this.setAddedChars(this.addedChars() + 1);
	}

	private void addToQueue(char aCharForAdd) {	// 큐에 삽입
		if (this.queue().enQueue(aCharForAdd)) {	// aCharForAdd 삽입
			AppView.outputLine("[EnQ] 삽입된 원소는 '" + aCharForAdd + "' 입니다.");
			this.countAddedChar();	// 삽입된 원소 세기
		} else {
			AppView.outputLine("[EnQ.Empty] 큐가 꽉 차서 더 이상 넣을 수가 없습니다.");
		}
	}

	private void removeOne() {	// 큐에서 제거
		if (this.queue().isEmpty()) {	// 큐가 비어 있으면
			AppView.outputLine("[DeQ.Empty] 큐에 삭제할 원소가 없습니다.");
		} else {	// 큐에 원소가 있으면
			Character removedChar = this.queue().deQueue();	// removedChar에 제거한 원소 저장
			if (removedChar == null) {
				AppView.outputLine("(오류) 큐에서 삭제하는 동안에 오류가 발생하였습니다.");
			} else {
				AppView.outputLine("[DeQ] 삭제된 원소는 '" + removedChar + "' 입니다.");
			}
		}

	}

	private void removeN(int numberOfCharsToBeRemoved) {	// N개만큼 큐에서 제거
		if (numberOfCharsToBeRemoved == 0) {	// 값이 0 이면
			AppView.outputLine("[DeQs] 삭제할 원소의 개수가 0개 입니다.");
		} else {	// 0이 아니면
			int count = 0;
			while (count < numberOfCharsToBeRemoved && (!this.queue().isEmpty())) { // 스택이 비어있지 않으면
				Character removedQueue = this.queue().deQueue(); // 맨 앞 원소 삭제
				if (removedQueue == null) {	// 원소가 없으면
					AppView.outputLine("[DeQs.Empty] 큐에 더이상 삭제할 원소가 없습니다.");
				} else {	// 원소가 있으면
					AppView.outputLine("[DeQs] 삭제된 원소는 '" + removedQueue + "'입니다.");
				}
				count++;	// count = count + 1
			}
			if (count < numberOfCharsToBeRemoved) {
				AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다.");
			}
		}
	}

	private void quitQueuePrecessing() {
		AppView.outputLine("<큐를 비우고 사용을 종료합니다>");
		this.showAllFromFront();
		this.removeN(this.queue().size());
	}

	private void showAllFromFront() { // 큐의 모든 원소를 Front부터 Rear까지 출력
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator = this.queue().iterator();
		while (queueIterator.hasNext()) {
			Character element = queueIterator.next();
			AppView.output(element.toString() + " ");
		}
		AppView.outputLine("<Rear>");
	}

	private void showAllFromRear() { // 큐의 모든 원소를 Rear부터 Front까지 출력
		AppView.output("[Queue] <Rear> ");
		for (int order = this.queue().size() - 1; order >= 0; order--) {
			AppView.output(this.queue().elementAt(order).toString() + " ");
		}
		AppView.outputLine("<Front>");
	}

	private void showFrontElement() { // 큐의 맨 앞 원소를 출력
		if (this.queue().isEmpty()) {
			AppView.outputLine("[Front.Empty] 큐가 비어서 맨 앞 원소가 존재하지 않습니다.");
		} else {
			AppView.outputLine("[Front] 맨 앞 원소는 '" + this.queue().front() + "' 입니다.");
		}
	}

	private void showRearElement() { // 큐의 마지막 원소를 출력
		if (this.queue().isEmpty()) {
			AppView.outputLine("[Rear.Empty] 큐가 비어서 맨 뒤 원소가 존재하지 않습니다.");
		} else {
			AppView.outputLine("[Rear] 맨 뒤 원소는 '" + this.queue().rear() + "' 입니다.");
		}
	}

	private void showQueueSize() { // 큐의 모든 원소의 개수 출력
		AppView.outputLine("[Size] 큐에는 현재  " + this.queue().size() + " 개의 원소가 있습니다.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<큐 사용 통계>");
		AppView.outputLine("- 입력된 문자는 " + this.inputChars() + " 개 입니다.");
		AppView.outputLine("- 정상 처리된 문자는 " + (this.inputChars() - this.ignoredChars()) + " 개 입니다.");
		AppView.outputLine("- 무시된 문자는 " + this.ignoredChars() + " 개 입니다.");
		AppView.outputLine("- 삽입된 문자는 " + this.addedChars() + " 개 입니다.");
	}

	private char inputChar() {
		AppView.outputLine("? 문자를 입력하시오 : ");
		return AppView.inputLine();

	}

	public void run() {
		AppView.outputLine("<<< 큐 기능 확인 프로그램을 시작합니다 >>>");
		AppView.outputLine("");

		char input = this.inputChar();
		while (input != '!') {	// !가 입력되면 통계 출력으로 전환
			this.countInputChar();	// 문자 입력
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
				AppView.outputLine("[Ignore] 의미 없는 문자가 입력되었습니다.");
				this.countIgnoredChar();
			}
			input = this.inputChar();
		}

		this.quitQueuePrecessing();
		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<<큐 기능 확인 프로그램을 종료합니다>>>");
	}
}
