**Arrays Note**
Array is the collection of similar data types arranged in a series of blocks in an indexed pattern (simplest data structure).
The array contains elements that can be accessed through the index numbers. The basic static array follows a simple O(1) notation. It's fine to start data structure using Arrays, but it's draw backs start to prevail when you start with insertion and deletion of the elements. Given a scenario, what would you do when an element is removed from the very left element? The hectic approach of shifting every following elements needs to be shifted to i-1 > 0 in order to fix the array placement. This indicates that the deletion and insertion uses the O(n) structure.

This is when **Dynamic Arrays** come handy as using the Array class, when the array size exceeds the limitation upon the insertion of the elements, a certian approach of dynamic array (as a class) helps to create a new array twice the original size so that the added elements could fit. The mechanism repeats if the elements keep on getting aded. 

**Exercise 1 Documentation**:- 
I followed Mosh's approach on how to instantiate the Array class so that it would chekc the size of the array using the count variable, and upon every insertion of the elements, it checks the condition. When the array size exceeds, the condition creates a new array object that will make sure every arranged element in a certain index number gets copied with also the added teh elemetns into the new array. 

Now, upon implementing the removeAt function, that would throw the exception for negative index or indexOutOfRange possible inputs, and then making sure that the remaining elements gets shifted to its left consecutive index. We do that by setting the item (specified) to the items with i+1 index. Decrement count triggers the removal of the element.

The indexOf is a return type method, that returns -1 if the index is outreached within the given limits, otherwise it gives the elements on that array. The indexOf gives a good sense of time complexity when uunderstanding Arrays. You need to think of the "Best Case Scenario" anbd the "Worst Case Scenario". In terms of array, finding the indexof within the given array size makes the time complexity as simple as O(1), but the millionth paramenter on the indexOf gives the worst case scenario of O(n) that can go far beyond, taking more time to execute. This is where linked list prevails.

Other Array classes such as the ArrayList (expands 50%) and Vector (expands 100% -  uses synchronization, accesing a single thread, too complicated, hence will be covered in advanced java course). The Arraylist contains add, remove, contains, max, intersect, reveerse, insertAt and other useful functions.

