package Pranaya.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashmapEx1_main {
    public static void main(String[]args){
        //Key: Employee Number (Integer)
        //Value: Name (string)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Pranaya");
        map.put(2, "Dikshya");
        map.put(2, "Kookie");
        map.put(3, null);
        map.put(null, null);//interview question: map has null keys and null values
        map.remove(1);
        map.containsKey(3);// O(1)
        map.containsValue("Dikshya");// O(n) iteration to find
        System.out.println(map);

        for(var item  : map.entrySet())//keyset prints the key number
            System.out.println(item);
    }
}
