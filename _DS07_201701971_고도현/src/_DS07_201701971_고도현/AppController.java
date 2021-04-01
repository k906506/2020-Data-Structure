package _DS07_201701971_고도현;

public class AppController {
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;

	private static final int BAN_CAPACITY = 10;

	private static boolean scoreIsValid(int aScore) {
		return (aScore <= AppController.VALID_MAX_SCORE && aScore >= AppController.VALID_MIN_SCORE);
	}

	private static Student inputStudent() {
		int score = AppView.inputScore();
		while (!AppController.scoreIsValid(score)) {
			AppView.outputLine("[오류] " + AppController.VALID_MIN_SCORE + " 보다 작거나 " + AppController.VALID_MAX_SCORE
					+ " 보다 커서, 정상적인 점수가 아닙니다.");
			score = AppView.inputScore();
		}
		Student student = new Student();
		student.setScore(score);
		return student;
	}

	private Ban _ban; // 비공개 인스턴스 변수
	private GradeCounter _gradeCounter;

	private Ban ban() {	// getter
		return this._ban;
	}

	private void setBan(Ban newBan) {	// setter
		this._ban = newBan;
	}

	private GradeCounter gradeCounter() {	// getter
		return this._gradeCounter;
	}

	private void setGradeCounter(GradeCounter newGradeCounter) {	// setter
		this._gradeCounter = newGradeCounter;
	}

	public AppController() {	// 생성자
	}

	private void inputAndStoreStudents() {
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while (storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {
			Student student = AppController.inputStudent();
			if (!this.ban().add(student)) {
				AppView.outputLine("(경고) 입력에 오류가 있습니다. 학급에 더이상 학생을 넣을 공간이 없습니다.");
				storingAStudentWasSuccessful = false;
			}
		}
		AppView.outputLine("! 성적 입력을 마칩니다.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[학급 성적 통계]");

		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}

	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[학점별 학생수]");

		this.setGradeCounter(this.ban().countGrades()); // ban 객체에게 학생들의 점수로부터 GradeCounter 객체를 생성하게 한다
		AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudentsForGrade('F', this.gradeCounter().numberOfF());
	}

	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[학생들의 성적순 목록]");

		this.ban().sortByScore(); // 점수 정렬

		Iterator<Student> iterator = this.ban().iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.outputScore(student.score());
		}
	}

	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 시작합니다. >>>");

		this.setBan(new Ban(AppController.BAN_CAPACITY));
		this.inputAndStoreStudents();
		if (this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(경고) 입력된 성적이 없습니다.");
		} else {
			this.showStudentsSortedByScore();
			this.showStatistics();
			this.showGradeCounts();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 종료합니다. >>>");
	}
}
