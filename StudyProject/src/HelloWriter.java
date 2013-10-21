
public class HelloWriter implements IStringWriter {

	String stringForPrint;
	
	public HelloWriter() {
		
	}

	@Override
	public void setString(String printableString) {
		this.stringForPrint = printableString;
	}

	@Override
	public void printString() {
		System.out.println("Hello, " + this.stringForPrint);
	}

}
