package org.code.chapter1;
/*
   URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
   has sufficient space at the end to hold the additional characters, and that you are given the "true"
   length of the string. (Note: If implementing in Java, please use a character array so that you can
   perform this operation in place.)
 */
public class URLify {

	public static void main(String[] args) {
		String input = "Mr John Smith     ";
		int length = 13;
		int num_spaces = 0;
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == ' ')
				num_spaces++;
		}
		char[] input_array = new char[length + num_spaces*2];

		//i:array indexer   |    j:string indexer
		for (int i = 0, j = 0; i < input_array.length && j < input_array.length; i++,j++ ) {
			if (input.charAt(j) == ' ') {
				input_array[i] = '%';
				input_array[i+1] = '2';
				input_array[i+2] = '0';
				i+=2;
			} else{
				input_array[i] = input.charAt(j);
			}
		}
		
		System.out.println("Given string is : "+input);
		System.out.println("output string is: "+String.valueOf(input_array));
	}

}
