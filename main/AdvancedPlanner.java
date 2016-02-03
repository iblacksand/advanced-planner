import java.util.*;
import java.io.*;
/**
*the base of the advanced planner
*@author John Elizarraras
*@version Feb. 1 2016
*/
public class AdvancedPlanner
{
	private static int failures;
	/**
	*the main method
	*@param args arguments (not used)
	*/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Script file = new Script();
		failures = false;
		boolean exit = false;
		while(exit == false)
		{
			exit = runCommand();
		}
	}

	/**
	*the method that loops the code for the specified amount
	*@param props the properties of the loop
	*@param object array holding the information of the loop
	*/
	public static void loop(String[] props,String[] object)
	{
		if(props[0].equals("f") && failures > 0)
		{
			gui.trowException("Error: Fragile and " + failures + " failures.");
		}
		else
		{
			file.toLine(file.currentLine() + 2);
			int startLine = file.currentLine();

			int loopEnd = startLine();
			for(int i = startLine; i < file.length(); i++)
			{
				String str = file.fullLine();
				if(str.equals("}")) break;
				else loopEnd++;
			}
			for(int i = 0; i < Integer.parseInt(String[1]); i++)
			{
				for(int p = startLine; i < loopEnd; p++)
				{
					runCommand(p);
				}
			}
			file.toLine(loopEnd + 1);
		}
	}

	/**
	*runs the commands in the script
	*@return the boolean if the file is on its line
	*/
	public static boolean runCommandMain()
	{
		String command = file.command();
		String[] props = file.properties();
		String object = file.object();
		switch(command)
		{
			case "loop":
			loop(props,object);
			break;
			case "run":
			run(props,object);
			break;
			case "display":
			display(props,object);
			break;
			break;
			default:
			break;
		}
		file.nextLine();
		return file.isLastLine();
	}

	/**
	*runs the command on the specified line
	*@param k the line to look at
	*/
	public static void runCommand(int k)
	{
		String command = file.command(k);
		String[] props = file.properties(k);
		String object = file.object(k);
		switch(command)
		{
			case "loop":
			loop(props,object);
			break;
			case "run":
			run(props,object);
			break;
			case "display":
			display(props,object);
			break;
			break;
			default:
			break;
		}
	}
}
