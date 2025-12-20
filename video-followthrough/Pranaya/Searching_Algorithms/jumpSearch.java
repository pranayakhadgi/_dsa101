package Pranaya.Searching_Algorithms;

public class jumpSearch {
    public int findJump(int[] array, int target){
        if(array.length == 0) return -1;

        int jumpSize = (int) Math.sqrt(array.length);
        return findJump(array, target, 0, jumpSize -1, jumpSize);
    }
    private int findJump(int[] array, int target, int start, int next, int jumpSize){
        if(start >= array.length)
            return -1;

        if(next >= array.length)
            next = array.length -1;

        if(target <= array[next]) {
            for(int i = start; i <= next; i++){
                if(array[i] == target) {
                    return i;
                }
            }
            return -1;
        } else{
            int newStart = next + 1;
            int newNext = newStart + jumpSize -1;
            return findJump(array, target, newStart, newNext, jumpSize);
        }
    }
}
