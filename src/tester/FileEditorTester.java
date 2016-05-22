package tester;

import file.FileEditor;

/**
 * Created by John Elizarraras on 2/27/2016.
 */
public class FileEditorTester {

    /**
     * tests the file editor class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        String path = "example.txt";
        FileEditor fe = new FileEditor(path);
        fe.addLine();
        fe.insertLine();
        fe.addLine();
    }
}
