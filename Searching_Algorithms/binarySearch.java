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
//[2,3,5,11,17,23,29] index: 0---->6 
//take search value as 1
public int binarySearch(int[] array, int searchValue){
    
    long first = 0; long last = 6;
while (first <= last) {
    //step 1: calcualte the middle value
    long middle = (first + last) /2;

    //step 2: set the conditionals. dr.rahman started with if array[middle] > searchValue
    //but it doesn't matter - mine's kind of reversed.
    //the step adds up to step 2++ until 5.
if(array[middle] == searchValue){
    searchValue =  array[middle]; break;
} else if(searchValue < array[middle]) {
    last = middle - 1;
else {// searchValue > array[middle]
    first = middle + 1;
}linke
return postion;
}
}



//THINK, PAIR AND SHARE#2
//[2, 16, 30, 80, 97, 98, 99
public iny binaryFind(int[] array, searchValue){
    
}

    
