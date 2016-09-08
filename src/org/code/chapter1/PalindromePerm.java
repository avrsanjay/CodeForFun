package org.code.chapter1;
/*
   Palindrome Permutation: 
   Given a string, write a function to check if it is a permutation of a palindrome.
   A palindrome is a word or phrase that is the same forwards and backwards. A permutation
   is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 */
public class PalindromePerm {
	public static void checkPalindromePerm(String input){
		int alpha[] = new int[26];
		for (int i = 0; i < input.length(); i++) {
			if ((int)input.charAt(i)%97 < 26)
				alpha[((int)input.charAt(i))%97]++;
		}
		int odd_pairs = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i]%2 != 0)
					odd_pairs++;
		}
		System.out.println("Given string"+((odd_pairs <= 1)?" is a ":" is not a ")+"palindrome");
	}
	public static void main(String[] args) {
		String input = "Tact Coa".toLowerCase();
		checkPalindromePerm(input);
	}
}
