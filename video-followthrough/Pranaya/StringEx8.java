//important for interview!!!!

//a string is an anagram of another string if it has the exact same characters in any orders
// ABCD - CBDA are anagrams
// ['A', 'B', 'C', 'D']<--- sort compare
package Pranaya;

import java.util.Arrays;

public class StringEx8 {

    //O(n log n)
    public static boolean areAnagrams (String first, String second){
        if(first == null || second == null || first.length() != second.length())
            return false;
        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    //O(n)
    public static boolean areAnagramusingHistogramming (String first, String second){
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for(var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++; // - 'a' will prevent OutOfArray

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;
            frequencies[index]--;//if the two strings match, the frequency shouldn't drop down to zero.
        }
        return true;
    }
}
