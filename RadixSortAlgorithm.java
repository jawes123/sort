package radixSort;

import java.util.Random;

public class RadixSortAlgorithm {
	
	
	
	public static void countingSort(String[] A, String[] B, int k, int d) {
		int[] C = new int[k+1];
		
		//Makes all elements in array C value 0.
		for(int i = 0; i <= k; i++) {
			C[i] = 0;
		}
		
		//Increases the elements of array C based on the elements in array A
		//For example, if A[0] is 8, then C[8] = C[8] + 1.
		for(int j = 0; j < A.length; j++) {
			
			//If the hexadecimal value is greater than 9, put it into the correct index of array C
			if(A[j].charAt(d) > '9') {
				C[A[j].charAt(d) - 'A' + 10] = C[A[j].charAt(d) - 'A' + 10] + 1;
			}
			else
				C[A[j].charAt(d) - '0'] = C[A[j].charAt(d) - '0'] + 1;
		}
		
		//Completes array C by adding each element in array C with all previous ones
		for(int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
		}
		
		//Inserts A[j] into the appropriate index in array B based on array C
		//Then, decrements the element in array C at that index.
		for(int j = A.length - 1; j >= 0; j--) {
			if(A[j].charAt(d) > '9') {
				B[C[A[j].charAt(d) - 'A' + 10]-1] = A[j];
				C[A[j].charAt(d) - 'A' + 10] = C[A[j].charAt(d) - 'A' + 10] - 1;
			}
			else {
				B[C[A[j].charAt(d) - '0']-1] = A[j];
				C[A[j].charAt(d) - '0'] = C[A[j].charAt(d) - '0'] - 1;
			}
		}
	}
	
	public static String[] radixSort(String[] A, int d) {
		String[] B = new String[30];
		for(int i = 1; i <= d; i++) {
			countingSort(A, B, 15, d-i);
			//Puts digit-sorted array B into array A for the sorting of the next digit.
			for(int j = 0; j < B.length; j++) {
				A[j] = B[j];
			}
		}
		return B;
	}
	
	public static void main(String[] args) {		
		String[] A = new String[30];
		
		//Randomly generates 5 digit hexadecimal and puts it into A[i]
		for(int i = 0; i < A.length; i++) {
			String empty = "00000";
			Random rand = new Random();
			String s = Integer.toString(rand.nextInt(0x100000), 16);
			s = empty.substring(s.length()) + s;
			A[i] = s.toUpperCase();
		}
		
		String[] B = radixSort(A,5);
		
		for(int i = 0; i < B.length; i++) {
			System.out.println(B[i]);
		}

	}

}
