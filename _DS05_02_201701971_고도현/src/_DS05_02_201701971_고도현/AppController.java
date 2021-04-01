package _DS05_02_201701971_����;

public class AppController {

	private LinkedList<Student> _list;	// �ν��Ͻ� ����

	private LinkedList<Student> list() {	// getter
		return this._list;
	}

	private void setList(LinkedList<Student> newList) {		// setter
		this._list = newList;
	}

	public AppController() {	// ������
		this.setList(new LinkedList<Student>());
	}

	private void showMenu() {
		AppView.outputLine("> �ؾ� �� �۾��� ��ȣ�� �����ؾ� �մϴ�:");
		AppView.outputLine(" DoesContain=1, ElementAt=2, First=3, Last=4, OrderOf=5,");
		AppView.outputLine(" AddTo=6, AddToFirst=7, AddToLast=8, Add=9, ");
		AppView.outputLine(" RemoveFrom=10, RemoveFirst=11, RemoveLast=12, RemoveAny=13, ReplaceAt=14, EndOfRun=99");
		AppView.output("? �۾� ��ȣ�� �Է��Ͻÿ�: ");
	}

	private MainMenu selectMenu() {
		AppView.outputLine("");
		this.showList();
		this.showMenu();
		try {
			int selectedMenuNumber = AppView.inputInteger();
			MainMenu selectedMenuValue = MainMenu.value(selectedMenuNumber);
			if (selectedMenuValue == MainMenu.Error) {
				AppView.outputLine("!���� : �۾� ������ �߸��Ǿ����ϴ�. (�߸��� �޴� ��ȣ: " + selectedMenuNumber + ")");
			}
			return selectedMenuValue;
		} catch (NumberFormatException e) {
			AppView.outputLine("!���� : �Էµ� �޴� ��ȣ�� ���� ���ڰ� �ƴմϴ�. ");
			return MainMenu.Error;
		}
	}

	public void run() {
		AppView.outputLine("<<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("");

		MainMenu selectedMenuValue = this.selectMenu();
		while (selectedMenuValue != MainMenu.EndOfRun) {
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
			case Last:
				this.last();
				break;
			case OrderOf:
				this.orderOf();
				break;
			case AddTo:
				this.addTo();
				break;
			case AddToFirst:
				this.addToFirst();
				break;
			case AddToLast:
				this.addToLast();
				break;
			case Add:
				this.add();
				break;
			case RemoveFrom:
				this.removeFrom();
				break;
			case RemoveFirst:
				this.removeFirst();
				break;
			case RemoveLast:
				this.removeLast();
				break;
			case RemoveAny:
				this.removeAny();
				break;
			case ReplaceAt:
				this.replaceAt();
				break;
			default:
				break;
			}
			selectedMenuValue = this.selectMenu();
		}
		this.showStatistics();

		AppView.outputLine("");
		AppView.outputLine(" <<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ�. >>> ");
	}

	private void doesContain() {
		AppView.outputLine("");
		AppView.outputLine("! DoesContain �۾��� �����մϴ�:");
		int score = this.inputScore();
		if (this.list().doesContain(new Student(score))) {
			AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� ����Ʈ�� �����մϴ�.");
		} else {
			AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� ����Ʈ�� �������� �ʽ��ϴ�.");
		}
	}

	private void elementAt() {
		AppView.outputLine("");
		AppView.outputLine("! ElementAt �۾��� �����մϴ� :");
		int order = this.inputOrder();
		if (this.list().elementAt(order) != null) {
			AppView.outputLine("! �Էµ� ���� [" + order + "]�� �л��� ������ (" + this.list().elementAt(order).score() + ") �Դϴ�.");
		} else {
			AppView.outputLine("! �Էµ� ���� [" + order + "]�� �����ϴ� �л��� �����ϴ�.");
		}
	}

