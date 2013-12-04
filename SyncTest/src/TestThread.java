class TestThread implements Runnable {
	private int id;
	private String text;
	
	TestThread(int iValue, String strValue) {
		id = iValue;
		text = strValue;
	}
	
	public void run() {
		System.out.println(""+id+": value before: "+text);
		String strResult = SharedBuffer.reverse(text);
		System.out.println(""+id+": value after: "+strResult);
	}
}

