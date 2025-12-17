package Pranaya;

public class StringEx2 {
    public static String getReverse(String word) {

        if(word == null)
            return "";
        StringBuilder reverse = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) { //O(n)
            reverse.append(word.charAt(i)); //O(1) from O(n)
        }

        return reverse.toString();
    }
}
//strings are immutable, meaning that adding new string means a creatio nof anew strnig placed