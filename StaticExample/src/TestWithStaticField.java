
public class TestWithStaticField {

	public static int sharedValue;
	private int localValue;
	
	public void setValues(int newValue) {
		TestWithStaticField.sharedValue = newValue;
		this.localValue = newValue;
	}

	public int getSharedValue() {
		return sharedValue;
	}

	public void setSharedValue(int sharedValue) {
		TestWithStaticField.sharedValue = sharedValue;
	}

	public int getLocalValue() {
		return this.localValue;
	}

	public void setLocalValue(int localValue) {
		this.localValue = localValue;
	}
}
