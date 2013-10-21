
public class TestClass {

	
	public static void main(String[] args) {
		
		TestWithStaticField t1 = new TestWithStaticField();
		TestWithStaticField t2 = new TestWithStaticField();

		//t1.setValues(10);
		t2.setValues(20);
		
		System.out.println(t1.getSharedValue());
		t1.setValues(10);
		System.out.println(t2.getSharedValue());
		System.out.println(TestWithStaticField.sharedValue);
	}

}
