
public class TestClass {

	public static void main(String[] args) {
		try {
			myFunction(args);
		} catch (MyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			System.out.println("Finished");
		}
	}
	
	public static void myFunction(String[] args) throws MyException {
		if (args.length == 0) {
			throw new MyException("There is no arguments");
		}
	}

}

class MyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}
}