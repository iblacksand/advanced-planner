package compile;

/**
* A compile error used for the Compiler
* @author John Elizarraras
* @version February 19 2016
*/
public class CompileError{

	int lineNum;
	String errorMessage;
	/**
	* creates a new compile error
	* @param lineNumber the line number of the error
	* @param errorMessage the error message associated with the error
	*/
	public CompileError(int lineNumber, String errorMessage){
		this.lineNume = lineNumber;
		this.errorMessage = errorMessage;
	}
	
	/**
	* gets the line number of the error
	* @return the line number of the error
	*/
	public int getLine(){
		return lineNum;
	}
	
	/**
	 * gets the error message of the error
	 * @return the error message of the error
	 */
	public String errorMessage(){
		return errorMessage;
	}
}
