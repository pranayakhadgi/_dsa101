package Pranaya;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class StringEx3_main {
    public static void main(String[] args) {
        String sentence = StringEx3.getReversed("     Mayowa might be homosexual    ");
        System.out.println("'" + sentence + "'");
    }
}
