# Strings

## My understanding

I am going through certain string as a data structure tutorials. I starting with the simple problem of counting vowels in a string. I just realised that the string method can be executed in a  String class that has the comparsin method. We use the Char.Conttains(), to chheck with the string "aeiou". Conditionals for null value and reutrn of the count all makes sense now. 

On the second exercise, the implementation of the reverse method using a separate String class gave me a good understanding of one commonly thought algorithm could have inefficient time complexity. In this case, I had to switch to StringBuilder function to reduce the time complexity from O(n) (becomes problematic when n value gets much larger) to O(1). Null conditional is thrown, and so returns an empty string for future consideration of finding the length and getting an exception.

On the third problem, with word reverse problem, I understood about Collection function that uses joining the arrays as lists. The function Arrays.asList() converts the given string literal to Arraylist which could be later executed as list objects for the Collection method. 

On the fourth problem, it gave me a sense of shortening the solutions using a single return statement which has a default boolean return value when implemetned with the correct functions. The use of concatination of two strings to comparte it with the second input string to check the rotation is actually a genius approach to execute a rather challenging problem. 

The fifth problem, that tells you to remove duplicates introduces to LinkedHash collection class, that take sthe key value and removes redundancy, using it with seen variables and comparing it with the given added char output we'll check the conditionals and add each characters to the output string.

The sixth problem was to find the most repeated character, and using the HashTable Map collections, I was able to integrate with the keyvalue and getvalue, where using some variable to store the maxcount wit hhte map fucntion to getthe value and store the most repeated character within the given input string.

(interview imp!!) For the seventh problem, every word initial capitalization was a little challenging but was ratehr a bunch of char index manipulation and making sure that the sub substring gets capitalized, later adding teh rest of the letters to the word, summing up the initial capitalized word with whitespace break in betwen.

(interview imp!!) The eight problem was the most imteresting string topic, the use of Anagram. Anagram refers to the two string having the same character despite their differnet orders. The simple apparoch for anagram check was to use the enhanced foreach to break the word into array of cahracters, sort both the arrays and then compare using equals. Note thqat equals is the method for content comparison, rather than reference, in which you use "==". The second method using Histrogramming was the use of frequencies between two arrays and making sure that the decrement in the frequency of the second array doesn't drop down to zero, in such case the strings aren't anagrams.

(common interview) The final and the ninth problem, was checking the palindrome. The simplest approach is to use the reverse and compare algorithms, otherwise you could use two pointers to go on both sides of the words to meet at the center of teh word to determine the palindrom e which uses much less time complexity.