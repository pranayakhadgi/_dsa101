package Pranaya.Searching_Algorithms;

public class exponentialSearch {
    public int findExpo(int[] array, int target){
        int bound =1;
        while (bound < array.length &&
                array[bound] < target)
            bound *= 2;

        int left = bound/2;
        int right = Math.min(bound, array.length -1);
        binarySearch bs = new binarySearch();
        //return bs.binaryFind(array, target, left, right);
        return -1;//the binaryFind didn't make sense, had to terminate at this point
    }



    public class exponentialSearch {
    public int findExpo(int[] array, int target){
        int bound =1;
        while (bound < array.length &&
                array[bound] < target)
            bound *= 2;

        int left = bound/2;
        int right = Math.min(bound, array.length -1);
        binarySearch bs = new binarySearch();
        //return bs.binaryFind(array, target, left, right);
        return -1;//the binaryFind didn't make sense, had to terminate at this point
    }
}


//main was skipped, but it's the same as Main 1, 2, 3 and 4.
