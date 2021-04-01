package _DS09_201701971_����;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);	// scanner
	private static boolean debugMode = false;	// ����׸�� = false

	public AppView() {	// ������

	}

	public static boolean debugMode() {	// getter
		return debugMode;
	}

	public static void setDebugMode(boolean newDebugMode) {	// setter
		debugMode = newDebugMode;
	}

	public static void outputDebugMessage(String aMessage) {	// debug�� �޼��� ���
		if (AppView.debugMode()) {	// debug��尡 on(true)�̸�
			System.out.print(aMessage);	// aMessage ���
		}
	}

	public static void outputLineDebugMessage(String aMessage) {	// debug�� (�ٹٲ�)�޼��� ���
		if (AppView.debugMode()) {	// debug��尡 on(true)�̸�
			System.out.println(aMessage);	// aMessage ���
		}
	}

	public static void output(String aMessage) {	// �޼��� ���
		System.out.print(aMessage);	// aMessage ���
	}

	public static void outputLine(String aMessage) {	// �޼��� �ٹٲ� ���
		System.out.println(aMessage);	// aMessage ���
	}
	
	public static String inputLine() {
		String line = AppView.scanner.nextLine().trim();	// ������ ������ ���ڸ� ��´�.
		while(line.equals("")) {	// ��ĭ�̸�
			line = AppView.scanner.nextLine().trim();	// �ٽ� �Է� �޴´�
		}
		return line;	// ���ڸ� return
	}
}
