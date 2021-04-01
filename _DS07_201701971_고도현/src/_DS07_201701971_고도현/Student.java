package _DS07_201701971_고도현;

public class Student implements Comparable<Student> {
	private static final int DEFAULT_SCORE = 0; // 상수

	private int _score; // 인스턴스 변수

	public int score() { // getter
		return this._score;
	}

	public void setScore(int newScore) { // setter
		this._score = newScore;
	}

	public Student() { // 학생의 점수를 DEFAULT_SCORE로 초기화하여 객체 생성
		this.setScore(DEFAULT_SCORE);
	}

	public Student(int givenScore) { // 학생의 점수를 givenScore로 초기화하여 객체 생성
		this.setScore(givenScore);
	}

	@Override
	public int compareTo(Student other) {
		if (this.score() < other.score()) {	// other값이 더 크면 -1
			return -1;
		} else if (this.score() == other.score()) {	// other값과 같으면 0
			return 0;
		} else {	// other값이 더 작으면 1
			return +1;
		}
	}

}
