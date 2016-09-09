package org.code.chapter1;
/*
String Rotation:
Assume you have a method isSubstringwhich checks if one word is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat"). 
*/
public class StringRotation {
	public static boolean isSubstring(String one, String two){
		int start = 0;
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(start) == two.charAt(i)) {
				if ((two.substring(i, two.length())+two.substring(0,i)).equals(one)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String one = "waterbottlew";
		String two = "tlewwaterbot";
		if (one.length() == two.length())
			System.out.println("\""+one+"\" is"+(isSubstring("waterbottle","tlewaterbot")?"":" not")+" a substring of \""+two+"\"");
		else
			System.out.println("\""+one+"\" is not a substring of \""+two+"\"");
	}
}
