package Pranaya.String;

import java.util.HashMap;
import java.util.Map;

public class StringEx6 {
    public static char mostRepeated (String str){
        Map<Character, Integer> freq= new HashMap<>();

        for(char ch : str.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        char mostRepeated = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> ch : freq.entrySet()) {
            if (ch.getValue() > maxCount){
                maxCount = ch.getValue();
                mostRepeated = ch.getKey();

            }
        }
        return mostRepeated;
    }
}
