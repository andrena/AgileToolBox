package refactoring.result;

import java.util.Arrays;

public class PersonMatcher {
	private final FullName fullName;
	private final Gender gender;

	public PersonMatcher(String gender, String firstName, String lastName) {
		this.gender = Gender.valueOf(gender);
		this.fullName = new FullName(firstName, lastName);
	}

	public boolean isTheSameAs(String name) {
		String[] nameParts = name.split(" ");
		String firstNamePart = nameParts[0];
		boolean salutationMatched = isAbbreviated(firstNamePart) && gender.salutationMatches(firstNamePart);
		boolean abbreviationMatched = isAbbreviated(firstNamePart) && fullName.abbreviationMatches(firstNamePart);
		if (salutationMatched|| abbreviationMatched) {
			nameParts = stripOffFirstNamePart(nameParts);
		}
		if (abbreviationMatched || nameParts.length == 1) {
			return fullName.matchLastName(nameParts);
		} else {
			return fullName.matchFullName(nameParts);
		}
	}

	private String[] stripOffFirstNamePart(String[] nameParts) {
		return Arrays.copyOfRange(nameParts, 1, nameParts.length);
	}

	private boolean isAbbreviated(String firstNamePart) {
		return firstNamePart.indexOf('.') > 0;
	}

}