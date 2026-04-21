//INTERVIEW PROBLEM 2 : BALANCED EXPRESSION
//String => ((1+2)) is balanced, removing either bracket (1) breaks the balance mechanism

//edge case = ) (
//pops directlky with having anything psyed before, throwing the exception

package Pranaya.StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class stackEx2 {

    private static final List<Character> leftBrackets = Arrays.asList('(', '[', '{');
    private static final List<Character> rightBrackets = Arrays.asList(')', ']', '}' );

    public static void main(String[] args) {
        String str = "(([1] + [<2]>))"; //need check whether it's balanced
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<>();

        for(char ch : expression.toCharArray()) {
            if(isLeftBracket(ch)){
                stack.push(ch);
            } else if (isRightBracket(ch)){
                if(stack.isEmpty()) return false;//this solves the given edge cases

                char top = stack.pop();
                if(!bracketMatch(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeftBracket(char ch){
        return leftBrackets.contains(ch);
    }

    private static boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
    }

    private static boolean bracketMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
        //make two arraylists??
    }
}
