package _DS07_201701971_고도현;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);

	public AppView() { // 생성자
	}

	public static void output(String aMessage) {	// 그냥 출력
		System.out.print(aMessage);
	}

	public static void outputLine(String aMessage) {	// 줄바꿈 출력
		System.out.println(aMessage);
	}

	public static void outputNumberOfStudents(int aNumberOfStudents) { // 학급 학생 수 출력
		System.out.println("학급 학생 수 : " + aNumberOfStudents);
	}

	public static void outputHighestScore(int aScore) { // 학급 최고 점수 출력
		System.out.println("학급 최고 점수 : " + aScore);
	}

	public static void outputLowestScore(int aScore) { // 학급 최저 점수 출력
		System.out.println("학급 최저 점수 : " + aScore);
	}

	public static void outputAverageScore(double anAverageScore) { // 학급 평균 점수 출력
		System.out.println("학급 평균 : " + anAverageScore);
	}

	public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudents) { // 평균 이상 학생 수 출력
		System.out.println("평균 이상인 학생 수 : " + aNumberOfStudents);
	}

	public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) { // 학점별 학생 수 출력
		System.out.println(aGrade + " 학점의 학생 수는 " + aNumberOfStudents + " 입니다.");
	}

	public static void outputScore(int aScore) { // 학생의 점수 출력
		System.out.println("점수 : " + aScore);
	}

	public static int inputInt() throws NumberFormatException {
		return Integer.parseInt(AppView.scanner.nextLine());
	}

	public static int inputScore() {
		while (true) {
			try {
				AppView.outputLine("- 점수를 입력하시오 (0..100) : ");
				int score = AppView.inputInt();
				return score;
			} catch (NumberFormatException e) {
				AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
			}
		}
	}

	public static boolean doesContinueToInputStudent() { // 점수입력 진행 여부 메소드
		AppView.output("성적을 입력하려면 'Y' 또는 'y'를, 종료하려면 다른 아무 키나 치시오 : ");
		String line = null;
		do {
			line = AppView.scanner.nextLine(); // 첫 번째로 do구문을 실행하고
		} while (line.equals(null)); // null이 입력되면 do구문을 실행한다. ( null이 아닐 때까지 입력받는다.)
		char answer = line.charAt(0);
		return ((answer == 'Y') || (answer == 'y')); // return true;
	}

}
