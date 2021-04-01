package _DS07_201701971_고도현;

public class Ban extends UnsortedArrayList<Student>{
	private static char scoreToGrade(int aScore) {	// 학점 계산
		if(aScore >= 90) {
			return 'A';
		}
		else if(aScore >= 80) {
			return 'B';
		}
		else if(aScore >= 70) {
			return 'C';
		}
		else if(aScore >= 60) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	
	public Ban() {
		super();
	}
	
	public Ban(int givenCapacity) {
		super(givenCapacity);
	}
	
	private Student lowestRecursively(int left, int right) {	// 최저 점수 계산
		if(left == right) {
			return this.elementAt(left);
		}
		else {
			Student lowestFromRights = lowestRecursively(left+1, right);
			if(lowestFromRights.compareTo(this.elementAt(left)) <= 0) {	// left의 값 >= (left+1)의 값 일 때
				return lowestFromRights;	// 재귀
			}
			else {	// left < (left+1)일 때
				return this.elementAt(left);	// left의 위치 return
			}
		}
	}
	
	public Student lowest() {
		if(this.isEmpty()) {
			return null;
			}
		else {
			return this.lowestRecursively(0,this.size()-1);
		}
	}

	private Student highestRecursively(int left, int right) {
		if(left == right) {	// 원소가 1개이면
			return this.elementAt(left);	// 그 값이 최대값
		}
		else {	// 원소가 2개 이상이면
			Student highestFromRights = highestRecursively(left+1, right);	// 재귀
			if(highestFromRights.compareTo(this.elementAt(left)) > 0) {	// left의 값 < (left+1)의 값 일 때
				return highestFromRights;	// 재귀
			}
			else {	// left의 값 >= (left+1)의 값 일 때
				return this.elementAt(left);	// left의 위치 return
			}
		}
	}
	
	public Student highest() {
		if(this.isEmpty()) {
			return null;
			}
		else {
			return this.highestRecursively(0,this.size()-1);
		}
	}
	
	private int sumOfScoresRecursively(int left, int right) {
		int mid = (left+right)/2;	// 구간을 나눈다.
		if(left == right) {	// 원소가 한 개일 경우
			return this.elementAt(left).score();	// 해당 위치의 원소가 점수의 합계
		}
		else {
			int leftSum = this.sumOfScoresRecursively(left, mid);	// 나눈 구간으로 재귀 시작
			int rightSum = this.sumOfScoresRecursively(mid+1, right);
			return (leftSum + rightSum);	// 왼쪽구간과 오른쪽구간의 합을 구한다.
		}
	}
	
	public int sum() {	// 합계
		if(this.isEmpty()) {	// 비어있으면
			return 0;
		}
		else {
			return this.sumOfScoresRecursively(0, this.size()-1);	// 0 ~ 배열의 끝까지 재귀함수로
		}
	}
	
	public double average() {	// 평균
		if(this.isEmpty()) {	// 비어있으면
			return 0;
		}
		else {
			return((double) this.sum())/((double) this.size());	// (합계 /학생 수)
		}
	}
	
	public int numberOfStudentsAboveAverage() {
		double average = this.average();
		int numberOfStudentsAboveAverage = 0;
		Iterator<Student> iterator = this.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.score()>= average) {
				numberOfStudentsAboveAverage++;
			}
		}
		return numberOfStudentsAboveAverage;
	}
	
	private void quicksortRecursively(int left, int right) {
		if(left<right) {	// 구간이 있으면
			int mid = this.partition(left, right);	// 구간 분할
			this.quicksortRecursively(left, mid-1);
			this.quicksortRecursively(mid+1, right);
		}
	}
	
	public void sortByScore() {
		if(this.size()>1) {
			int maxLoc = 0;
			for(int i = 1; i < this.size(); i++) {
				if(this.elementAt(i).score() > this.elementAt(maxLoc).score()) {	// 최대값 찾기
					maxLoc = i;	// maxLoc에 i값 저장
				}
			}
			this.swap(maxLoc, this.size() -1);
			this.quicksortRecursively(0, this.size()-2);
		}
	}
	
	private void swap(int p, int q) {	// 원소 위치 변경
		Student temp = this.elementAt(p);	// p 위치의 원소를 temp에 저장
		this.setElementAt(p, this.elementAt(q));	// p 위치의 원소를 q의 원소로 변경
		this.setElementAt(q, temp);	 // q 위치의 원소를 temp로 변경
	}
	
	private int partition(int left, int right) {	// 공간 분할
		int pivot = left;	// 기준점
		int toRight = left;		// 우측으로 옮길 원소
		int toLeft = right + 1;		// 좌측으로 옮길 원소
		do {
			do {toRight++;} while(this.elementAt(toRight).score() < this.elementAt(pivot).score());	// toRight가 기준점보다 작으면 이동 X
			do {toLeft--;} while (this.elementAt(toLeft).score() > this.elementAt(pivot).score());	// toLeft가 기준점보다 크면 이동 X
			if(toRight < toLeft) {	// toRight가 toleft보다 작으면
				this.swap(toRight, toLeft);	// 위치 변경
			}
		}while (toRight< toLeft);
		this.swap(left, toLeft);
		return toLeft;
	}
	
	public GradeCounter countGrades() {
		GradeCounter gradeCounter = new GradeCounter();
		
		Iterator<Student> iterator = this.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			char grade = Ban.scoreToGrade(student.score());
			gradeCounter.count(grade);
		}
		return gradeCounter;
	}
}
