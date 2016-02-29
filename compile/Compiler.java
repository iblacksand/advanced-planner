package compile;

import java.io.*;
import java.util.ArrayList;
 /**
 * Created by John Elizarraras on 2/28/2016.
 */
public class Compiler {

    ArrayList<CompileError> errors = new ArrayList<>();
    ArrayList<String> file = new ArrayList<>();
    String path;

    /**
     * Creates a new Compiler with a path of main.txt
     */
    public Compiler(){
        path = "main.txt";
    }

    /**
     * Creates a new Compiler
     * @param path the path of the file
     */
    public Compiler(String path){
        this.path = path;
    }

    /**
     * adds an error
     * @param line the line of the error
     * @param errorMessage the error message
     */
    public void addError(int line, String errorMessage){
        errors.add(new CompileError(line,errorMessage));
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
}
