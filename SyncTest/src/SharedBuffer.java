public class SharedBuffer
{
	public static void main(String [] args)	{
		new Thread(new TestThread(1, "Some text")).start();
		new Thread(new TestThread(2, "Another text string")).start();
	}
	
	static private StringBuffer stringBuffer = new StringBuffer();
	
	static public String reverse(String strValue) {
		stringBuffer.setLength(0);
		for (int iIdx = strValue.length() - 1; iIdx >= 0; iIdx--)
		{
			stringBuffer.append(strValue.charAt(iIdx));
			try	{
				Thread.sleep(50);
			} catch (InterruptedException ex) {
			}
		}
		return stringBuffer.toString();
	}
}