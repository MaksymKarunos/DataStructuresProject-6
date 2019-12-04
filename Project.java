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
        int[] descendingOrder = new int[n];
        int[] ascendingOrder = new int[n];
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
 * 
 * 
 * 
 * NOTE: 
 * 1 - Insertion Sort 
 * 2a - QuickSort (firtst element is the pivot)
 * 2b - QuickSort (median of 3)
 * n = 14000
 * 
 *   Version | increasing order | decreasing order | random     |
 *      1    | 126141           |  181858210       |  87277458  |
 *      2a   | 62794781         |  82114685        |  6043453   | 
 *      2b   | 28520406         |  20120641        |  29629639  | 
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
 * When we start comparing sorting methods in an already sorted in increasing order array, we noticed some data that doesn't really
 * match our expectations. According to our theory, the fastest sort should be insertion sort since we would just need to go through the 
 * array making n comparisons and realizing that all items are already sorted. The next fastest method will be quicksort when the pivot is
 * the median between three values. The slowest should be quicksort with a random pivot since the works case will be n^2 because we could choose either
 * the smallest or largest value. However, our experimental running times don't exactly match with that. Insertion sort is the fastest but the times for the quicksort
 * methods should be reverse.
 * 
 * When comparing decreasing order we got the expected times. Quicksort with median as pivot is the fastest. It also makes sense the worst case for quicksort with leftmost pivot
 * and insertion sort are a lot higher since they are O(n^2)
 * 
 * For a random array we observed that the largest running time for sorting corresponded with what we predicted, insertion sort, that has a worst case time of O(n^2)
 * The running times for quicksort match the O(nlgn)time but it is uncommon that choosing a random pivot is faster than the median.
 * 
 * For comparing insertion sort in the three different types of arrays we noticed that the fastest observed was for a increasing order array as we predicted.
 * Sorting by insertion sort something that is already sorted in increasing order should always be faster as long as our insertion sort method sort numbers in increasing order.
 * 
 * For quicksort using the leftmost as pivot we observed that as we predicted the fastest time was for a random array, this way we know that the pivot is just a random number unlike in 
 * the other cases when we know its either the largest of the smallest, making the partitions for quicksort useless.
 * 
 * When choosing the median we always assure O(nlogn) as worst case. All values obtained are pretty consistent with a time between 2 million nanoseconds and 3 million.
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
        int[] descendingOrder = new int[n];
        int[] ascendingOrder = new int[n];
        int[] randomOrder = new int[n];

        reinitializing(ascendingOrder, descendingOrder, randomOrder, n, myRandom);

        //  UNCOMMENT THE LINE BELOW TO CHECK THE ORDER 
        // Project.printArray(descsendingOrder);
        // INSERTION  |  RANDOM 
        startTime = System.nanoTime();
        Insertion.sort(randomOrder);
        endTime = System.nanoTime();
        System.out.println("INSERTION SORT:" + " It took " + (endTime-startTime) + " nano" + " to sort an array of random numberss");

        // INSERTION  |  ASCENDING 
        startTime = System.nanoTime();
        Insertion.sort(ascendingOrder);
        endTime = System.nanoTime();
        System.out.println("INSERTION SORT:" + " It took " + (endTime-startTime) + " nano" + " to sort an array of ascending numberss");

        // INSERTION  |  DESCEDNING 
        startTime = System.nanoTime();
        Insertion.sort(descendingOrder);
        endTime = System.nanoTime();
        System.out.println("INSERTION SORT:" + " It took " + (endTime-startTime) + " nano" + " to sort an array of descending numberss");

        //  UNCOMMENT THE LINE BELOW TO CHECK THE ORDER 
        // Project.printArray(descendingOrder); 

        // REINITIALIZING OBJECTS
        reinitializing(ascendingOrder, descendingOrder, randomOrder, n, myRandom);

        // QUICKSORT | LEFTMOST (first) |  RANDOM 
        startTime = System.nanoTime();
        QuickSort.leftQuickSort(randomOrder,0,randomOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[LEFTMOSE ELEMENT - PIVOT] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of random numbers");
        //Project.printArray(ascendingOrder); 
        // QUICKSORT | LEFTMOST (first)  |  ASCENDING 
        startTime = System.nanoTime();
        QuickSort.leftQuickSort(ascedningOrder,0,ascedningOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[LEFTMOSE ELEMENT - PIVOT] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of ascending numbers");
        //Project.printArray(ascendingOrder); 
        // QUICKSORT | LEFTMOST (first) |  DESCEDNING 
        startTime = System.nanoTime();
        QuickSort.leftQuickSort(descendingOrder,0,descendingOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[LEFTMOSE ELEMENT - PIVOT] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of descending numbers");
        
        //Project.printArray(descendingOrder);
        // QUICKSORT | MEDIAN OF 3  |  RANDOM 
        startTime = System.nanoTime();
        QuickSort.medianQuickSort(randomOrder,0,randomOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[MEDIAN OF 3] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of random numbers");
        //Project.printArray(ascendingOrder); 
        // QUICKSORT | MEDIAN OF 3  |  ASCENDING 
        startTime = System.nanoTime();
        QuickSort.medianQuickSort(ascedningOrder,0,ascedningOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[MEDIAN OF 3] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of ascending numbers");
        //Project.printArray(ascendingOrder); 
        // QUICKSORT | MEDIAN OF 3  |  DESCEDNING 
        startTime = System.nanoTime();
        QuickSort.medianQuickSort(descendingOrder,0,descendingOrder.length-1);
        endTime = System.nanoTime();
        System.out.println("[MEDIAN OF 3] QuickSort:" + " It took " + (endTime-startTime) + " nanoseconds" + " to sort an array of descending numbers");
        
        //Project.printArray(descendingOrder);
        // REINITIALIZING OBJECTS
        reinitializing(ascendingOrder, descendingOrder, randomOrder, n, myRandom);

        //Project.printArray(descendingOrder);


        //Project.printArray(descendingOrder);

        myScanner.close();
        

    }
}