import java.util.Random;
import java.util.Scanner;

public class Project{
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random(228);
        System.out.println("Input n");
        int n = myScanner.nextInt();

        int[] decendingOrder = new int[n];
        int[] ascedningOrder = new int[n];
        int[] randomOrder = new int[n];

        for ( int i = 0; i < n; i++ ){
            ascedningOrder[i] = i;
        }
        for ( int i = n-1; i > 0; i--){
            decendingOrder[i] = i;
        }
        for ( int i = 0; i < n; i++){
            randomOrder[i] = myRandom.nextInt(Integer.MAX_VALUE);
        }
        Insertion.sort(randomOrder);
        Project.printArray(randomOrder);
        myScanner.close();
        // PLEASE LEAEN 
        // I love new jersey

    }
}