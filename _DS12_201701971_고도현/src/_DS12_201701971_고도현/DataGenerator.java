package _DS12_201701971_고도현;

import java.util.Random;

public class DataGenerator {

	private DataGenerator() {
	}

	public static Integer[] ascendingList(int aSize) { // 오름차순 배열 생성
		Integer[] list = null; // 배열을 null로 초기화
		if (aSize > 0) {
			list = new Integer[aSize]; // aSize 크기의 배열을 저장
			for (int i = 0; i < aSize; i++) { // 오름차순으로 배열 생성
				list[i] = i;
			}
		}
		return list;
	}

	public static Integer[] descendingList(int aSize) { // 내림차순 배열 생성
		Integer[] list = null; // 배열을 null로 초기화
		int max = aSize - 1;
		if (aSize > 0) {
			list = new Integer[aSize]; // aSize 크기의 배열을 저장
			for (int i = 0; i < aSize; i++) { // 내림차순으로 배열 생성
				list[i] = max;
				max--;
			}
		}
		return list;
	}

	public static Integer[] randomList(int aSize) { // 무작위
		Integer[] list = null;
		if (aSize > 0) { // 일단은 오름차순으로 생성
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
			Random random = new Random();
			for (int i = 0; i < aSize; i++) { // list[i]를 무작위배열 list[r]과 맞바꾼다.
				int r = random.nextInt(aSize);
				Integer temp = list[i]; // 오름차순을 temp에 저장
				list[i] = list[r]; // 무작위를 list[i]에 저장
				list[r] = temp; // 오름차순을 list[r]에 저장
			}
		}
		return list;
	}

}
