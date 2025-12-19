//interview question: FIND THE FIRST NON-REPEATED CHARACTER
package Pranaya;

//import java.util.HashMap;
//import java.util.Map;

public class HashmapEx2_main {
    public static void main(String[]args) {
        CharFinder finder = new CharFinder();
        String statement = "a green apple.";
        var ch = finder.findFirstNonRepeatingChar(statement);
        var dz = finder.findFirstRepeatedChar(statement);
        System.out.println(ch);
        System.out.println(dz);
        }
    }

