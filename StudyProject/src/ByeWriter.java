
public class ByeWriter implements IStringWriter {

	String stringForPrint;
	
	public ByeWriter() {
		
	}

	@Override
	public void setString(String printableString) {
		this.stringForPrint = printableString;
	}

	@Override
	public void printString() {
		System.out.println("Bye, " + this.stringForPrint);
	}

}
