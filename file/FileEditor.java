package file;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
* FileEditor class
* @author John Elizarraras
* @version Feb 2 2016
*/
public class FileEditor {
	Scanner in = new Scanner(System.in);
	String path;
	ArrayList<String> file = new ArrayList<String>();

	/**
	* main method to test the method
	* @param args the arguments
	*/
	public static void main(String[] args) {
		FileEditor fileEditor = new FileEditor("example.sc");
		System.out.println(fileEditor.textSize());
		for(int i = 0; i < 2; i++) {
			fileEditor.addLine();
		}
	}

	/**
	* creates a new fileeditor editing the given path
	* @param path the path to edit
	*/
	public FileEditor(String path) {
		this.path = path;
		readFile();
	}

	/**
	* reads the file and adds it to an arraylist
	*/
	public void readFile() {
		file = new ArrayList<String>();
		try {
			File f = new File(path);
			BufferedReader r = new BufferedReader(new FileReader(f));
			for (int i = 0; i < textSize(); i++) {
				file.add(r.readLine());
			}
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found : " + path);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	* writes the given arraylist to the file
	* @param ary the arraylist to write to the file
	*/
	public void write(ArrayList<String> ary)
	{
		try
		{
			File f = new File(path);
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			for(String str : ary)
			{
				pw.println(str);
			}
			pw.close();
			readFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	* gets the files length
	* @return the size of the array
	*/
	public int textSize() {
		int t = 0;
		try {
			FileReader fr = new FileReader(new File(path));
			BufferedReader textReader = new BufferedReader(fr);

			for (int i = 0; i < 1000; i++) {
				String text = textReader.readLine();
				if (text == null
						|| text.trim().equals("")) {
					textReader.close();
					t = i;
					break;
				}

			}
			textReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * gets the full line at specfied index
	 * @param index the index of the line
	 * @return the full line in string form
	 */
	public String line(int index) {
		String str = "";
		if (index < file.size()) str = file.get(index);
		return str;
	}

	/**
	 * edits a line at a specified index
	 * @param index the line to change
     */
	public void editLine(int index) {
		System.out.println("line: " + file.get(index) + "\nDo You want to edit this line?");
		String input = in.nextLine().toLowerCase().trim();
		if (input.equals("y") || input.equals("yes"))
		{
			System.out.println("What do you want to change it too?");
			input = in.nextLine();
			String change = "";
			int length = input.length();
			if(length > file.get(index).length()) length = file.get(index).length();
			for(int i = 0; i < length; i++){
				if(input.substring(i,i+1).equals("*")) change += file.get(index).substring(i,i+1);
				else change += input.substring(i,i+1);
			}
			if(length != input.length())
			{
				for(int i = length; i < input.length(); i++)
				{
					change += input.substring(i,i+1);
				}
			}
			file.set(index, change);
			write(file);
		}
	}

	/**
	* Adds a line to the file
	*/
	public void addLine()
	{
		System.out.println("What do you want to add?");
		file.add(in.nextLine());
		write(file);
	}

	/**
	* inserts a line to the specified line
	*/
	public void insertLine()
	{
		System.out.println("What do you want to insert?");
		String input = in.nextLine();
		System.out.println("Where do you want to insert");
		String line = in.nextLine();
		if(!isNumber(line)){
			System.out.println("That is not a number!");
		}
		else{
			file.add(Integer.parseInt(line), input);
			write(file);
		}
	}

	/**
	* Checks if the String given is a number
	* @param str the string to check
	* @return true if string is a number
	*/
	public boolean isNumber(String str)
	{
		boolean result = false;
		try
		{
			Integer.parseInt(str);
			result = true;
		}
		catch (Exception e)
		{
			result = false;
		}
		return result;
	}
}
