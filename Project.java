/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Maksym Karunos, Alejandro Gonzalez, Paula Medina
 *  External Collaborators: NONE
 *  References: Java textbook
 *
 *  Assignment: 6
 *  Problem: Analyzing QuickSort vs Insertion Sort vs Library Sort
 *  Description: Analyzing time and space complexity of three very famos sorts and their best/average/worse cases
 *
 *  Input: n
 *  Output: time taken to sort by a given sort
 *
 *  Visible data fields:
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random(228);
        System.out.println("Input n");
        int n = myScanner.nextInt();

        long startTime = 0;
        long endTime = 0; 
        int[] decendingOrder = new int[n];
        int[] ascedningOrder = new int[n];
        int[] randomOrder = new int[n];
 *
 *  Visible methods:
 *  static void printArray(int arr[]) 
 *  static void reinitializing(int[] a , int [] b, int[] c, int n, Random myRandom)
 *  main()
 *
 *   Remarks
 *   -------
 *
 *      PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 *  *   PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 *  *   PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 *                  Your task
 *   1) Use 0<n<15000 YOUR PROGRAMM WILL NOT COMPILE UNLESS IT'S LOWER THAN 15000
 *   2) COMPLETE ALL NON-CODING QUESTIONS TEXT ME SHOULD ANY ISSUES ARISE
 *   3) HAPPY THANKSGIVING
 *   4) PLEASE FIX MY TYPOS
 * 
 *  *   PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 *  *   PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 *  *   PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 *  *   PAULA |||||||||||||||| ATENTION!!!! AHTUNG |||||||||||||||||||||
 * 
 * 
 * 
 * NOTE: 
 * 1 - Insertion Sort 
 * 2a - QuickSort (firtst element is the pivot)
 * 2b - QuickSort (media of 3)
 * n = 14000
 * 
 *   Version | increasing order | decreasing order | random     |
 *      1    | 129745896        |  111582          |  82319708  |
 *      2a   | 111582           |  33707794        |  2890248   | 
 *      2b   | 9536567          |  10860421        |  14344177  | 
 * 
 * BIG-O expected 
 * 
 *   Version | increasing order | decreasing order | random     |
 *      1    |     O(n)         |      O(n^2)      | O(n^2)     | 
 *      2a   |     O(n^2)       |     O(n^2)       | O(nlog(n)) |
 *      2b   |     O(nlog(n))   |     O(nlog(n))   | O(nlog(n)) |  
 * 
 *
 *
 *************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class Project{
    // Use this method to check wether the array is sorted or not
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
    // Fill three arays with their initial numbers (Ascending, Descending, Random, Size, RandomVariable with seed)
    static void reinitializing(int[] a , int [] b, int[] c, int n, Random myRandom){
        for ( int i = 0; i < n; i++ ){
            a[i] = i;
        }
        for ( int i = n-1; i >= 0; i--){
        
           b[n-i-1] = i;
         // 
        }
        for ( int i = 0; i < n; i++){
            c[i] = myRandom.nextInt(n);
    }
}

    public static void main(String[] args){

        // All the variables
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random(228);
        System.out.println("Input n");
        int n = myScanner.nextInt();

        long startTime = 0;
        long endTime = 0; 
        int[] decendingOrder = new int[n];
        int[] ascedningOrder = new int[n];
        int[] randomOrder = new int[n];

        reinitializing(ascedningOrder, decendingOrder, randomOrder, n, myRandom);

        //  UNCOMMENT THE LINE BELOW TO CHECK THE ORDER 
        // Project.printArray(decendingOrder);
        // INSERTION  |  RANDOM 
        startTime = System.nanoTime();
        Insertion.sort(randomOrder);
        endTime = System.nanoTime();
        System.out.println("INSERTION SORT:" + " It took " + (endTime-startTime) + " nano" + " to sort an array of random numberss");

        // INSERTION  |  ASCENDING 
        startTime = System.nanoTime();
        Insertion.sort(ascedningOrder);
        endTime = System.nanoTime();
        System.out.println("INSERTION SORT:" + " It took " + (endTime-startTime) + " nano" + " to sort an array of ascending numberss");

        // INSERTION  |  DESCEDNING 
        startTime = System.nanoTime();
        Insertion.sort(decendingOrder);
        endTime = System.nanoTime();
        System.out.println("INSERTION SORT:" + " It took " + (endTime-startTime) + " nano" + " to sort an array of descending numberss");

        //  UNCOMMENT THE LINE BELOW TO CHECK THE ORDER 
        // Project.printArray(decendingOrder); 

        // REINITIALIZING OBJECTS
        reinitializing(ascedningOrder, decendingOrder, randomOrder, n, myRandom);

        // QUICKSORT | LEFTMOST (first) |  RANDOM 
        startTime = System.nanoTime();
        QuickSort.leftQuickSort(randomOrder,0,randomOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[LEFTMOSE ELEMENT - PIVOT] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of random numberss");
        //Project.printArray(ascedningOrder); 
        // QUICKSORT | LEFTMOST (first)  |  ASCENDING 
        startTime = System.nanoTime();
        QuickSort.leftQuickSort(ascedningOrder,0,ascedningOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[LEFTMOSE ELEMENT - PIVOT] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of ascending numberss");
        //Project.printArray(ascedningOrder); 
        // QUICKSORT | LEFTMOST (first) |  DESCEDNING 
        startTime = System.nanoTime();
        QuickSort.leftQuickSort(decendingOrder,0,decendingOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[LEFTMOSE ELEMENT - PIVOT] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of descending numberss");
        
        //Project.printArray(decendingOrder);
        // QUICKSORT | MEDIAN OF 3  |  RANDOM 
        startTime = System.nanoTime();
        QuickSort.medianQuickSort(randomOrder,0,randomOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[MEDIAN OF 3] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of random numberss");
        //Project.printArray(ascedningOrder); 
        // QUICKSORT | MEDIAN OF 3  |  ASCENDING 
        startTime = System.nanoTime();
        QuickSort.medianQuickSort(ascedningOrder,0,ascedningOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[MEDIAN OF 3] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of ascending numberss");
        //Project.printArray(ascedningOrder); 
        // QUICKSORT | MEDIAN OF 3  |  DESCEDNING 
        startTime = System.nanoTime();
        QuickSort.medianQuickSort(decendingOrder,0,decendingOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[MEDIAN OF 3] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of descending numberss");
        
        //Project.printArray(decendingOrder);
        // REINITIALIZING OBJECTS
        reinitializing(ascedningOrder, decendingOrder, randomOrder, n, myRandom);

        //Project.printArray(decendingOrder);


        //Project.printArray(decendingOrder);

        myScanner.close();
        // PLEASE LEAEN 
        // I love new jersey

    }
}