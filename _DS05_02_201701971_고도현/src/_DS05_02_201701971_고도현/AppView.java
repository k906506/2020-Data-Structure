package _DS05_02_201701971_����;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);	// scanner ����
	
	private AppView() {	// ������ ����
		
	}
	
	public static void output(String message) {	// �޼��� ���
		System.out.print(message);
	}
	
	public static void outputLine(String message) {	// �޼��� �ٹٲ� ���
		System.out.println(message);
	}
	
	public static void outputDebugMessage (String message) {	// ���� ���
		System.out.println(message);
	}
	
	public static int inputInteger() throws NumberFormatException{	// ���� ó��
		return Integer.parseInt(AppView.scanner.next());
	}
	
	
}