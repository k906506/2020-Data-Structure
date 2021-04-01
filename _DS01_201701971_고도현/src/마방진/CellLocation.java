package ������;

public class CellLocation {
	private static final int UndefinedIndex = -1;
	
	private int _row;
	private int _col;
	
	public CellLocation() {	//�⺻ ������ : Cell��ǥ�� �־����� ���� ��
		this.setRow(UndefinedIndex);	//(-1,-1)�� ����
		this.setCol(UndefinedIndex);
	}
	
	public CellLocation(int givenRow, int givenCol) {	//Cell��ǥ�� �־��� ��
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
