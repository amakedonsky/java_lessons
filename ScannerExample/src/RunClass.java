import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Scanner;


public class RunClass {

	public static void main(String[] args) {
		try	{
			String systemEncoding = System.getProperty("file.encoding");
			System.out.println("Input encoding is: " + systemEncoding);
			System.out.print("Enter simple numeric expression: ");
			
			Scanner scanner = new Scanner(
					new InputStreamReader(System.in, systemEncoding));
			scanner.useDelimiter("");
			
			String strValue1 = scanner.next("\\d+");
			String strOperator = scanner.next("[\\+\\-\\*/]");
			String strValue2 = scanner.next("\\d+");
			
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(
							new BufferedOutputStream(System.out), systemEncoding));
			writer.println(
					MessageFormat.format("Parsed expression: {0} {1} {2}", 
							new Object[]{strValue1, strOperator, strValue2}));
			writer.flush();
			scanner.close();
		} catch (Exception ex) { 
			ex.printStackTrace(); 
		} 
	}

}
