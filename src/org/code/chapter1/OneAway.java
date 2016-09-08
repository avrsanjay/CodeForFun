package org.code.chapter1;
/*
One Away: 
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */
public class OneAway {
	public static boolean oneWay(String one, String two){
		int edits = 0;
		int l_one = one.length();
		int l_two = two.length();
		
		if (one.charAt(0) == two.charAt(0)) {
			for (int i = 1, j = 1; i < l_one && j < l_two ; ) {
				if (one.charAt(i) != two.charAt(j)) {
					edits++;
					j++;
				} else {
					i++;
					j++;
				}
			}
		} else if (one.charAt(l_one-1) == two.charAt(l_two-1)) {
			for (int i = l_one-2, j = l_two-2; i >= 0 && j >= 0 ; i--,j-- ) {
				if (one.charAt(i) != two.charAt(j)) {
					edits++;
					j--;
				} else {
					i--;
					j--;
				}
			}
		} else {
			return false;
		}
		
		return (edits > 1)?false:true;
	}
	public static void main(String[] args) {
		String one = "bake".toLowerCase();
		String two = "pale".toLowerCase();
		
		if(Math.abs(one.length()-two.length()) > 1)
			System.out.println("false");
		else{
			System.out.println((one.length() >= two.length())?oneWay(two,one):oneWay(one,two));
		}
	}
}
