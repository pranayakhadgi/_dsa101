package Pranaya;

public class StringEx4 {
    public static boolean isReverseOf(String str1, String str2){
//        return(str1.length() == str2.length() && (str1 + str2).contains(str2));  the shortest way of using the same logic
        if(str1.length() != str2.length())
            return false;

        if( !(str1 + str2).contains(str2))//OutOfBoundsException might concur for a larger string , use of for is adviced
            return false;
        return true;
//        StringBuilder reversed = new StringBuilder();
//        for (int i = str1.length() - 1; i >= 0 ; i--){
//            reversed.append(str1.charAt(i));
//        }
//        return (reversed.toString().equals(str2));

    }
}
