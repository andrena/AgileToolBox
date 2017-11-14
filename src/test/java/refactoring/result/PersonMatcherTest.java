package refactoring.result;

import static org.junit.Assert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import refactoring.result.PersonMatcher;

public class PersonMatcherTest {
	private PersonMatcher frankMustermann = new PersonMatcher("m", "Frank", "Mustermann");
	private PersonMatcher erikaMusterfrau = new PersonMatcher("f", "Erika", "Musterfrau");

	@Test
	public void testGivenCorrectLastNameItMatches() {
		assertThat(frankMustermann, matchesName("Mustermann"));
	}

	@Test
	public void testGivenEmptyStringDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName(""));
	}

	@Test
	public void testGivenOnlyWrongLastNameItDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Anders"));
	}

	@Test
	public void testGivenCorrectFirstAndLastNameItMatches() {
		assertThat(frankMustermann, matchesName("Frank Mustermann"));
	}

	@Test
	public void testGivenIncorrectFirstAndCorrectLastNameItDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Bernd Mustermann"));
	}

	@Test
	public void testGivenCorrectFirstAndIncorrectLastNameItDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Frank Anders"));
	}

	@Test
	public void testGivenCorrectFirstAndLastNameButWrongGenderItDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Fr. Frank Mustermann"));
	}

	@Test
	public void testGivenOnlyCorrectLastNameButWrongGenderItMatches() {
		assertThat(frankMustermann, matchesName("Fr. Mustermann"));
	}

	@Test
	public void testGivenCorrectFirstAndLastNameAndCorrectGenderItMatches() {
		assertThat(frankMustermann, matchesName("Hr. Frank Mustermann"));
	}

	@Test
	public void testGivenIncorrectFirstNameButCorrectLastNameAndCorrectGenderItDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Hr. Bernd Mustermann"));
	}

	@Test
	public void testGivenIncorrectLastNameButCorrectFirstNameAndCorrectGenderItDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Hr. Frank Anders"));
	}

	@Test
	public void testGivenCorrectLastNameButUnknownGenderDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Mr. Mustermann"));
	}

	@Test
	public void testGivenCorrectLastNameAndGenderItMatches() {
		assertThat(frankMustermann, matchesName("Hr. Mustermann"));
	}

	@Test
	public void testGivenIncorrectLastNameButCorrectGenderDoesNotMatch() {
		assertThat(frankMustermann, doesNotMatchName("Hr. Anders"));
	}

	@Test
	public void testFemaleGivenCorrectLastNameAndGenderItMatches() {
		assertThat(erikaMusterfrau, matchesName("Fr. Musterfrau"));
	}

	@Test
	public void testFemaleGivenIncorrectLastNameButCorrectGenderItDoesNotMatch() {
		assertThat(erikaMusterfrau, doesNotMatchName("Fr. Anders"));
	}

	@Test
	public void testFemaleGivenCorrectFirstAndLastNameAndGenderItMatches() {
		assertThat(erikaMusterfrau, matchesName("Fr. Erika Musterfrau"));
	}

	@Test
	public void testFemaleGivenCorrectLastNameAndWrongGenderItDoesNotMatch() {
		assertThat(erikaMusterfrau, doesNotMatchName("Hr. Musterfrau"));
	}

	@Test
	public void testFemaleGivenCorrectFirstAndLastNameItMatches() {
		assertThat(erikaMusterfrau, matchesName("Erika Musterfrau"));
	}

	@Test
	public void testFemaleGivenCorrectLastNameButUnknownGenderDoesNotMatch() {
		assertThat(erikaMusterfrau, doesNotMatchName("Ms. Musterfrau"));
	}

	@Test
	public void testFemaleGivenIncorrectFirstNameButCorrectLastNameAndCorrectGenderItDoesNotMatch() {
		assertThat(erikaMusterfrau, doesNotMatchName("Fr. Beate Musterfrau"));
	}

	@Test
	public void testFemaleGivenIncorrectLastNameButCorrectFirstNameAndCorrectGenderItDoesNotMatch() {
		assertThat(erikaMusterfrau, doesNotMatchName("Hr. Erika Anders"));
	}

	@Test
	public void testFemaleGivenCorrectShortenedFirstNameAndCorrectLastNameItMatches() {
		assertThat(erikaMusterfrau, matchesName("E. Musterfrau"));
	}

	@Test
	public void testFemaleGivenCorrectShortenedFirstNameButIncorrectLastNameItDoesNotMatch() {
		assertThat(erikaMusterfrau, doesNotMatchName("E. Anders"));
	}

	private TypeSafeDiagnosingMatcher<PersonMatcher> matchesName(String name) {
		return new TypeSafeDiagnosingMatcher<PersonMatcher>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("to match name '" + name + "'");
			}

			@Override
			protected boolean matchesSafely(PersonMatcher item, Description mismatchDescription) {
				return item.isTheSameAs(name);
			}
		};
	}

	private TypeSafeDiagnosingMatcher<PersonMatcher> doesNotMatchName(String name) {
		return new TypeSafeDiagnosingMatcher<PersonMatcher>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("to NOT match name '" + name + "'");
			}

			@Override
			protected boolean matchesSafely(PersonMatcher item, Description mismatchDescription) {
				return !item.isTheSameAs(name);
			}
		};
	}
}
