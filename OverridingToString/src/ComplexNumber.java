
public class ComplexNumber {

	private int real;
	private int image;
	
	public ComplexNumber() {
		setReal(0);
		setImage(0);
	}
	
	public ComplexNumber(int realValue, int imageValue) {
		setReal(realValue);
		setImage(imageValue);
	}
	
	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer(10);
		strBuffer.append(getReal());
		strBuffer.append(" + ");
		strBuffer.append(getImage());
		strBuffer.append("*i");
		return strBuffer.toString();		
	}

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
}
