package main;

import file.Script;

/**
 *the base of the advanced planner
 *@author John Elizarraras
 *@version Feb. 1 2016
 */
public class AdvancedPlanner
{
    private static int failures;
    private static Script file;
    /**
     *the main method
     *@param args arguments (not used)
     */
    public static void main(String[] args) {
        file = new Script();
        if(args.length > 0)
        {
            setPath(args[0]);
        }
        failures = 0;
        System.out.println("hello");
        boolean exit = false;
        while(exit == false)
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
        if(props[0].equals("f") && failures > 0)
        {
            System.out.println("Fragile error");
        }
        else
        {
            file.toLine(file.currentLine() + 2);
            int startLine = file.currentLine();

            int loopEnd = startLine;
            for(int i = startLine; i < file.length(); i++)
            {
                String str = file.fullLine();
                if(str.equals("}")) break;
                else loopEnd++;
            }
            for(int i = 0; i < Integer.parseInt(object[1]); i++)
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
        if(!file.isLastLine())
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
    }

    /**
     * runs a program(broken)
     * @param props the properties of the program
     * @param objs the name of the program
     */
    public static void run(String[] props, String[] objs)
    {
        if(contains(props,"f") && failures > 0)
        {

        }
        else
        {
            String full = "";
            for(int i = 0; i < objs.length; i++)
            {
                full += objs[i];
            }
            try{
                Process p = Runtime.getRuntime().exec(full);
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
        for(int i = 0; i < strA.length; i++)
        {
            if(strA[i].equalsIgnoreCase(find)) result = true;
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
        for(int i = 0; i < objs.length; i++)
        {
            System.out.print(objs[i]);
        }
    }
}

