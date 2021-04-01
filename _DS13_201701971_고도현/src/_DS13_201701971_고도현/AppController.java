package _DS13_201701971_고도현;

public class AppController {
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;
	private static final int VALID_MAX_LENGTH = 9;

	private Ban _ban; // 비공개 인스턴스 변수

	private Ban ban() { // getter
		return this._ban;
	}

	private void setBan(Ban newBan) {	// setter
		this._ban = newBan;
	}

	public AppController() { // 생성자
	}

	private static boolean scoreIsValid(int aScore) {	// 점수 유효범위
		return (aScore <= AppController.VALID_MAX_SCORE && aScore >= AppController.VALID_MIN_SCORE);
	}

	private static boolean studentIdIsValid(String id) {	// 학번 유효범위
		return ((id.length() >= VALID_MIN_SCORE) && (id.length() <= VALID_MAX_LENGTH));
	}

	private static DictionaryElement<String, Student> inputStudent() {	// 학번과 점수를 입력받는 메소드
		String id = AppView.inputId();
		int score = AppView.inputScore();
		if (AppController.studentIdIsValid(id)) { // 학번이 유효범위 이내면
			if (AppController.scoreIsValid(score)) { // 성적이 유효범위 이내면
				DictionaryElement<String, Student> studentInfo = new DictionaryElement<String, Student>();
				Student student = new Student();	// student 객체를 생성하고
				student.setScore(score);	// 점수 설정
				student.setId(id);	// 학번 설정
				studentInfo.setKey(id);	// id를 키로 갖는 studentInfo
				studentInfo.setObject(student);	// student를 object로 갖는 studentInfo
				return studentInfo;	// studentInfo 반환
			} else { // 성적이 유효범위가 아니면
				AppView.outputLine("(오류) 성적이 " + VALID_MIN_SCORE + "보다 작거나 " + AppController.VALID_MAX_SCORE
						+ "보다 커서, 정상적인 점수가 아닙니다.");
			}
		} else { // 학번이 유효범위가 아니면
			AppView.outputLine("(오류) 학번의 길이가 너무 깁니다. 최대 " + AppController.VALID_MAX_LENGTH + "입니다.");
		}
		return null;
	}

	private void inputAndStoreStudents() {	// 점수와 학번 삽입
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while (storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {	
			DictionaryElement<String, Student> studentInfo = AppController.inputStudent();	// 
			if (studentInfo != null) {	// 값이 입력되면
				this.ban().addKeyAndObject(studentInfo.key(), studentInfo.object());	// studentInfo의 key값과 object값을 트리에 넣어준다.
			}
			AppView.outputLine("");	// 줄바꿈
		}
		AppView.outputLine("! 성적 입력을 마칩니다.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[학생 목록]");
		Iterator<DictionaryElement<String, Student>> iterator = this.ban().iterator();	// DictionaryElement의 Iterator
		DictionaryElement<String, Student> student = null;
		while (iterator.hasNext()) {	// 다음 노드 값이 있으면
			student = iterator.next();
			AppView.outputLine("학번 : " + student.object().id() + ", 점수 : " + student.object().score());	// 학번과 점수 출력
		}
	}

	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[학습 성적 처리 결과]");

		AppView.outputTotalNumberOfStudents(this.ban().size());	// 전체 학생 수
		AppView.outputHighestScore(this.ban().highest().score());	// 최고 점수
		AppView.outputLowestScore(this.ban().lowest().score());	// 최저 점수
		AppView.outputAverageScore(this.ban().average());	// 평균 값
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());	// 평균 이상의 학생 수
	}

	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[학생들의 성적순 목록]");
		Student[] student = new Student[this.ban().size()];	// Student 객체를 선언
		char[] grade = new char[this.ban().size()];	// 학점을 담을 ban 객체 선언
		student = this.ban().studentsSortedByScore(); // 점수 정렬
		for (int i = this.ban().size() - 1; i >= 0; i--) {
			this.ban();
			grade[i] = Ban.scoreToGrade(student[i].score());
			AppView.outputStudentInfo(student[i].id(), student[i].score(), grade[i]);
		}
	}

	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 시작합니다. >>>");

		this.setBan(new Ban());
		this.inputAndStoreStudents();
		if (this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(오류) 입력된 성적이 없습니다.");
		} else {
			this.showStudentsSortedByScore();
			this.showStatistics();
			this.showGradeCounts();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 종료합니다. >>>");
	}
}
