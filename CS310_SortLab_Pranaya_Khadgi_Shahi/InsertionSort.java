/*
 * CS310 lab: Insertion Sort Implementation
 * @author Pranaya Khadgi Shahi
 * @date 2/19/2026
 * 
 * This program implements the insertion sort with step counting
 * to analyze the algorithm's performance 
 */
public class InsertionSort {

    //using the static counter ensures the number of steps required
    private static long stepCount = 0; 

    public static void insertionSort(int[] arr) {
        stepCount = 0; //resets the count for each run

        int n = arr.length;

        for(int i = 1; i < n; i++) {
            int key = arr[i];
            stepCount++;

            int j = i - 1;
            while(j >= 0){
                stepCount++;

                if(arr[j] > key) {
                    stepCount++; //counts the comparison
                    arr[j + 1 ] = arr[j];
                }
            }
        }
    }
}