
public class StringReaderB implements IStringReader {
	
	private boolean isRead;

	public StringReaderB() {
		this.setIsRead(false);
	}

	@Override
	public boolean hasMoreStrings() {
		return !this.getIsRead();
	}

	@Override
	public String readString() {
		this.setIsRead(false);
		return "B";
	}

	public boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}

}
