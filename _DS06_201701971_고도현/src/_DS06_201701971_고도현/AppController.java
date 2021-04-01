package _DS06_201701971_����;

public class AppController {
	private Experiment _experiment;	// ����� �ν��Ͻ� ����

	private Experiment experiment() {	// getter
		return this._experiment;
	}
	
	private void setExperiment(Experiment newExperiment) {	// setter
		this._experiment = newExperiment;
	}
	
	public AppController() {	// ������
		this.setExperiment(new Experiment());	// ���� ��ü�� �����Ѵ�
		this.experiment().generateDate();	// ���� ��ü���� ������ ����� �����͸� �����ϰ� �Ѵ�
	}
	
	public void run() {
		AppView.outputLine("<<< ����Ʈ ���� ���� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("! ����Ʈ�� ������ ���� �ð��� ���̸� �˾ƺ��ϴ�. (���� : micro Second)");
		
		// Unsorted Array List�� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<Unsorted Array List>");
		this.experiment().measureForUnsortedArrayList();	// ���� ��ü���� 'Unsorted Array List'�� ���� ���� ������ �����ϰ� �Ѵ�.
		this.showExperimentResults();	// ���� ����� ����Ѵ�.
		
		// Sorted Array List�� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<Sorted Array List>");
		this.experiment().measureForSortedArrayList();	// ���� ��ü���� 'Sorted Array List'�� ���� ���� ������ �����ϰ� �Ѵ�.
		this.showExperimentResults();	// ���� ����� ����Ѵ�.
		
		// Unsorted Linked List�� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<Unsorted Linked list>");
		this.experiment().measureForUnsortedLinkedList();	// ���� ��ü���� 'Unsorted Linked List'�� ���� ���� ������ �����ϰ� �Ѵ�.
		this.showExperimentResults();	// ���� ����� ����Ѵ�.
		
		// Sorted Linked List�� ���� ����
		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		this.experiment().measureForSortedLinkedList();		// ���� ��ü���� 'Sorted Linked List'�� ���� ���� ������ �����ϰ� �Ѵ�.
		this.showExperimentResults();	// ���� ����� ����Ѵ�.
		AppView.outputLine("");
		AppView.outputLine("<<< ����Ʈ ���� ���� ���α׷��� �����մϴ�. >>> ");
	}
	
	private void showExperimentResults() {	// ���� ��� ���
		MeasuredResult[] results = this.experiment().measuredResults();
		for (int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResults(results[i].size(), results[i].durationForAdd()/1000, results[i].durationForMax()/1000);
		}
	}
}
