package org.code.chapter1;

/*
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */

class CheckUnique{
	public static boolean checkUnique(String test_string){
		if(test_string.length() > 1)
			if(test_string.substring(1, test_string.length()).contains(test_string.substring(0, 1)))
				return false;
			else
				return checkUnique(test_string.substring(1,test_string.length()));
		else
			return true;
	}
	public static void main(String args[]){
		String input = "";
		System.out.println("Given string "+((input.length() == 0 || input == null)?"is empty":(((input.length() == 1)?"is":(checkUnique(input)?"is":"is not"))+" unique")));
	}
}