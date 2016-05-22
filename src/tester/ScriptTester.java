package tester;

import file.Script;

/**
 * tests the script.java
 *
 * @author Johnny
 * @version 2/5/2015
 */
public class ScriptTester {
    /**
     * starts the test
     *
     * @param args the arguments for the test
     */
    public static void main(String[] args) {
        System.out.println("hello");
        standard("example.txt");
    }

    /**
     * does a standard test of the main.txt file
     */
    public static void standard() {
        Script file = new Script();
        for (int i = 0; i < file.fileSize(); i++) {
            System.out.println("starting test:");
            String c = file.command();
            String[] p = file.properties();
            String[] o = file.object();
            System.out.println("Command - " + c);
            for (String aP : p) {
                System.out.println(aP);
            }
            for (String anO : o) {
                System.out.println(anO);
            }
            file.nextLine();
        }
    }

    /**
     * does a standard test on a special file
     *
     * @param path the path of the file
     */
    public static void standard(String path) {
        Script file = new Script(path);
        for (int i = 0; i < file.fileSize(); i++) {
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
}
