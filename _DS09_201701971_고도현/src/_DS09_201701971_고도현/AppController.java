package _DS09_201701971_고도현;

public class AppController {
	private static final char END_OF_CALCULATION = '!'; // 상수
	private static final boolean DEBUG_MODE = true;

	private Calculator _calculator; // 인스턴스 변수

	private Calculator calculator() { // getter
		return this._calculator;
	}

	private void setCalculator(Calculator newCalculator) { // setter
		this._calculator = newCalculator;
	}

	public AppController() { // 생성자
		this.setCalculator(new Calculator());
		AppView.setDebugMode(AppController.DEBUG_MODE);
	}

	private String inputExpression() { // 수식을 입력받는다
		AppView.outputLine(""); // 줄바꿈
		AppView.outputDebugMessage("? 계산할 수식을 입력하시오 (종료하려면 " + END_OF_CALCULATION + "를 입력하시오.) ");
		return AppView.inputLine(); // 입력을 받는다
	}

	private void showCalculatorErrorMessage(CalculatorError anError) {	// 오류 메세지 출력 메소드
		switch (anError) {
		case InfixError_NoExpression:
			AppView.outputLine("[오류] 중위 계산식이 주어지지 않았습니다.");
			break;
		case InfixError_TooLongExpression:
			AppView.outputLine("[오류] 중위 계산식이 너무 길어 처리할 수 없습니다.");
			break;
		case InfixError_MissingLeftParen:
			AppView.outputLine("[오류] 왼쪽 괄호가 빠졌습니다.");
			break;
		case InfixError_MissingRightParen:
			AppView.outputLine("[오류] 오른쪽 괄호가 빠졌습니다.");
			break;
		case InfixError_UnknownOperator:
			AppView.outputLine("[오류] 중위 계산식에 알 수 없는 연산자가 있습니다.");
			break;
		case PostfixError_NoExpression:
			AppView.outputLine("[오류] 후위 계산식이 주어지지 않았습니다.");
			break;
		case PostfixError_TooLongExpression:
			AppView.outputLine("[오류] 후위 계산식이 너무 길어 처리할 수 없습니다.");
			break;
		case PostfixError_TooFewValues:
			AppView.outputLine("[오류] 연산자에 비해 연산값 수가 적습니다.");
			break;
		case PostfixError_TooManyValues:
			AppView.outputLine("[오류] 연산자에 비해 연산값 수가 많습니다.");
			break;
		case PostfixError_DivideByZero:
			AppView.outputLine("[오류] 나눗셈의 분모가 0 입니다.");
			break;
		case PostfixError_UnknownOperator:
			AppView.outputLine("[오류] 후위 계산식에 알 수 없는 연산자가 있습니다.");
			break;
		default:
			;
		}
	}
	
	public void run() {
		AppView.outputLine("<<< 계산기 프로그램을 시작합니다 >>>");
		String infixExpression = this.inputExpression();	// 수식을 입력받고 infixExpression에 저장
		while(infixExpression.charAt(0) != AppController.END_OF_CALCULATION) {	// 입력받은 값이 !가 아니면
			try {
				int result = this.calculator().evaluate(infixExpression);	// 
				AppView.outputLine("> 계산값 : " + result);
			}
			catch (CalculatorException exception) {	// CalculatorException 객체를 catch하고
				this.showCalculatorErrorMessage(exception.error());	// exception.error()를 얻어내어 오류코드를 출력한다.
			}
			infixExpression = this.inputExpression();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 계산기 프로그램을 종료합니다 >>>");
	}
}
