package tester;

import file.Script;

/**
 * tests the script.java
 * @author Johnny
 *
 */
public class ScriptTester
{
    public static void main(String[] args)
    {
        System.out.println("hello");
        standard("example.sc");
    }

    public static void standard()
    {
        Script file = new Script();
        for(int i = 0; i < file.fileSize(); i++)
        {
            System.out.println("starting test:");
            String c = file.command();
            String[] p = file.properties();
            String[] o = file.object();
            System.out.println(c);
            for(int x = 0; x < p.length; x++)
            {
                System.out.println(p[x]);
            }
            for(int x = 0; x < o.length; x++)
            {
                System.out.println(o[x]);
            }
            file.nextLine();
        }
    }

    public static void standard(String path)
    {
        Script file = new Script(path);
        for(int i = 0; i < file.fileSize(); i++)
        {
            System.out.println("starting test:");
            String c = file.command();
            String[] p = file.properties();
            String[] o = file.object();
            System.out.println(c);
            for(int x = 0; x < p.length; x++)
            {
                System.out.println(p[x]);
            }
            for(int x = 0; x < o.length; x++)
            {
                System.out.println(o[x]);
            }
            file.nextLine();
        }
    }
}
