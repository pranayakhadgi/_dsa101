//another common interview question - PALINDROME
// ABBA, MADAM, RACECAR
//common reverse -> check
//compare left and right most charaters and keep on going in, until both the pointers meet.
package Pranaya;

public class StringEx9 {
    public static boolean isPalindrome(String word){
        var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);
    }

    //uses the two pointers
    public static boolean isPalindrome2(String word){
        if(word == null)
            return false;
        int left = 0;
        int right = word.length() - 1;

        while (left < right)
            if(word.charAt(left++) != word.charAt(right--))
                return false;
        return true;
    }
}
