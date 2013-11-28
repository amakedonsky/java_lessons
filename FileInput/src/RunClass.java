import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class RunClass {

	public static void main(String[] args) {
		File file = new File("C:\\input.txt");
		try {
			InputStream is = new FileInputStream(file);
			try {
				dumpStream(is);
			} finally {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void dumpStream(InputStream is) throws IOException {
		while (is.available() > 0) {
			int value = is.read();
			System.out.print(Integer.toHexString(value));
		}
	}
}
