package ru.urfu.rtf.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileStringReader implements IPaymentStringReader {

	private BufferedReader reader;
	
	public FileStringReader(String filePath) {
		File file = getFile(filePath);
		try {
			this.reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			this.reader = null;
		}
	}
	
	private File getFile(String filePath) {
		// method for checking and creating appropriate file
		// now just create new one
		return new File(filePath);
	}

	@Override
	public boolean hasNextString() {
		try {
			return reader.ready();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String readString() {
		try {
			return reader.readLine();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public void finish() {
		try {
			reader.close();
		} catch (Exception e) {
		}
	}

}
