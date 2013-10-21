
public class Parent {
	
	private String myMessage;
	
	public Parent() {
		setMessage("I'm a parent class!");
	}
	
	public void printMessage() {
		System.out.println(getMessage());
	}

	protected String getMessage() {
		return this.myMessage;
	}

	protected void setMessage(String newMessage) {
		this.myMessage = newMessage;
	}
}