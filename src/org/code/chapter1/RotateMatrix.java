package org.code.chapter1;
/*
Rotate Matrix:
Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
	
	public static boolean debug = false;
	
	public static void printArray(int[][] input, int N){
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] rotateArray(int[][] input_dup){
		int level = 0, matrix_size = input_dup.length, matrix_max_index = matrix_size - 1; //(matrix_max_index is 4 in a 5x5 matrix)
		while(true){
			if(debug){
				System.out.println();
				System.out.println("Level:"+level);
				System.out.println("----------");
			}
			for (int index = level; index < (matrix_max_index-level); index++) {
				int num1_row = level, 								   											num1_col = index;
				int num2_row = (index + matrix_max_index - level)%(matrix_max_index - level), 					num2_col = matrix_max_index - level;
				int num3_row = matrix_max_index - level,														num3_col = matrix_max_index - index;
				int num4_row = matrix_max_index - ((index+matrix_max_index-level)%(matrix_max_index-level)),	num4_col = level;
				
				if(debug){
					System.out.println("Index:"+index);
					System.out.println("["+num1_row+"]["+num1_col+"],["+num2_row+"]["+num2_col+"],["+num3_row+"]["+num3_col+"],["+num4_row+"]["+num4_col+"]");
				}
				
				int temp1 = input_dup[num1_row][num1_col];
				input_dup[num1_row][num1_col] = input_dup[num4_row][num4_col];
				input_dup[num4_row][num4_col] = input_dup[num3_row][num3_col];
				input_dup[num3_row][num3_col] = input_dup[num2_row][num2_col];
				input_dup[num2_row][num2_col] = temp1;
			}
			if(level < input_dup.length/2)
				level+=1;
			else
				break;
		}
		return input_dup;
	}
	public static void main(String[] args) {
		int[][] input55 = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};
		//int[][] input44 = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
		//int[][] input33 = {{1,1,1},{2,2,2},{3,3,3}};
		//int[][] input22 = {{1,1},{2,2}};
		int[][] input = input55;
		
		System.out.println("Given matrix");
		System.out.println("------------");
		printArray(input,input.length);
		System.out.println();
		System.out.println("After rotation");
		System.out.println("--------------");
		printArray(rotateArray(input),input.length);
	}
}