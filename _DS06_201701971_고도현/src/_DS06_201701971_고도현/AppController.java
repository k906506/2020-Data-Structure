package _DS06_201701971_고도현;

public class AppController {
	private Experiment _experiment;	// 비공개 인스턴스 변수

	private Experiment experiment() {	// getter
		return this._experiment;
	}
	
	private void setExperiment(Experiment newExperiment) {	// setter
		this._experiment = newExperiment;
	}
	
	public AppController() {	// 생성자
		this.setExperiment(new Experiment());	// 실험 객체를 생성한다
		this.experiment().generateDate();	// 실험 객체에게 측정에 사용할 데이터를 생성하게 한다
	}
	
	public void run() {
		AppView.outputLine("<<< 리스트 성능 측정 프로그램을 시작합니다. >>>");
		AppView.outputLine("! 리스트의 구현에 따른 시간의 차이를 알아봅니다. (단위 : micro Second)");
		
		// Unsorted Array List에 대한 측정
		AppView.outputLine("");
		AppView.outputLine("<Unsorted Array List>");
		this.experiment().measureForUnsortedArrayList();	// 실험 객체에게 'Unsorted Array List'에 대한 성능 측정을 실행하게 한다.
		this.showExperimentResults();	// 실험 결과를 출력한다.
		
		// Sorted Array List에 대한 측정
		AppView.outputLine("");
		AppView.outputLine("<Sorted Array List>");
		this.experiment().measureForSortedArrayList();	// 실험 객체에게 'Sorted Array List'에 대한 성능 측정을 실행하게 한다.
		this.showExperimentResults();	// 실험 결과를 출력한다.
		
		// Unsorted Linked List에 대한 측정
		AppView.outputLine("");
		AppView.outputLine("<Unsorted Linked list>");
		this.experiment().measureForUnsortedLinkedList();	// 실험 객체에게 'Unsorted Linked List'에 대한 성능 측정을 실행하게 한다.
		this.showExperimentResults();	// 실험 결과를 출력한다.
		
		// Sorted Linked List에 대한 측정
		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		this.experiment().measureForSortedLinkedList();		// 실험 객체에게 'Sorted Linked List'에 대한 성능 측정을 실행하게 한다.
		this.showExperimentResults();	// 실험 결과를 출력한다.
		AppView.outputLine("");
		AppView.outputLine("<<< 리스트 성능 측정 프로그램을 종료합니다. >>> ");
	}
	
	private void showExperimentResults() {	// 실험 결과 출력
		MeasuredResult[] results = this.experiment().measuredResults();
		for (int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResults(results[i].size(), results[i].durationForAdd()/1000, results[i].durationForMax()/1000);
		}
	}
}
