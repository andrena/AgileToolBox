package tdd.example;

public class TextTrimmer {

	public String trimEnd(String text) {
		String trimmed = "";

		for (String line : text.split("\n")) {
			if (trimmed.isEmpty())
				trimmed = trimFirstLine(trimmed, line);
			else {
				trimmed = trimFollowingLine(trimmed, line);
			}
		}

		if (text.endsWith("\n"))
			trimmed = addNewLine(trimmed);

		return trimmed;
	}

	private String trimFirstLine(String trimmed, String line) {
		String trimmedStartAndEnd = line.trim();
		int startOfTrimmed = line.lastIndexOf(trimmedStartAndEnd);
		trimmed += line.substring(0,
				startOfTrimmed + trimmedStartAndEnd.length());
		return trimmed;
	}

	private String trimFollowingLine(String trimmed, String line) {
		trimmed = addNewLine(trimmed);
		trimmed += line.trim();
		return trimmed;
	}

	private String addNewLine(String trimmed) {
		trimmed += "\n";
		return trimmed;
	}

}
