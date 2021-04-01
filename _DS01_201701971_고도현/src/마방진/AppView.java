package ������;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);	//scanner ����
	
	private AppView() {	//������ ����
		
	}
	
	public static int inputOrder() {	//������ ������ �Է� �޾� ����.
		int inputNum;
		System.out.print(" ? ������ ������ �Է��Ͻÿ�. (������ �Է��ϸ� �����մϴ�.)");
		inputNum = scanner.nextInt();
		return inputNum;
	}
	
	public static void output(String message) {	//�޼��� ���
		System.out.print(message);
	}
	
	public static void outputLine(String message) {	//�޼��� ���(�ٹٲ�)
		System.out.println(message);
	}
	
	public static void outputTitleWithOrder(int order) {	//�Է¹��� ���� �� ���
		System.out.print("! Magic Square Board:Order " + order);
	}
	
	public static void outputRowNumber(int number) {	//�� ���.
		System.out.printf("[%3d]", number);
	}
	
	public static void outputCellValue(int value) {		//�� ���.
		System.out.printf("  %3d", value);
	}
}
