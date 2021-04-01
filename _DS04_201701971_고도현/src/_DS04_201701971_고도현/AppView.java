package _DS04_201701971_����;

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

	public static int inputMenuNumber() {	// �޴� �Է� �޼ҵ�
		int inputNum;	// �޴��Է� ����
		System.out.print("? �����Ϸ��� �ϴ� �޴� ��ȣ�� �����Ͻÿ� (add : 1, remove : 2, research : 3, frequency : 4, exit : 9) : ");
		inputNum = scanner.nextInt(); // �Է�
		return inputNum;	// �Է��� ���� return�Ѵ�
	}
	
	public static int inputCapacityOfCoinBag() { // ������ �ִ� ũ�� �޼ҵ�
		int maxCoin; // �ִ�ũ�� ����
		System.out.print("? ���� ������ ũ��, �� ���濡 �� ������ �ִ� ������ �Է��Ͻÿ� : ");
		maxCoin = scanner.nextInt(); // �Է�
		return maxCoin; // �Է��� ���� return�Ѵ�
	}
	
	public static int inputCoinValue() { // ���� �Է� �޼ҵ�
		int inputCoin;	// ���� �� ����
		System.out.print("? ���� ���� �Է��Ͻÿ� : ");
		inputCoin = scanner.nextInt();	// �Է�
		return inputCoin; // �Է��� ���� return�Ѵ�
	}
}