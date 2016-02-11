package file;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
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
}