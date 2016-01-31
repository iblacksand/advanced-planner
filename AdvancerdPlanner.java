import java.util.*;
import java.io.*;
public class AdvancedPlanner
{
	private static boolean failures;
	private static TiemUnit t = new TiemUnit();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Script file = new Script();
		failures = false;
		boolean exit = false;
		while(exit == false;)
		{
			runCommand();
		}
	}

	public static loop(String[] props,String[] object)
	{
		if(props[0].equals("f") && failures == true)
		{

		}
		else
		{
			file.toLine(file.currentLine() + 2);
			int startLine = file.currentLine();
			
		}
	}

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
			run(props,object)
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
			run(props,object)
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