/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Input: NONE
 *  Output: NONE
 *
 *  Visible data fields:
 *  NONE
 *
 *  Visible methods:
 *  static void sort(int arr[]) 
 *************************************************************************/
public class Insertion{
    //Implementation of insertion sort
    static void sort(int arr[]) { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
}