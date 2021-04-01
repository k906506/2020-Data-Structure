package ������;

import ������.Enum.OrderValidity;

public class AppController {	//�������
	public static final int MIN_ORDER = 3;	//�ּڰ�
	public static final int MAX_ORDER = 99;	//�ִ�
	
	private MagicSquare _magicSquare;	//���������
	
	public AppController() {	//������
		this._magicSquare = new MagicSquare(AppController.MAX_ORDER);
	}
	
	private void showOrderValidityErrorMessage(OrderValidity orderValidity) {	//�����϶� ���
		switch (orderValidity) {
		case TooSmall:	//orderValidity�� TooSmall�� �ش�� ��
			AppView.outputLine(
					"[����] ������ �ʹ� �۽��ϴ�." + AppController.MIN_ORDER + "���� ũ�ų� ���ƾ� �մϴ�.");
			break;
		case TooLarge:	//orderValidity�� TooLarge�� �ش�� ��
			AppView.outputLine(
					"[����] ������ �ʹ� Ů�ϴ�." + AppController.MAX_ORDER + "���� �۰ų� ���ƾ� �մϴ�.");
			break;
		case NotOddNumber:	//orderValidity�� NotOddNumber�� �ش�� ��
			AppView.outputLine(
					"[����] ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.");
			break;
			default:
				break;
		}
	}
	
	private void showBoard (Board board) {
		CellLocation currentLoc = new CellLocation();	//currentLoc ��ü ����
		this.showTitleForColumnIndexes(board.order());
		for(int row = 0; row < board.order(); row++) {
			AppView.outputRowNumber(row);
			for(int col = 0; col < board.order(); col++) {
				currentLoc.setRow(row);	//currentLoc�� row�� �ο�
				currentLoc.setCol(col);	//currentLoc�� col�� �ο�
				AppView.outputCellValue(board.cellValue(currentLoc)); //�ο��� row,col���� ���
			}
			AppView.outputLine("");	//������ �� ���ο��� �� �ٹٲ�
		}
		AppView.outputLine("");	//������ �� ��� �� �ٹٲ�
	}
	
	private void showTitleForColumnIndexes(int order) {	//������ǥ���� ���° ��� ������ �˷��ִ� �Լ�
		AppView.output("      ");
		for(int col = 0; col < order; col++) {
			AppView.output(String.format("[%3d]",  col));	//3ĭ�� ���� ����
		}
		AppView.outputLine("");
	}
	
	
	public void run() {//�����Լ�
		AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ�. >>>");
		AppView.outputLine("");
		
		int currentOrder = AppView.inputOrder();	//�޼����� �������� ������ �Է¹���
		OrderValidity currentValidity = OrderValidity.validityOf(currentOrder);
		while(currentValidity != OrderValidity.EndOfRun) {	//������ ������ ���α׷� ����
			if(currentValidity == OrderValidity.Valid) {	//������ ��ȿ(3~99 �Է�)
				AppView.outputTitleWithOrder (currentOrder);	//���� ���� ���
				AppView.outputLine("");							//�������� ��� �� �ٹٲ�
				Board solvedBoard = this._magicSquare.solve(currentOrder);	//magicSquare��ü�� solvedBoard���� ������ Ǯ���� ��Ŵ
				this.showBoard(solvedBoard);	//�������� ���
			}
			else {
				this.showOrderValidityErrorMessage(currentValidity);	//��ȿ���� �ƴ� �� �����޼��� ���
				AppView.outputLine("");	//��¸޼����� �ٹٲ�
			}
			currentOrder = AppView.inputOrder();	//���� �������� ���� ���� �Է�
			currentValidity = OrderValidity.validityOf(currentOrder);
		}
	AppView.outputLine("");
	AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ�. >>>");
	}
}