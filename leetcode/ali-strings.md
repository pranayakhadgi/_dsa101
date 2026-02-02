# Best Time to Buy and Sell Stock

## Problem
[LeetCode 121: Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

### Example
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

## Approach

### Brute Force Solution (Time Limit Exceeded)

The initial approach uses nested loops to check all possible buy-sell pairs:

1. For each day `i`, consider it as a potential buy day
2. For each day `j` after `i`, consider it as a potential sell day
3. Calculate profit: `prices[j] - prices[i]`
4. Track the maximum profit found

**Why it fails**: This approach has O(n²) time complexity, which exceeds the time limit for large inputs.

### Optimal Solution: Two-Pointer / Greedy Algorithm

The optimal solution uses a **two-pointer technique** with a greedy approach:

1. **Left pointer (`left`)**: Tracks the minimum price seen so far (best day to buy)
2. **Right pointer (`right`)**: Scans through all days to find the best day to sell
3. **Greedy strategy**: Whenever we find a lower price, update the buy day. Whenever we find a higher price, calculate profit and update maximum profit.

**Key insight**: We only need to track the minimum price seen so far. For each subsequent day, if the price is higher, we can potentially make a profit. If the price is lower, we update our buy day to this new minimum.

### Algorithm Steps
1. Initialize `left = 0` (buy day) and `right = 1` (sell day)
2. Initialize `maxProfit = 0`
3. While `right < prices.size()`:
   - If `prices[left] < prices[right]`:
     - Calculate profit: `prices[right] - prices[left]`
     - Update `maxProfit = max(maxProfit, profit)`
   - Else (if `prices[left] >= prices[right]`):
     - Update `left = right` (found a new minimum price, better buy day)
   - Increment `right` to check the next day
4. Return `maxProfit`

## Complexity Analysis

### Brute Force Solution
- **Time Complexity**: O(n²)
  - Outer loop: O(n)
  - Inner loop: O(n)
  - Overall: O(n²)
- **Space Complexity**: O(1)
  - Only using a few variables

### Optimal Solution (Two-Pointer)
- **Time Complexity**: O(n)
  - Single pass through the array
  - Each element is visited at most twice
- **Space Complexity**: O(1)
  - Only using a constant amount of extra space

## Solutions

### Brute Force Solution (Java) - Time Limit Exceeded

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}
```

### Optimal Solution (C++) - Two-Pointer Approach

```cpp
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int left = 0;   // Buy day (minimum price so far)
        int right = 1;  // Sell day (current day)
        int maxProfit = 0;
    
        while (right < prices.size()) {
            if (prices[left] < prices[right]) {       
                int profit = prices[right] - prices[left];
                maxProfit = max(maxProfit, profit);
            } else {
                // Found a new minimum price, update buy day
                left = right;
            }
            right++;
        }
    
        return maxProfit;
    }
};
```

## Example Walkthrough

Given `prices = [7, 1, 5, 3, 6, 4]`:

### Optimal Solution Execution:

1. **Initialization**: `left = 0`, `right = 1`, `maxProfit = 0`
   - `prices[0] = 7`, `prices[1] = 1`

2. **Iteration 1** (`right = 1`):
   - `prices[left] = 7` > `prices[right] = 1`
   - Update `left = 1` (new minimum found)
   - `maxProfit = 0`

3. **Iteration 2** (`right = 2`):
   - `prices[left] = 1` < `prices[right] = 5`
   - Calculate profit: `5 - 1 = 4`
   - Update `maxProfit = max(0, 4) = 4`

4. **Iteration 3** (`right = 3`):
   - `prices[left] = 1` < `prices[right] = 3`
   - Calculate profit: `3 - 1 = 2`
   - Update `maxProfit = max(4, 2) = 4`

5. **Iteration 4** (`right = 4`):
   - `prices[left] = 1` < `prices[right] = 6`
   - Calculate profit: `6 - 1 = 5`
   - Update `maxProfit = max(4, 5) = 5`

6. **Iteration 5** (`right = 5`):
   - `prices[left] = 1` < `prices[right] = 4`
   - Calculate profit: `4 - 1 = 3`
   - Update `maxProfit = max(5, 3) = 5`

7. **Return**: `maxProfit = 5`

**Result**: Buy on day 1 (price = 1) and sell on day 4 (price = 6), profit = 5.

## Notes

- The two-pointer approach is optimal because we only need one pass through the array
- The key insight is that we should always buy at the minimum price seen so far
- When we encounter a price lower than our current buy price, we update the buy day because it gives us a better opportunity for profit
- This problem can also be solved using dynamic programming, but the two-pointer approach is more efficient and intuitive
- Edge cases handled: empty array, descending prices (returns 0), single element array

---

# Longest Substring Without Repeating Characters

## Problem
[LeetCode 3: Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Given a string `s`, find the length of the **longest substring** without repeating characters.

### Example
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

## Approach

This solution uses a **sliding window technique** with a **hash set** to efficiently track characters in the current window:

1. **Two pointers**: `l` (left) and `r` (right) define the current window
2. **Hash set (`set1`)**: Tracks unique characters in the current window
3. **Sliding window**: Expand the window by moving `r` forward, and shrink it by moving `l` forward when duplicates are found

**Key insight**: When we encounter a character that's already in our set, we need to shrink the window from the left until that duplicate character is removed. This ensures we always maintain a valid substring without repeating characters.

### Algorithm Steps
1. Initialize `l = 0` (left pointer), `longest = 0` (maximum length found), and an empty set `set1`
2. Iterate through the string with `r` from 0 to n-1:
   - **While** `s[r]` is already in `set1` (duplicate found):
     - Remove `s[l]` from the set
     - Increment `l` to shrink the window from the left
   - Calculate current window width: `w = (r - l) + 1`
   - Update `longest = max(longest, w)`
   - Add `s[r]` to the set
3. Return `longest`

## Complexity Analysis

- **Time Complexity**: O(n)
  - Each character is visited at most twice (once by `r`, once by `l`)
  - The while loop inside the for loop doesn't make it O(n²) because each character is removed from the set at most once
  - Overall: O(n)

- **Space Complexity**: O(min(n, m))
  - Where `n` is the length of the string and `m` is the size of the character set (e.g., 26 for lowercase letters, 128 for ASCII)
  - The set stores at most `min(n, m)` unique characters
  - In the worst case (all unique characters), space is O(n)

## Solution

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        longest = 0
        set1 = set()
        n = len(s)
        
        for r in range(n):
            while s[r] in set1:
                set1.remove(s[l])
                l += 1
            w = (r - l) + 1
            longest = max(longest, w)
            set1.add(s[r])
            
        return longest
```

