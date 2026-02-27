public class SelectionSort {
    public int[] selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            int min_inx = i; 
            for(j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                min_idx = j;
            }

            if(min+idx != i)
            swap(arr, i, min_idx);
        }
        return arr;
    } 

    public void swap(int[] arr, int i, int min_idx){
        int temp = arr[i];
        arr[i] = arr[min_idx];
        arr[min_idx] = temp;
    }
}