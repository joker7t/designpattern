package example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class example {
	private static final String SPACE = " ";
	private static final String DOT = ".";
	
	public static void main(String args[]) {
		String example = "aaaaaaaaaaaa bbbbbbbbbbbbbb ccccccccccccccccc dddddd-ddddddd eeeeeeeee";
		String result = shortenName(example);
		System.out.println("123");
	}

	private static String shortenName(String example) {
		while(example.length() > 30) {	
			String[] singleNames = cutToSingleNames(example);
			int lastSingleNameIndex = singleNames.length - 1;
			singleNames[lastSingleNameIndex] = shortenSingleName(singleNames[lastSingleNameIndex]);
			example = Arrays.asList(singleNames).stream().collect(Collectors.joining(SPACE));
		}
		return example;
	}

	private static String shortenSingleName(String string) {
		char firstChar = string.charAt(0);
		return firstChar + DOT;
	}

	private static String[] cutToSingleNames(String example) {
		return example.split(SPACE);
	}
}
