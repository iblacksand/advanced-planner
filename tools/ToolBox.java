package tools;

import java.io.FileReader;

/**
 * Created by John Elizarraras on 4/17/2016.
 */
public class ToolBox {
    /**
     * combines an String array into one
     * @param ary the array to combine
     * @param toAddSpace boolean whether or not to add a space
     * @param newLines boolean wheter or not to put \n after each string
     * @return the String array combined into one
     */
    public static String combine(String[] ary, boolean toAddSpace, boolean newLines)
    {
        String params = "";
        if(toAddSpace) params += " ";
        if(newLines) params += "\n";
        String full = "";
        for (String anAry : ary) {
            full += anAry + params;
        }
        return full;
    }

    /**
     * checks if the string is an int
     * @param str the possible number to check
     * @return true if inputted string is a int.
     */
    public static boolean isNumber(String str){
        boolean result = false;
        try{
            Integer.parseInt(str);
            result = true;
        }
        catch(Exception e){
            result = false;
        }
        return result;
    }

    public static boolean isFile(String name){
        boolean res = true;
        try {
            FileReader f = new FileReader(name);
        }
        catch(Exception e){
            res = false;
        }
        return res;
    }
}
