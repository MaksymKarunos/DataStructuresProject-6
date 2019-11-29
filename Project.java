import java.util.Random;
import java.util.Scanner;

public class Project{
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
    static void reinitializing(int[] a , int [] b, int[] c, int n, Random myRandom){
        for ( int i = 0; i < n; i++ ){
            a[i] = i;
        }
        for ( int i = n-1; i >= 0; i--){
        
           b[n-i-1] = i;
         // 
        }
        for ( int i = 0; i < n; i++){
            c[i] = myRandom.nextInt(Integer.MAX_VALUE);
    }
}

    public static void main(String[] args){
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
        
        // REINITIALIZING OBJECTS
        reinitializing(ascedningOrder, decendingOrder, randomOrder, n, myRandom);

        myScanner.close();
        // PLEASE LEAEN 
        // I love new jersey

    }
}