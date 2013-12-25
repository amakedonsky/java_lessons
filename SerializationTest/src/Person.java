import java.io.Serializable;

class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int personAge;
	private String personName;
	
	private Person() {
		// do nothing;
	}
	
	public Person(int iAge, String strName) {
		personAge = iAge;
		personName = strName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
}