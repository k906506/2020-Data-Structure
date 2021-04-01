package _DS07_201701971_고도현;

public class GradeCounter {
	private int _numberOfA;		// 비공개 인스턴스 변수
	private int _numberOfB;		// 비공개 인스턴스 변수
	private int _numberOfC;		// 비공개 인스턴스 변수
	private int _numberOfD;		// 비공개 인스턴스 변수
	private int _numberOfF;		// 비공개 인스턴스 변수

	public int numberOfA() {	// getter
		return this._numberOfA;
	}

	public int numberOfB() {	// getter
		return this._numberOfB;
	}

	public int numberOfC() {	// getter
		return this._numberOfC;
	}

	public int numberOfD() {	// getter
		return this._numberOfD;
	}

	public int numberOfF() {	// getter
		return this._numberOfF;
	}

	private void setNumberOfA(int newNumberOfA) {	// setter
		this._numberOfA = newNumberOfA;
	}

	private void setNumberOfB(int newNumberOfB) {	// setter
		this._numberOfB = newNumberOfB;
	}

	private void setNumberOfC(int newNumberOfC) {	// setter
		this._numberOfC = newNumberOfC;
	}

	private void setNumberOfD(int newNumberOfD) {	// setter
		this._numberOfD = newNumberOfD;
	}

	private void setNumberOfF(int newNumberOfF) {	// setter
		this._numberOfF = newNumberOfF;
	}

	public GradeCounter() {	// 생성자
		this.setNumberOfA(0);
		this.setNumberOfB(0);
		this.setNumberOfC(0);
		this.setNumberOfD(0);
		this.setNumberOfF(0);
	}

	public void count(char aGrade) {	// 학점별 학생 수
		switch (aGrade) {
		case 'A':
			this.setNumberOfA(this.numberOfA() + 1);	// +1
			break;

		case 'B':
			this.setNumberOfB(this.numberOfB() + 1);	// +1
			break;

		case 'C':
			this.setNumberOfC(this.numberOfC() + 1);	// +1
			break;

		case 'D':
			this.setNumberOfD(this.numberOfD() + 1);	// +1
			break;

		case 'F':
			this.setNumberOfF(this.numberOfF() + 1);	// +1
			break;
		}
	}

}
