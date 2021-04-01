package 마방진;

public class CellLocation {
	private static final int UndefinedIndex = -1;
	
	private int _row;
	private int _col;
	
	public CellLocation() {	//기본 생성자 : Cell좌표가 주어지지 않을 때
		this.setRow(UndefinedIndex);	//(-1,-1)로 설정
		this.setCol(UndefinedIndex);
	}
	
	public CellLocation(int givenRow, int givenCol) {	//Cell좌표가 주어질 때
		this.setRow(givenRow);
		this.setCol(givenCol);
	}
	
	public void setRow(int newRow) {	//Setter
		this._row = newRow;
	}
	
	public int row() {	//Getter
		return this._row;
	}
	
	public void setCol(int newCol) {	//Setter
		this._col = newCol;
	}
	
	public int col() {	//Getter
		return this._col;
	}

}
