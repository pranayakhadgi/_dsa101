public class QuickSort {
    public int[] quickSort(int[] arr, int start, int end){
        //the start of our base case
        if (start >= end) return;

        //1. partition
        int p = partition(arr, start, end);

        //2. recurse
        quickSort(arr, start, p - 1);//left
        quickSort(arr, p + 1, end);//right
    }

    public int partition(int[] arr, int start, int end){
        int pivot = arr[start];//the starting element will be the pivot for partition

        int count = 0;
        for(int i = start + 1; i <= end; i++) {
            if(array[i] <= pivot)
            count++;
        }

        int pivotIndex = start + count;
        swap(arr[pivotIndex], arr[start]);

        int i = start, j = end;
        while(i < pivotIndex && j > pivotIndex) {

            while(arr[i] <= pivot) i++;
            while(arr[j] > pivot) j--;

            
            if( i < pivotIndex && j > pivotIndex) {
                swap(arr[i++], arr[j--]);
            }
        }
        return pivotIndex;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}