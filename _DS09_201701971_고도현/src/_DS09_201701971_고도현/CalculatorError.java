package _DS09_201701971_고도현;

public enum CalculatorError {
	UndeFined,	// error가 발상하기 전 상태로 초기화 하는 목적으로 사용
	// infix 수식을 계산하는 동안 발생할 수 있는 오류 코드
	InfixError_None,
	InfixError_NoExpression,
	InfixError_TooLongExpression,
	InfixError_MissingLeftParen,
	InfixError_MissingRightParen,
	InfixError_UnknownOperator,
	// postfix 수식을 계산하는 동안 발생할 수 있는 오류 코드
	PostfixError_None,
	PostfixError_NoExpression,
	PostfixError_TooLongExpression,
	PostfixError_TooFewValues,
	PostfixError_TooManyValues,
	PostfixError_DivideByZero,
	PostfixError_UnknownOperator,

}
