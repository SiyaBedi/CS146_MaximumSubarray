package cs146F19.bedi.project2;

//This program uses Kadane's Algorithm to get the maximum subarray 
public class KadaneAlgorithm {

	int start; // To store start/arrival date
	int end; // To store end/departure date
	int total; // To store maximum sum
	
	// Constructor
	KadaneAlgorithm(int s, int e, int t){
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

	/* This method takes in an array and its size as the parameter,
	 * uses Kadane's algorithm to calculate the max subarray, and
	 * returns a new object of the class kadane's algorithm with the
	 * the arrival date, departure date and the sum encapsulated.
	 */
	public static KadaneAlgorithm MaxSubArrayKadane(int[] A, int n) {
		
		int maxSum = 0;  // Keeps track of total sum and is returned at the end
		int maxTemp = 0; // Running total that is reset to 0 if it is a negative number
		int arrive = 0; // Keeps track of arrival date
		int depart = 0; // Keeps track of departure date
		int tempArrive = 0;

		for(int i = 0; i < n; i++) {
			maxTemp = maxTemp + A[i];
			
			if(maxTemp < 0) {
				maxTemp = 0;
				arrive = i + 1;
			}
			
			if(maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}
		}
		
		arrive = tempArrive;
		
		return new KadaneAlgorithm(arrive, depart, maxSum);

	}

}
