package tester;

import compile.CompilerViewer;

/**
 * Created by John Elizarraras on 4/19/2016.
 */
public class CompilerViewerTester {

    public static void main(String[] args) {
        new CompilerViewer(new compile.Compiler("example.txt"), "test");
    }
}
