package org.code.chapter1;
/*
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
 */
public class CheckStringPermutation {
	public static boolean checkPerm(String one, String two){
		char[] one_array = one.toCharArray();
		for(int i=0;i<one_array.length;i++){
			int index = two.indexOf(one_array[i]);
			if(i != index && index >= 0)
			{
				char temp = one_array[i];
				one_array[i] = one_array[index];
				one_array[index] = temp;
			}
		}
		return (String.copyValueOf(one_array).equals(two)) ? true:false;
	}
	public static void main(String[] args) {
		String one = "aba";
		String two = "aaa";
		if(one == null || two == null)
			System.out.println("Please check the strings");
		else
			if(one.length() == two.length())
				System.out.println("String "+one+(checkPerm(one,two)?" is ":" is not ")+"a permutation of "+two);
			else
				System.out.println("String "+one+" is not "+"a permutation of "+two);
	}
}
