package _DS05_01_201701971_고도현;

public class Student {
	private static final int DEFAULT_SCORE = 0;
	
	private int _score;	// 인스턴스 변수
	
	public int score() {	// getter
		return this._score;
	}
	public void setScore(int newScore) {	// setter
		this._score = newScore;
	}
	
	public Student() {	// 생성자
		this.setScore(Student.DEFAULT_SCORE);
	}
	
	public Student(int givenScore) { // 생성자
		this.setScore(givenScore);
	}
	
	@Override
	public boolean equals(Object aStudent) {	// 객체값 비교 
		if (aStudent.getClass() != Student.class) {
			return false;
		}
		else {
			return (this.score() == ((Student)aStudent).score());
		}
	}

}
