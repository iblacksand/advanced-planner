package file;

import java.io.*;
import java.util.ArrayList;

public class FileEditor
{
	File f;
	BufferedReader r;
	PrintWriter w;
	String path;
	ArrayList<String> file = new ArrayList<String>();
	public FileEditor(String path)
	{
		this.path = path;
		try{
			f = new File(path);
			r = new BufferedReader(new FileReader(f));
			w = new PrintWriter(new FileWriter(f));
			readFile();
		}

		catch(FileNotFoundException e)
		{
			System.out.println("File not Found : " + path);
			System.exit(1);
		}

		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void readFile()
	{
		try{
			f = new File(path);
			r = new BufferedReader(new FileReader(f));
			for(int i= 0; i < textSize(); i++)
			{
				file.add(r.readLine());
			}
			r.close();
		}

		catch(FileNotFoundException e)
		{
			System.out.println("File not Found : " + path);
			System.exit(1);
		}

		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
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

            }

            t = -1;
        }
        catch(IOException e)
        {
			e.printStackTrace();
        }
        return t;
    }

	/**
	 * gets the full line at specfied index
	 * @param index the index of the line
	 * @return the full line in string form
     */
	public String line(int index)
	{
		String str = "";
		if(index < file.size()) str = file.get(index);
		return str;
	}
}