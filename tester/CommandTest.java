package tester;
import main.AdvancedPlanner;
public class CommandTest {
    /**
     * does a test of the example.sc file
	 * @param args not used
     */
	public static void main(String[] args)
	{
		String[] a = {"example.sc"};
		new AdvancedPlanner(a[0]);
	}
}