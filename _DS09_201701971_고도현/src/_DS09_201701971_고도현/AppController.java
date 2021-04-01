package _DS09_201701971_����;

public class AppController {
	private static final char END_OF_CALCULATION = '!'; // ���
	private static final boolean DEBUG_MODE = true;

	private Calculator _calculator; // �ν��Ͻ� ����

	private Calculator calculator() { // getter
		return this._calculator;
	}

	private void setCalculator(Calculator newCalculator) { // setter
		this._calculator = newCalculator;
	}

	public AppController() { // ������
		this.setCalculator(new Calculator());
		AppView.setDebugMode(AppController.DEBUG_MODE);
	}

	private String inputExpression() { // ������ �Է¹޴´�
		AppView.outputLine(""); // �ٹٲ�
		AppView.outputDebugMessage("? ����� ������ �Է��Ͻÿ� (�����Ϸ��� " + END_OF_CALCULATION + "�� �Է��Ͻÿ�.) ");
		return AppView.inputLine(); // �Է��� �޴´�
	}

	private void showCalculatorErrorMessage(CalculatorError anError) {	// ���� �޼��� ��� �޼ҵ�
		switch (anError) {
		case InfixError_NoExpression:
			AppView.outputLine("[����] ���� ������ �־����� �ʾҽ��ϴ�.");
			break;
		case InfixError_TooLongExpression:
			AppView.outputLine("[����] ���� ������ �ʹ� ��� ó���� �� �����ϴ�.");
			break;
		case InfixError_MissingLeftParen:
			AppView.outputLine("[����] ���� ��ȣ�� �������ϴ�.");
			break;
		case InfixError_MissingRightParen:
			AppView.outputLine("[����] ������ ��ȣ�� �������ϴ�.");
			break;
		case InfixError_UnknownOperator:
			AppView.outputLine("[����] ���� ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�.");
			break;
		case PostfixError_NoExpression:
			AppView.outputLine("[����] ���� ������ �־����� �ʾҽ��ϴ�.");
			break;
		case PostfixError_TooLongExpression:
			AppView.outputLine("[����] ���� ������ �ʹ� ��� ó���� �� �����ϴ�.");
			break;
		case PostfixError_TooFewValues:
			AppView.outputLine("[����] �����ڿ� ���� ���갪 ���� �����ϴ�.");
			break;
		case PostfixError_TooManyValues:
			AppView.outputLine("[����] �����ڿ� ���� ���갪 ���� �����ϴ�.");
			break;
		case PostfixError_DivideByZero:
			AppView.outputLine("[����] �������� �и� 0 �Դϴ�.");
			break;
		case PostfixError_UnknownOperator:
			AppView.outputLine("[����] ���� ���Ŀ� �� �� ���� �����ڰ� �ֽ��ϴ�.");
			break;
		default:
			;
		}
	}
	
	public void run() {
		AppView.outputLine("<<< ���� ���α׷��� �����մϴ� >>>");
		String infixExpression = this.inputExpression();	// ������ �Է¹ް� infixExpression�� ����
		while(infixExpression.charAt(0) != AppController.END_OF_CALCULATION) {	// �Է¹��� ���� !�� �ƴϸ�
			try {
				int result = this.calculator().evaluate(infixExpression);	// 
				AppView.outputLine("> ��갪 : " + result);
			}
			catch (CalculatorException exception) {	// CalculatorException ��ü�� catch�ϰ�
				this.showCalculatorErrorMessage(exception.error());	// exception.error()�� ���� �����ڵ带 ����Ѵ�.
			}
			infixExpression = this.inputExpression();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< ���� ���α׷��� �����մϴ� >>>");
	}
}
