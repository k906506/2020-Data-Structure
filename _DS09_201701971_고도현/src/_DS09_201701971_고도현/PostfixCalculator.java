package _DS09_201701971_����;

public class PostfixCalculator {

	private static final int DEFAULT_MAX_EXPRESSION_LENGTH = 100;	// ���� �ִ� ����

	private int _maxExpressionLength;	// �ν��Ͻ� ����
	private Stack<Integer> _valueStack;

	public int maxExpressionLength() {	// getter
		return this._maxExpressionLength;
	}

	public void setMaxExpressionLength(int newMaxExpressionLength) {	// setter
		this._maxExpressionLength = newMaxExpressionLength;
	}

	private Stack<Integer> valueStack() {	// getter
		return this._valueStack;
	}

	private void setValueStack(Stack<Integer> newValueStack) {	// setter
		this._valueStack = newValueStack;
	}

	// ������
	public PostfixCalculator() {
		this(PostfixCalculator.DEFAULT_MAX_EXPRESSION_LENGTH);
	}

	public PostfixCalculator(int givenMaxExpressionLength) {
		this.setMaxExpressionLength(givenMaxExpressionLength);
		this.setValueStack(new ArrayList<Integer>(this.maxExpressionLength()));
	}

	public int evaluate(String aPostfixExpression) throws CalculatorException {	// ������ �߻��ϸ� CalculatorException���� throw
		if (aPostfixExpression == null || aPostfixExpression.length() == 0) { // ���ڰ� ���ų� ���̰� 0�̸�
			throw new CalculatorException(CalculatorError.PostfixError_NoExpression);	// NoExpression���� ����ó��
		}
		this.valueStack().clear();	// ������ �ʱ�ȭ�ϰ�
		char token;
		for (int current = 0; current < aPostfixExpression.length(); current++) {	// ������ ������ŭ �ݺ����� ������.
			token = aPostfixExpression.charAt(current);	// current��ġ�� ���ڸ� token�� �����Ѵ�.
			if (Character.isDigit(token)) { // token�� ���ڰ� ���ڸ�
				int tokenValue = Character.getNumericValue(token); // token�� ���ڸ� int������ ��ȯ
				if (this.valueStack().isFull()) {	// ������ �̹� ���� ä����������
					throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);	// TooLongExpression���� ����ó��
				} else {
					this.valueStack().push(Integer.valueOf(tokenValue)); // tokenValue���� Integer��ü�� ��ȯ
				}
			} else { // ���ڰ� �ƴ� �� = ������
				CalculatorError error = this.executeBinaryOperator(token);	// executeBinaryOperator ��ü�� ����
				if (error != CalculatorError.PostfixError_None) {	// �����ڰ� ���� ���
					throw new CalculatorException(error);	// error���� ���� ó��
				}
			}
			this.showTokenAndValueStack(token);	// ���� �����ڵ��� �����ش�.
		}
		if (this.valueStack().size() == 1) {
			return (this.valueStack().pop().intValue());
		} else {	// token�� ó������ ���� ���
			throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);	// TooManyValues�� ���� ó��
		}
	}

	private CalculatorError executeBinaryOperator(char anOperator) {
		if (this.valueStack().size() < 2) { // ���ڰ� 2�� �̸��� ��
			return CalculatorError.PostfixError_TooFewValues;	// TooFewValues�� ���� ó��
		}
		int operand1 = this.valueStack().pop().intValue();	// int������ ��ȯ�Ͽ� operand1�� ����
		int operand2 = this.valueStack().pop().intValue();	// int������ ��ȯ�Ͽ� operand2�� ����
		int calculated = 0;	// ��갪 �ʱ�ȭ
		switch (anOperator) {	// �Էµ� ������
		case '^':	// ������ ���
			calculated = (int) Math.pow((double) operand2, (double) operand1);	// ������ ���
			break;
		case '*':	// ���ϱ� ���
			calculated = operand2 * operand1;	// ���ϱ� ���
			break;
		case '/':	// ������ ���
			if (operand1 == 0) {	// ù���� �Է°��� 0�̸�(�и� 0)
				AppView.outputLineDebugMessage(	
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);	// ���� �޼��� ���
				return CalculatorError.PostfixError_DivideByZero;
			} else {	// �ƴ� ���
				calculated = operand2 / operand1;	// ������
			}
			break;
		case '%':	// ������ ���
			if (operand1 == 0) {	// ù���� �Է°��� 0�̸�
				AppView.outputLineDebugMessage(
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);	// �����޼��� ���
				return CalculatorError.PostfixError_DivideByZero;
			} else {
				calculated = operand2 % operand1;	// ������ ���
			}
			break;
		case '+':	// ���ϱ� ���
			calculated = operand2 + operand1;
			break;
		case '-':	// ���� ���
			calculated = operand2 - operand1;
			break;
		default:	// �̿��� ��
			return CalculatorError.PostfixError_UnknownOperator;	// UnknownOperator�� ���� ó��
		}
		this.valueStack().push(Integer.valueOf(calculated)); // �⺻�ڷ��� int���� ��ü �ڷ��� Integer�� ��ȯ�Ѵ�.
		return CalculatorError.PostfixError_None;
	}
	
	private void showTokenAndValueStack(char aToken) {	// ���� �����ڸ� �����ش�
		AppView.outputDebugMessage(aToken + " : ValueStack <Bottom> ");
		for(int i = 0; i <this.valueStack().size(); i++) {
			AppView.outputDebugMessage(((ArrayList<Integer>)this.valueStack()).elementAt(i).intValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}
}