	private void first() {
		AppView.outputLine("");
		AppView.outputLine("! FirstElement �۾��� �����մϴ� :");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ����ֽ��ϴ�.");
		} else {
			Student student = this.list().first();
			AppView.outputLine("[�� ��] �л��� ������ (" + student.score() + ") �Դϴ�. ");
		}
	}

	private void last() {
		AppView.outputLine("");
		AppView.outputLine("! lastElement �۾��� �����մϴ� :");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ����ֽ��ϴ�.");
		} else {
			Student student = this.list().last();
			AppView.outputLine("[�� ��] �л��� ������ (" + student.score() + ") �Դϴ�. ");
		}
	}

	private void orderOf() {
		AppView.outputLine("");
		AppView.outputLine("! OrderOfElement �۾��� �����մϴ� :");
		int score = this.inputScore();
		if (this.list().orderOf(new Student(score)) != -1) {
			AppView.outputLine(
					"! �Էµ� ���� (" + score + ")�� �л��� ������ [" + this.list().orderOf(new Student(score)) + "] �Դϴ�.");
		} else {
			AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� ����Ʈ�� �������� �ʽ��ϴ�.");
		}
	}

	private void showList() {
		AppView.output("! ������ ����Ʈ ���ҵ�: [");
		Student student = null;
		Iterator<Student> iterator = this.list().iterator();
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.output(" " + student.score());
		}
		AppView.outputLine(" ]");
	}

	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("> ����Ʈ ���� �Դϴ�:");
		AppView.outputLine("! �л� �� : " + this.list().size());
		this.showList();
	}

	private int inputScore() {
		int score;
		while (true) {
			try {
				AppView.output("? ������ �Է��Ͻÿ�: ");
				score = AppView.inputInteger();
				return score;
			} catch (NumberFormatException e) {
				AppView.outputLine("[����] �Էµ� ������ ������ �ƴմϴ�. ");
			}
		}
	}

	private int inputOrder() {
		int score;
		while (true) {
			try {
				AppView.output("? ����Ʈ������ ���� ��ȣ�� �Է��Ͻÿ�: ");
				score = AppView.inputInteger();
				return score;
			} catch (NumberFormatException e) {
				AppView.outputLine("[����] �Էµ� ���� ��ȣ�� ������ �ƴմϴ�. ");
			}
		}
	}

	private void addTo() {
		AppView.outputLine("");
		AppView.outputLine("! AddTo �۾��� �����մϴ�.");
		if (this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {
			int order = this.inputOrder();
			if (order < 0 || order > this.list().size()) {
				AppView.outputLine("! �Էµ� ���� [" + order + "]�� ���� ���� [0.." + this.list().size() + "]�� ���� �ʽ��ϴ�.");
			} else {
				int score = this.inputScore();
				if (this.list().addTo(new Student(score), order)) {
					AppView.outputLine("! �Էµ� ���� [" + order + "]�� �Էµ� ���� (" + score + ")�� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				} else {
					AppView.outputLine("! �Էµ� ���� [" + order + "]�� �Էµ� ���� (" + score + ")�� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
		}
	}

	private void addToFirst() {
		AppView.outputLine("");
		AppView.outputLine("! AddToFirst �۾��� �����մϴ�:");
		if (this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {
			int score = this.inputScore();
			if (this.list().addToFirst(new Student(score))) {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����߽��ϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void addToLast() {
		AppView.outputLine("");
		AppView.outputLine("! AddToLast �۾��� �����մϴ�:");
		if (this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {
			int score = this.inputScore();
			if (this.list().addToLast(new Student(score))) {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����߽��ϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void add() {
		AppView.outputLine("");
		AppView.outputLine("! Add �۾��� �����մϴ�:");
		if (this.list().isFull()) {
			AppView.outputLine("! ����Ʈ�� �� �� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {
			int score = this.inputScore();
			if (this.list().add(new Student(score))) {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [������ ����]�� �����ϴ� �۾��� �����߽��ϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� (" + score + ")�� �л��� [������ ����]�� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeFrom() {
		AppView.outputLine("");
		AppView.outputLine("! RemoveFrom �۾��� �����մϴ�:");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�.");
		} else {
			int order = this.inputOrder();
			if (order < 0 || order >= this.list().size()) {
				AppView.outputLine("! �Էµ� ���� [" + order + "]�� ���� ���� [0.." + (this.list().size() - 1) + "]�� ���� �ʽ��ϴ�.");
			}
			Student student = this.list().removeFrom(order);
			
			if (student != null) {
				AppView.outputLine("! �Էµ� ���� [" + order + "]���� ������ �л��� ������ (" + student.score() + ")�Դϴ�.");
			} else {
				AppView.outputLine("! �Էµ� ���� [" + order + "]���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeFirst() {
		AppView.outputLine("");
		AppView.outputLine("! RemoveFirst �۾��� �����մϴ�.:");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�. ");
		} else {
			Student student = this.list().removeFirst();
			if (student != null) {
				AppView.outputLine("! ������ [�� ��] �л��� ������ (" + student.score() + ") �Դϴ�.");
			} else {
				AppView.outputLine("! [�� ��] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeLast() {
		AppView.outputLine("");
		AppView.outputLine("! RemoveLast �۾��� �����մϴ�.:");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�. ");
		} else {
			Student student = this.list().removeLast();
			if (student != null) {
				AppView.outputLine("! ������ [�� ��] �л��� ������ (" + student.score() + ") �Դϴ�.");
			} else {
				AppView.outputLine("! [�� ��] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void removeAny() {
		AppView.outputLine("");
		AppView.outputLine("! RemoveAny �۾��� �����մϴ�.:");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ ���� �۾��� �� �� �����ϴ�. ");
		} else {
			Student student = this.list().removeAny();
			if (student != null) {
				AppView.outputLine("! ������ [������] �л��� ������ (" + student.score() + ") �Դϴ�.");
			} else {
				AppView.outputLine("! [������] �л��� �����ϴ� �۾��� �����Ͽ����ϴ�.");
			}
		}
	}

	private void replaceAt() {
		AppView.outputLine("");
		AppView.outputLine("! ReplaceAt �۾��� �����մϴ�:)");
		if (this.list().isEmpty()) {
			AppView.outputLine("! ����Ʈ�� ��� �־ �ٲٱ� �۾��� �� �� �����ϴ�.");
		} else {
			int order = this.inputOrder();
			if (order < 0 || order >= this.list().size()) {
				AppView.outputLine("! �Էµ� ���� [" + order + "]�� ���� ���� [0.." + (this.list().size() - 1) + "]�� ���� �ʽ��ϴ�. ");
			} else {
				int score = this.inputOrder();
				if (this.list().replaceAt(new Student(score), order)) {
					AppView.outputLine("! �־��� ���� [" + order + "]�� �л��� ������ (" + score + ")�� �ٲ�����ϴ�.");
				} else {
					AppView.outputLine("! �־��� ���� [" + order + "]�� �л��� ������ �ٲٴ� �۾��� �����Ͽ����ϴ�.");
				}
			}
		}
	}

}
