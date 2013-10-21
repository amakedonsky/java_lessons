
public class StringReaderC implements IStringReader {

	private boolean isRead;
	
	public StringReaderC() {
		this.setRead(false);
	}
	
	@Override
	public boolean hasMoreStrings() {
		return !this.isRead();
	}

	@Override
	public String readString() {
		this.setRead(true);
		return "C";
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

}
