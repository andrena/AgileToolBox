package refactoring.result;

public enum Gender {

	m("Hr."), f("Fr.");

	private String salutation;

	private Gender(String salutation) {
		this.salutation = salutation;
	}
	
	public boolean salutationMatches(String firstNamePart) {
		return firstNamePart.equals(salutation);
	}

}
