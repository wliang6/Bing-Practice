package lab10;

public class Person implements Comparable<Person>{
	private String firstname;
	private String lastname;
	
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

    public int compareTo(Person other) {
    	if(this.lastname.compareTo(other.lastname) == 0){
    		return this.firstname.compareTo(other.firstname);
    	}
    	return this.lastname.compareTo(other.lastname);
    }

	@Override
	public String toString() {
		return lastname + ", " + firstname;
	}
}
