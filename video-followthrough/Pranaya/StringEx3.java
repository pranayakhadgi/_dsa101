package Pranaya;

import java.util.Arrays;
import java.util.Collections;

public class StringEx3 {
    public static String getReversed (String str){
//        StringBuilder reversed = new StringBuilder();
//        String[] word = str.split(" ");
//        for(int i = word.length -1; i >= 0; i--){
//            reversed.append(word[i]);
//            if(i != 0)
//                reversed.append(" ");// adds spaces between the words
//        }
//            return reversed.toString().trim();
        if(str == null)
            return "";

        String[] words = str.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
