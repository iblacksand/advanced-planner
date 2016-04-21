package compile;

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
    public CompilerViewer(compile.Compiler comp){
        errors = comp.getErrors();
        generate();
    }

    private void generate(){
        try{
            FileWriter fw = new FileWriter(new File("compileErrors.html"));
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<title>Advanced-Planner Compile Messages</title>");
            pw.println("<xmp theme =\"readable\" style:\"display:none;\">");
            pw.println("# [Advanced Planner](http://iblacksand.github.io/advanced-planner/) Compiler Errors:");
            for (CompileError e:errors) {
                pw.println("#### Error on line: " + e.getLine());
                pw.println("Error Message: " + e.errorMessage());
            }
            if(errors.size() == 0) pw.println("# No Errors");
            pw.println("###### Line Indexes start at 0");
            pw.println("</xmp>");
            pw.println("<script src=\"http://strapdownjs.com/v/0.2/strapdown.js\"></script>");
            pw.println("</html>");
            pw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
