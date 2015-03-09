package com.testing.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileUtility {
	private static String filePath;

	private static File getFileObject() {
		return new File(filePath);
	}

	protected static boolean isFilePresent(String name) {
		filePath = name;
		return getFileObject().isFile();
	}

	/**
	 * This will split the file object passed into an array of lines. It will
	 * also resize the array to the correct array size to free unnecessary
	 * memory
	 * 
	 * @return String[] <code>lines</code>
	 */
	public static String[] getLines() {
		String[] lines = new String[100];
		try {
			Scanner scan = new Scanner(getFileObject());
			scan.useDelimiter(getDelimiterForLines());
			int counter = 0;
			while (scan.hasNext()) {
				lines[counter] = scan.next();
				counter++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newOptimizedArray(lines);
	}

	/**
	 * Array resizing and free original array
	 * 
	 * @param lines
	 * @return
	 */
	private static String[] newOptimizedArray(String[] lines) {
		int count = lines.length;
		int counter = 0;
		int actualSize = 0;
		while (count > 0) {
			if (lines[counter] != null) {
				actualSize++;
			} else {
				break;
			}
			counter++;
			count--;
		}
		String[] newCopy = new String[actualSize];
		for (int i = 0; i < actualSize; i++) {
			newCopy[i] = lines[i];
		}
		lines = null;
		return newCopy;
	}

	private static String getDelimiterForLines() {
		return "\n";
	}

	/**
	 * It split the each line into arraylist of words through tokenenizer. Then
	 * count the number of duplicates in each array for each string and store
	 * them as an array of Strings for that particular line and return it
	 * 
	 * @param line
	 * @return String[] <code>duplicateWords</code>
	 */
	public static String[] getDublicateWords(String line) {
		ArrayList<String> completeWords = new ArrayList<String>();
		ArrayList<String> dublicateWords = new ArrayList<String>();
		StringTokenizer stringToken = new StringTokenizer(line.trim(), "\n");
		while (stringToken.hasMoreTokens()) {
			completeWords.add(stringToken.nextToken());
		}
		int counter = 1;
		for(String lines: completeWords){
		Object[] words = lines.split(" ");
		for (int i = 0; i < words.length; i++) {
			int dublicateCount = 0;
			for (int k = 0; k < words.length; k++) {
				if (words[i].toString().trim().equals(words[k].toString().trim())) {
					dublicateCount++;
				}
			}
			if (dublicateCount > 1 && !dublicateWords.contains(words[i].toString().trim() + ":" + counter)) {
				for (int j = 0; j < dublicateCount; j++) {
					dublicateWords.add(words[i].toString().trim() + ":" + counter);
				}
			}
		}
		counter++;
	}
		String[] resultantDublicates = new String[dublicateWords.size()];

		for (int count = 0; count < dublicateWords.size(); count++) {
			resultantDublicates[count] = dublicateWords.get(count);
		}
		return resultantDublicates;
	}

}
