import java.util.Arrays;
import java.util.Random;

public class QuickSort{
    private static int medianPivot(int arr[], int low, int high) {
		/*
		 * create subarray with low, high, and middle elements in the array sort the
		 * subarray and use index 1 as the median of 3
		 */

		int first = arr[low];
		int last = arr[arr.length - 1];
		int mid = (high) / 2;

		int[] sortingArr = { arr[low], arr[mid], arr[high] };

		Arrays.sort(sortingArr);

		int middleValue = sortingArr[1];
		//printArray(sortingArr);

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
    public static void medianQuickSort(int arr[], int low, int high) {
		if (low < high) {

			int pi = medianPivot(arr, low, high);

			quickSort(arr, low, high);

		}
    }
    public static void quickSort(int arr[], int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
    }
    public static int partition(int arr[], int low, int high) {
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
}
