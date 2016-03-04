package compile;

import file.Script;
import java.io.*;
import java.util.ArrayList;
/**
 * Created by John Elizarraras on 2/28/2016.
 */
public class Compiler {

    ArrayList<CompileError> errors = new ArrayList<>();
    Script file;
    String path;

    /**
     * Creates a new Compiler with a path of main.txt
     */
    public Compiler(){
        path = "main.txt";
        file = new Script(path);
        compile();
    }

    /**
     * Creates a new Compiler
     * @param path the path of the file
     */
    public Compiler(String path){
        this.path = path;
    }

    /**
     * adds an error
     * @param line the line of the error
     * @param errorMessage the error message
     */
    public void addError(int line, String errorMessage){
        errors.add(new CompileError(line,errorMessage));
    }

    private void compile(){
        for(int i = 0; i < file.length(); i++){
            String line = file.fullLine();
            if(isCommand(file.command())){
	    	switch(file.command().toLowerCase()){
			case "run":
			checkRun(i);
			break;
			case "loop":
			checkLoop(i);
			break;
			case "display":
			checkDisplay(i);
			break;
			default:
			addError("Not a command");
			break;
		}
            }
            else{
                addError(i, "This is not a command");
            }
            file.nextLine();
        }
    }

    private boolean isCommand(String posCommand){
        boolean result = true;
        switch(posCommand.toLowerCase()){
            case "loop":
            break;
            case "run":
            break;
            case "display":
            break;
            default:
            result = false;
            break;
        }
        return result;
    }

    public void checkRun(){
    }
    
    public void checkLoop(int index){
	String[] vars = file.objects(i);
	if(vars.length < 2) addError(index, "Not enough modifiers");
	else if(vars.length > 2) addError(index, "Too many modifiers");
	else{
		if(isNumber(vars[0].substring(0, vars[0].length()))){
		}
		else{
			addError(index, "Time is not a number");
		}
		switch(vars[0].substring(vars[0].length() - 1)){
			case "s":
			break;
			case "m":
			break;
			case "h":
			break;
			case "d":
			break;
			default:
			new 
					
	}
    }

        /**
	* Checks if the String given is a number
	* @param str the string to check
	* @return true if string is a number
	*/
	public boolean isNumber(String str)
	{
		boolean result = false;
		try
		{
			Integer.parseInt(str);
			result = true;
		}
		catch (Exception e)
		{
			result = false;
		}
		return result;
	}
}
