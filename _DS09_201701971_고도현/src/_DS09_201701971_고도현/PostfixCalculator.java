package _DS09_201701971_고도현;

public class PostfixCalculator {

	private static final int DEFAULT_MAX_EXPRESSION_LENGTH = 100;	// 식의 최대 길이

	private int _maxExpressionLength;	// 인스턴스 변수
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

	// 생성자
	public PostfixCalculator() {
		this(PostfixCalculator.DEFAULT_MAX_EXPRESSION_LENGTH);
	}

	public PostfixCalculator(int givenMaxExpressionLength) {
		this.setMaxExpressionLength(givenMaxExpressionLength);
		this.setValueStack(new ArrayList<Integer>(this.maxExpressionLength()));
	}

	public int evaluate(String aPostfixExpression) throws CalculatorException {	// 오류가 발생하면 CalculatorException으로 throw
		if (aPostfixExpression == null || aPostfixExpression.length() == 0) { // 문자가 없거나 길이가 0이면
			throw new CalculatorException(CalculatorError.PostfixError_NoExpression);	// NoExpression으로 오류처리
		}
		this.valueStack().clear();	// 스택을 초기화하고
		char token;
		for (int current = 0; current < aPostfixExpression.length(); current++) {	// 문자의 개수만큼 반복문을 돌린다.
			token = aPostfixExpression.charAt(current);	// current위치의 문자를 token에 저장한다.
			if (Character.isDigit(token)) { // token의 문자가 숫자면
				int tokenValue = Character.getNumericValue(token); // token의 숫자를 int값으로 변환
				if (this.valueStack().isFull()) {	// 스택이 이미 가득 채워져있으면
					throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);	// TooLongExpression으로 오류처리
				} else {
					this.valueStack().push(Integer.valueOf(tokenValue)); // tokenValue값을 Integer객체로 변환
				}
			} else { // 숫자가 아닐 때 = 연산자
				CalculatorError error = this.executeBinaryOperator(token);	// executeBinaryOperator 객체를 선언
				if (error != CalculatorError.PostfixError_None) {	// 연산자가 없을 경우
					throw new CalculatorException(error);	// error으로 오류 처리
				}
			}
			this.showTokenAndValueStack(token);	// 사용된 연산자들을 보여준다.
		}
		if (this.valueStack().size() == 1) {
			return (this.valueStack().pop().intValue());
		} else {	// token이 처리되지 않은 경우
			throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);	// TooManyValues로 오류 처리
		}
	}

	private CalculatorError executeBinaryOperator(char anOperator) {
		if (this.valueStack().size() < 2) { // 숫자가 2개 미만일 때
			return CalculatorError.PostfixError_TooFewValues;	// TooFewValues로 오류 처리
		}
		int operand1 = this.valueStack().pop().intValue();	// int값으로 변환하여 operand1에 저장
		int operand2 = this.valueStack().pop().intValue();	// int값으로 변환하여 operand2에 저장
		int calculated = 0;	// 계산값 초기화
		switch (anOperator) {	// 입력된 연산자
		case '^':	// 제곱긴 계산
			calculated = (int) Math.pow((double) operand2, (double) operand1);	// 제곱근 계싼
			break;
		case '*':	// 곱하기 계산
			calculated = operand2 * operand1;	// 곱하기 계산
			break;
		case '/':	// 나누기 계산
			if (operand1 == 0) {	// 첫번쨰 입력값이 0이면(분모가 0)
				AppView.outputLineDebugMessage(	
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);	// 오류 메세지 출력
				return CalculatorError.PostfixError_DivideByZero;
			} else {	// 아닌 경우
				calculated = operand2 / operand1;	// 나눗셈
			}
			break;
		case '%':	// 나머지 계산
			if (operand1 == 0) {	// 첫번쨰 입력값이 0이면
				AppView.outputLineDebugMessage(
						anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1);	// 오류메세지 출력
				return CalculatorError.PostfixError_DivideByZero;
			} else {
				calculated = operand2 % operand1;	// 나머지 계산
			}
			break;
		case '+':	// 더하기 계산
			calculated = operand2 + operand1;
			break;
		case '-':	// 빼기 계산
			calculated = operand2 - operand1;
			break;
		default:	// 이외의 값
			return CalculatorError.PostfixError_UnknownOperator;	// UnknownOperator로 오류 처리
		}
		this.valueStack().push(Integer.valueOf(calculated)); // 기본자료형 int형을 객체 자료형 Integer로 변환한다.
		return CalculatorError.PostfixError_None;
	}
	
	private void showTokenAndValueStack(char aToken) {	// 사용된 연산자를 보여준다
		AppView.outputDebugMessage(aToken + " : ValueStack <Bottom> ");
		for(int i = 0; i <this.valueStack().size(); i++) {
			AppView.outputDebugMessage(((ArrayList<Integer>)this.valueStack()).elementAt(i).intValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}
}
