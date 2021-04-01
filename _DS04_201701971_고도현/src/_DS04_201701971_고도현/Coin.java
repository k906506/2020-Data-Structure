package _DS04_201701971_고도현;

public class Coin {
	private static final int DEFALUT_VALUE = 0;
	
	private int _value;
	
	public Coin() {	// Coin 객체를 생성한다
		this._value = DEFALUT_VALUE;
	}
	
	public Coin(int givenValue) {	// givenValue값을 갖는 Coin 객체를 생성한다
		this._value = givenValue;
	}
	
	public int value() { // Coin의 금액을 얻는다
		return this._value;
	}
	
	public void setValue(int newValue) { // Coin의 금액을 newValue값으로 설정한다
		this._value = newValue;
	}
	
	public boolean equals (Object otherCoin) {	// Coin의 금액이 otherCoin과 같은지 확인한다
		if(otherCoin.getClass() != Coin.class) {
			return false;	// 다르면 false
		}
		else {
			return (this.value()==((Coin)otherCoin).value()); // 같으면 Coin의 금액 return
		}
	}
}