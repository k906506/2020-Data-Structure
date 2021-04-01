package _DS09_201701971_����;

import java.util.Arrays;

public class Calculator {
	private static final int MAX_EXPRESSION_LENGTH = 100;

	// �ν��Ͻ� ����
	private Stack<Character> _operatorStack;
	private String _infixExpression;
	private String _postfixExpression;
	private PostfixCalculator _postfixCalculator;

	private String infixExpression() { // getter
		return this._infixExpression;
	}

	private void setInfixExpression(String newInfixExpression) { // setter
		this._infixExpression = newInfixExpression;
	}

	private String postfixExpression() { // getter
		return this._postfixExpression;
	}

	private void setPostfixExpression(String newPostfixExpression) { // setter
		this._postfixExpression = newPostfixExpression;
	}

	private PostfixCalculator postfixCalculator() { // getter
		return this._postfixCalculator;
	}

	private void setPostfixCalculator(PostfixCalculator newPostfixCalculator) { // setter
		this._postfixCalculator = newPostfixCalculator;
	}

	private Stack<Character> operatorStack() { // getter
		return this._operatorStack;
	}

	private void setOperatorStack(Stack<Character> newOperatorStack) { // setter
		this._operatorStack = newOperatorStack;
	}

	// ������
	public Calculator() {
		this.setOperatorStack(new ArrayList<Character>(Calculator.MAX_EXPRESSION_LENGTH));
		this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_LENGTH));
	}

	private void showOperatorStack(String anOperationLabel) { // ���ڸ� ����Ѵ�
		AppView.outputDebugMessage(anOperationLabel + " : ValueStack <Bottom> ");	// anOpertionLabel�� ������ ����Ѵ�.
		for(int i = 0; i <this.operatorStack().size(); i++) {	// ����� ������ ������ŭ
			AppView.outputDebugMessage(((ArrayList<Character>)this.operatorStack()).elementAt(i).charValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
		
	}

	private void showTokenAndPostfixExpression(char aToken, char[] aPostfixExpressionArray) {	// ���� �����ڰ� ������ ����ϴ� �޼ҵ�
		AppView.outputDebugMessage(aToken + " : (Postfix �������� ���) ");	
		AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
	}

	private void showTokenAndMessage(char aToken, String aMessage) {	// ���� �����ڿ� �޼����� ����ϴ� �޼ҵ�
		AppView.outputLineDebugMessage(aToken + " : (" + aMessage + ") ");
	}

	private int inComingPrecedence(Character aToken) {	// ���� ó�� ���� 
		switch (aToken.charValue()) {	// �Էµ� ������
		case '(':
			return 20;
		case ')':
			return 19;
		case '^':
			return 17;
		case '*':
			return 13;
		case '/':
			return 13;
		case '%':
			return 13;
		case '+':
			return 12;
		case '-':
			return 12;
		default:
			return -1;
		}
	}

	private int inStackPrecedence(Character aToken) {	// �̹� �Էµ� ������
		switch (aToken.charValue()) {
		case '(':
			return 0;
		case ')':
			return 19;
		case '^':
			return 16;
		case '*':
			return 13;
		case '/':
			return 13;
		case '%':
			return 13;
		case '+':
			return 12;
		case '-':
			return 12;
		default:
			return -1;
		}
	}

	private CalculatorError infixToPostfix() {
		char[] postfixExpressionArray = new char[this.infixExpression().length()];	// �Էµ� ������ ���̸�ŭ�� �迭
		Arrays.fill(postfixExpressionArray, ' '); // ��� ĭ�� ���� ���ڷ� ä���

		Character currentToken, poppedToken, topToken;
		this.operatorStack().clear();	// ������ ���� �ʱ�ȭ
		int p = 0;	// postfix ���Ŀ� token�� ����� ��ġ
		for (int i = 0; i < this.infixExpression().length(); i++) {
			currentToken = this.infixExpression().charAt(i);	// i��° ���ڿ� currentToken�� ����
			if (Character.isDigit(currentToken.charValue())) {	// currentToken�� ���� ���� ���� ���
				postfixExpressionArray[p++] = currentToken;
				this.showTokenAndPostfixExpression(currentToken, postfixExpressionArray);
			} else {	// currentToken�� �������� ���
				if (currentToken == ')') {
					this.showTokenAndMessage(currentToken, "���� ��ȣ�� ��Ÿ�� ������ ���ÿ��� ������ ���");
					poppedToken = this.operatorStack().pop();
					while (poppedToken != null && poppedToken.charValue() != '(') {	// ���� ��ȣ�� ���� ������ ���� ���θ� �����ش�.
						postfixExpressionArray[p++] = poppedToken.charValue();
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						poppedToken = this.operatorStack().pop();
					}
					if (poppedToken == null) {
						return CalculatorError.InfixError_MissingLeftParen;
					}
					this.showOperatorStack("Popped");
				} else {	// ��ȣ�� ���� ������ ���
					int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());
					if (inComingPrecedence < 0) {	// �켱���� ���� 0���� ������
						AppView.outputLineDebugMessage(currentToken + " : (Unkown Operator)");
						return CalculatorError.InfixError_UnknownOperator;	// �� �� ���� ������
					}
					this.showTokenAndMessage(currentToken, "�Է� �����ں��� ������ ���� ���� �����ڸ� ���ÿ��� ������ ���");
					topToken = this.operatorStack().peek();
					while (topToken != null && this.inStackPrecedence(topToken) >= inComingPrecedence) {
						poppedToken = this.operatorStack().pop();
						postfixExpressionArray[p++] = poppedToken;
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						topToken = this.operatorStack().peek();
					}
					if (this.operatorStack().isFull()) {
						this.showOperatorStack("Fulled");
						return CalculatorError.InfixError_TooLongExpression;
					}
					this.operatorStack().push(currentToken);
					this.showOperatorStack("Pushed");
				}
			}
		}
		AppView.outputLineDebugMessage("(End of infix expression : ���ÿ��� ��� �����ڸ� ������ ���)");
		while (!this.operatorStack().isEmpty()) {	// �����ڽ����� ������� ������
			poppedToken = this.operatorStack().pop();	// ���� �ֱٿ� �Էµ� �����ں��� ����
			this.showOperatorStack("Popped");
			if(poppedToken == '(') {	// ���� ��ȣ�� ������
				return CalculatorError.InfixError_MissingRightParen;	// ������ ��ȣ�� ���ٴ� ����
			}
			postfixExpressionArray[p++] = poppedToken;
			this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
		}
		this.setPostfixExpression(new String(postfixExpressionArray).trim());
		return CalculatorError.InfixError_None;	
	}
	
	public int evaluate(String anInfixExpression) throws CalculatorException{
		this.setInfixExpression(anInfixExpression);
		AppView.outputLineDebugMessage("[Infix to Postfix] " + anInfixExpression);
		if(this.infixExpression() == null || this.infixExpression().length() == 0) {
			throw new CalculatorException(CalculatorError.InfixError_NoExpression);
		}
		CalculatorError infixError = this.infixToPostfix();	// infix�� postfix�� ��ȯ�Ŀ� infixError�� ����
		if (infixError == CalculatorError.InfixError_None) {
			AppView.outputLine("");
			AppView.outputLineDebugMessage("[Evaluate Postfix] " + this.postfixExpression());
			return this.postfixCalculator().evaluate(this.postfixExpression());	// postfix�� ����Ѵ�
		}
		else {
			throw new CalculatorException(infixError);
		}
	}
}
