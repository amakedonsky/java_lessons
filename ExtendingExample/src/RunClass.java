public class RunClass {

	public static void main(String[] args) {

		Parent parent = new Parent();
		//parent.printMessage();
		
		Child child = new Child();
		//child.printMessage();

		Parent something = new Child();
		something.printMessage();
	}

}
