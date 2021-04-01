package _DS05_01_201701971_����;

public class Student {
	private static final int DEFAULT_SCORE = 0;
	
	private int _score;	// �ν��Ͻ� ����
	
	public int score() {	// getter
		return this._score;
	}
	public void setScore(int newScore) {	// setter
		this._score = newScore;
	}
	
	public Student() {	// ������
		this.setScore(Student.DEFAULT_SCORE);
	}
	
	public Student(int givenScore) { // ������
		this.setScore(givenScore);
	}
	
	@Override
	public boolean equals(Object aStudent) {	// ��ü�� �� 
		if (aStudent.getClass() != Student.class) {
			return false;
		}
		else {
			return (this.score() == ((Student)aStudent).score());
		}
	}

}
