package _DS08_201701971_고도현;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);

	public static void outputLine(String aMessage) { // 줄바꿈 출력
		System.out.println(aMessage);
	}

	public static void output(String aMessage) { // 그냥 출력
		System.out.print(aMessage);
	}

	public static char inputChar() { // 문자 입력
		String line = AppView.scanner.nextLine().trim(); // 문자열을 입력받는다. (trim은 앞뒤 공백을 없애준다.)
		while (line.equals("")) { // 문자열이 입력되지 않으면
			line = AppView.scanner.nextLine().trim();
		}
		return line.charAt(0); // 입력된 문자열 중의 첫번째 문자값 리턴
	}
}
