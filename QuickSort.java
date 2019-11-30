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
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  public static void leftQuickSort(int arr[], int low, int high)
 *  public static void medianQuickSort(int arr[], int low, int high)
 *************************************************************************/

import java.util.Arrays;
import java.util.Random;

public class QuickSort{
    // Quicksort using pivot as the median | excellent pivot
    public static void medianQuickSort(int arr[], int low, int high) {
		if (low < high) {

			int pi = medianPivot(arr, low, high);

			medianQuickSort(arr, low, pi - 1);
			medianQuickSort(arr, pi + 1, high);

		}
    }
    // Using first (leftmost) element as the pivot | worst pivot
    public static void leftQuickSort(int arr[], int low, int high) {

		if (low < high -1 ) {
			int pi = leftPartition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			leftQuickSort(arr, low, pi - 1);
			leftQuickSort(arr, pi + 1, high);
		}
    }
    
    // Assistant method to compute median of 3
    private static int medianPivot(int arr[], int low, int high) {

		int first = arr[low];
		int last = arr[arr.length - 1];
		int mid = (high) / 2;

		int[] sortingArr = { arr[low], arr[mid], arr[high] };

		Arrays.sort(sortingArr);

		int middleValue = sortingArr[1];

		// swap with the last to serve as pivot
		int temp = arr[high];
		arr[high] = middleValue;
		if (middleValue == arr[low]) {
			arr[low] = temp;
		} else if (middleValue == arr[mid]) {
			arr[mid] = temp;
		}

		return partition(arr, low, high);

    }
    // Asistant method using median of 3 as the pivot
    private static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element

		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
			
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;

    } 
    // Assistant method that uses first (leftmost) element as the pivot
   private static int leftPartition(int arr[], int low, int high){
    int pivot = arr[low];
    int p1 = low+1;
    int i;
    int temp;

    for( i = low+1 ; i <= high; i++){
        if(arr[i] < pivot){
            if(i!=p1){
                temp=arr[p1];
                arr[p1]=arr[i];
                arr[i]=temp;
          }
        p1++;
        }
    }
    arr[low] = arr[p1-1];
    arr[p1-1] = pivot;
    
    return p1-1;
   } 
}