## Example Walkthrough

Given `s = "abcabcbb"`:

1. **Initialization**: `l = 0`, `longest = 0`, `set1 = {}`

2. **Iteration 1** (`r = 0`, `s[0] = 'a'`):
   - `'a'` not in set → Add `'a'` to set
   - `w = (0 - 0) + 1 = 1`
   - `longest = max(0, 1) = 1`
   - `set1 = {'a'}`

3. **Iteration 2** (`r = 1`, `s[1] = 'b'`):
   - `'b'` not in set → Add `'b'` to set
   - `w = (1 - 0) + 1 = 2`
   - `longest = max(1, 2) = 2`
   - `set1 = {'a', 'b'}`

4. **Iteration 3** (`r = 2`, `s[2] = 'c'`):
   - `'c'` not in set → Add `'c'` to set
   - `w = (2 - 0) + 1 = 3`
   - `longest = max(2, 3) = 3`
   - `set1 = {'a', 'b', 'c'}`

5. **Iteration 4** (`r = 3`, `s[3] = 'a'`):
   - `'a'` is in set → Enter while loop:
     - Remove `s[0] = 'a'` from set, `l = 1`
     - `'a'` no longer in set → Exit while loop
   - Add `'a'` to set
   - `w = (3 - 1) + 1 = 3`
   - `longest = max(3, 3) = 3`
   - `set1 = {'b', 'c', 'a'}`

6. **Iteration 5** (`r = 4`, `s[4] = 'b'`):
   - `'b'` is in set → Enter while loop:
     - Remove `s[1] = 'b'` from set, `l = 2`
     - `'b'` no longer in set → Exit while loop
   - Add `'b'` to set
   - `w = (4 - 2) + 1 = 3`
   - `longest = max(3, 3) = 3`
   - `set1 = {'c', 'a', 'b'}`

7. **Iteration 6** (`r = 5`, `s[5] = 'c'`):
   - `'c'` is in set → Enter while loop:
     - Remove `s[2] = 'c'` from set, `l = 3`
     - `'c'` no longer in set → Exit while loop
   - Add `'c'` to set
   - `w = (5 - 3) + 1 = 3`
   - `longest = max(3, 3) = 3`
   - `set1 = {'a', 'b', 'c'}`

8. **Iteration 7** (`r = 6`, `s[6] = 'b'`):
   - `'b'` is in set → Enter while loop:
     - Remove `s[3] = 'a'` from set, `l = 4`
     - `'b'` still in set → Continue
     - Remove `s[4] = 'b'` from set, `l = 5`
     - `'b'` no longer in set → Exit while loop
   - Add `'b'` to set
   - `w = (6 - 5) + 1 = 2`
   - `longest = max(3, 2) = 3`
   - `set1 = {'c', 'b'}`

9. **Iteration 8** (`r = 7`, `s[7] = 'b'`):
   - `'b'` is in set → Enter while loop:
     - Remove `s[5] = 'c'` from set, `l = 6`
     - `'b'` still in set → Continue
     - Remove `s[6] = 'b'` from set, `l = 7`
     - `'b'` no longer in set → Exit while loop
   - Add `'b'` to set
   - `w = (7 - 7) + 1 = 1`
   - `longest = max(3, 1) = 3`
   - `set1 = {'b'}`

10. **Return**: `longest = 3`

**Result**: The longest substring without repeating characters is "abc" (or "bca" or "cab"), with length 3.

## Notes

- The sliding window technique is optimal for this problem, avoiding the need to check all possible substrings
- The set data structure provides O(1) average-case lookup, insertion, and deletion operations
- The key optimization is that we don't need to reset the window completely when a duplicate is found; we only need to remove characters from the left until the duplicate is eliminated
- This approach ensures we always maintain the longest valid substring ending at the current position
- Edge cases handled: empty string (returns 0), string with all unique characters, string with all same characters
- Alternative approaches include using a hash map to store character indices for faster window shrinking, but the set-based approach is simpler and still efficient

