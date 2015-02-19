package com.testing.project1;

public class Main {

	public static void main(String[] args) {

		if (FileUtility.isFilePresent(args[0])) {
			String[] lines = FileUtility.getLines();

			int lineNumber = 1;
			// We should resize array to minimize space waste
			for (String eachLine : lines) {
				// get the duplicate words per each line
				String[] dublicateWords = FileUtility
						.getDublicateWords(eachLine);
				if (dublicateWords.length > 0) {
					printOutPutToUser(lineNumber, dublicateWords);
				}
				lineNumber++;
			}
		}

	}

	/**
	 * Print the value to the user with the format specified in the sample
	 * output file
	 * 
	 * @param lineNumber
	 * @param dublicates
	 */
	static void printOutPutToUser(Integer lineNumber, String[] dublicates) {
		System.out.print("Repeated word on line " + lineNumber + ": ");
		for (String string : dublicates) {
			System.out.print(string + " ");
		}
		System.out.print("\n");
	}
}
