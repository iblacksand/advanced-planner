package tester;

import compile.Compiler;

/**
 * Created by John Elizarraras on 3/4/2016.
 */
public class CompilerTester {

    public static void main(String[] args) {
        Compiler comp = new Compiler("example.txt");
        comp.listErrors();
        System.out.println(comp.errors());
    }
}
