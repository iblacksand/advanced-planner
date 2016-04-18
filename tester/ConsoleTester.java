package tester;

import java.util.Scanner;
import gui.Console;

/**
 * Created by John Elizarraras on 4/10/2016.
 */
public class ConsoleTester {
    public static void main(String[] args){
        //launch(args);
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        Console con = new Console(text);
    }
}
