package _DS09_201701971_고도현;

import java.util.Arrays;

public class Calculator {
	private static final int MAX_EXPRESSION_LENGTH = 100;

	// 인스턴스 변수
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

	// 생성자
	public Calculator() {
		this.setOperatorStack(new ArrayList<Character>(Calculator.MAX_EXPRESSION_LENGTH));
		this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_LENGTH));
	}

	private void showOperatorStack(String anOperationLabel) { // 숫자를 출력한다
		AppView.outputDebugMessage(anOperationLabel + " : ValueStack <Bottom> ");	// anOpertionLabel과 문장을 출력한다.
		for(int i = 0; i <this.operatorStack().size(); i++) {	// 저장된 숫자의 개수만큼
			AppView.outputDebugMessage(((ArrayList<Character>)this.operatorStack()).elementAt(i).charValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
		
	}

	private void showTokenAndPostfixExpression(char aToken, char[] aPostfixExpressionArray) {	// 사용된 연산자과 수식을 출력하는 메소드
		AppView.outputDebugMessage(aToken + " : (Postfix 수식으로 출력) ");	
		AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
	}

	private void showTokenAndMessage(char aToken, String aMessage) {	// 사용된 연산자와 메세지를 출력하는 메소드
		AppView.outputLineDebugMessage(aToken + " : (" + aMessage + ") ");
	}

	private int inComingPrecedence(Character aToken) {	// 연산 처리 순서 
		switch (aToken.charValue()) {	// 입력될 연산자
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

	private int inStackPrecedence(Character aToken) {	// 이미 입력된 연산자
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
		char[] postfixExpressionArray = new char[this.infixExpression().length()];	// 입력된 수식의 길이만큼의 배열
		Arrays.fill(postfixExpressionArray, ' '); // 모든 칸을 공백 문자로 채운다

		Character currentToken, poppedToken, topToken;
		this.operatorStack().clear();	// 연산자 스택 초기화
		int p = 0;	// postfix 수식에 token을 출력할 위치
		for (int i = 0; i < this.infixExpression().length(); i++) {
			currentToken = this.infixExpression().charAt(i);	// i번째 문자열 currentToken에 저장
			if (Character.isDigit(currentToken.charValue())) {	// currentToken의 값이 숫자 값일 경우
				postfixExpressionArray[p++] = currentToken;
				this.showTokenAndPostfixExpression(currentToken, postfixExpressionArray);
			} else {	// currentToken이 연산자일 경우
				if (currentToken == ')') {
					this.showTokenAndMessage(currentToken, "왼쪽 괄호가 나타날 때까지 스택에서 꺼내어 출력");
					poppedToken = this.operatorStack().pop();
					while (poppedToken != null && poppedToken.charValue() != '(') {	// 여는 괄호를 만날 때까지 스택 내부를 보여준다.
						postfixExpressionArray[p++] = poppedToken.charValue();
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						poppedToken = this.operatorStack().pop();
					}
					if (poppedToken == null) {
						return CalculatorError.InfixError_MissingLeftParen;
					}
					this.showOperatorStack("Popped");
				} else {	// 괄호가 없는 수식인 경우
					int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());
					if (inComingPrecedence < 0) {	// 우선순위 값이 0보다 작으면
						AppView.outputLineDebugMessage(currentToken + " : (Unkown Operator)");
						return CalculatorError.InfixError_UnknownOperator;	// 알 수 없는 연산자
					}
					this.showTokenAndMessage(currentToken, "입력 연산자보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력");
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
		AppView.outputLineDebugMessage("(End of infix expression : 스택에서 모든 연산자를 꺼내어 출력)");
		while (!this.operatorStack().isEmpty()) {	// 연산자스택이 비어있지 않으면
			poppedToken = this.operatorStack().pop();	// 가장 최근에 입력된 연산자부터 삭제
			this.showOperatorStack("Popped");
			if(poppedToken == '(') {	// 여는 괄호가 나오면
				return CalculatorError.InfixError_MissingRightParen;	// 오른쪽 괄호가 없다는 오류
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
		CalculatorError infixError = this.infixToPostfix();	// infix를 postfix로 변환후에 infixError에 저장
		if (infixError == CalculatorError.InfixError_None) {
			AppView.outputLine("");
			AppView.outputLineDebugMessage("[Evaluate Postfix] " + this.postfixExpression());
			return this.postfixCalculator().evaluate(this.postfixExpression());	// postfix를 계산한다
		}
		else {
			throw new CalculatorException(infixError);
		}
	}
}
