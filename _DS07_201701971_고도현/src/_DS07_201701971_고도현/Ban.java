package _DS07_201701971_����;

public class Ban extends UnsortedArrayList<Student>{
	private static char scoreToGrade(int aScore) {	// ���� ���
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
	
	private Student lowestRecursively(int left, int right) {	// ���� ���� ���
		if(left == right) {
			return this.elementAt(left);
		}
		else {
			Student lowestFromRights = lowestRecursively(left+1, right);
			if(lowestFromRights.compareTo(this.elementAt(left)) <= 0) {	// left�� �� >= (left+1)�� �� �� ��
				return lowestFromRights;	// ���
			}
			else {	// left < (left+1)�� ��
				return this.elementAt(left);	// left�� ��ġ return
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
		if(left == right) {	// ���Ұ� 1���̸�
			return this.elementAt(left);	// �� ���� �ִ밪
		}
		else {	// ���Ұ� 2�� �̻��̸�
			Student highestFromRights = highestRecursively(left+1, right);	// ���
			if(highestFromRights.compareTo(this.elementAt(left)) > 0) {	// left�� �� < (left+1)�� �� �� ��
				return highestFromRights;	// ���
			}
			else {	// left�� �� >= (left+1)�� �� �� ��
				return this.elementAt(left);	// left�� ��ġ return
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
		int mid = (left+right)/2;	// ������ ������.
		if(left == right) {	// ���Ұ� �� ���� ���
			return this.elementAt(left).score();	// �ش� ��ġ�� ���Ұ� ������ �հ�
		}
		else {
			int leftSum = this.sumOfScoresRecursively(left, mid);	// ���� �������� ��� ����
			int rightSum = this.sumOfScoresRecursively(mid+1, right);
			return (leftSum + rightSum);	// ���ʱ����� �����ʱ����� ���� ���Ѵ�.
		}
	}
	
	public int sum() {	// �հ�
		if(this.isEmpty()) {	// ���������
			return 0;
		}
		else {
			return this.sumOfScoresRecursively(0, this.size()-1);	// 0 ~ �迭�� ������ ����Լ���
		}
	}
	
	public double average() {	// ���
		if(this.isEmpty()) {	// ���������
			return 0;
		}
		else {
			return((double) this.sum())/((double) this.size());	// (�հ� /�л� ��)
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
		if(left<right) {	// ������ ������
			int mid = this.partition(left, right);	// ���� ����
			this.quicksortRecursively(left, mid-1);
			this.quicksortRecursively(mid+1, right);
		}
	}
	
	public void sortByScore() {
		if(this.size()>1) {
			int maxLoc = 0;
			for(int i = 1; i < this.size(); i++) {
				if(this.elementAt(i).score() > this.elementAt(maxLoc).score()) {	// �ִ밪 ã��
					maxLoc = i;	// maxLoc�� i�� ����
				}
			}
			this.swap(maxLoc, this.size() -1);
			this.quicksortRecursively(0, this.size()-2);
		}
	}
	
	private void swap(int p, int q) {	// ���� ��ġ ����
		Student temp = this.elementAt(p);	// p ��ġ�� ���Ҹ� temp�� ����
		this.setElementAt(p, this.elementAt(q));	// p ��ġ�� ���Ҹ� q�� ���ҷ� ����
		this.setElementAt(q, temp);	 // q ��ġ�� ���Ҹ� temp�� ����
	}
	
	private int partition(int left, int right) {	// ���� ����
		int pivot = left;	// ������
		int toRight = left;		// �������� �ű� ����
		int toLeft = right + 1;		// �������� �ű� ����
		do {
			do {toRight++;} while(this.elementAt(toRight).score() < this.elementAt(pivot).score());	// toRight�� ���������� ������ �̵� X
			do {toLeft--;} while (this.elementAt(toLeft).score() > this.elementAt(pivot).score());	// toLeft�� ���������� ũ�� �̵� X
			if(toRight < toLeft) {	// toRight�� toleft���� ������
				this.swap(toRight, toLeft);	// ��ġ ����
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
