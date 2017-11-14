package refactoring.result;

public class FullName {

	private String firstName;
	private String lastName;

	public FullName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public boolean abbreviationMatches(String firstNamePart) {
		return firstName.startsWith(firstNamePart.substring(0, firstNamePart.length() - 1));
	}

	public boolean matchFullName(String[] nameParts) {
		return firstName.equals(nameParts[0]) && lastName.equals(nameParts[1]);
	}

	public boolean matchLastName(String[] nameParts) {
		return lastName.equals(nameParts[0]);
	}

}
