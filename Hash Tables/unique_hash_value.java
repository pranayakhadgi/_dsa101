public class unique_hash_value {
    public int hashCode(String text){
        int hash = 0;
        for(int i = 0; i < text.length(); i++)
            hash = hash + ((int)Math.pow(2, i)) * int(text[i]);
        return hash;
    }

    public static void main(String[] args)
    {
        String foo = "abc";
        String bar = "cba";
        String beta = "bca";

        System.out.println(foo.hashCode());
        System.out.println(bar.hashCode());
        System.out.println(beta.hashCode());
    }
}