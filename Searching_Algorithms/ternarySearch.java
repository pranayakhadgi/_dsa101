package Pranaya.Searching_Algorithms;

public class ternarySearch {
    public int ternaryFind(int[] array, int target){
        return ternaryFind(array, target, 0, array.length -1);
    }

    private int ternaryFind(int[] array, int target, int left, int right){
        if(right < left) return -1;

        var partitionSize = (right -left)/3;
        var mid1 = left + partitionSize; var mid2 = right - partitionSize;

        if(array[mid1] == target) return mid1;
        if(array[mid2] == target) return mid2;

        if(array[mid1] > target) return ternaryFind(array, target, left, mid1 -1);
        else if(array[mid1] < target && array[mid2] > target) return ternaryFind(array, target, mid1 +1, mid2 -1);


        else return ternaryFind(array, target, mid2 + 1, right);
    }
}
