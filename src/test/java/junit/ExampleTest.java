package junit;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExampleTest {

	@Test
	public void testEqualValues() {
		int sum = 1 + 1;
		assertThat(sum, is(2));
	}

	@Test
	public void testTrueValue() {
		boolean isEmpty = "".isEmpty();
		assertThat(isEmpty, is(true));
	}

	@Test
	public void testFalseValue() {
		boolean isEmpty = "234".isEmpty();
		assertThat(isEmpty, is(false));
	}

	@Test
	public void testNullValue() {
		Integer nullable = null;
		assertThat(nullable, is(nullValue()));
	}

	@Test
	public void testNotNullValue() {
		Integer nullable = 42;
		assertThat(nullable, is(not(nullValue())));
	}
}
