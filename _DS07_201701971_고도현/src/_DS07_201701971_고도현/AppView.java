package _DS07_201701971_����;

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

	public static void outputNumberOfStudents(int aNumberOfStudents) { // �б� �л� �� ���
		System.out.println("�б� �л� �� : " + aNumberOfStudents);
	}

	public static void outputHighestScore(int aScore) { // �б� �ְ� ���� ���
		System.out.println("�б� �ְ� ���� : " + aScore);
	}

	public static void outputLowestScore(int aScore) { // �б� ���� ���� ���
		System.out.println("�б� ���� ���� : " + aScore);
	}

	public static void outputAverageScore(double anAverageScore) { // �б� ��� ���� ���
		System.out.println("�б� ��� : " + anAverageScore);
	}

	public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudents) { // ��� �̻� �л� �� ���
		System.out.println("��� �̻��� �л� �� : " + aNumberOfStudents);
	}

	public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) { // ������ �л� �� ���
		System.out.println(aGrade + " ������ �л� ���� " + aNumberOfStudents + " �Դϴ�.");
	}

	public static void outputScore(int aScore) { // �л��� ���� ���
		System.out.println("���� : " + aScore);
	}

	public static int inputInt() throws NumberFormatException {
		return Integer.parseInt(AppView.scanner.nextLine());
	}

	public static int inputScore() {
		while (true) {
			try {
				AppView.outputLine("- ������ �Է��Ͻÿ� (0..100) : ");
				int score = AppView.inputInt();
				return score;
			} catch (NumberFormatException e) {
				AppView.outputLine("(����) ������ �Էµ��� �ʾҽ��ϴ�.");
			}
		}
	}

	public static boolean doesContinueToInputStudent() { // �����Է� ���� ���� �޼ҵ�
		AppView.output("������ �Է��Ϸ��� 'Y' �Ǵ� 'y'��, �����Ϸ��� �ٸ� �ƹ� Ű�� ġ�ÿ� : ");
		String line = null;
		do {
			line = AppView.scanner.nextLine(); // ù ��°�� do������ �����ϰ�
		} while (line.equals(null)); // null�� �ԷµǸ� do������ �����Ѵ�. ( null�� �ƴ� ������ �Է¹޴´�.)
		char answer = line.charAt(0);
		return ((answer == 'Y') || (answer == 'y')); // return true;
	}

}
