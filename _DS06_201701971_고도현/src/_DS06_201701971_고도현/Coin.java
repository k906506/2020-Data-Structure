package _DS06_201701971_����;

public class Coin implements Comparable<Coin>{
		private static final int DEFALUT_VALUE = 0;
		
		private int _value;
		
		public Coin() {	// Coin ��ü�� �����Ѵ�
			this._value = DEFALUT_VALUE;
		}
		
		public Coin(int givenValue) {	// givenValue���� ���� Coin ��ü�� �����Ѵ�
			this._value = givenValue;
		}
		
		public int value() { // Coin�� �ݾ��� ��´�
			return this._value;
		}
		
		public void setValue(int newValue) { // Coin�� �ݾ��� newValue������ �����Ѵ�
			this._value = newValue;
		}
		
	@Override
	public int compareTo(Coin aCoin) {
		if(this.value() < aCoin.value()) {	// aCoin�� ���� �� ũ�� 
			return -1; // -1
		}
		else if(this.value() > aCoin.value()) {	// aCoin�� ���� �� ������
			return +1;	// 1
		}
		else {	// ������
			return 0;	// 0
		}
	}
}
