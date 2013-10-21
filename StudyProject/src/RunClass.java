
public class RunClass {

	public static void main(String[] args) {
		StringHandler myHandler = new StringHandler();
		
		myHandler.handle(
				new StringReaderA(), 
				new HelloWriter());
		
		myHandler.handle(
				new StringReaderA(), 
				new ByeWriter());
		
		myHandler.handle(
				new StringReaderB(), 
				new HelloWriter());
		
		myHandler.handle(
				new StringReaderB(), 
				new ByeWriter());
		
		myHandler.handle(
				new StringReaderC(), 
				new HelloWriter());
		
		myHandler.handle(
				new StringReaderC(), 
				new ByeWriter());
	}

}
