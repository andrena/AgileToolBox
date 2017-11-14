package tdd.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import tdd.example.TextTrimmer;

public class TextTrimmerTest {
	private TextTrimmer textTrimmer;

	@Before
	public void setUp() {
		textTrimmer = new TextTrimmer();
	}

	@Test
	public void testNoTrimmingNeccessary() throws Exception {
		String trimmed = textTrimmer.trimEnd("abc");

		assertThat(trimmed, is("abc"));
	}

	@Test
	public void testEndsWithTab() throws Exception {
		String trimmed = textTrimmer.trimEnd("abc\t");

		assertThat(trimmed, is("abc"));
	}

	@Test
	public void testNoRemovalOfBeginningWhitespace() {
		String trimmed = textTrimmer.trimEnd("   abc");

		assertThat(trimmed, is("   abc"));
	}

	@Test
	public void testNoRemovalOfNewLine() {
		String trimmed = textTrimmer.trimEnd("abc\n");

		assertThat(trimmed, is("abc\n"));
	}

	@Test
	public void testRemoveWhitespaceOnEachLine() {
		String trimmed = textTrimmer.trimEnd(" ab\n cd \n");

		assertThat(trimmed, is(" ab\ncd\n"));
	}

}
