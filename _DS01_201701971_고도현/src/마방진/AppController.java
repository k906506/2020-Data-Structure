package 마방진;

import 마방진.Enum.OrderValidity;

public class AppController {	//공개상수
	public static final int MIN_ORDER = 3;	//최솟값
	public static final int MAX_ORDER = 99;	//최댓값
	
	private MagicSquare _magicSquare;	//비공개변수
	
	public AppController() {	//생성자
		this._magicSquare = new MagicSquare(AppController.MAX_ORDER);
	}
	
	private void showOrderValidityErrorMessage(OrderValidity orderValidity) {	//오류일때 출력
		switch (orderValidity) {
		case TooSmall:	//orderValidity의 TooSmall에 해당될 때
			AppView.outputLine(
					"[오류] 차수가 너무 작습니다." + AppController.MIN_ORDER + "보다 크거나 같아야 합니다.");
			break;
		case TooLarge:	//orderValidity의 TooLarge에 해당될 때
			AppView.outputLine(
					"[오류] 차수가 너무 큽니다." + AppController.MAX_ORDER + "보다 작거나 같아야 합니다.");
			break;
		case NotOddNumber:	//orderValidity의 NotOddNumber에 해당될 때
			AppView.outputLine(
					"[오류] 차수가 짝수입니다. 홀수이어야 합니다.");
			break;
			default:
				break;
		}
	}
	
	private void showBoard (Board board) {
		CellLocation currentLoc = new CellLocation();	//currentLoc 객체 생성
		this.showTitleForColumnIndexes(board.order());
		for(int row = 0; row < board.order(); row++) {
			AppView.outputRowNumber(row);
			for(int col = 0; col < board.order(); col++) {
				currentLoc.setRow(row);	//currentLoc에 row값 부여
				currentLoc.setCol(col);	//currentLoc에 col값 부여
				AppView.outputCellValue(board.cellValue(currentLoc)); //부여된 row,col값을 출력
			}
			AppView.outputLine("");	//마방진 판 내부에서 행 줄바꿈
		}
		AppView.outputLine("");	//마방진 판 출력 후 줄바꿈
	}
	
	private void showTitleForColumnIndexes(int order) {	//마방진표에서 몇번째 행과 열인지 알려주는 함수
		AppView.output("      ");
		for(int col = 0; col < order; col++) {
			AppView.output(String.format("[%3d]",  col));	//3칸에 값을 저장
		}
		AppView.outputLine("");
	}
	
	
	public void run() {//공개함수
		AppView.outputLine("<<< 마방진 풀이를 시작합니다. >>>");
		AppView.outputLine("");
		
		int currentOrder = AppView.inputOrder();	//메세지를 내보내고 차수를 입력받음
		OrderValidity currentValidity = OrderValidity.validityOf(currentOrder);
		while(currentValidity != OrderValidity.EndOfRun) {	//차수가 음수면 프로그램 종료
			if(currentValidity == OrderValidity.Valid) {	//차수가 유효(3~99 입력)
				AppView.outputTitleWithOrder (currentOrder);	//현재 차수 출력
				AppView.outputLine("");							//마방진판 출력 전 줄바꿈
				Board solvedBoard = this._magicSquare.solve(currentOrder);	//magicSquare객체인 solvedBoard한테 마방진 풀도록 시킴
				this.showBoard(solvedBoard);	//마방진판 출력
			}
			else {
				this.showOrderValidityErrorMessage(currentValidity);	//유효값이 아닐 때 오류메세지 출력
				AppView.outputLine("");	//출력메세지간 줄바꿈
			}
			currentOrder = AppView.inputOrder();	//다음 마방진을 위해 차수 입력
			currentValidity = OrderValidity.validityOf(currentOrder);
		}
	AppView.outputLine("");
	AppView.outputLine("<<< 마방진 풀이를 종료합니다. >>>");
	}
}