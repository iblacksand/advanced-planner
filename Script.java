import java.util.*;
import java.io.*;
/**
*This is the file for reading and interpreting the file
*@author John Elizarraras
*@version Febuary 1 2016
*/
public class Script
{
    private String path;
    private int curLine;
    private String[] file;

    /**
    *The constructor where it sets the defualt path of main.txt
    */
    public Script()
    {
        path = "main.txt";
        curLine = 0;
        readFile();
    }

    /**
    *The constructor for a specific path
    *@param path the path of the special file
    */
    public Script(String path)
    {
        this.path = path;
        curLine = 0;
        readFile();
    }

    /**
    *reads the file and puts it in an array
    */
    public void readFile()
    {
        try
        {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        ArrayList<String> a = new ArrayList<String>();
        for(int i =0; i<1000;i++)
        {
            try
            {
            String text = textReader.readLine();
            if(text!="")
            {
                a.add(text);
            }
            else
            {
                break;
            }
            }
            catch (IOException e)
            {
                break;
            }
        }
        textReader.close();
        file = new String[a.size()];
        for(int i = 0; i < a.size(); i++)
        {
            file[i] = a.get(i);
        }
        }

        catch(IOException e)
        {

        }
    }

    /**
    * Makes the script move to the next line
    */
    public void nextLine()
    {
        curLine++;
    }

    /**
    *gets the current line the script is looking at
    *@return the current line
    */
    public int currentLine()
    {
        return curLine;
    }

    /**
    *sets the line on the script to the one specified
    *@param k the line to move to
    */
    public void toLine(int k)
    {
        curLine = k;
    }

    /**
    *gets the full string of the current line
    *@return the full line
    */
    public String fullLine()
    {
        return file[curLine];
    }

    /**
    *gets the full string of the specified line
    *@param k the index of the line
    *@return the full line
    */
    public String fullLine(int k)
    {
        try
        {
            return file[k];
        }

        catch(Exception e)
        {
            return "";
        }
    }

    /**
    *gets the command portion of the current line
    *@return the command in the line
    */
    public String command()
    {
        String line = file[curLine];
        String command = "";
        for(int i = 0; i < line.length(); i++)
        {
            String str = line.substring(i,i+1);
            if(!(str.equals(" ") || str.equals(".")))
            {
                command += str;
            }
            else
            {
                break;
            }
        }
        return command;
    }
}
