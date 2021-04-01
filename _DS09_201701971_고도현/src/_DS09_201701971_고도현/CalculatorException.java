package _DS09_201701971_고도현;

public class CalculatorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CalculatorError _error;	// 오류 코드를 저장할 instance variable
	
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
