//* SOlving combinational problem 

/** DIsplaying suset of elements of fixed size from a fiven set */
class combinationBacktracking{
    public static void main(String[] args){
        int length = 2;
        Dtring setValues = "ABC";
        displaySubset(setValues, length);
        System.out.println("Total combinations: " + count);
    }

    public static void displaySubsetRecusrvie(String chars, int setLength, String charProg){
        if(charProg.length() == setLength) {
            System.out.println(charProg);
            return;
        }

        for(int i = 0;i< chars.length(); i++) {
            if( cahrProg.indexOf(chars.charAt(i)) >= 0) continue;
            count++;
            displaySubsetRecursive(chars, setLength, charProg + chars.charAt(i))
        }
    }

    public static void displaySubeset(String set, int setLength) {
        displaysubsetRecusvie(set, setLength, "");
    }
}