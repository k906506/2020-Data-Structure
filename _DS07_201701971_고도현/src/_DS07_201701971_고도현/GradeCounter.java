package _DS07_201701971_����;

public class GradeCounter {
	private int _numberOfA;		// ����� �ν��Ͻ� ����
	private int _numberOfB;		// ����� �ν��Ͻ� ����
	private int _numberOfC;		// ����� �ν��Ͻ� ����
	private int _numberOfD;		// ����� �ν��Ͻ� ����
	private int _numberOfF;		// ����� �ν��Ͻ� ����

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

	public GradeCounter() {	// ������
		this.setNumberOfA(0);
		this.setNumberOfB(0);
		this.setNumberOfC(0);
		this.setNumberOfD(0);
		this.setNumberOfF(0);
	}

	public void count(char aGrade) {	// ������ �л� ��
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
