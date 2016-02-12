package file;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileEditor {
	Scanner in = new Scanner(System.in);
	String path;
	ArrayList<String> file = new ArrayList<String>();

	public static void main(String[] args) {
		FileEditor fileEditor = new FileEditor("example.sc");
		System.out.println(fileEditor.textSize());
		for(int i = 0; i < fileEditor.textSize(); i++) {
			fileEditor.editLine(i);
		}
	}

	public FileEditor(String path) {
		this.path = path;
		readFile();
	}

	public void readFile() {
		try {
			File f = new File(path);
			BufferedReader r = new BufferedReader(new FileReader(f));
			for (int i = 0; i < textSize(); i++) {
				file.add(r.readLine());
			}
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found : " + path);
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

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
	 *
	 * @param index the index of the line
	 * @return the full line in string form
	 */
	public String line(int index) {
		String str = "";
		if (index < file.size()) str = file.get(index);
		return str;
	}

	public void editLine(int index) {
		System.out.println("line: " + file.get(index) + "\nDo You want to edit this line?");
		String input = in.nextLine().toLowerCase().trim();
		if (input.equals("y") || input.equals("yes"))
		{
			try {
				FileWriter fw = new FileWriter(path,true);
				PrintWriter w = new PrintWriter(fw);
				for (int i = 0; i < index; i++) {
					w.println(file.get(i));
				}
				System.out.println("What do you want to change it to?");
				w.println(in.nextLine());
				readFile();
				for(String str : file)
				{
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String inStringForm(Clipboard clpbrd)
	{
		String str = "error";
		try
		{
			str = "" + clpbrd.getData(DataFlavor.stringFlavor);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}
}