package 마방진;

import 마방진.Enum.OrderValidity;

public class MagicSquare {
	private static final int DEFAULT_MAX_ORDER = 99;
	private int _maxOrder;
	
	public int maxOrder() {	//마방진의 현 상태의 최대 차수를 얻음
		return this._maxOrder;
	}
	
	private void setMaxOrder(int newMaxOrder) {	//주어진 값을 최대 차수로 지정
		this._maxOrder = newMaxOrder;
	}
	
	public MagicSquare() {	//기본 생성자(최대값 99)
		this.setMaxOrder(MagicSquare.DEFAULT_MAX_ORDER);
	}
	
	public MagicSquare(int givenMaxOrder) {	//최대 차수를 사용자가 지정하는 생성자
		this.setMaxOrder(givenMaxOrder);
	}
	
	public Board solve(int anOrder) {
		if(OrderValidity.validityOf(anOrder) != OrderValidity.Valid) {	//유효한 범위의 차수가 아니면 null값
			return null;
		}
		else {
			Board board = new Board(anOrder);	//차수와 함께 Board 객체 생성자를 call하여, Board 객체를 생성한다
			CellLocation currentLoc = new CellLocation(0,anOrder/2);	//출발 위치를 보드의 (0행,가운데열)로 설정한다
			CellLocation nextLoc = new CellLocation();
			
			board.setCellValue(currentLoc, 1);	//출발 위치에 1을 채운다
			
			int lastValue = anOrder*anOrder;
			for(int cellValue = 2; cellValue <= lastValue; cellValue++) {
				nextLoc.setRow(currentLoc.row()-1); 
				nextLoc.setCol(currentLoc.col()+1);	//단계 1 : <현재위치>로부터 <다음위치>인 "오른쪽 위" 위치를 게산한다
				if(nextLoc.row()<0) {	// <현재위치>의 행이 0이여서 -1을 할 경우 <다음위치>가 0보다 작을 때
					nextLoc.setRow(anOrder-1);	// 마지막행인 (anOrder-1)로 간다
				}
				if(nextLoc.col()>anOrder-1) { // <현재위치>의 열이 (anOrder-1), 즉 최대값일 때
					nextLoc.setCol(0);	// 처음 열인 0으로 간다
				}
				if(!board.cellIsEmpty(nextLoc)) { //단계 2 : <다음위치>가 채워져 있으면 <다음위치>를 <현재위치> 바로 아래 칸으로 수정한다
					nextLoc.setRow(currentLoc.row()+1);
					nextLoc.setCol(currentLoc.col());
				}
				currentLoc.setRow(nextLoc.row()); //단계3 : <다음위치>를 새로운 <현재위치>로 한다.
				currentLoc.setCol(nextLoc.col());
				board.setCellValue(currentLoc,cellValue);	//단계4: 새로운 <현재위치>에 cellValue값을 넣는다.
			}
			return board;
		}
	}
}
