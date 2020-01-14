package cs146F19.bedi.project2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class BruteForceTest {
	
	ArrayList<Integer> fileArr = new ArrayList<>(); // Stores all elements from the file

	/* This test reads the file, store all the elements in an arraylist,
	 * creates and shifts all the elements in an array, calls the
	 * BruteForce class with the array as the input and checks to see
	 * if the results match up.
	 */
	@Test
	void test() {

		try {
			Scanner scan = new Scanner(new File("maxSumtest.txt"));

			while(scan.hasNext()) {
				fileArr.add(scan.nextInt());

			}

			scan.close();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Inserts the first row of 100 elements into the array
		int n = 100;
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = fileArr.remove(0);
		}
		
		// Checks to see if the BruteForce class works for the first 100 elements
		BruteForce bf = BruteForce.MaxSubArrayBF(array, n);
		
		int expectedTotal = fileArr.remove(0);
		assertEquals(expectedTotal, bf.getTotal());
		
		int expectedArrival = fileArr.remove(0);
		assertEquals(expectedArrival, bf.getStart());
		
		int expectedDeparture = fileArr.remove(0);
		assertEquals(expectedDeparture, bf.getEnd());
	}
	
	// Checks to see if the given array works for the BruteForce class
	@Test
	public void test1() {
		int array[] = {-2, -3, 4, -1, -2, 1, 5, -3, 7, 2, 6};
		BruteForce a = BruteForce.MaxSubArrayBF(array, array.length);
		assertEquals(2, a.getStart());
		assertEquals(10, a.getEnd());
		assertEquals(19, a.getTotal());
	}
	
	
	@Test
	public void test2() {
		Random rand = new Random();
		int[] array = new int[100];
		
		for(int i = 0; i < 100; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 100 is " + elapsedTime/10);
		
	}
	
	@Test
	public void test3() {
		Random rand = new Random();
		int[] array = new int[200];
		
		for(int i = 0; i < 200; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 200 is " + elapsedTime/10);
		
	}
	
	@Test
	public void test4() {
		Random rand = new Random();
		int[] array = new int[500];
		
		for(int i = 0; i < 500; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 500 is " + elapsedTime/10);
		
	}
	
	@Test
	public void test5() {
		Random rand = new Random();
		int[] array = new int[1000];
		
		for(int i = 0; i < 1000; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 1000 is " + elapsedTime/10);
		
	}
	
	@Test
	public void test6() {
		Random rand = new Random();
		int[] array = new int[2000];
		
		for(int i = 0; i < 2000; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 2000 is " + elapsedTime/10);
		
	}
	
	@Test
	public void test7() {
		Random rand = new Random();
		int[] array = new int[5000];
		
		for(int i = 0; i < 5000; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 5000 is " + elapsedTime/10);
		
	}
	
	@Test
	public void test8() {
		Random rand = new Random();
		int[] array = new int[10000];
		
		for(int i = 0; i < 10000; i++) {
			array[i] = rand.nextInt();
		}
		
		long start = System.nanoTime();
		BruteForce.MaxSubArrayBF(array, array.length);
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println("Run time for size 10000 is " + elapsedTime/10);
		
	}
	
}
