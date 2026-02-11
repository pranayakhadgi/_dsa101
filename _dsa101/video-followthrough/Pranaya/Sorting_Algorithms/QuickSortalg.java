public class QuickSortalg {
    public static void main(String[] args) {
        int[] array = { 23, 21, 12, 56, 10, 34, 78, 90, 21, 45 };
        quickSort(array, 0, array.length - 1);

        // Output for verification
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start]; // this is our partition value

        int count = 0;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] <= pivot)
                count++;
        }

        int pivotIndex = start + count;
        swap(array, pivotIndex, start);

        int i = start;
        int j = end;

        // this sorts the left and right part of the pivot elements
            while (i < pivotIndex && j > pivotIndex) {//follows O(n)

            while (array[i] <= pivot) {
                if (i >= pivotIndex)
                    break;
                i++;
            }

            while (array[j] > pivot) {
                if (j <= pivotIndex)
                    break;
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    // recursive method
    public static void quickSort(int[] array, int start, int end) {
        // our base case starts
        if (start >= end)
            return;

        // prebuilt function - partition
        int p = partition(array, start, end);

        // recursive calls
        quickSort(array, start, p - 1);// left sort
        quickSort(array, p + 1, end);// right sort
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
