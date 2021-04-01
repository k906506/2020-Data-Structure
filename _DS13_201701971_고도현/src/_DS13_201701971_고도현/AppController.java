package _DS13_201701971_����;

public class AppController {
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;
	private static final int VALID_MAX_LENGTH = 9;

	private Ban _ban; // ����� �ν��Ͻ� ����

	private Ban ban() { // getter
		return this._ban;
	}

	private void setBan(Ban newBan) {	// setter
		this._ban = newBan;
	}

	public AppController() { // ������
	}

	private static boolean scoreIsValid(int aScore) {	// ���� ��ȿ����
		return (aScore <= AppController.VALID_MAX_SCORE && aScore >= AppController.VALID_MIN_SCORE);
	}

	private static boolean studentIdIsValid(String id) {	// �й� ��ȿ����
		return ((id.length() >= VALID_MIN_SCORE) && (id.length() <= VALID_MAX_LENGTH));
	}

	private static DictionaryElement<String, Student> inputStudent() {	// �й��� ������ �Է¹޴� �޼ҵ�
		String id = AppView.inputId();
		int score = AppView.inputScore();
		if (AppController.studentIdIsValid(id)) { // �й��� ��ȿ���� �̳���
			if (AppController.scoreIsValid(score)) { // ������ ��ȿ���� �̳���
				DictionaryElement<String, Student> studentInfo = new DictionaryElement<String, Student>();
				Student student = new Student();	// student ��ü�� �����ϰ�
				student.setScore(score);	// ���� ����
				student.setId(id);	// �й� ����
				studentInfo.setKey(id);	// id�� Ű�� ���� studentInfo
				studentInfo.setObject(student);	// student�� object�� ���� studentInfo
				return studentInfo;	// studentInfo ��ȯ
			} else { // ������ ��ȿ������ �ƴϸ�
				AppView.outputLine("(����) ������ " + VALID_MIN_SCORE + "���� �۰ų� " + AppController.VALID_MAX_SCORE
						+ "���� Ŀ��, �������� ������ �ƴմϴ�.");
			}
		} else { // �й��� ��ȿ������ �ƴϸ�
			AppView.outputLine("(����) �й��� ���̰� �ʹ� ��ϴ�. �ִ� " + AppController.VALID_MAX_LENGTH + "�Դϴ�.");
		}
		return null;
	}

	private void inputAndStoreStudents() {	// ������ �й� ����
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while (storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {	
			DictionaryElement<String, Student> studentInfo = AppController.inputStudent();	// 
			if (studentInfo != null) {	// ���� �ԷµǸ�
				this.ban().addKeyAndObject(studentInfo.key(), studentInfo.object());	// studentInfo�� key���� object���� Ʈ���� �־��ش�.
			}
			AppView.outputLine("");	// �ٹٲ�
		}
		AppView.outputLine("! ���� �Է��� ��Ĩ�ϴ�.");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[�л� ���]");
		Iterator<DictionaryElement<String, Student>> iterator = this.ban().iterator();	// DictionaryElement�� Iterator
		DictionaryElement<String, Student> student = null;
		while (iterator.hasNext()) {	// ���� ��� ���� ������
			student = iterator.next();
			AppView.outputLine("�й� : " + student.object().id() + ", ���� : " + student.object().score());	// �й��� ���� ���
		}
	}

	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[�н� ���� ó�� ���]");

		AppView.outputTotalNumberOfStudents(this.ban().size());	// ��ü �л� ��
		AppView.outputHighestScore(this.ban().highest().score());	// �ְ� ����
		AppView.outputLowestScore(this.ban().lowest().score());	// ���� ����
		AppView.outputAverageScore(this.ban().average());	// ��� ��
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());	// ��� �̻��� �л� ��
	}

	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[�л����� ������ ���]");
		Student[] student = new Student[this.ban().size()];	// Student ��ü�� ����
		char[] grade = new char[this.ban().size()];	// ������ ���� ban ��ü ����
		student = this.ban().studentsSortedByScore(); // ���� ����
		for (int i = this.ban().size() - 1; i >= 0; i--) {
			this.ban();
			grade[i] = Ban.scoreToGrade(student[i].score());
			AppView.outputStudentInfo(student[i].id(), student[i].score(), grade[i]);
		}
	}

	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");

		this.setBan(new Ban());
		this.inputAndStoreStudents();
		if (this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(����) �Էµ� ������ �����ϴ�.");
		} else {
			this.showStudentsSortedByScore();
			this.showStatistics();
			this.showGradeCounts();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< �б� ���� ó���� �����մϴ�. >>>");
	}
}
