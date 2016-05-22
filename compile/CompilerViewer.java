package compile;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by John Elizarraras on 4/19/2016.
 */
public class CompilerViewer {
    ArrayList<CompileError> errors;
    String name;
    String path;
    public CompilerViewer(compile.Compiler comp, String name) {
        errors = comp.getErrors();
        this.name = name;
        path = comp.getString();
        generate();
        File htmlFile = new File(name + ".html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void generate() {
        try {
            FileWriter fw = new FileWriter(new File(name + ".html"));
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<title>Advanced-Planner Compile Messages: " + path + "</title>");
            pw.println("<xmp theme =\"readable\" style:\"display:none;\">");
            pw.println("# [Advanced Planner](http://iblacksand.github.io/advanced-planner/) Compiler Errors: " + path);
            for (CompileError e : errors) {
                pw.println("#### Error on line: " + e.getLine());
                pw.println("Error Message: " + e.errorMessage());
            }
            if (errors.size() == 0) pw.println("# No Errors");
            pw.println("###### Line Indexes start at 0");
            pw.println("</xmp>");
            pw.println("<script src=\"http://strapdownjs.com/v/0.2/strapdown.js\"></script>");
            pw.println("</html>");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
