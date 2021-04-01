package _DS04_201701971_고도현;

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

	public static int inputMenuNumber() {	// 메뉴 입력 메소드
		int inputNum;	// 메뉴입력 변수
		System.out.print("? 수행하려고 하는 메뉴 번호를 선택하시오 (add : 1, remove : 2, research : 3, frequency : 4, exit : 9) : ");
		inputNum = scanner.nextInt(); // 입력
		return inputNum;	// 입력한 값을 return한다
	}
	
	public static int inputCapacityOfCoinBag() { // 가방의 최대 크기 메소드
		int maxCoin; // 최대크기 변수
		System.out.print("? 동전 가방의 크기, 즉 가방에 들어갈 동전의 최대 개수를 입력하시오 : ");
		maxCoin = scanner.nextInt(); // 입력
		return maxCoin; // 입력한 값을 return한다
	}
	
	public static int inputCoinValue() { // 동전 입력 메소드
		int inputCoin;	// 동전 값 변수
		System.out.print("? 동전 값을 입력하시오 : ");
		inputCoin = scanner.nextInt();	// 입력
		return inputCoin; // 입력한 값을 return한다
	}
}