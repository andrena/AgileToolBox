package junit;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class AdvancedTest {

	@Test
	public void testHasItems() {
		List<Integer> myList = asList(1, 2, 3);
		assertThat(myList, hasItems(1, 2));
	}

	@Test
	public void testContains() {
		List<Integer> myList = asList(1, 2, 3);
		assertThat(myList, containsInAnyOrder(2, 1, 3));
	}

	@Test
	public void testCompareNumbers() {
		assertThat(6, is(greaterThan(5)));
	}

	@Test
	public void testCombined() {
		assertThat(6, is(allOf(greaterThan(5), lessThan(8), equalTo(6))));
	}
}
