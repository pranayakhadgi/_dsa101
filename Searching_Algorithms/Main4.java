package Pranaya.Searching_Algorithms;

public class Main4 {
    public static void main(String[] args) {
        jumpSearch search = new jumpSearch();
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        var result = search.findJump(array, 8);
        System.out.println(result);
    }
}
