package org.code.chapter1;
/*
String Compression: 
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
	public static String stringCompression(String input){
		String output = "";
		char running_char = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == running_char) {
				count++;
			} else {
				output = output+running_char+String.valueOf(count);
				running_char = input.charAt(i);
				count = 1;
			}
		}
		return output+running_char+String.valueOf(count);
	}
	public static void main(String[] args) {
		String input = "aabcccccaaa";
		System.out.println("Input : "+input);
		System.out.println("Output: "+stringCompression(input));
	}
}
