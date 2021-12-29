package bucketSort;

import java.util.LinkedList;

public class BucketSortAlgorithm {
	
	public static void bucketSort(ElementBucket[] A) {
		int n = A.length;
		LinkedList<ElementBucket>[] B = new LinkedList[n];
		
		//Makes B[i] an empty list
		for(int i = 0; i <= n-1; i++) {
			B[i] = new LinkedList<ElementBucket>();
		}		
		
		//Inserts A[i] into the respective bucket B based on element value of A[i]
		for(int i = 0; i < n; i++) {
			B[(int)Math.floor(n*A[i].getElementValue())].add(A[i]);
			
			
		}
		
		//Insertion sort to sort B; doesn't apply for this exercise because elements in array are only 1 digit each.
		for(int i = 0; i < B.length; i++) {
			for(int x = 1; x < B[i].size(); x++) {
				if(B[i].size() == 0 || B[i].size() == 1)
					break;
				ElementBucket key = B[i].get(x);
				int j = x - 1;
				while(j >= 0 && B[i].get(j).getElementValue() > key.getElementValue()) {
					B[i].set(j+1, B[i].get(j));
					j = j - 1;
				}
				B[i].set(j+1,key);
			}
		}

		//Inserts each ElementBucket node of linkedlist B[i] into the array A
		int x = 0;
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i].size(); j++) {
				A[x] = B[i].get(j);
				x++;
			}
		}
	}
	
	//Normalizes array A by dividing each element value by 10
	public static void normalize(ElementBucket[] A) {
		for(int i = 0; i < A.length; i++) {
			A[i].setElementValue(A[i].getElementValue()/10);
			
		}
	}
	
	//Un-normalizes array A by multiplying each element value by 10
	public static void unNormalize(ElementBucket[] A) {
		for(int i = 0; i < A.length; i++) {
			A[i].setElementValue(A[i].getElementValue()*10);
		}
	}
	
	public static void main(String[] args) {
		ElementBucket[] A = new ElementBucket[15];
		
		//Create the array A with given element values and its index/position
		A[0] = new ElementBucket(8.0,1);
		A[1] = new ElementBucket(8.0,2);
		A[2] = new ElementBucket(2.0,1);
		A[3] = new ElementBucket(9.0,1);
		A[4] = new ElementBucket(4.0,1);
		A[5] = new ElementBucket(2.0,2);
		A[6] = new ElementBucket(3.0,1);
		A[7] = new ElementBucket(5.0,1);
		A[8] = new ElementBucket(4.0,2);
		A[9] = new ElementBucket(9.0,2);
		A[10] = new ElementBucket(3.0,2);
		A[11] = new ElementBucket(7.0,1);
		A[12] = new ElementBucket(4.0,3);
		A[13] = new ElementBucket(7.0,2);
		A[14] = new ElementBucket(2.0,3);
		
		normalize(A);
		bucketSort(A);
		unNormalize(A);
		
		//Prints sorted array B
				System.out.println("\n" + "Sorted array: " + "\n");
				for(int i = 0; i < A.length; i++) {
					System.out.println("Element value: " + A[i].getElementValue() + "; Element position: " + A[i].getElementPosition());
				}
	}
}
