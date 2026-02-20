package Pranaya.Searching_Algorithms;

public class Main2 {
    public static void main(String[] args){
        binarySearch nums = new binarySearch();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        var result = nums.binaryFind(arr, 4);
        System.out.println(result);

    }
}
