package _DS08_201701971_����;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);

	public static void outputLine(String aMessage) { // �ٹٲ� ���
		System.out.println(aMessage);
	}

	public static void output(String aMessage) { // �׳� ���
		System.out.print(aMessage);
	}

	public static char inputChar() { // ���� �Է�
		String line = AppView.scanner.nextLine().trim(); // ���ڿ��� �Է¹޴´�. (trim�� �յ� ������ �����ش�.)
		while (line.equals("")) { // ���ڿ��� �Էµ��� ������
			line = AppView.scanner.nextLine().trim();
		}
		return line.charAt(0); // �Էµ� ���ڿ� ���� ù��° ���ڰ� ����
	}
}
