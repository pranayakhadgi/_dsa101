package Pranaya;

public class StringEx1 {
    public static int countVowels(String str) {
//        String message = "hello";
//        int count = 0;
//        for (int i = 0; i < message.length(); i++) {
//            char s = Character.toUpperCase(message.charAt(i));
//            if(s == 'A' || s =='E' || s =='I' || s =='O' || s == 'U')
//            count++;
//        }
//        System.out.println(count);
        if(str == null)
            return 0;

        int count =0;
        String vowels = "aeiou";
        // aeiou
        for  (var ch : str.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;
        return count;
    }

}
