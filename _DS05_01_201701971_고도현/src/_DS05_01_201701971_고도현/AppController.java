package _DS05_01_201701971_고도현;

public class AppController {
	private static final int LIST_CAPACITY = 100;	// maximum 값

	private ArrayList<Student> _list;	// 인스턴스 변수

	private ArrayList<Student> list() {	// getter
		return this._list;
	}

	private void setList(ArrayList<Student> newList) {	// setter
		this._list = newList;
	}

	public AppController() { // 생성자
		this.setList(new ArrayList<Student>(AppController.LIST_CAPACITY));
	}

	private void showMenu() {	// showMenu
		AppView.outputLine("> 해야 할 작업의 번호를 선택해야 합니다:");
		AppView.outputLine(" DoesContain=1, ElementAt=2, First=3, Last=4, OrderOf=5,");
		AppView.outputLine(" AddTo=6, AddToFirst=7, AddToLast=8, Add=9, ");
		AppView.outputLine(" RemoveFrom=10, RemoveFirst=11, RemoveLast=12, RemoveAny=13, ReplaceAt=14, EndOfRun=99");
		AppView.output("? 작업 번호를 입력하시오: ");
	}

	private MainMenu selectMenu() {
		AppView.outputLine("");
		this.showList();	// 리스트 출력
		this.showMenu();	// 메뉴 출력
		try {
			int selectedMenuNumber = AppView.inputInteger();	// 메뉴값 입력 받은 후 selectedMenuNumber에 대입
			MainMenu selectedMenuValue = MainMenu.value(selectedMenuNumber);
			if (selectedMenuValue == MainMenu.Error) {	// selectedMenuValue가 error일 경우
				AppView.outputLine("!오류 : 작업 선택이 잘못되었습니다. (잘못된 메뉴 번호: " + selectedMenuNumber + ")");
			}
			return selectedMenuValue;	// selectedValue를 return
		} catch (NumberFormatException e) {
			AppView.outputLine("!오류 : 입력된 메뉴 번호가 정수 숫자가 아닙니다. ");
			return MainMenu.Error;	// error값
		}
	}

	public void run() {
		AppView.outputLine("<<< 리스트 기능 확인 프로그램을 시작합니다. >>>");
		AppView.outputLine("");

		MainMenu selectedMenuValue = this.selectMenu();	
		while (selectedMenuValue != MainMenu.EndOfRun) {	// selectedMenuValue가 EndOfRun이 아니면
			switch (selectedMenuValue) {
			case DoesContain: // 1 입력
				this.doesContain();
				break;
			case ElementAt: // 2입력
				this.elementAt();
				break;
			case First: // 3입력
				this.first();
				break;
			case Last:	// 4입력
				this.last();
				break;
			case OrderOf:	// 5입력
				this.orderOf();
				break;
			case AddTo:	// 6입력
				this.addTo();
				break;
			case AddToFirst:	// 7입력
				this.addToFirst();
				break;
			case AddToLast:	// 8입력
				this.addToLast();
				break;
			case Add:	// 9입력
				this.add();
				break;
			case RemoveFrom:	// 10입력
				this.removeFrom();
				break;
			case RemoveFirst:	// 11입력
				this.removeFirst();
				break;
			case RemoveLast:	// 12입력
				this.removeLast();
				break;
			case RemoveAny:	// 13입력
				this.removeAny();
				break;
			case ReplaceAt:	// 14입력
				this.replaceAt();
				break;
			default:
				break;
			}
			selectedMenuValue = this.selectMenu();
		}
		this.showStatistics();	// 리스트 출력

		AppView.outputLine("");
		AppView.outputLine(" <<< 리스트 기능 확인 프로그램을 종료합니다. >>> ");
	}

