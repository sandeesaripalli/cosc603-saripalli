package com.testing.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtility {
	private static String filePath;
	
	private static File getFileObject(){
		return new File(filePath);
	}
	
	protected static boolean isFilePresent(String name){
		filePath = name;
		 return getFileObject().isFile();
	}

	public static String[] getLines() {
		String[] lines = new String[100];
		try {
			Scanner scan = new Scanner(getFileObject());
			scan.useDelimiter(getDelimiterForLines());
			int counter = 0;
			while(scan.hasNext()){
				lines[counter] = scan.next();
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newOptimizedArray(lines);
	}
	
	private static String[] newOptimizedArray(String[] lines){
		int count = lines.length;
		int counter = 0;
		int actualSize = 0;
		while (count > 0){
			if(lines[counter] != null){
				actualSize++;
			}else{
				break;
			}
			counter++;
			count--;
		}
		String[] newCopy = new String[actualSize];
		for(int i = 0; i < actualSize ; i++){
			newCopy[i] = lines[i];
		}
		lines = null;
		return newCopy;
	}
	
	private static String getDelimiterForLines(){
		return "\n";
	}

}
