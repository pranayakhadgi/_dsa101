public class SortSimulation{
    public static void Main(String[] args){
        int[] array = new int[]{10, 50, 16, 16, 2, 5};
        int start = array[0]; int end = array[array.length - 1];
        insertionSort(array);
        //mergeSort(array, start, end);
        //quickSort(array, start, end);
        //selectionSort(array);
        
    }
}