package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *This is the file for reading and interpreting the file
 *@author John Elizarraras
 *@version February 2 2016
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
        ArrayList<String> a = new ArrayList<String>();
        String line = null;
        try
        {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            for(int i = 0; i < textSize(); i++)
            {
                line = br.readLine();
                if(line != null) a.add(line.trim());
                else break;
            }
            br.close();
            file = new String[a.size()];
            for(int i = 0; i < file.length; i++)
            {
                file[i] = a.get(i);
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                path + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + path + "'");
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
        String command = "";
        try
        {
            String line = file[curLine];
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
        }
        catch(Exception e)
        {

        }
        return command;
    }

    /**
     *gets the command portion of the specified line
     *@param k the line to look at
     *@return the command in the line
     */
    @SuppressWarnings("unused")
	public String command(int k)
    {
    	if(k < length() && k > -1)
    	{
            String command = "";
            try
            {
                String line = file[k];
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
            }
            catch(Exception e)
            {

            }
            return command;
    	}
    	return "";

    }

    /**
     *Gets the properties of the selected line
     * @param k the index of the line
     *@return the array of properties
     */
    public String[] properties(int k)
    {
        if(k < length() && k > -1)
        {
            String line = file[k];
            ArrayList<String> a = new ArrayList<String>();
            for(int i = 0; i < line.length() - 6; i++)
            {
                String str = line.substring(i,i+5);
                if(str.equals("prop("))
                {
                    String full = "";
                    for(int x = i + 5; x < line.length(); x++)
                    {
                        String c = line.substring(x,x+1);
                        if(!c.equals(")")) full += c;
                        else break;
                    }
                    a.add(full);
                }
            }

            for(int i = 0; i < a.size(); i++)
            {
                String str = a.get(i);
                switch(str.toLowerCase())
                {
                    case "fragile":
                    a.set(i,"f");
                    break;
                    case "autoclose":
                    a.set(i,"ac");
                    break;
                    case "f":
                    break;
                    case "ac":
                    break;
                    default:
                    if((str.substring((str.length()-1)).equals("h") || str.substring(str.length()-1).equals("m") || str.substring(str.length()-1).equals("s")) && isNumber(str.substring(0,str.length()-1)));
                    else
                    {
                        a.remove(i);
                        i--;
                    }
                    break;
                }

            }
            String[] props = new String[a.size()];
            for(int i = 0; i < props.length; i++)
            {
                props[i] = a.get(i);
            }
            return props;
        }
        else
        {
            return new String[0];
        }
    }

    /**
     *Gets the properties on the line specified
     *@return the properties of the line
     */
    public String[] properties()
    {
        if(!isLastLine())
        {
            String line = file[curLine];
            ArrayList<String> a = new ArrayList<String>();
            for(int i = 0; i < line.length() - 6; i++)
            {
                String str = line.substring(i,i+5);
                if(str.equals("prop("))
                {
                    String full = "";
                    for(int x = i + 5; x < line.length(); x++)
                    {
                        String c = line.substring(x,x+1);
                        if(!c.equals(")")) full += c;
                        else break;
                    }
                    a.add(full);
                }
            }

            for(int i = 0; i < a.size(); i++)
            {
                String str = a.get(i);
                switch(str.toLowerCase())
                {
                    case "fragile":
                    a.set(i,"f");
                    break;
                    case "autoclose":
                    a.set(i,"ac");
                    break;
                    case "f":
                    break;
                    case "ac":
                    break;
                    default:
                    if((str.substring((str.length()-1)).equals("h") || str.substring(str.length()-1).equals("m") || str.substring(str.length()-1).equals("s")) && isNumber(str.substring(0,str.length()-1)));
                    else
                    {
                        a.remove(i);
                        i--;
                    }
                    break;
                }

            }
            String[] props = new String[a.size()];
            for(int i = 0; i < props.length; i++)
            {
                props[i] = a.get(i);
            }

            return props;
        }
        else
        {
            return new String[0];
        }
    }

    /**
     * gets the objects of the current line
     * @return the array of objects
     */
    public String[] object()
    {
    	if(!isLastLine())
    	{
        ArrayList<String> a = new ArrayList<String>();
        String line = file[curLine];
        int start = 0;
        boolean startFound = false;
        for(int i = 0; i < line.length(); i++)
        {
            if(line.substring(i,i+1).equals(" "))
            {
                start = i;
                startFound = true;
                break;
            }
        }

        String str = line.substring(start + 1);
        String build = "";
        int lastCut = 0;
        for(int i = 0; i < str.length(); i++)
        {
            String c = str.substring(i,i+1);
            if(c.equals(" "))
            {
                a.add(build.trim());
                build = "";
                lastCut = i;
            }
            else build += c.trim();
        }
        a.add(str.substring(lastCut).trim());
        String[] objects = new String[a.size()];
        for(int i = 0; i < objects.length; i++)
        {
            objects[i] = a.get(i);
        }
        if(!startFound)
        {
            objects = new String[0];
        }
        return objects;
    	}
    	else
    	{
    		return new String[0];
    	}
    }

    /**
     * gets the objects in the specified line
     * @param k the line to look at
     * @return the array of objects
     */
    public String[] object(int k)
    {
    	if(k < length() &&  k > -1)
    	{
            ArrayList<String> a = new ArrayList<String>();
            String line = file[k];
            int start = 0;
            boolean startFound = false;
            for(int i = 0; i < line.length(); i++)
            {
                if(line.substring(i,i+1).equals(" "))
                {
                    start = i;
                    startFound = true;
                    break;
                }
            }

            String str = line.substring(start + 1);
            String build = "";
            int lastCut = 0;
            for(int i = 0; i < str.length(); i++)
            {
                String c = str.substring(i,i+1);
                if(c.equals(" "))
                {
                    a.add(build.trim());
                    build = "";
                    lastCut = i;
                }
                else build += c.trim();
            }
            a.add(str.substring(lastCut).trim());
            String[] objects = new String[a.size()];
            for(int i = 0; i < objects.length; i++)
            {
                objects[i] = a.get(i);
            }
            if(!startFound)
            {
                objects = new String[0];
            }
            return objects;
        }
    	else
    	{
    		return new String[0];
    	}
    }

    /**
     *gets the file size
     *@return the file size
     */
    public int fileSize()
    {
        return file.length;
    }

    /**
     * gets the length of the script
     * @return the number of lines in the script
     */
    public int length()
    {
        return file.length;
    }

    /**
     *gets the size of the text file
     *@return the size of the original text file
     */
    public int textSize()
    {
        int t = 0;
        try
        {
            FileReader fr = new FileReader(path);
            BufferedReader textReader = new BufferedReader(fr);

            for(int i =0; i<1000;i++)
            {
                String text = textReader.readLine();
                if(text==null
                ||text.trim().equals(""))
                {
                    textReader.close();
                    t = i;
                }
                else
                {

                }

            }

            t = -1;
        }
        catch(IOException e)
        {
        }
        return t;
    }

    /**
     * checks if the current line is past the last line
     * @return false if the current line is less then the line or true if not
     */
    public boolean isLastLine()
    {
        return !(curLine < length());
    }

    /**
     * checks if the string is a number
     * @param str the string to check
     * @return true if the string is a number
     */
    public boolean isNumber(String str)
    {
	boolean result = true;
	try{
		int test = Integer.parseInt(str);
	}
	catch(Exception e){
		result = false;
	}
        return result;
    }
}
