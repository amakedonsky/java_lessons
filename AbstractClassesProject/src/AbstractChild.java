
public abstract class AbstractChild implements ISomeInterface{

	public void someMethod() {
		System.out.println("Some value:" + someOtherMethod());
	}

	public int someOtherMethod() {
		return 10 + getValue();
	}

	abstract protected int getValue();
}
