/*
 * CS310 lab: Merge Sort Implementation
 * @author Pranaya Khadgi Shahi
 * @date 2/19/2026
 *
 * implements merge sort with step counting to analyze the algorithms performance
 */
public class MergeSort {

    // static counter for number of steps required
    private static long stepCount = 0;

    /**
     * Sorts the given array in ascending order using merge sort.
     * @param arr the array to sort (modified in place)
     */
    public static void mergeSort(int[] arr) {
        stepCount = 0; // resets count for each run
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive merge sort on the range [begin, end].
     */
    private static void mergeSort(int[] arr, int begin, int end){
        if (begin >= end) return;

        stepCount++;
        int mid = begin + (end - begin) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    /**
     * Merges two sorted subarrays arr[left..mid] and arr[mid+1..right].
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int lenLeft = mid - left + 1;
        int lenRight = right - mid;

        int[] leftArray = new int[lenLeft];
        int[] rightArray = new int[lenRight];

        for (int i = 0; i < lenLeft; i++) {
            leftArray[i] = arr[left + i];
            stepCount++;
        }
        for (int j = 0; j < lenRight; j++) {
            rightArray[j] = arr[mid + 1 + j];
            stepCount++;
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < lenLeft && j < lenRight) {
            stepCount++; // comparision
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            stepCount++;
            k++;
        }

        while (i < lenLeft) {
            arr[k] = leftArray[i];
            stepCount++;
            i++;
            k++;
        }

        while (j < lenRight) {
            arr[k] = rightArray[j];
            stepCount++;
            j++;
            k++;
        }
    }

    /**
     * Returns the step count from the last run of mergeSort.
     * @return number of steps counted
     */
    public static long getStepCount() {
        return stepCount;
    }

    /** Sample run for deliverable 1 */
    public static void main(String[] args) {
        int[] array = {10, 50, 16, 16, 2, 5};
        mergeSort(array);
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("Steps: " + getStepCount());
    }
}
