package _DS05_02_201701971_고도현;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);	// scanner 선언
	
	private AppView() {	// 생성자 없음
		
	}
	
	public static void output(String message) {	// 메세지 출력
		System.out.print(message);
	}
	
	public static void outputLine(String message) {	// 메세지 줄바꿈 출력
		System.out.println(message);
	}
	
	public static void outputDebugMessage (String message) {	// 오류 출력
		System.out.println(message);
	}
	
	public static int inputInteger() throws NumberFormatException{	// 예외 처리
		return Integer.parseInt(AppView.scanner.next());
	}
	
	
}