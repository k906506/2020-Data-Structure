package _DS12_201701971_����;

import java.util.Random;

public class DataGenerator {

	private DataGenerator() {
	}

	public static Integer[] ascendingList(int aSize) { // �������� �迭 ����
		Integer[] list = null; // �迭�� null�� �ʱ�ȭ
		if (aSize > 0) {
			list = new Integer[aSize]; // aSize ũ���� �迭�� ����
			for (int i = 0; i < aSize; i++) { // ������������ �迭 ����
				list[i] = i;
			}
		}
		return list;
	}

	public static Integer[] descendingList(int aSize) { // �������� �迭 ����
		Integer[] list = null; // �迭�� null�� �ʱ�ȭ
		int max = aSize - 1;
		if (aSize > 0) {
			list = new Integer[aSize]; // aSize ũ���� �迭�� ����
			for (int i = 0; i < aSize; i++) { // ������������ �迭 ����
				list[i] = max;
				max--;
			}
		}
		return list;
	}

	public static Integer[] randomList(int aSize) { // ������
		Integer[] list = null;
		if (aSize > 0) { // �ϴ��� ������������ ����
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
			Random random = new Random();
			for (int i = 0; i < aSize; i++) { // list[i]�� �������迭 list[r]�� �¹ٲ۴�.
				int r = random.nextInt(aSize);
				Integer temp = list[i]; // ���������� temp�� ����
				list[i] = list[r]; // �������� list[i]�� ����
				list[r] = temp; // ���������� list[r]�� ����
			}
		}
		return list;
	}

}
