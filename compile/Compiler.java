package compile;

import file.Script;
import tools.ToolBox;

import java.util.ArrayList;

/**
 * Created by John Elizarraras on 2/28/2016.
 */
public class Compiler {

    ArrayList<CompileError> errors = new ArrayList<>();
    Script file;
    String path;
    int aliasNum;
    /**
     * Creates a new Compiler with a path of main.txt
     */
    public Compiler() {
        path = "main.txt";
        file = new Script(path);
        compile();
        new CompilerViewer(this, "compileErrors");
        aliasNum = 0;
    }

    /**
     * Creates a new Compiler
     *
     * @param path the path of the file
     */
    public Compiler(String path) {
        this.path = path;
        file = new Script(path);
        compile();
        new CompilerViewer(this, "compileErrors");
        aliasNum = 0;
    }

    public Compiler(String path, String fileName) {
        this.path = path;
        file = new Script(path);
        compile();
        new CompilerViewer(this, fileName);
        aliasNum = 0;
    }

    public String getString(){
        return path;
    }

    /**
     * adds an error
     *
     * @param line         the line of the error
     * @param errorMessage the error message
     */
    public void addError(int line, String errorMessage) {
        errors.add(new CompileError(line, errorMessage));
    }
    /**
     * compiles all of the file
     */
    private void compile() {
        for (int i = 0; i < file.length(); i++) {
            String line = file.fullLine();
            if (isCommand(file.command())) {
                switch (file.command().toLowerCase()) {
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
                        checkOpenBracket(i);
                        break;
                    case "}":
                        checkCloseBracket(i);
                        break;
                    case "alias":
                        checkAlias(i);
                        break;
                    default:
                        addError(i, "Not a command");
                        break;
                }
            } else {
                addError(i, "This is not a command");
            }
            file.nextLine();
        }
    }

    private void checkAlias(int index) {
        String[] vars = file.object(index);

        if (!ToolBox.isFile(ToolBox.combine(vars, true, false))) {
            addError(index, "String given is not a file!");
        }
        else{
            Compiler comp = new Compiler(ToolBox.combine(vars, true, false), "compileErrors" + aliasNum);
            if(comp.errors() > 0) addError(index, "Alias has an error!");
            aliasNum++;
        }
    }

    /**
     * checks if the string is a command
     *
     * @param posCommand the possible command
     * @return true if the string is an accepted command
     */
    private boolean isCommand(String posCommand) {
        boolean result = true;
        switch (posCommand.toLowerCase()) {
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
            case "alias":
                break;
            default:
                result = false;
                break;
        }
        return result;
    }

    /**
     * checks if the run command is in the right format
     *
     * @param index the index of the command
     */
    public void checkRun(int index) {

    }

    /**
     * checks if the loop is in the correct format
     *
     * @param index the index of the loop command
     */
    public void checkLoop(int index) {
        String[] vars = file.object(index);
        if (vars.length < 2) addError(index, "Not enough modifiers");
        else if (vars.length > 2) addError(index, "Too many modifiers");
        else {
            if (isNumber(vars[0].substring(0, vars[0].length() - 1))) {
            } else {
                addError(index, "Time is not a number");
            }
            switch (vars[0].substring(vars[0].length() - 1)) {
                case "s":
                    break;
                case "m":
                    break;
                case "h":
                    break;
                case "d":
                    break;
                default:
                    addError(index, "Not an acceptable time format.");
                    break;
            }

            if (!isNumber(vars[1])) addError(index, "Second modifier is not a number");
            else {
                if (Integer.parseInt(vars[1]) < 0) addError(index, "Second modifier is negative");
            }
            try {
                if (!file.fullLine(index + 1).equals("{")) addError(index + 1, "Is not a '{'");

                boolean needsError = true;
                for (int i = index + 2; i < file.length(); i++) {
                    if (file.fullLine(i).equals("{")) {
                        addError(i, "Another '{' before a '}'");
                    } else if (file.fullLine(i).equals("}")) {
                        needsError = false;
                        break;
                    }
                }
                if (needsError) addError(file.length(), "No closing '}'");
            } catch (IndexOutOfBoundsException e) {
                addError(file.length(), "Loop doesn't open/close");
            }
        }
    }

    /**
     * checks if the display command is in the right format
     *
     * @param index the index of the run command
     */
    private void checkDisplay(int index) {

    }

    private void checkOpenBracket(int index) {
        try {
            if (!lineContains("loop", file.fullLine(index - 1), 0, 4))
                addError(index, "Open bracket without loop before");
        } catch (Exception e) {
            addError(index, "Open bracket without loop before");
        }
    }

    private void checkCloseBracket(int index) {
        try {
            for (int i = index - 1; i >= 0; i--) {
                if (lineContains("loop", file.fullLine(i), 0, 4)) return;
                else if (lineContains("}", file.fullLine(i), 0, 1)) addError(i, "'}' before '{'");
            }
            addError(index, "'}' with no opening bracket");
        } catch (Exception e) {
            addError(index, "Closed bracket in illegal position");
        }
    }

    private boolean lineContains(String wantToFind, String toCheck, int index1, int index2) {
        try {
            return wantToFind.equals(toCheck.substring(index1, index2));
        } catch (Exception e) {
        }
        ;
        return false;
    }

    /**
     * Checks if the String given is a number
     *
     * @param str the string to check
     * @return true if string is a number
     */
    public boolean isNumber(String str) {
        boolean result = false;
        try {
            Double.parseDouble(str);
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * gets the number of errors
     *
     * @return the amount of errors
     */
    public int errors() {
        return errors.size();
    }

    public ArrayList<CompileError> getErrors() {
        return errors;
    }

    /**
     * lists the errors in the file
     */
    public void listErrors() {
        for (CompileError error : errors) {
            System.out.println(error);
        }
    }
}
