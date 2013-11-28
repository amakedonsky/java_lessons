package ru.urfu.rtf.bank;

public interface IPaymentStringReader {

	public boolean hasNextString();
	public String readString();
	public void finish();
}
