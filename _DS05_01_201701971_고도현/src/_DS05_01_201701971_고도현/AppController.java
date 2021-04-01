package _DS05_01_201701971_����;

public class AppController {
	private static final int LIST_CAPACITY = 100;	// maximum ��

	private ArrayList<Student> _list;	// �ν��Ͻ� ����

	private ArrayList<Student> list() {	// getter
		return this._list;
	}

	private void setList(ArrayList<Student> newList) {	// setter
		this._list = newList;
	}

	public AppController() { // ������
		this.setList(new ArrayList<Student>(AppController.LIST_CAPACITY));
	}

	private void showMenu() {	// showMenu
		AppView.outputLine("> �ؾ� �� �۾��� ��ȣ�� �����ؾ� �մϴ�:");
		AppView.outputLine(" DoesContain=1, ElementAt=2, First=3, Last=4, OrderOf=5,");
		AppView.outputLine(" AddTo=6, AddToFirst=7, AddToLast=8, Add=9, ");
		AppView.outputLine(" RemoveFrom=10, RemoveFirst=11, RemoveLast=12, RemoveAny=13, ReplaceAt=14, EndOfRun=99");
		AppView.output("? �۾� ��ȣ�� �Է��Ͻÿ�: ");
	}

	private MainMenu selectMenu() {
		AppView.outputLine("");
		this.showList();	// ����Ʈ ���
		this.showMenu();	// �޴� ���
		try {
			int selectedMenuNumber = AppView.inputInteger();	// �޴��� �Է� ���� �� selectedMenuNumber�� ����
			MainMenu selectedMenuValue = MainMenu.value(selectedMenuNumber);
			if (selectedMenuValue == MainMenu.Error) {	// selectedMenuValue�� error�� ���
				AppView.outputLine("!���� : �۾� ������ �߸��Ǿ����ϴ�. (�߸��� �޴� ��ȣ: " + selectedMenuNumber + ")");
			}
			return selectedMenuValue;	// selectedValue�� return
		} catch (NumberFormatException e) {
			AppView.outputLine("!���� : �Էµ� �޴� ��ȣ�� ���� ���ڰ� �ƴմϴ�. ");
			return MainMenu.Error;	// error��
		}
	}

	public void run() {
		AppView.outputLine("<<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("");

		MainMenu selectedMenuValue = this.selectMenu();	
		while (selectedMenuValue != MainMenu.EndOfRun) {	// selectedMenuValue�� EndOfRun�� �ƴϸ�
			switch (selectedMenuValue) {
			case DoesContain: // 1 �Է�
				this.doesContain();
				break;
			case ElementAt: // 2�Է�
				this.elementAt();
				break;
			case First: // 3�Է�
				this.first();
				break;
			case Last:	// 4�Է�
				this.last();
				break;
			case OrderOf:	// 5�Է�
				this.orderOf();
				break;
			case AddTo:	// 6�Է�
				this.addTo();
				break;
			case AddToFirst:	// 7�Է�
				this.addToFirst();
				break;
			case AddToLast:	// 8�Է�
				this.addToLast();
				break;
			case Add:	// 9�Է�
				this.add();
				break;
			case RemoveFrom:	// 10�Է�
				this.removeFrom();
				break;
			case RemoveFirst:	// 11�Է�
				this.removeFirst();
				break;
			case RemoveLast:	// 12�Է�
				this.removeLast();
				break;
			case RemoveAny:	// 13�Է�
				this.removeAny();
				break;
			case ReplaceAt:	// 14�Է�
				this.replaceAt();
				break;
			default:
				break;
			}
			selectedMenuValue = this.selectMenu();
		}
		this.showStatistics();	// ����Ʈ ���

		AppView.outputLine("");
		AppView.outputLine(" <<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ�. >>> ");
	}

	private void doesContain() {	// Ư�� ������ �л�
		AppView.outputLine("");
		AppView.outputLine("! DoesContain �۾��� �����մϴ�:");
		int score = this.inputScore();	// ���� �Է�
		if (this.list().doesContain(new Student(score))) {	// ����Ʈ ���� �ش� ���Ҹ� ã�´�
			AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� ����Ʈ�� �����մϴ�.");
		} else {
			AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� ����Ʈ�� �������� �ʽ��ϴ�.");
		}
	}

	private void elementAt() {	// Ư�� ������ �л��� ����
		AppView.outputLine("");
		AppView.outputLine("! ElementAt �۾��� �����մϴ� :");
		int order = this.inputOrder();	// ���� �Է�
		if (this.list().elementAt(order) != null) {	// ����Ʈ ���� ������ �˾Ƴ���.
			AppView.outputLine("! �Էµ� ���� [" + order + "]�� �л��� ������ (" + this.list().elementAt(order).score() + ") �Դϴ�.");
		} else {
			AppView.outputLine("! �Էµ� ���� [" + order + "]�� �����ϴ� �л��� �����ϴ�.");
		}
	}

	private void first() {	// �� �� ���� ���
		AppView.outputLine("");	
		AppView.outputLine("! FirstElement �۾��� �����մϴ� :");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ����ֽ��ϴ�.");
		} else {	// ����Ʈ�� ���Ұ� ������
			Student student = this.list().first(); // ����Ʈ�� �� �� ���� student��ü�� ����
			AppView.outputLine("[�� ��] �л��� ������ (" + student.score() + ") �Դϴ�. ");
		}
	}

