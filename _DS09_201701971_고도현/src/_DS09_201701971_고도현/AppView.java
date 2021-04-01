package _DS09_201701971_고도현;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);	// scanner
	private static boolean debugMode = false;	// 디버그모드 = false

	public AppView() {	// 생성자

	}

	public static boolean debugMode() {	// getter
		return debugMode;
	}

	public static void setDebugMode(boolean newDebugMode) {	// setter
		debugMode = newDebugMode;
	}

	public static void outputDebugMessage(String aMessage) {	// debug용 메세지 출력
		if (AppView.debugMode()) {	// debug모드가 on(true)이면
			System.out.print(aMessage);	// aMessage 출력
		}
	}

	public static void outputLineDebugMessage(String aMessage) {	// debug용 (줄바꿈)메세지 출력
		if (AppView.debugMode()) {	// debug모드가 on(true)이면
			System.out.println(aMessage);	// aMessage 출력
		}
	}

	public static void output(String aMessage) {	// 메세지 출력
		System.out.print(aMessage);	// aMessage 출력
	}

	public static void outputLine(String aMessage) {	// 메세지 줄바꿈 출력
		System.out.println(aMessage);	// aMessage 출력
	}
	
	public static String inputLine() {
		String line = AppView.scanner.nextLine().trim();	// 공백을 제거한 문자를 얻는다.
		while(line.equals("")) {	// 빈칸이면
			line = AppView.scanner.nextLine().trim();	// 다시 입력 받는다
		}
		return line;	// 문자를 return
	}
}
