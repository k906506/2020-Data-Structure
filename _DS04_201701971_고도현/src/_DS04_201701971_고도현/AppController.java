package _DS04_201701971_����;

public class AppController {
	private static final int MENU_ADD = 1; 	// ���
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_END_OF_RUN = 9;
	private LinkedBag<Coin> _coinBag;

	private LinkedBag<Coin> coinBag() {	// �⺻ ������
		return this._coinBag;
	}

	private void setCoinBag(LinkedBag<Coin> newCoinBag) { 
		this._coinBag = newCoinBag; 
	}

	public AppController() {
	}

	public void run() {
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>");

		this.setCoinBag(new LinkedBag<Coin>());	// ��ü ����
		AppView.outputLine("");

		int menuNumber = AppView.inputMenuNumber();
		while (menuNumber != MENU_END_OF_RUN) { // 9�� �ƴ� ���
			switch (menuNumber) {
			case MENU_ADD: // 1 �Է�
				this.addCoin();
				break;
			case MENU_REMOVE:	// 2�Է�
				this.removeCoin();
				break;
			case MENU_SEARCH:	// 3�Է�
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:	// 4�Է�
				this.frequencyOfCoin();
				break;
			default:
				this.undefinedMenuNumber(menuNumber);
			}
			menuNumber = AppView.inputMenuNumber();
		}
		this.showStatistics(); //
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>");
	}

	private void addCoin() {	// ������ �߰��ϴ� �޼ҵ�
			int coinValue = AppView.inputCoinValue();
			if (this.coinBag().add(new Coin(coinValue))) {	// �Է¹��� coinValue���� ���� �ȿ� �߰��Ѵ�
				AppView.outputLine("- �־��� ���� ���� ������ ���濡 ���������� �־����ϴ�.");
			} else {
				AppView.outputLine("- �־��� ���� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�.");
			}
		AppView.outputLine("");	// �ٹٲ�
	}

	private void removeCoin() {	// ������ �����ϴ� �޼ҵ�
		int coinValue = AppView.inputCoinValue(); // �����ϰ��� �ϴ� ���� ���� �Է¹޴´�
		if (!this.coinBag().remove(new Coin(coinValue))) {	// �Է¹��� coinValue���� ������ ���濡�� �����Ѵ�
			AppView.outputLine("- �־��� ���� ���� ������ ���濡 �������� �ʽ��ϴ�.");
		} else {
			AppView.outputLine("- �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�.");
		}
		AppView.outputLine("");	// �ٹٲ�
	}

	private void searchForCoin() {	// ������ Ž���ϴ� �޼ҵ� 
		int coinValue = AppView.inputCoinValue();	// Ž���ϰ��� �ϴ� ���� ���� �Է¹޴´�
		if (this.coinBag().doesContain(new Coin(coinValue))) {	// �Է¹��� coinValue���� ������ Ž���Ѵ�
			AppView.outputLine("- �־��� ���� ���� ������ ���濡 �����մϴ�.");
		} else {
			AppView.outputLine("- �־��� ���� ���� ������  ���� �ȿ� �������� �ʽ��ϴ�.");
		}
		AppView.outputLine("");	// �ٹٲ�
	}

	private void frequencyOfCoin() {	// ������ ������ Ž���ϴ� �޼ҵ�
		int coinValue = AppView.inputCoinValue();	// ������ ã����� ���� ���� �Է¹޴´�
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));	// �Է¹��� coinValue���� ������ ������ Ž���Ѵ�
		AppView.outputLine("- �־��� ���� ���� ������ ������ " + frequency + "�� �Դϴ�.");
		AppView.outputLine("");	// �ٹٲ�
	}

	private void undefinedMenuNumber(int menuNumber) { // ��ȿ���� �Է����� �ʾ��� ��
		AppView.outputLine("- ���õ� �޴� ��ȣ " + menuNumber + "�� �߸��� ��ȣ�Դϴ�.");
		AppView.outputLine("");

	}

	private int sumOfCoinValues() { // ������ �հ� �޼ҵ�
		int sum = 0;
		for (int i = 0; i < this.coinBag().size(); i++) { // ������ ������ ���� ��ŭ �ݺ����� ������
			sum = sum + this.coinBag().elementAt(i).value(); // �����Ѵ�
		}
		return sum;	// sum�� ����
	}

	private int maxCoinValue() { // ������ �ִ밪 �޼ҵ�
		int maxValue = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {// ������ ������ ���� ��ŭ �ݺ����� ������
			if (maxValue < this.coinBag().elementAt(i).value()) { // maxValue���� ũ��
				maxValue = this.coinBag().elementAt(i).value();	//  maxValue�� �����Ѵ�
			}
		}
		return maxValue; // maxValue�� ����
	}

	private void showStatistics() {
		AppView.outputLine("���濡 ��� �ִ� ������ ���� : " + this.coinBag().size());
		AppView.outputLine("���� �� ���� ū �� : " + this.maxCoinValue());
		AppView.outputLine("��� ���� ���� �� : " + this.sumOfCoinValues());
	}

}
