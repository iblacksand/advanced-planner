import java.util.*;
import java.io.*;
public class Script
{
    private String path;
    private int curLine;
    private String[] file;

    public Script()
    {
        path = "main.txt";
        curLine = 0;
        readFile();
    }

    public void readFile()
    {
        try
        {
        FileReader fr = new FileReader("main.txt");
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

    public void nextLine()
    {
        curLine++;
    }

    public int currentLine()
    {
        return curLine;
    }

    public void toLine(int k)
    {
        curLine = k;
    }

    public String fullLine()
    {
        return file[curLine];
    }

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
