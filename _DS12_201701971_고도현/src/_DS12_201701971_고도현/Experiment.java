package _DS12_201701971_고도현;

public class Experiment {
	private final ParameterSet _parameterSet;
	// Class의 함수에서 이 값을 변경할 수 없다.
	// 생성자 안에서만 값을 변경 가능하다.
	// 즉, 객체를 생성할 때 정해진 값을 그대로 유지한다.

	private ParameterSet parameterSet() {	// getter
		return this._parameterSet;
	}

	public Experiment(ParameterSet givenParameterSet) {	// setter
		this._parameterSet = givenParameterSet;
	}

	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize) { // 배열 복사
		Integer[] copiedList = null;	// 새로운 배열 copiedList를 생성 후 초기화
		if (copiedSize <= aList.length) {	
			copiedList = new Integer[copiedSize];	// copiedSize 크기
			for (int i = 0; i < copiedSize; i++) {	
				copiedList[i] = aList[i];	// copiedList에 aList 원소를 한개씩 복사
			}
		}
		return copiedList;
	}

	private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList) {	// 정렬 진행 시간
		Timer timer = new Timer(); // Timer 객체 생성
		timer.start();	// 	시작시각
		{
			aSort.sort(aList, aList.length);	// 정렬 진행
		}
		timer.stop();	// 종료시각
		return timer.duration();	// 종료시각 - 시작시각 = runtime
	}

	public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList) {
		int numberOfSteps = this.parameterSet().numberOfSizeIncreasingSteps();	// 실행할 측정 횟수
		long[] durations = new long[numberOfSteps];	

		int sortingSize = this.parameterSet().startingSize();	// 정렬 데이터의 시작 크기
		int incrementSize = this.parameterSet().incrementSize();	// 정렬 데이터 증가 크기

		for (int step = 0; step < numberOfSteps; step++) {
			Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize); // 측정에 사용할 데이터 리스트 복사
			durations[step] = this.durationOfSingleSort(aSort, listForSorting); // 측정하여 그 결과를 저장
			sortingSize += incrementSize; // 다음 단게의 정렬 데이터 크기를 얻음
		}
		return durations;
	}
}
