package _DS09_201701971_����;

public class CalculatorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CalculatorError _error;	// ���� �ڵ带 ������ instance variable
	
	public CalculatorError error() {	// getter
		return this._error;
	}
	
	public void setError (CalculatorError newError) {	// setter
		this._error = newError;
	}
	
	public CalculatorException() {	// getter
		this.setError(CalculatorError.UndeFined);
	}
	
	public CalculatorException(CalculatorError givenError) {	// setter
		this.setError(givenError);
	}

}
