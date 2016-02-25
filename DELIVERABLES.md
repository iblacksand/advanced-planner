#Deliverables


Dates:
[February 26](##Deliverables for February 26)

##Deliverables for February 26
###From [FileEditor.java](https://github.com/iblacksand/advanced-planner/blob/master/file/FileEditor.java)

```java
package file;
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
```

This does the basic functions of a file editor. There are more methods but this is a good snippet

###From [Script.java](https://github.com/iblacksand/advanced-planner/blob/master/file/Script.java)

```java
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
```

This can read the file and put it in an array. Other methods figure out which parts are which

###From [AdvancedPlanner.java](https://github.com/iblacksand/advanced-planner/blob/master/main/AdvancedPlanner.java)

```java
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
```

This will run a cmd command or run a program

```java
public static void display(String[] props, String[] objs)
{
for (String obj : objs) {
System.out.print(obj);
}
}
```

This will display the text given. This will change when the gui is implemented

