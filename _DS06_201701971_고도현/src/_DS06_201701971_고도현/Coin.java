package _DS06_201701971_고도현;

public class Coin implements Comparable<Coin>{
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
		
	@Override
	public int compareTo(Coin aCoin) {
		if(this.value() < aCoin.value()) {	// aCoin의 값이 더 크면 
			return -1; // -1
		}
		else if(this.value() > aCoin.value()) {	// aCoin의 값이 더 작으면
			return +1;	// 1
		}
		else {	// 같으면
			return 0;	// 0
		}
	}
}
