package main;

import file.Script;
import file.FileEditor;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *the base of the advanced planner
 *@author John Elizarraras
 *@version Feb. 1 2016
 */
public class AdvancedPlanner
{
    private static int failures;
    private static Script file;
    private static Scanner in = new Scanner(System.in);

    /**
     *the main method
     *@param args arguments (not used)
     */
    public static void main(String[] args) {
        file = new Script(args[0]);
        failures = 0;
        System.out.println("hello");
        boolean exit = false;
        while(!exit)
        {
            System.out.println("running command");
            exit = runCommandMain();
        }
    }
    
    /**
     * sets the path of the file
     * @param path the new path of the file.
     */
    public static void setPath(String path)
    {
        file = new Script(path);
    }

    /**
     *the method that loops the code for the specified amount
     *@param props the properties of the loop
     *@param object array holding the information of the loop
     */
    public static void loop(String[] props,String[] object)
    {
        Timer timer = new Timer();
        file.toLine(file.currentLine() + 2);
        int startLine = file.currentLine();
        int loopEnd = startLine;
        for(int i = startLine; i < file.length(); i++)
        {
            String str = file.fullLine();
            if(str.equals("}")) break;
            else loopEnd++;
        }
        final int loope = loopEnd;
        for(int i = 0; i < Integer.parseInt(object[1]); i++)
        {
                    for(int p = startLine; p < loope; p++)
                    {
                        final int temp = p;
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runCommand(temp - 1);
                            }
                        }, convertTime(object[0]));

                    }
        }
        file.toLine(loopEnd + 1);
    }

    /**
     *runs the commands in the script
     *@return the boolean if the file is on its line
     */
    public static boolean runCommandMain()
    {
        String command = file.command();
        String[] props = file.properties();
        String[] object = file.object();
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
        if(k < file.length() && k > 0)
        {
            String command = file.command(k);
            String[] props = file.properties(k);
            String[] object = file.object(k);
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
                default:
                break;
            }
        }
        else failures++;
    }

    /**
     * runs a program
     * @param props the properties of the program
     * @param objs the name of the program
     */
    public static void run(String[] props, String[] objs)
    {
        if(contains(props,"f") && failures > 0)
        {
            System.out.println("Error! Fragile with " + failures + "failures");
        }
        else
        {
            String full = combine(objs,true,false);
            try{
                ProcessBuilder pb = new ProcessBuilder(combine(objs,true,false));
                Process p = pb.start();
            }
            catch(Exception e)
            {
                failures++;
            }
        }
    }

    /**
     * checks if the string array contains the other string
     * @param strA the String[] to search in
     * @param find the string to search for
     * @return true if the string[] contains the string
     */
    public static boolean contains(String[] strA, String find)
    {
        boolean result = false;
        for (String aStrA : strA) {
            if (aStrA.equalsIgnoreCase(find)) result = true;
        }
        return result;
    }

    /**
     * displays the objects created
     * @param props the properties of the text
     * @param objs the text to display
     */
    public static void display(String[] props, String[] objs)
    {
        for (String obj : objs) {
            System.out.println(obj);
        }
    }

    /**
     * allows for editing of the specified script
     * @param props the properties of the command
     * @param objs the object of the command 
     */
    public static void fixScript(String[] props, String[] objs)
    {
        System.out.println("What is the path to change?");
        FileEditor fe = new FileEditor(in.nextLine());
    }

    /**
    * combines an String array into one
    * @param ary the array to combine
    * @param toAddSpace boolean whether or not to add a space
    * @param newLines boolean wheter or not to put \n after each string
    * @return the String array combined into one
    */
    public static String combine(String[] ary, boolean toAddSpace, boolean newLines)
    {
        String params = "";
        if(toAddSpace) params += " ";
        if(newLines) params += "\n";
        String full = "";
        for (String anAry : ary) {
            full += anAry + params;
        }
        return full;
    }

	/**
	* adds a failure if needed
	*/
    public static void addFailure(){
        failures++;
	}

    /**
     * converts the string input into milliseconds
     * @param input the string to convert
     * @return the string in millisecond form or zero if input is not in correct format
     */
    public static int convertTime(String input){
        if(isNumber(input.substring(0,input.length() -1))) {
            int retVal = Integer.parseInt(input.substring(0,input.length() -1));
            switch (input.substring(input.length() - 1).toLowerCase().trim()) {
                case "m":
                    retVal *= 60000;
                    break;
                case "h":
                    retVal *= 360000;
                    break;
                case "s":
                    retVal *= 1000;
                    break;
                default:
                    retVal = 0;
                    break;
            }
            return retVal;
        }
        else{
            return 0;
        }
    }

    /**
     * checks if the string is an int
     * @param str the possible number to check
     * @return true if inputted string is a int.
     */
    private static boolean isNumber(String str){
        boolean result = false;
        try{
            Integer.parseInt(str);
            result = true;
        }
        catch(Exception e){
            result = false;
        }
        return result;
    }
}
