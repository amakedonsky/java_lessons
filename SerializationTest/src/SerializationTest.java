import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class SerializationTest {

	public static void main(String[] args) {
		
		Person person = new Person(20, "Ivanov Ivan");
		File file = new File("data.bin");
		try {
			OutputStream os = new FileOutputStream(file);
			try {
				ObjectOutputStream oos = 
						new ObjectOutputStream(new BufferedOutputStream(os));
				try {
					oos.writeObject(person);
					oos.flush();
				}
				finally {
					oos.close();
				}
			}
			finally {
				os.close();
			}
			InputStream is = new FileInputStream(file);
			try {
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is));
				try {
					Person restored = (Person)ois.readObject();
					System.out.println(restored.getPersonName()+": "+restored.getPersonAge());
					boolean bSame = (person == restored);
					System.out.println("Same object: "+bSame);
				}
				catch (ClassNotFoundException ex) { 
					ex.printStackTrace(); 
				}
				finally { 
					ois.close(); 
				}
			}
			finally { 
				is.close(); 
			}
		}
		catch (IOException ex) { 
			ex.printStackTrace(); 
		}
	}

}
