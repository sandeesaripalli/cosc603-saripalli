package com.testing.project1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(FileUtility.isFilePresent(args[0])){
			String[] lines = FileUtility.getLines();
			
			//We should resize array to minimize wastage
			for(String eachLine : lines){
				System.out.println(eachLine);
			}
		}

	}

}
