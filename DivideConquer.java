package cs146F19.bedi.project2;

//This program uses the Divide and Conquer Algorithm to get the maximum subarray 

public class DivideConquer {

	int start; // To store start/arrival date
	int end; // To store end/departure date
	int total; // To store maximum sum
	
	// Constructor
	DivideConquer(int s, int e, int t){
		start = s;
		end = e;
		total = t;
		
	}
	
	// To get the arrival date
	public int getStart() {
		
		return start;
	}
	
	// To get the departure date
	public int getEnd() {
		
		return end;
	}
	
	// To get the maximum sum
	public int getTotal() {
		
		return total;
	}

	/* This method takes in the array, the lowest index, the middle index and the highest index as the parameters,
	 * finds the max subarray that crosses the middle element by dividing the array into two parts, and 
	 * returns the left maximum, right maximum and the combined sum of both sides
	 * encapsulated in a new Object of the DivideConquer class.
	 */
	public static DivideConquer MaxCrossArray(int[] A, int low, int mid, int high) {

		// Calculations for left part of the middle
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int leftMax = 0;

		for(int i = mid; i >= low; i--) {
			sum = sum + A[i];
			if(sum > leftSum) {
				leftSum = sum;
				leftMax = i;

			}
		}

		// Calculations for the right part of the middle
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int rightMax = 0;

		for(int j = mid + 1; j <= high; j++) {
			sum = sum + A[j];
			if(sum > rightSum) {
				rightSum = sum;
				rightMax = j;
			}
		}


		return new DivideConquer(leftMax, rightMax, leftSum + rightSum);
	}

	/* This method recursively finds the maximum subarray of the
	 * left half, right half and the sum such that the subarray crosses the midpoint.
	 * It takes in the array, the lowest index and the highest index as the parameters,
	 * and returns the object that compared to have the highest total.
	 */
	public static DivideConquer MaxSubArray(int[] A, int low, int high) {
		
		// Base case if there is only one element
		if(high == low) {
			return new DivideConquer(low, high, A[low]);
		}

		// find the middle point
		int mid = (low + high)/2;

		// created three objects: left half, right half, cross sum respectively
		DivideConquer a = MaxSubArray(A, low, mid);
		DivideConquer b = MaxSubArray(A, mid + 1, high);
		DivideConquer c = MaxCrossArray(A, low, mid, high);

		// Returns the object with the highest sum after all possible comparisons
		if(a.total > b.total && a.total > c.total) {
			return a;
		}
		else if(b.total > a.total && b.total > c.total) {
			return b;
		}
		else {
			return c;
		}
	}


}
