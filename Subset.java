/*
A program that uses recursion to print out all k-element subsets of the n-
element set {1, 2, 3 ... n}, where bothn and k are given on the command line.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Subset{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean error = false;
		boolean  zeroCombos = false;
		int n = -1;
		int k = -1;
	
		// Get n and k from user input 
		try {	
			n = input.nextInt();
			k = input.nextInt();
		}
			
		// Error if invalid input given
		catch (Exception e) {
			System.out.println("Usage: Java Subset <int> <int>");
			error = true;
		}
		if((k > n || k == -1 || n == -1) && error == false) {
			error = true;
			System.out.println("Usage: Java Subset <int> <int>");
		}
		if(k == 0) zeroCombos = true;
		
		if(error == false) {
			if(k == 0) System.out.println("{}");
		else {
			int[] numberSet = new int[n+1];
			numberSet[0] = 0;
			printSubsets(numberSet, k, 1);
		}
	}
}

	//Turns array of set elements into a string
	static String setToString(int[] B){
		String set = "{";
		for(int i = 1; i < B.length; i++){
			if(B[i] == 1) set = set + i + ", ";	
		}
		if(set.length() > 2){
			set = set.substring(0,set.length() - 2);
			set = set + "}";
		}
		else{
			set = "{}";
		}
		return set;
	}
	
	//Prints all subsets of n-element set
	static void printSubsets(int[] B, int k, int i){
		if(k == 0){
			System.out.println(setToString(B));
			return;
		}
		if(k > 0 && k > B.length - i) {
			return;
		}
			int[] include = B; 
			include[i] = 1;
			printSubsets(include,k - 1,i + 1);
			int[] exclude = B; 
			exclude[i] = 0;
	
			printSubsets(exclude,k,i + 1);
	}
