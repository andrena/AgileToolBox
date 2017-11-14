package refactoring;

import java.util.Arrays;

public class UglyClass {
	private final String firstName;
	private final String lastName;
	private final String gender;

	public UglyClass(String gender, String firstName, String lastName) {
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean isTheSameAs(String name) {
		String[] nameParts = name.split(" ");
		String firstNamePart = nameParts[0];
		boolean salutationMatched = false;
		boolean abbreviationMatched = false;
		if (firstNamePart.indexOf('.') > 0) {
			if (firstNamePart.equals("Hr.") && gender.equals("m")) {
				salutationMatched = true;
			} else if (firstNamePart.equals("Fr.") && gender.equals("f")) {
				salutationMatched = true;
			} else if (firstName.startsWith(firstNamePart.substring(0, firstNamePart.length() -1))) {
				abbreviationMatched = true;
			}
			if (salutationMatched || abbreviationMatched) {
				nameParts = Arrays.copyOfRange(nameParts, 1, nameParts.length);
			}
		}
		if (abbreviationMatched || nameParts.length == 1) {
			return matchLastName(nameParts);
		} else {
			return matchFullName(nameParts);
		}
	}

	private boolean matchFullName(String[] nameParts) {
		return firstName.equals(nameParts[0]) && lastName.equals(nameParts[1]);
	}

	private boolean matchLastName(String[] nameParts) {
		return lastName.equals(nameParts[0]);
	}

}