#Deliverables


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
System.out.println(obj);
}
}
```

This will display the text given. This will change when the gui is implemented

```java
/**
     *the method that loops the code for the specified amount
     *@param props the properties of the loop
     *@param object array holding the information of the loop
     */
    public static void loop(String[] props,String[] object)
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
            for(int p = startLine; p < loopEnd; p++)
            {
                runCommand(p - 1);
            }
        }
        file.toLine(loopEnd + 1);
    }
```

This will loop the code for the specified amount. This is a basic version and the time between is not implemented.

##From [/tester](https://github.com/iblacksand/advanced-planner/tree/master/tester)

```java
package tester;

import file.FileEditor;
/**
 * Created by John Elizarraras on 2/27/2016.
 */
public class FileEditorTester {

    /**
     * tests the file editor class
     * @param args not used
     */
    public static void main(String[] args){
        String path = "example.txt";
        FileEditor fe = new FileEditor(path);
        fe.addLine();
        fe.insertLine();
        fe.addLine();
    }
}
```
This tests the FileEditor for everything that is is capable of

```java
public static void standard(String path)
    {
        Script file = new Script(path);
        for(int i = 0; i < file.fileSize(); i++)
        {
            System.out.println("starting test:");
            String c = file.command();
            String[] p = file.properties();
            String[] o = file.object();
            System.out.println(c);
            for (String aP : p) {
                System.out.println(aP);
            }
            for (String anO : o) {
                System.out.println(anO);
            }
            file.nextLine();
        }
    }
```

This does a standard test for the script.java

```java
package tester;
import main.AdvancedPlanner;
public class CommandTest {
    /**
     * does a test of the example.sc file
	 * @param args not used
     */
	public static void main(String[] args)
	{
		String[] a = {"example.sc"};
		 AdvancedPlanner.main(a);
	}
}
```

This will run the example.txt to test different commands

## Deliverables for March 15

### From [Compiler.java](https://github.com/iblacksand/advanced-planner/blob/master/compile/Compiler.java)

```java
/**
     * compiles all of the file
     */
    private void compile(){
        for(int i = 0; i < file.length(); i++){
            String line = file.fullLine();
            if(isCommand(file.command())){
	    	switch(file.command().toLowerCase()){
			    case "run":
			        checkRun(i);
			        break;
			    case "loop":
			        checkLoop(i);
			        break;
			    case "display":
			        checkDisplay(i);
			        break;
                case "{":
                    break;
                case "}":
                    break;
			    default:
			        addError(i,"Not a command");
			        break;
		}
            }
            else{
                addError(i, "This is not a command");
            }
            file.nextLine();
        }
    }
```

This will go through and make sure the commands go through and add errors if needed

### From [GuiWindow.java](https://github.com/iblacksand/advanced-planner/blob/master/gui/GuiWindow.java)

```java
super("Advanced Planner");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                GuiWindow.this.setVisible(false);
                GuiWindow.this.dispose();
            }
        });

        final JLabel test  =new JLabel();
        test.setText("Hello");
        add(test);
```

This was used to test how Swing worked and know I think I will be able to work on the actual GUI.

## Deliverables for the April 1 2016

### From [/gui](https://github.com/iblacksand/advanced-planner/tree/master/gui)

```java
Button edit = new Button("Edit File");
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String file = textField.getText();
                if(isFile(file)){
                    notFile.setVisible(false);
                    new ScriptMaker(file);
                }
                else{
                    notFile.setVisible(true);
                }
            }
        });
```

```java
 Button exit = new Button("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primStage.hide();
            }
        });
        Button add = new Button("Add Line");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileEditor.add(textField.getText());
            }
        });
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0,20,10,20));
        hBox.getChildren().addAll(textField, add, exit);
        borderPane.setCenter(hBox);
        Scene scene = new Scene(borderPane, 800, 600);
        primStage.setScene(scene);
        primStage.show();
```

This is the gui for making the script which was one of the deliverables i plan to add more complicated gui that will prevent any errors made.

### From [Compiler.java](https://github.com/iblacksand/advanced-planner/blob/master/compile/Compiler.java)
```java
 /**
     * checks if the string is a command
     * @param posCommand the possible command
     * @return true if the string is an accepted command
     */
    private boolean isCommand(String posCommand){
        boolean result = true;
        switch(posCommand.toLowerCase()){
            case "loop":
            break;
            case "run":
            break;
            case "display":
            break;
            case "{":
                break;
            case "}":
                break;
            default:
            result = false;
            break;
        }
        return result;
    }
```

This is a snippet that will check to make sure all of the possible commands will work. I have tested it a lot and have no errors that i can find

### From [AdvancedPlanner.java](https://github.com/iblacksand/advanced-planner/blob/master/main/AdvancedPlanner.java)
```java
public void alias(String[] props, String[] objs){
        String[] file = {combine(objs, true, false)};
        AdvancedPlanner.main(file);
    }
```
this is the very basics of the alias support. The program won't recognize it unless you do under the hood stuff.