package org.code.chapter1;
/*
Zero Matrix: 
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
s*/
public class ZeroMatrix {
	public static void printArray(int[][] input, int N){
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void convertToZero(int[][] input){
		boolean[] row = new boolean[input.length];
		boolean[] col = new boolean[input[0].length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if(input[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				for (int j = 0; j < input[0].length; j++) {
					input[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < col.length; i++) {
			if (col[i]) {
				for (int j = 0; j < input.length; j++) {
					input[j][i] = 0;
				}
			}
		}
		System.out.println("Zeroed Matrix:");
		System.out.println("--------------");
		printArray(input, input.length);
	}
	public static void main(String[] args) {
		int[][] input = {{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,0},{1,1,1,1,1},{1,1,1,1,1}};
		System.out.println("Given Matrix:");
		System.out.println("-------------");
		printArray(input, input.length);
		System.out.println();
		convertToZero(input);
	}
}
