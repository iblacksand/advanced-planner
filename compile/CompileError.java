package compile;

/**
* A compile error used for the Compiler
* @author John Elizarraras
* @version February 19 2016
*/
public class CompileError{

	int lineNum;

	/**
	* creates a new compile error
	* @param lineNumber the line number of the error
	*/
	public CompileError(int lineNumber){
		this.lineNume = lineNumber;
	}
	
	/**
	* gets the line number of the error
	* @return the line number of the error
	*/

	public int getLine(){
		return lineNum;
	}

