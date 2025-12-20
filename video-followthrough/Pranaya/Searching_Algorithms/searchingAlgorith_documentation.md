# My view on Searching Algorithms

## Linear Search
We started with the simplest search algorithm, the linear approach. Run for loop return the value, else return -1. Good for shorter list, which gives the best case scenario of O(1), otherwise, a longer stretch would give us the worst case O(n) for extremely high values. 

## Binary Search
It is much faster, but only works at sorted array. We get the middleIndex through (left+right)/2, but to prevent us from the OutofBoundsError, we strategically use left + (right-left)/2 operation. It uses recursive and iteration way. You could choose either. The time complexity fo rthe binary search is O(log_2 n), slightly faster than the ternary search.
The logic is simple, the middleIndex checks the target value, and based on whether it is equal (displays that index), less (right = middleIndex - 1) or more (left = middleIndex + 1). A total of three conditionals (note this!)

## Ternary Search
Think about Quadraints. The first and third quadraints as two middle indexes this time, same implementation as Binary Search, but with more added conditionals. Yes, they have recursive and iterative method for doing it as well. It uses the time complexity of O(log _3 n).

## Jump Search (Improved Linear)
The jump search algorithm takes a blockSize of (int)Math.sqrt(array.length), and having the edge cases like [!(start >= length && !(next >= length)] in which start exceed will return -1, and next == length-1;
Note that the blockIntervals for target > next1 and target < start2 is the same, so we join them using the AND operator conditional. It uses iterative approach, but recursive can be applied here as well!

## Exponential Search (Improved Binary)
The exponential search algorithm works similar to jump, but instead it doubles the boundary everytime the target is not in that bound. This goes on until bound >= array.length.
Then we implment the binary (middle point) search when the target is highly possible to be within that boundary.

