package Pranaya;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringEx5 {
    public static String remDuplicate (String word) {
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new LinkedHashSet<>();//this collection class has a property that removes duplication
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!seen.contains(ch)) {
                output.append(ch);
                seen.add(ch);
            }
        }
        return output.toString();
    }
}
