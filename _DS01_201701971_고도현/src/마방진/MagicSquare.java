package ������;

import ������.Enum.OrderValidity;

public class MagicSquare {
	private static final int DEFAULT_MAX_ORDER = 99;
	private int _maxOrder;
	
	public int maxOrder() {	//�������� �� ������ �ִ� ������ ����
		return this._maxOrder;
	}
	
	private void setMaxOrder(int newMaxOrder) {	//�־��� ���� �ִ� ������ ����
		this._maxOrder = newMaxOrder;
	}
	
	public MagicSquare() {	//�⺻ ������(�ִ밪 99)
		this.setMaxOrder(MagicSquare.DEFAULT_MAX_ORDER);
	}
	
	public MagicSquare(int givenMaxOrder) {	//�ִ� ������ ����ڰ� �����ϴ� ������
		this.setMaxOrder(givenMaxOrder);
	}
	
	public Board solve(int anOrder) {
		if(OrderValidity.validityOf(anOrder) != OrderValidity.Valid) {	//��ȿ�� ������ ������ �ƴϸ� null��
			return null;
		}
		else {
			Board board = new Board(anOrder);	//������ �Բ� Board ��ü �����ڸ� call�Ͽ�, Board ��ü�� �����Ѵ�
			CellLocation currentLoc = new CellLocation(0,anOrder/2);	//��� ��ġ�� ������ (0��,�����)�� �����Ѵ�
			CellLocation nextLoc = new CellLocation();
			
			board.setCellValue(currentLoc, 1);	//��� ��ġ�� 1�� ä���
			
			int lastValue = anOrder*anOrder;
			for(int cellValue = 2; cellValue <= lastValue; cellValue++) {
				nextLoc.setRow(currentLoc.row()-1); 
				nextLoc.setCol(currentLoc.col()+1);	//�ܰ� 1 : <������ġ>�κ��� <������ġ>�� "������ ��" ��ġ�� �Ի��Ѵ�
				if(nextLoc.row()<0) {	// <������ġ>�� ���� 0�̿��� -1�� �� ��� <������ġ>�� 0���� ���� ��
					nextLoc.setRow(anOrder-1);	// ���������� (anOrder-1)�� ����
				}
				if(nextLoc.col()>anOrder-1) { // <������ġ>�� ���� (anOrder-1), �� �ִ밪�� ��
					nextLoc.setCol(0);	// ó�� ���� 0���� ����
				}
				if(!board.cellIsEmpty(nextLoc)) { //�ܰ� 2 : <������ġ>�� ä���� ������ <������ġ>�� <������ġ> �ٷ� �Ʒ� ĭ���� �����Ѵ�
					nextLoc.setRow(currentLoc.row()+1);
					nextLoc.setCol(currentLoc.col());
				}
				currentLoc.setRow(nextLoc.row()); //�ܰ�3 : <������ġ>�� ���ο� <������ġ>�� �Ѵ�.
				currentLoc.setCol(nextLoc.col());
				board.setCellValue(currentLoc,cellValue);	//�ܰ�4: ���ο� <������ġ>�� cellValue���� �ִ´�.
			}
			return board;
		}
	}
}
