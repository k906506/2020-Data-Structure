package _DS04_201701971_����;

public class Coin {
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
	
	public boolean equals (Object otherCoin) {	// Coin�� �ݾ��� otherCoin�� ������ Ȯ���Ѵ�
		if(otherCoin.getClass() != Coin.class) {
			return false;	// �ٸ��� false
		}
		else {
			return (this.value()==((Coin)otherCoin).value()); // ������ Coin�� �ݾ� return
		}
	}
}