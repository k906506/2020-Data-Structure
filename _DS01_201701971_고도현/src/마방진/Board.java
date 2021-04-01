package 마방진;

public class Board {
	private static int EMPTY_CELL = -1;
	
	private int		_order;
	private int[][] _cells;
	
	public Board (int givenOrder) {	//주어진 차수의 마방진 판을 생성한다.
		this.setOrder(givenOrder);	//setCells에 givenOrder값 입력하여 _order에 givenOrder 저장.
		this.setCells(new int[givenOrder][givenOrder]);
		for(int row = 0; row<givenOrder; row++) {
			for(int col = 0; col<givenOrder; col++) {
				this.setCellValue(row, col, Board.EMPTY_CELL);	//-1로 마방진 판을 채운다.
			}
		}
	}
	
	public int order() {	//마방진 판의 차수를 얻는다.
		return this._order;
	}
	
	private void setOrder(int newOrder) {	//마방진 차수를 주어진 값으로 설정
		this._order = newOrder;
	}
	
	private void setCells(int[][] newCells) {
		this._cells = newCells;
	}
	
	public int cellValue(CellLocation location) {	//주어진 위치 aLocation의 Cell값을 없는다.
		return this._cells[location.row()][location.col()];
	}
	
	public void setCellValue(CellLocation location, int cellValue) {	//주어진 값 cellValue를 주어진 location의 cell에 넣는다.
		this._cells[location.row()][location.col()] = cellValue;
	}
	
	private void setCellValue(int row, int col,int cellValue) {	//주어진 값 cellValue를 주어진 위치(row,col)에 넣는다.
		this._cells[row][col] = cellValue;
	}
	
	public boolean cellIsEmpty (CellLocation location) {	//주어진 위치의 Cell이 비어있는지를 알려준다.
		return (this.cellValue(location)) == EMPTY_CELL;	//비어있으면 true, 아니면 false를 얻는다.
	}
}
