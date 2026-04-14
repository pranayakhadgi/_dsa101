package Pranaya.HashMap;

import java.util.Hashtable;

public class HashmapEx3_hashtable_main {
    public static void main(String[] args) {

        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(6, "A"); // remainder 1 index 1
        table.put(8, "B"); // 3
        table.put(11, "C");
        table.put(6, "A+");
        table.remove(60);
        System.out.println(table.get(10));

    }
}
