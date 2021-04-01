package _DS10_02_201701971_고도현;

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

	public static char inputLine() {
		String line = AppView.scanner.nextLine().trim();	// 공백을 제거한 문자를 얻는다.
		while(line.equals("")) {	// 빈칸이면
			line = AppView.scanner.nextLine().trim();	// 다시 입력 받는다
		}
		return line.charAt(0);	// 문자를 return
	}

}
