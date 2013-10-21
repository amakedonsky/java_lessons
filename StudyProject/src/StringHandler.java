
public class StringHandler {

	public StringHandler() {		
		
	}

	public void handle(IStringReader myReader, IStringWriter myWriter) {
		String printableString = "";
		
		if (myReader.hasMoreStrings()) {
			printableString = myReader.readString();
		}
		
		printableString = printableString + "!";
		
		myWriter.setString(printableString);
		myWriter.printString();
	}
}
