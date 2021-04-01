package 마방진;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);	//scanner 선언
	
	private AppView() {	//생성자 없음
		
	}
	
	public static int inputOrder() {	//마방진 차수를 입력 받아 얻음.
		int inputNum;
		System.out.print(" ? 마방진 차수를 입력하시오. (음수를 입력하면 종료합니다.)");
		inputNum = scanner.nextInt();
		return inputNum;
	}
	
	public static void output(String message) {	//메세지 출력
		System.out.print(message);
	}
	
	public static void outputLine(String message) {	//메세지 출력(줄바꿈)
		System.out.println(message);
	}
	
	public static void outputTitleWithOrder(int order) {	//입력받은 차수 값 출력
		System.out.print("! Magic Square Board:Order " + order);
	}
	
	public static void outputRowNumber(int number) {	//행 출력.
		System.out.printf("[%3d]", number);
	}
	
	public static void outputCellValue(int value) {		//열 출력.
		System.out.printf("  %3d", value);
	}
}
