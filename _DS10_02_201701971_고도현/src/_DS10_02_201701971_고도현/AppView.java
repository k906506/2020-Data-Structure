package _DS10_02_201701971_����;

import java.util.Scanner;

public class AppView {

	private static Scanner scanner = new Scanner(System.in);

	public AppView() { // ������
	}

	public static void output(String aMessage) {	// �׳� ���
		System.out.print(aMessage);
	}

	public static void outputLine(String aMessage) {	// �ٹٲ� ���
		System.out.println(aMessage);
	}

	public static char inputLine() {
		String line = AppView.scanner.nextLine().trim();	// ������ ������ ���ڸ� ��´�.
		while(line.equals("")) {	// ��ĭ�̸�
			line = AppView.scanner.nextLine().trim();	// �ٽ� �Է� �޴´�
		}
		return line.charAt(0);	// ���ڸ� return
	}

}