	private void last() { // �� �� ���� ���
		AppView.outputLine("");
		AppView.outputLine("! lastElement �۾��� �����մϴ� :");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ����ֽ��ϴ�.");
		} else {	// ����Ʈ�� ���Ұ� ������
			Student student = this.list().last(); // ����Ʈ�� �� �� ���� student��ü�� ����
			AppView.outputLine("[�� ��] �л��� ������ (" + student.score() + ") �Դϴ�. ");
		}
	}

	private void orderOf() {	// ���� ���
		AppView.outputLine("");
		AppView.outputLine("! OrderOfElement �۾��� �����մϴ� :");
		int score = this.inputScore();	// ���� �Է�
		if (this.list().orderOf(new Student(score)) != -1) {	// orderOf�� ���� ���� -1�� �ƴ� ��(���Ұ� ������)
			AppView.outputLine(
					"! �Էµ� ���� (" + score + ")�� �л��� ������ [" + this.list().orderOf(new Student(score)) + "] �Դϴ�.");
		} else {
			AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� ����Ʈ�� �������� �ʽ��ϴ�.");
		}
	}

	private void showList() {	// ����Ʈ ���� ���� ���
		AppView.output("! ������ ����Ʈ ���ҵ�: [");
		Student student = null;
		Iterator<Student> iterator = this.list().iterator();
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.output(" " + student.score());
		}
		AppView.outputLine(" ]");
	}

	private void showStatistics() { // ����Ʈ�� ũ�� ���
		AppView.outputLine("");
		AppView.outputLine("> ����Ʈ ���� �Դϴ�:");
		AppView.outputLine("! �л� �� : " + this.list().size());
		this.showList();
	}

	private int inputScore() {	// �����Է� �޼ҵ�
		int score;	// ������ �ش��ϴ� ����
		while (true) {	// ���ѷ���
			try {
				AppView.output("? ������ �Է��Ͻÿ�: ");
				score = AppView.inputInteger();	// ���� �Է�
				return score;	// ���� return
			} catch (NumberFormatException e) {	// ���� ó��
				AppView.outputLine("[����] �Էµ� ������ ������ �ƴմϴ�. ");
			}
		}
	}

	private int inputOrder() {	// �����Է� �޼ҵ�
		int order;	// ������ �ش��ϴ� ����
		while (true) {
			try {
				AppView.output("? ����Ʈ������ ���� ��ȣ�� �Է��Ͻÿ�: ");
				order = AppView.inputInteger(); // ���� �Է�
				return order;	// ���� return
			} catch (NumberFormatException e) {	// ���� ó��
				AppView.outputLine("[����] �Էµ� ���� ��ȣ�� ������ �ƴմϴ�. ");
			}
		}
	}

	private void addTo() {	// ���� �߰�
		AppView.outputLine("");
		AppView.outputLine("! AddTo �۾��� �����մϴ�.");
		if (this.list().isFull()) {	// ����Ʈ�� ������ ������
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {	// ����Ʈ�� ������ ���� ��
			int order = this.inputOrder();	// ���� �Է�
			if (order < 0 || order > this.list().size()) { 	// ������ ���� ������ �ƴ� ��
				AppView.outputLine("! �Էµ� ���� [" + order + "]�� ���� ���� [0.." + this.list().size() + "]�� ���� �ʽ��ϴ�.");
			} else {	// ������ ���� �����϶�
				int score = this.inputScore();	// ���� �Է�
				if (this.list().addTo(new Student(score), order)) {	//  Student ȣ�� �� ������ ����
					AppView.outputLine("! �Էµ� ���� [" + order + "]�� �Էµ� ���� (" + score + ")�� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				} else {
					AppView.outputLine("! �Էµ� ���� [" + order + "]�� �Էµ� ���� (" + score + ")�� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
			} 
		}
	}

	private void addToFirst() {	// ���� �Ǿ� �߰�
		AppView.outputLine("");
		AppView.outputLine("! AddToFirst �۾��� �����մϴ�:");
		if (this.list().isFull()) {	// ����Ʈ�� ������ ������
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {	// ����Ʈ�� ������ ������
			int score = this.inputScore();	// ���� �Է�
			if (this.list().addToFirst(new Student(score))) {	// Student ȣ�� �� ���� ����
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����߽��ϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void addToLast() {	// ���� �ǵ� �߰�
		AppView.outputLine("");
		AppView.outputLine("! AddToLast �۾��� �����մϴ�:");
		if (this.list().isFull()) {	// ����Ʈ�� ������ ������
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {	// ����Ʈ�� ������ ������ 
			int score = this.inputScore();	// �����Է�
			if (this.list().addToLast(new Student(score))) { // Student ȣ�� �� ���� ����
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����߽��ϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void add() {	// ���� �߰�
		AppView.outputLine("");	
		AppView.outputLine("! Add �۾��� �����մϴ�:");
		if (this.list().isFull()) {	// ����Ʈ�� ������ ������
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {	// ����Ʈ�� ������ ������
			int score = this.inputScore();	// ���� �Է�
			if (this.list().add(new Student(score))) {	// Student ȣ�� �� ���� ����
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [������ ����]�� �����ϴ� �۾��� �����߽��ϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [������ ����]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeFrom() {	// ���� ����
		AppView.outputLine("");
		AppView.outputLine("! RemoveFrom �۾��� �����մϴ�:");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {	// ����Ʈ�� ���Ұ� ������
			int order = this.inputOrder();	// ���� �Է�
			if (order < 0 || order >= this.list().size()) {	// �Է°��� ��ȿ �����̸�
				AppView.outputLine("! �Էµ� ���� [" + order + "]�� ���� ���� [0.." + (this.list().size() - 1) + "]�� ���� �ʽ��ϴ�.");
			}
			Student student = this.list().removeFrom(order);	// Student ��ü�� ������ ���� ����
			
			if (student != null) {
				AppView.outputLine("! �Էµ� ���� [" + order + "]���� ������ �л��� ������ (" + student.score() + ")�Դϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� [" + order + "]���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeFirst() {	// ���� �Ǿ� ����
		AppView.outputLine("");
		AppView.outputLine("! RemoveFirst �۾��� �����մϴ�.:");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�. ");
		} else {	// ����Ʈ�� ���Ұ� ������
			Student student = this.list().removeFirst(); // �� �� ���Ҹ� �����
			if (student != null) { // ���Ҹ� ��������
				AppView.outputLine("! ������ [�� ��] �л��� ������ (" + student.score() + ") �Դϴ�.");
			} else {
				AppView.outputLine("! [�� ��] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeLast() {	// ���� �ǵ� ����
		AppView.outputLine("");
		AppView.outputLine("! RemoveLast �۾��� �����մϴ�.:");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�. ");
		} else {	// ����Ʈ�� ���Ұ� ������
			Student student = this.list().removeLast();	// �� �� ���Ҹ� �����.
			if (student != null) {	// ���Ҹ� ��������
				AppView.outputLine("! ������ [�� ��] �л��� ������ (" + student.score() + ") �Դϴ�.");
			} else {
				AppView.outputLine("! [�� ��] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeAny() {	// ���� ����
		AppView.outputLine("");
		AppView.outputLine("! RemoveAny �۾��� �����մϴ�.:");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�. ");
		} else {	// ����Ʈ�� ���Ұ� ������
			Student student = this.list().removeAny();	// �� �� ���Ҹ� �����
			if (student != null) {	// ���Ҹ� ��������
				AppView.outputLine("! ������ [������] �л��� ������ (" + student.score() + ") �Դϴ�.");
			} else {
				AppView.outputLine("! [������] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void replaceAt() {	// ���� ��ü
		AppView.outputLine("");
		AppView.outputLine("! ReplaceAt �۾��� �����մϴ�:)");
		if (this.list().isEmpty()) {	// ����Ʈ�� ���������
			AppView.outputLine("! ����Ʈ�� ��� �־ �ٲٱ� �۾��� �� �� �����ϴ�.");
		} else {	// ����Ʈ�� ���Ұ� ������
			int order = this.inputOrder();	// ���� �Է�
			if (order < 0 || order >= this.list().size()) {	// ������ ��ȿ ������ ���� ������
				AppView.outputLine("! �Էµ� ���� [" + order + "]�� ���� ���� [0.." + (this.list().size() - 1) + "]�� ���� �ʽ��ϴ�. ");
			} else {	// ������ ��ȿ �����̸�
				int score = this.inputOrder();	// ���� �Է�
				if (this.list().replaceAt(new Student(score), order)) {
					AppView.outputLine("! �־��� ���� [" + order + "]�� �л��� ������ (" + score + ")�� �ٲ�����ϴ�.");
				} else {
					AppView.outputLine("! �־��� ���� [" + order + "]�� �л��� ������ �ٲٴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
		}
	}

}
