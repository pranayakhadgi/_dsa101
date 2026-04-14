import java.util.Arrays;

public class Selection_Sorting {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {20, 12, 10, 15, 2};
        System.out.println("Before Selection Sort:");
        System.out.println(Arrays.toString(data));

        selectionSort(data);

        System.out.println("After Selection Sort:");
        System.out.println(Arrays.toString(data));
        
        System.out.println("\nJava execution is working correctly!");
    }
}