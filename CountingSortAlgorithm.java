package countingSort;

public class CountingSortAlgorithm {

	public static void countingSort(ElementCounting[] A, ElementCounting[] B, int k) {
		int counter = 1;
		int[] C = new int[k+1];
		
		//Makes all elements in array C value 0.
		for(int i = 0; i <= k; i++) {
			C[i] = 0;
		}
		
		//Increases the elements of array C based on the elements in array A
		//For example, if A[0] is 8, then C[8] = C[8] + 1.
		for(int j = 0; j < A.length; j++) {
			C[A[j].getElementValue()] = C[A[j].getElementValue()] + 1;
		}
		
		//Completes array C by adding each element in array C with all previous ones
		for(int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i-1];
		}
		
		//Prints array C before sorting has begun
		System.out.println("Original Array C: ");
		System.out.print("C[");
		for(int y = 0; y < C.length-1; y++) {
			System.out.print(C[y] + ", ");
		}
		System.out.println(C[C.length-1] + "]");
		
		//Inserts A[j] into the appropriate index in array B based on array C
		//Then, decrements the element in array C at that index.
		for(int j = A.length - 1; j >= 0; j--) {
			B[C[A[j].getElementValue()]-1] = A[j];
			C[A[j].getElementValue()] = C[A[j].getElementValue()] - 1;
			
			
			//Prints intermediate result of array B
			System.out.println("\n" + "Step " + counter + ": ");
			System.out.println("Array B: ");
			System.out.print("B[");
			for(int x = 1; x < B.length; x++) {
				System.out.print(B[x-1].getElementValue() + "s" + B[x-1].getElementPosition() + ", ");
			}
			System.out.println(B[B.length-1].getElementValue() + "s" + B[B.length-1].getElementPosition() + "]");
			
			
			//Prints intermediate result of array C
			System.out.println("Array C: ");
			System.out.print("C[");
			for(int y = 0; y < C.length-1; y++) {
				System.out.print(C[y] + ", ");
			}
			System.out.println(C[C.length-1] + "]");
			
			counter++;
		}
	}
	
	public static void main(String[] args) {
		ElementCounting[] A = new ElementCounting[15];
		ElementCounting[] B = new ElementCounting[15];
		
		//Create the array A with given element values and its index/position
		A[0] = new ElementCounting(8,1);
		A[1] = new ElementCounting(8,2);
		A[2] = new ElementCounting(2,1);
		A[3] = new ElementCounting(9,1);
		A[4] = new ElementCounting(4,1);
		A[5] = new ElementCounting(2,2);
		A[6] = new ElementCounting(3,1);
		A[7] = new ElementCounting(5,1);
		A[8] = new ElementCounting(4,2);
		A[9] = new ElementCounting(9,2);
		A[10] = new ElementCounting(3,2);
		A[11] = new ElementCounting(7,1);
		A[12] = new ElementCounting(4,3);
		A[13] = new ElementCounting(7,2);
		A[14] = new ElementCounting(2,3);
		
		//Create array B with element value and position set to 0 to avoid NullPointerException
		for(int i = 0; i < B.length; i++) {
			B[i] = new ElementCounting(0,0);
		}
		
		//Call countingSort method
		countingSort(A,B,9);
		
		//Prints sorted array B
		System.out.println("\n" + "Sorted array: " + "\n");
		for(int i = 0; i < B.length; i++) {
			System.out.println("Element value: " + B[i].getElementValue() + "; Element position: " + B[i].getElementPosition());
		}

	}

}
