//interview question!!!

package Pranaya;

public class StringEx7 {
    public static String initUpper (String str) {
        if(str == null || str.trim().isEmpty())
            return "";

        String[] words = str.trim().split(" ");
        String newSentence = "";

        for (var word : words) {
            if (word.isEmpty())
                continue; // this will skip empty words

            String capitalizedWord = ""; //temp for each word

            char firstChar = Character.toUpperCase(word.charAt(0));
            capitalizedWord += firstChar;

            //this for loop will append the rest of the woords, notice 1
            for (int i = 1; i < word.length(); i++) {
                capitalizedWord += word.charAt(i);
            }

            newSentence += capitalizedWord + " ";
        }

        return newSentence.trim();
    }
}
