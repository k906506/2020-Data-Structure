package _DS06_201701971_고도현;

public class AppView {
	private AppView() {	// 생성자
	}

	public static void outputLine(String message) {	// 줄바꿈 메세지 출력
		System.out.println(message);
	}

	public static void output(String message) {	// 메세지 출력
		System.out.print(message);
	}
	
	public static void outputResults(int size, long durationForAdd, long durationForMax) {	// 결과 출력
		AppView.outputLine(
				"[크기: " + String.format("%5d", size) + "] " +
				"삽입: " + String.format("%8d", durationForAdd) + ", " +
				"최대값: " + String.format("%8d", durationForMax)
				);
	}
}
