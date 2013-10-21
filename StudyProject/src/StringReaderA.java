
public class StringReaderA implements IStringReader {
	
	private boolean isRead;

	public StringReaderA() {
		this.setIsRead(false);
	}

	@Override
	public boolean hasMoreStrings() {
		return !this.getIsRead();
	}

	@Override
	public String readString() {
		this.setIsRead(false);
		return "A";
	}

	public boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}

}
