package _DS12_201701971_����;

public class AppController {
	private ExperimentManager _manager;	// ExperimentManager ��ü ����

	private ExperimentManager manager() {	// getter
		return this._manager;	
	}

	private void setManager(ExperimentManager newManager) {	// setter
		this._manager = newManager;
	}

	public AppController() {	// ������
		this.setManager(new ExperimentManager());
	}

	private void showTableTitle(ListOrder anOrder) {	// ���� ���
		AppView.outputLine(">" + anOrder.orderName() + " �����͸� ����Ͽ� ������ ���� : ");
	}

	private void showTableHead() {	// �޼��� ���
		AppView.outputLine(String.format("%8s", " ") + String.format("%16s", "<Insertion Sort>")
				+ String.format("%16s", "<Quick Sort>"));
	}

	private void showTableContent() {
		int startingSize = this.manager().parameterSet().startingSize();	// �ʱ� ��
		int incrementSize = this.manager().parameterSet().incrementSize();	// ������
		int numberOfSteps = this.manager().parameterSet().numberOfSizeIncreasingSteps();	// ������ ����

		for (int step = 0; step < numberOfSteps; step++) {	// numberOfStep��ŭ ���� ����
			int sortingSize = startingSize + (incrementSize * step);
			AppView.outputLine("[" + String.format("%5d", sortingSize) + "]"
					+ String.format("%16d", this.manager().measuredResultForInsertionSortAt(step))
					+ String.format("%16d", this.manager().measuredResultForQuickSortAt(step)));
		}
	}

	private void showResultTable(ListOrder anOrder) { // �־��� anOrder�� ���Ͽ�, ���� ���� ����� �����ش�.
		this.showTableTitle(anOrder);
		this.showTableHead();
		this.showTableContent();
		AppView.outputLine("");
	}

	private void measuredAndShowFor(ListOrder anOrder) {
		this.manager().performExperiment(anOrder);
		this.showResultTable(anOrder);
	}

	public void run() {
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("");
		{
			AppView.outputLine(">> 2���� ������ ���� �� : ����, �� <<");
			this.manager().prepareExperiment(null);
			// ExperimentManager ��ü���� ������ �غ��Ų��.
			// �̹� ���迡���� �Ű����� ������ �⺻ ���� ���� ����Ѵ�.
			// �⺻ ���� ���� ExperimentManager�� �����Ǿ� �ִ�.
			this.measuredAndShowFor(ListOrder.Ascending);	// �������� ����
			this.measuredAndShowFor(ListOrder.Descending);	// �������� ����
			this.measuredAndShowFor(ListOrder.Random);		// ������ ����
		}
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ�. >>>");
	}
}