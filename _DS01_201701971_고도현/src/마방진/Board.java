package ������;

public class Board {
	private static int EMPTY_CELL = -1;
	
	private int		_order;
	private int[][] _cells;
	
	public Board (int givenOrder) {	//�־��� ������ ������ ���� �����Ѵ�.
		this.setOrder(givenOrder);	//setCells�� givenOrder�� �Է��Ͽ� _order�� givenOrder ����.
		this.setCells(new int[givenOrder][givenOrder]);
		for(int row = 0; row<givenOrder; row++) {
			for(int col = 0; col<givenOrder; col++) {
				this.setCellValue(row, col, Board.EMPTY_CELL);	//-1�� ������ ���� ä���.
			}
		}
	}
	
	public int order() {	//������ ���� ������ ��´�.
		return this._order;
	}
	
	private void setOrder(int newOrder) {	//������ ������ �־��� ������ ����
		this._order = newOrder;
	}
	
	private void setCells(int[][] newCells) {
		this._cells = newCells;
	}
	
	public int cellValue(CellLocation location) {	//�־��� ��ġ aLocation�� Cell���� ���´�.
		return this._cells[location.row()][location.col()];
	}
	
	public void setCellValue(CellLocation location, int cellValue) {	//�־��� �� cellValue�� �־��� location�� cell�� �ִ´�.
		this._cells[location.row()][location.col()] = cellValue;
	}
	
	private void setCellValue(int row, int col,int cellValue) {	//�־��� �� cellValue�� �־��� ��ġ(row,col)�� �ִ´�.
		this._cells[row][col] = cellValue;
	}
	
	public boolean cellIsEmpty (CellLocation location) {	//�־��� ��ġ�� Cell�� ����ִ����� �˷��ش�.
		return (this.cellValue(location)) == EMPTY_CELL;	//��������� true, �ƴϸ� false�� ��´�.
	}
}
