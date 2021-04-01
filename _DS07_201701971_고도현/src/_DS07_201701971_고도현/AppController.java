package _DS07_201701971_����;

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
			AppView.outputLine("[����] " + AppController.VALID_MIN_SCORE + " ���� �۰ų� " + AppController.VALID_MAX_SCORE
					+ " ���� Ŀ��, �������� ������ �ƴմϴ�.");
			score = AppView.inputScore();
		}
		Student student = new Student();
		student.setScore(score);
		return student;
	}

	private Ban _ban; // ����� �ν��Ͻ� ����
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

	public AppController() {	// ������
	}

	private void inputAndStoreStudents() {
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while (storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {
			Student student = AppController.inputStudent();
			if (!this.ban().add(student)) {
				AppView.outputLine("(���) �Է¿� ������ �ֽ��ϴ�. �б޿� ���̻� �л��� ���� ������ �����ϴ�.");
				storingAStudentWasSuccessful = false;
			}
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�б� ���� ���]");

		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}

	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[������ �л���]");

		this.setGradeCounter(this.ban().countGrades()); // ban ��ü���� �л����� �����κ��� GradeCounter ��ü�� �����ϰ� �Ѵ�
		AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudentsForGrade('F', this.gradeCounter().numberOfF());
	}

	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���]");

		this.ban().sortByScore(); // ���� ����

		Iterator<Student> iterator = this.ban().iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.outputScore(student.score());
		}
	}

	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");

		this.setBan(new Ban(AppController.BAN_CAPACITY));
		this.inputAndStoreStudents();
		if (this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(���) �Էµ� ������ �����ϴ�.");
		} else {
			this.showStudentsSortedByScore();
			this.showStatistics();
			this.showGradeCounts();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");
	}
}
