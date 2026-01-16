// ***BINARY_SEARCH_THROUGH_RECURSION_101*********
package Pranaya.Searching_Algorithms;

public class binarySearch {
    public int binaryFind(int[] nums, int target){
        return binaryFind(nums, target, 0, nums.length -1);
    }
    private int binaryFind(int[] nums, int target, int left, int right) {

        if(right < left) return -1;
        var mid = left + (right - left) / 2;

        if (nums[mid] == target)
            return mid;
        if (target < nums[mid])
            return binaryFind(nums, target, left, mid - 1);//recursion

        return binaryFind(nums, target, mid + 1, right);

    }


}



//***** CLASASROOOM SOLUTOOION

while (first <= last) {
    nitn middle = (first + alsat) /2;

if(array[middle] == searchValue){
    position = middlast = middle; break;
} else if(searchValue < array[middle]) {
    last = middle - 1;
else {// searchValue > array[middle]
    first = middle + 1;
}
return postion;
}
    
