package _DS09_201701971_����;

public enum CalculatorError {
	UndeFined,	// error�� �߻��ϱ� �� ���·� �ʱ�ȭ �ϴ� �������� ���
	// infix ������ ����ϴ� ���� �߻��� �� �ִ� ���� �ڵ�
	InfixError_None,
	InfixError_NoExpression,
	InfixError_TooLongExpression,
	InfixError_MissingLeftParen,
	InfixError_MissingRightParen,
	InfixError_UnknownOperator,
	// postfix ������ ����ϴ� ���� �߻��� �� �ִ� ���� �ڵ�
	PostfixError_None,
	PostfixError_NoExpression,
	PostfixError_TooLongExpression,
	PostfixError_TooFewValues,
	PostfixError_TooManyValues,
	PostfixError_DivideByZero,
	PostfixError_UnknownOperator,

}
