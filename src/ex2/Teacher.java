package ex2;

public class Teacher {
	
	// states
	private final String name;
	private final Gender gender;
	
	// constructor
	public Teacher(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}
	
	// getters
	public Gender getGender() {
		return gender;
	}
	public String getName() {
		return name;
	}
	
	

}
