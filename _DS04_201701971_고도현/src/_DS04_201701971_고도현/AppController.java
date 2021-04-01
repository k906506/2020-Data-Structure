package _DS04_201701971_고도현;

public class AppController {
	private static final int MENU_ADD = 1; 	// 상수
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_END_OF_RUN = 9;
	private LinkedBag<Coin> _coinBag;

	private LinkedBag<Coin> coinBag() {	// 기본 생성자
		return this._coinBag;
	}

	private void setCoinBag(LinkedBag<Coin> newCoinBag) { 
		this._coinBag = newCoinBag; 
	}

	public AppController() {
	}

	public void run() {
		AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다. >>>");

		this.setCoinBag(new LinkedBag<Coin>());	// 객체 생성
		AppView.outputLine("");

		int menuNumber = AppView.inputMenuNumber();
		while (menuNumber != MENU_END_OF_RUN) { // 9가 아닐 경우
			switch (menuNumber) {
			case MENU_ADD: // 1 입력
				this.addCoin();
				break;
			case MENU_REMOVE:	// 2입력
				this.removeCoin();
				break;
			case MENU_SEARCH:	// 3입력
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:	// 4입력
				this.frequencyOfCoin();
				break;
			default:
				this.undefinedMenuNumber(menuNumber);
			}
			menuNumber = AppView.inputMenuNumber();
		}
		this.showStatistics(); //
		AppView.outputLine("<<< 동전 가방 프로그램을 종료합니다. >>>");
	}

	private void addCoin() {	// 동전을 추가하는 메소드
			int coinValue = AppView.inputCoinValue();
			if (this.coinBag().add(new Coin(coinValue))) {	// 입력받은 coinValue값을 가방 안에 추가한다
				AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 성공적으로 넣었습니다.");
			} else {
				AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 넣는데 실패하였습니다.");
			}
		AppView.outputLine("");	// 줄바꿈
	}

	private void removeCoin() {	// 동전을 제거하는 메소드
		int coinValue = AppView.inputCoinValue(); // 제거하고자 하는 동전 값을 입력받는다
		if (!this.coinBag().remove(new Coin(coinValue))) {	// 입력받은 coinValue값의 동전을 가방에서 제거한다
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방에 존재하지 않습니다.");
		} else {
			AppView.outputLine("- 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.");
		}
		AppView.outputLine("");	// 줄바꿈
	}

	private void searchForCoin() {	// 통전을 탐색하는 메소드 
		int coinValue = AppView.inputCoinValue();	// 탐색하고자 하는 동전 값을 입력받는다
		if (this.coinBag().doesContain(new Coin(coinValue))) {	// 입력받은 coinValue값의 동전을 탐색한다
			AppView.outputLine("- 주어진 값을 갖는 동전이 가방에 존재합니다.");
		} else {
			AppView.outputLine("- 주어진 값을 갖는 동전은  가방 안에 존재하지 않습니다.");
		}
		AppView.outputLine("");	// 줄바꿈
	}

	private void frequencyOfCoin() {	// 통전의 개수를 탐색하는 메소드
		int coinValue = AppView.inputCoinValue();	// 개수를 찾고싶은 동전 값을 입력받는다
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));	// 입력받은 coinValue값의 동전의 개수를 탐색한다
		AppView.outputLine("- 주어진 값을 갖는 동전의 개수는 " + frequency + "개 입니다.");
		AppView.outputLine("");	// 줄바꿈
	}

	private void undefinedMenuNumber(int menuNumber) { // 유효값을 입력하지 않았을 때
		AppView.outputLine("- 선택된 메뉴 번호 " + menuNumber + "는 잘못된 번호입니다.");
		AppView.outputLine("");

	}

	private int sumOfCoinValues() { // 동전의 합계 메소드
		int sum = 0;
		for (int i = 0; i < this.coinBag().size(); i++) { // 가방의 원소의 개수 만큼 반복문을 돌린다
			sum = sum + this.coinBag().elementAt(i).value(); // 저장한다
		}
		return sum;	// sum값 리턴
	}

	private int maxCoinValue() { // 동전의 최대값 메소드
		int maxValue = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {// 가방의 원소의 개수 만큼 반복문을 돌린다
			if (maxValue < this.coinBag().elementAt(i).value()) { // maxValue보다 크면
				maxValue = this.coinBag().elementAt(i).value();	//  maxValue에 대입한다
			}
		}
		return maxValue; // maxValue값 리턴
	}

	private void showStatistics() {
		AppView.outputLine("가방에 들어 있는 동전의 개수 : " + this.coinBag().size());
		AppView.outputLine("동전 중 가장 큰 값 : " + this.maxCoinValue());
		AppView.outputLine("모든 동전 값의 합 : " + this.sumOfCoinValues());
	}

}
