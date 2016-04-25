package main;

import file.Script;
import file.FileEditor;
import tools.ToolBox;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 *the base of the advanced planner
 *@author John Elizarraras
 *@version Feb. 1 2016
 */
public class AdvancedPlanner
{
    private  int failures;
    private  Script file;
    private  Scanner in = new Scanner(System.in);

    public AdvancedPlanner(String file){
        this.file = new Script(file);
        failures = 0;
        while(runCommandMain());
    }

    /**
     * sets the path of the file
     * @param path the new path of the file.
     */
    public  void setPath(String path)
    {
        file = new Script(path);
    }

    /**
     *the method that loops the code for the specified amount
     *@param props the properties of the loop
     *@param object array holding the information of the loop
     */
    public void loop(String[] props,String[] object)
    {
        pause(props);
        file.toLine(file.currentLine() + 2);
        int startLine = file.currentLine();
        int loopEnd = startLine;
        for(int i = startLine; i < file.length(); i++)
        {
            String str = file.fullLine();
            if(str.equals("}")) break;
            else loopEnd++;
        }
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for(int i = 0; i < Integer.parseInt(object[1]); i++)
        {
            for(int p = startLine; p < loopEnd; p++)
            {
                runCommand(p);
                ToolBox.pause(convertTime(object[0]));
            }
        }
        file.toLine(loopEnd);
    }

    public void alias(String[] props, String[] objs){
        String file = combine(objs, true, false);
        new AdvancedPlanner(file);
    }

    /**
     *runs the commands in the script
     *@return the boolean if the file is on its line
     */
    public boolean runCommandMain()
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
    public void runCommand(int k)
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
    public void run(String[] props, String[] objs)
    {
        if(contains(props,"f") && failures > 0)
        {
            System.out.println("Error! Fragile with " + failures + "failures");
        }
        else
        {
            pause(props);
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
    public boolean contains(String[] strA, String find)
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
    public void display(String[] props, String[] objs)
    {
        pause(props);
        for (String obj : objs) {
            System.out.println(obj);
        }
    }

    /**
     * allows for editing of the specified script
     * @param props the properties of the command
     * @param objs the object of the command 
     */
    public void fixScript(String[] props, String[] objs)
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
    public String combine(String[] ary, boolean toAddSpace, boolean newLines)
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
    public void addFailure(){
        failures++;
    }

    /**
     * converts the string input into milliseconds
     * @param input the string to convert
     * @return the string in millisecond form or zero if input is not in correct format
     */
    public int convertTime(String input){
        if(isNumber(input.substring(0,input.length() -1))) {
            double retVal = Integer.parseInt(input.substring(0,input.length() -1));
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
            return (int)retVal;
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
    private boolean isNumber(String str){
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

    private void pause(String[] possible){
        for(String str : possible){
            if(validTime(str)){
                ToolBox.pause(convertTime(str));
            }
        }
    }

    public boolean validTime(String input){
        boolean retVal = false;
        switch (input.substring(input.length() - 1).toLowerCase().trim()) {
            case "m":
            retVal = true;
            break;
            case "h":
            retVal = true;
            break;
            case "s":
            retVal = true;
            break;
            default:
            retVal = false;
            break;
        }
        return retVal;
    }
}
