package cs146F19.bedi.project2;

// This program uses the Brute Force algorithm to find the maximum subarray

public class BruteForce {
	
	int start; // To store start/arrival date
	int end; // To store end/departure date
	int total; // To store maximum sum
	
	// Constructor
	BruteForce(int s, int e, int t){
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

	/* this method takes in an array and its size as the parameter,
	 * uses the Brute Force algorithm to calculate max subarray, and
	 * returns a new object of the class BruteForce with the 
	 * arrival date, departure date and the maximum sum encapsulated.
	 */
	public static BruteForce MaxSubArrayBF(int[] A, int n) {

		int max = A[1]; // Keeps track of maximum sum
		int arrive = -1; // Keeps track of arrival date
		int depart = -1; // Keeps track of departure date

		for(int i = 0; i < n; i++) {
			int value = 0; // Running total used to check sum and compared against max

			for(int j = i; j < n; j++) {
				value = value + A[j];

				if(value > max) {
					max = value;
					arrive = i;
					depart = j;
				}
			}
		}

		return new BruteForce(arrive, depart, max);
	}

}
