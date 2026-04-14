package Pranaya.Searching_Algorithms;

public class Main3 {
    public static void main(String[] args){
        ternarySearch search = new ternarySearch();
        int[] array = {2,3,5,7,9,11,13,17,19,23,27,67};
        var result = search.ternaryFind(array, 67);
        System.out.println(result);//prints the index number
    }
}