	private void doesContain() {	// 특정 점수의 학생
		AppView.outputLine("");
		AppView.outputLine("! DoesContain 작업을 실행합니다:");
		int score = this.inputScore();	// 점수 입력
		if (this.list().doesContain(new Student(score))) {	// 리스트 내의 해당 원소를 찾는다
			AppView.outputLine("! 입력된 점수 (" + score + ")의 학생이 리스트에 존재합니다.");
		} else {
			AppView.outputLine("! 입력된 점수 (" + score + ")의 학생이 리스트에 존재하지 않습니다.");
		}
	}

	private void elementAt() {	// 특정 순서의 학생의 점수
		AppView.outputLine("");
		AppView.outputLine("! ElementAt 작업을 실행합니다 :");
		int order = this.inputOrder();	// 점수 입력
		if (this.list().elementAt(order) != null) {	// 리스트 내의 순서를 알아낸다.
			AppView.outputLine("! 입력된 순서 [" + order + "]의 학생의 점수는 (" + this.list().elementAt(order).score() + ") 입니다.");
		} else {
			AppView.outputLine("! 입력된 순서 [" + order + "]에 존재하는 학생은 없습니다.");
		}
	}

	private void first() {	// 맨 앞 원소 출력
		AppView.outputLine("");	
		AppView.outputLine("! FirstElement 작업을 실행합니다 :");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어있습니다.");
		} else {	// 리스트에 원소가 있으면
			Student student = this.list().first(); // 리스트의 맨 앞 값을 student객체에 저장
			AppView.outputLine("[맨 앞] 학생의 점수는 (" + student.score() + ") 입니다. ");
		}
	}

	private void last() { // 맨 뒤 원소 출력
		AppView.outputLine("");
		AppView.outputLine("! lastElement 작업을 실행합니다 :");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어있습니다.");
		} else {	// 리스트에 원소가 있으면
			Student student = this.list().last(); // 리스트의 맨 뒤 값을 student객체에 저장
			AppView.outputLine("[맨 뒤] 학생의 점수는 (" + student.score() + ") 입니다. ");
		}
	}

	private void orderOf() {	// 순서 출력
		AppView.outputLine("");
		AppView.outputLine("! OrderOfElement 작업을 실행합니다 :");
		int score = this.inputScore();	// 점수 입력
		if (this.list().orderOf(new Student(score)) != -1) {	// orderOf의 리턴 값이 -1이 아닐 때(원소가 있을때)
			AppView.outputLine(
					"! 입력된 점수 (" + score + ")의 학생의 순서는 [" + this.list().orderOf(new Student(score)) + "] 입니다.");
		} else {
			AppView.outputLine("! 입력된 점수 (" + score + ")의 학생이 리스트에 존재하지 않습니다.");
		}
	}

	private void showList() {	// 리스트 내의 정보 출력
		AppView.output("! 현재의 리스트 원소들: [");
		Student student = null;
		Iterator<Student> iterator = this.list().iterator();
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.output(" " + student.score());
		}
		AppView.outputLine(" ]");
	}

	private void showStatistics() { // 리스트의 크기 출력
		AppView.outputLine("");
		AppView.outputLine("> 리스트 정보 입니다:");
		AppView.outputLine("! 학생 수 : " + this.list().size());
		this.showList();
	}

	private int inputScore() {	// 점수입력 메소드
		int score;	// 점수에 해당하는 변수
		while (true) {	// 무한루프
			try {
				AppView.output("? 점수를 입력하시오: ");
				score = AppView.inputInteger();	// 점수 입력
				return score;	// 점수 return
			} catch (NumberFormatException e) {	// 예외 처리
				AppView.outputLine("[오류] 입력된 점수는 점수가 아닙니다. ");
			}
		}
	}

	private int inputOrder() {	// 순서입력 메소드
		int order;	// 순서에 해당하는 변수
		while (true) {
			try {
				AppView.output("? 리스트에서의 순서 번호를 입력하시오: ");
				order = AppView.inputInteger(); // 순서 입력
				return order;	// 순서 return
			} catch (NumberFormatException e) {	// 에외 처리
				AppView.outputLine("[오류] 입력된 순서 번호는 정수가 아닙니다. ");
			}
		}
	}

	private void addTo() {	// 원소 추가
		AppView.outputLine("");
		AppView.outputLine("! AddTo 작업을 시작합니다.");
		if (this.list().isFull()) {	// 리스트에 공간이 없으면
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		} else {	// 리스트에 공간이 있을 때
			int order = this.inputOrder();	// 순서 입력
			if (order < 0 || order > this.list().size()) { 	// 순서가 정상 범위가 아닐 때
				AppView.outputLine("! 입력된 순서 [" + order + "]가 정상 범위 [0.." + this.list().size() + "]에 있지 않습니다.");
			} else {	// 순서가 정상 범위일때
				int score = this.inputScore();	// 점수 입력
				if (this.list().addTo(new Student(score), order)) {	//  Student 호출 후 점수를 삽입
					AppView.outputLine("! 입력된 순서 [" + order + "]에 입력된 정수 (" + score + ")의 학생을 삽입하는 작업을 성공하였습니다.");
				} else {
					AppView.outputLine("! 입력된 순서 [" + order + "]에 입력된 정수 (" + score + ")의 학생을 삽입하는 작업을 실패하였습니다.");
				}
			} 
		}
	}

	private void addToFirst() {	// 원소 맨앞 추가
		AppView.outputLine("");
		AppView.outputLine("! AddToFirst 작업을 시작합니다:");
		if (this.list().isFull()) {	// 리스트에 공간이 없으면
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		} else {	// 리스트에 공간이 있으면
			int score = this.inputScore();	// 점수 입력
			if (this.list().addToFirst(new Student(score))) {	// Student 호출 후 점수 삽입
				AppView.outputLine("! 입력된 점수 (" + score + ")의 학생을 [맨 앞]에 삽입하는 작업을 성공했습니다.");
			} else {
				AppView.outputLine("! 입력된 점수 (" + score + ")의 학생을 [맨 앞]에 삽입하는 작업을 실패하엿습니다.");
			}
		}
	}

	private void addToLast() {	// 원소 맨뒤 추가
		AppView.outputLine("");
		AppView.outputLine("! AddToLast 작업을 시작합니다:");
		if (this.list().isFull()) {	// 리스트에 공간이 없으면
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		} else {	// 리스트에 공간이 있으면 
			int score = this.inputScore();	// 점수입력
			if (this.list().addToLast(new Student(score))) { // Student 호출 후 점수 삽입
				AppView.outputLine("! 입력된 점수 (" + score + ")의 학생을 [맨 뒤]에 삽입하는 작업을 성공했습니다.");
			} else {
				AppView.outputLine("! 입력된 점수 (" + score + ")의 학생을 [맨 뒤]에 삽입하는 작업을 실패하엿습니다.");
			}
		}
	}

	private void add() {	// 원소 추가
		AppView.outputLine("");	
		AppView.outputLine("! Add 작업을 시작합니다:");
		if (this.list().isFull()) {	// 리스트에 공간이 없으면
			AppView.outputLine("! 리스트가 꽉 차 있어서 삽입 작업을 할 수 없습니다.");
		} else {	// 리스트에 공간이 있으면
			int score = this.inputScore();	// 점수 입력
			if (this.list().add(new Student(score))) {	// Student 호출 후 점수 삽입
				AppView.outputLine("! 입력된 점수 (" + score + ")의 학생을 [임의의 순서]에 삽입하는 작업을 성공했습니다.");
			} else {
				AppView.outputLine("! 입력된 점수 (" + score + ")의 학생을 [임의의 순서]에 삽입하는 작업을 실패하엿습니다.");
			}
		}
	}

	private void removeFrom() {	// 원소 제거
		AppView.outputLine("");
		AppView.outputLine("! RemoveFrom 작업을 시작합니다:");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다.");
		} else {	// 리스트에 원소가 있으면
			int order = this.inputOrder();	// 순서 입력
			if (order < 0 || order >= this.list().size()) {	// 입력값이 유효 범위이면
				AppView.outputLine("! 입력된 순서 [" + order + "]가 정상 범위 [0.." + (this.list().size() - 1) + "]에 있지 않습니다.");
			}
			Student student = this.list().removeFrom(order);	// Student 객체에 삭제된 원소 저장
			
			if (student != null) {
				AppView.outputLine("! 입력된 순서 [" + order + "]에서 삭제된 학생의 성적은 (" + student.score() + ")입니다.");
			} else {
				AppView.outputLine("! 입력된 순서 [" + order + "]에서 학생을 삭제하는 작업을 실패하였습니다.");
			}
		}
	}

	private void removeFirst() {	// 원소 맨앞 제거
		AppView.outputLine("");
		AppView.outputLine("! RemoveFirst 작업을 시작합니다.:");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다. ");
		} else {	// 리스트에 원소가 있으면
			Student student = this.list().removeFirst(); // 맨 앞 원소를 지운다
			if (student != null) { // 원소를 지웠으면
				AppView.outputLine("! 삭제된 [맨 앞] 학생의 성적은 (" + student.score() + ") 입니다.");
			} else {
				AppView.outputLine("! [맨 앞] 학생을 삭제하는 작업을 실패하였습니다.");
			}
		}
	}

	private void removeLast() {	// 원소 맨뒤 제거
		AppView.outputLine("");
		AppView.outputLine("! RemoveLast 작업을 시작합니다.:");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다. ");
		} else {	// 리스트에 원소가 있으면
			Student student = this.list().removeLast();	// 맨 뒤 원소를 지운다.
			if (student != null) {	// 원소를 지웠으면
				AppView.outputLine("! 삭제된 [맨 뒤] 학생의 성적은 (" + student.score() + ") 입니다.");
			} else {
				AppView.outputLine("! [맨 뒤] 학생을 삭제하는 작업을 실패하였습니다.");
			}
		}
	}

	private void removeAny() {	// 원소 제거
		AppView.outputLine("");
		AppView.outputLine("! RemoveAny 작업을 시작합니다.:");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어 있어서 삭제 작업을 할 수 없습니다. ");
		} else {	// 리스트에 원소가 있으면
			Student student = this.list().removeAny();	// 맨 뒤 원소를 지운다
			if (student != null) {	// 원소를 지웠으면
				AppView.outputLine("! 삭제된 [임의의] 학생의 성적은 (" + student.score() + ") 입니다.");
			} else {
				AppView.outputLine("! [임의의] 학생을 삭제하는 작업을 실패하였습니다.");
			}
		}
	}

	private void replaceAt() {	// 원소 교체
		AppView.outputLine("");
		AppView.outputLine("! ReplaceAt 작업을 시작합니다:)");
		if (this.list().isEmpty()) {	// 리스트가 비어있으면
			AppView.outputLine("! 리스트가 비어 있어서 바꾸기 작업을 할 수 없습니다.");
		} else {	// 리스트에 원소가 있으면
			int order = this.inputOrder();	// 순서 입력
			if (order < 0 || order >= this.list().size()) {	// 순서가 유효 범위에 있지 않으면
				AppView.outputLine("! 입력된 순서 [" + order + "]가 정상 범위 [0.." + (this.list().size() - 1) + "]에 있지 않습니다. ");
			} else {	// 순서가 유효 범위이면
				int score = this.inputOrder();	// 점수 입력
				if (this.list().replaceAt(new Student(score), order)) {
					AppView.outputLine("! 주어진 순서 [" + order + "]의 학생의 점수가 (" + score + ")로 바뀌었습니다.");
				} else {
					AppView.outputLine("! 주어진 순서 [" + order + "]의 학생의 점수를 바꾸는 작업을 실패하였습니다.");
				}
			}
		}
	}

}
