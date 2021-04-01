package _DS07_201701971_����;

public class Student implements Comparable<Student> {
	private static final int DEFAULT_SCORE = 0; // ���

	private int _score; // �ν��Ͻ� ����

	public int score() { // getter
		return this._score;
	}

	public void setScore(int newScore) { // setter
		this._score = newScore;
	}

	public Student() { // �л��� ������ DEFAULT_SCORE�� �ʱ�ȭ�Ͽ� ��ü ����
		this.setScore(DEFAULT_SCORE);
	}

	public Student(int givenScore) { // �л��� ������ givenScore�� �ʱ�ȭ�Ͽ� ��ü ����
		this.setScore(givenScore);
	}

	@Override
	public int compareTo(Student other) {
		if (this.score() < other.score()) {	// other���� �� ũ�� -1
			return -1;
		} else if (this.score() == other.score()) {	// other���� ������ 0
			return 0;
		} else {	// other���� �� ������ 1
			return +1;
		}
	}

}
