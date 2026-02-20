# First Letter to Appear Twice

## Problem
[LeetCode 2351: First Letter to Appear Twice](https://leetcode.com/problems/first-letter-to-appear-twice/)

Given a string `s` consisting of lowercase English letters, return the **first letter to appear twice**.

**Note:**
- A letter `a` appears twice before another letter `b` if the **second occurrence** of `a` is before the **second occurrence** of `b`.
- `s` will contain at least one letter that appears twice.

### Example
```
Input: s = "abccbaacz"
Output: "c"
Explanation:
The letter 'a' appears at indices 0, 5 and 6.
The letter 'b' appears at indices 1 and 4.
The letter 'c' appears at indices 2, 3 and 7.
The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
```

## Approach

This solution uses a **hash set** to efficiently track characters we've seen so far:

1. **Hash set (`freq`)**: Stores characters that have been encountered
2. **Single pass**: Iterate through the string character by character
3. **Early return**: As soon as we find a character that's already in the set, return it immediately

**Key insight**: The first character to appear twice will be the first character we encounter that already exists in our set. We don't need to track counts or indices - we just need to know if we've seen a character before.

### Algorithm Steps
1. Initialize an empty `unordered_set<char>` called `freq`
2. Iterate through each character `c` in the string `s`:
   - Check if `c` is already in `freq`:
     - If yes: Return `c` immediately (this is the first letter to appear twice)
     - If no: Add `c` to `freq` and continue
3. Return `'\0'` (null character) if no duplicate is found (though the problem guarantees at least one duplicate exists)

## Complexity Analysis

- **Time Complexity**: O(n)
  - Single pass through the string
  - Hash set operations (insert and find) are O(1) on average
  - Overall: O(n) where n is the length of the string

- **Space Complexity**: O(min(n, m))
  - Where `n` is the length of the string and `m` is the size of the character set (26 for lowercase English letters)
  - In the worst case, we might store all unique characters before finding a duplicate
  - Since we're dealing with lowercase English letters, space is at most O(26) = O(1)
  - However, for a general character set, it's O(min(n, m))

## Solution

```cpp
class Solution {
public:
    char repeatedCharacter(string s) {
        unordered_set<char> freq;
        for(char c : s) {
            if(freq.find(c) != freq.end()) {
                return c;
            }
            freq.insert(c);
        }
        return '\0';
    }
};
```

## Example Walkthrough

Given `s = "abccbaacz"`:

1. **Initialization**: `freq = {}`

2. **Iteration 1** (`c = 'a'`):
   - `'a'` not in `freq` → Add `'a'` to `freq`
   - `freq = {'a'}`

3. **Iteration 2** (`c = 'b'`):
   - `'b'` not in `freq` → Add `'b'` to `freq`
   - `freq = {'a', 'b'}`

4. **Iteration 3** (`c = 'c'`):
   - `'c'` not in `freq` → Add `'c'` to `freq`
   - `freq = {'a', 'b', 'c'}`

5. **Iteration 4** (`c = 'c'`):
   - `'c'` **is in** `freq` → **Return `'c'` immediately**

**Result**: `'c'` is the first letter to appear twice.

### Alternative Example: `s = "abcdd"`

1. **Iteration 1** (`c = 'a'`): `freq = {'a'}`
2. **Iteration 2** (`c = 'b'`): `freq = {'a', 'b'}`
3. **Iteration 3** (`c = 'c'`): `freq = {'a', 'b', 'c'}`
4. **Iteration 4** (`c = 'd'`): `freq = {'a', 'b', 'c', 'd'}`
5. **Iteration 5** (`c = 'd'`): `'d'` is in `freq` → **Return `'d'`**

## Notes

- The hash set approach is optimal for this problem, providing O(1) average-case lookup and insertion
- We use `unordered_set` in C++ for better average-case performance compared to `set` (which uses a balanced tree)
- The early return optimization means we don't need to process the entire string if we find the duplicate early
- This problem is simpler than finding all duplicates or counting frequencies - we only need to detect the first duplicate
- The problem guarantees at least one duplicate exists, so the `return '\0'` case is technically unreachable but good practice
- Alternative approaches could use a boolean array of size 26 (for lowercase letters) for even better space efficiency, but the hash set approach is more general and readable

---

# Most Frequent Even Element

## Problem
[LeetCode 2404: Most Frequent Even Element](https://leetcode.com/problems/most-frequent-even-element/)

Given an integer array `nums`, return the **most frequent even element**.

If there is a tie, return the **smallest** one. If there is no such element, return `-1`.

### Example
```
Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
2 is the smallest, so return 2.
```

## Approach

This solution uses a **hash map** to count frequencies of even numbers:

1. **Hash map (`umap`)**: Stores each even number and its frequency
2. **First pass**: Iterate through the array, count only even numbers
3. **Second pass**: Find the even number with the highest frequency, breaking ties by choosing the smallest number

**Key insight**: We need to:
- Filter for even numbers only (using modulo operation)
- Count frequencies of even numbers
- Find the maximum frequency
- If multiple numbers have the same maximum frequency, choose the smallest one

### Algorithm Steps
1. Initialize an empty `unordered_map<int, int>` called `umap`
2. **First pass** - Count even numbers:
   - Iterate through each number in `nums`
   - If the number is even (`num % 2 == 0`):
     - Increment its count in `umap`
   - Otherwise, skip it
3. **Second pass** - Find the most frequent even number:
   - Initialize `maxFreq = 0` and `result = -1`
   - Iterate through each pair in `umap`:
     - If the count is greater than `maxFreq`:
       - Update `maxFreq` and `result`
     - If the count equals `maxFreq` and the number is smaller than `result`:
       - Update `result` to the smaller number
4. Return `result` (will be `-1` if no even numbers exist)

## Complexity Analysis

- **Time Complexity**: O(n)
  - First pass: O(n) to iterate through the array
  - Second pass: O(k) where k is the number of unique even numbers (k ≤ n)
  - Overall: O(n)

- **Space Complexity**: O(k)
  - Where k is the number of unique even numbers in the array
  - In the worst case, all numbers are even and unique, so k = n
  - However, typically k < n, so space is O(n) in the worst case

## Solution

```cpp
class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        std::unordered_map<int, int> umap;
        int n = nums.size();

        // First pass: Count frequencies of even numbers
        for(int num : nums) {
            if(num % 2 == 0) {
                umap[num]++;
            } else {
                continue;
            }
        }

        int maxFreq = 0;
        int result = -1;

        // Second pass: Find the most frequent even number
        for(auto pair : umap) {
            int num = pair.first;
            int count = pair.second;

            if(count > maxFreq || (count == maxFreq && num < result)) {
                maxFreq = count;
                result = num;
            }
        }

        return result;
    }
};
```

## Example Walkthrough

Given `nums = [0, 1, 2, 2, 4, 4, 1]`:

### First Pass - Count Even Numbers:

1. **num = 0**: Even → `umap[0] = 1`
2. **num = 1**: Odd → Skip
3. **num = 2**: Even → `umap[2] = 1`
4. **num = 2**: Even → `umap[2] = 2`
5. **num = 4**: Even → `umap[4] = 1`
6. **num = 4**: Even → `umap[4] = 2`
7. **num = 1**: Odd → Skip

**After first pass**: `umap = {0: 1, 2: 2, 4: 2}`

### Second Pass - Find Most Frequent:

1. **pair = (0, 1)**:
   - `count = 1`, `maxFreq = 0` → Update: `maxFreq = 1`, `result = 0`

2. **pair = (2, 2)**:
   - `count = 2`, `maxFreq = 1` → Update: `maxFreq = 2`, `result = 2`

3. **pair = (4, 2)**:
   - `count = 2`, `maxFreq = 2`, `num = 4`, `result = 2`
   - `count == maxFreq` and `4 < 2`? No → No update

**Result**: `result = 2` (appears twice, and is smaller than 4 which also appears twice)

### Alternative Example: `nums = [4, 4, 4, 9, 2, 4]`

**First pass**: `umap = {4: 4, 2: 1}`

**Second pass**:
- `(4, 4)`: `maxFreq = 4`, `result = 4`
- `(2, 1)`: `count = 1 < maxFreq = 4` → No update

**Result**: `4` (appears 4 times)

### Edge Case: `nums = [1, 3, 5]` (No even numbers)

**First pass**: `umap = {}` (empty)

**Second pass**: No iterations, `result` remains `-1`

**Result**: `-1` (no even numbers exist)

## Notes

- The hash map approach efficiently counts frequencies without needing to sort the array
- We use `unordered_map` for O(1) average-case insertion and lookup
- The tie-breaking logic (`count == maxFreq && num < result`) ensures we return the smallest number when frequencies are equal
- The `continue` statement in the first loop is optional but makes the code more readable
- The solution handles edge cases: no even numbers (returns -1), single even number, all numbers are even
- Alternative approach: Could use a single pass with tracking, but the two-pass approach is clearer and easier to understand
- The modulo operation (`num % 2 == 0`) is the standard way to check for even numbers

---

# Majority Element

## Problem
[LeetCode 169: Majority Element](https://leetcode.com/problems/majority-element/)

Given an array `nums` of size `n`, return the **majority element**.

The majority element is the element that appears **more than** `⌊n / 2⌋` times.

You may assume that the majority element always exists in the array.

### Example
```
Input: nums = [3,2,3]
Output: 3
Explanation: The element 3 appears 2 times, which is more than ⌊3 / 2⌋ = 1.
```

## Approach

This solution uses a **hash map** to count the frequency of each element:

1. **Hash map (`freq`)**: Stores each number and its frequency count
2. **First pass**: Count the frequency of each element in the array
3. **Second pass**: Find the element with frequency greater than `n / 2`

**Key insight**: Since the majority element appears more than half the time, we can simply count all frequencies and find the one that exceeds the threshold. The problem guarantees that a majority element exists, so we don't need to handle the case where no majority exists.

### Algorithm Steps
1. Initialize an empty `unordered_map<int, int>` called `freq`
2. **First pass** - Count frequencies:
   - Iterate through each number in `nums`
   - Increment the count for each number in `freq`
3. **Second pass** - Find majority element:
   - Iterate through each pair in `freq`
   - If the count (`pair.second`) is greater than `n / 2`:
     - Return that element (`pair.first`)
4. Return `-1` if no majority found (though the problem guarantees one exists)

## Complexity Analysis

- **Time Complexity**: O(n)
  - First pass: O(n) to iterate through the array and count frequencies
  - Second pass: O(k) where k is the number of unique elements (k ≤ n)
  - Overall: O(n)

- **Space Complexity**: O(k)
  - Where k is the number of unique elements in the array
  - In the worst case, all elements are unique, so k = n
  - However, typically k < n, so space is O(n) in the worst case

## Solution

```cpp
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> freq; 
        int n = nums.size();

        // First pass: Count frequencies
        for(int num : nums) {
            freq[num]++;
        }

        // Second pass: Find element with frequency > n/2
        for(auto pair : freq) {
            if(pair.second > n / 2) {
                return pair.first;
            }
        }

        return -1; 
    }
};
```

## Example Walkthrough

Given `nums = [3, 2, 3]`:

### First Pass - Count Frequencies:

1. **num = 3**: `freq[3] = 1`
2. **num = 2**: `freq[2] = 1`
3. **num = 3**: `freq[3] = 2`

**After first pass**: `freq = {3: 2, 2: 1}`, `n = 3`

### Second Pass - Find Majority Element:

1. **pair = (3, 2)**:
   - `count = 2`, `n / 2 = 3 / 2 = 1`
   - `2 > 1` → **Return `3`**

**Result**: `3` (appears 2 times, which is more than ⌊3 / 2⌋ = 1)

### Alternative Example: `nums = [2, 2, 1, 1, 1, 2, 2]`

**First pass**: `freq = {2: 4, 1: 3}`, `n = 7`

**Second pass**:
- `(2, 4)`: `4 > 7 / 2 = 3` → **Return `2`**

**Result**: `2` (appears 4 times, which is more than ⌊7 / 2⌋ = 3)

### Edge Case: `nums = [1]` (Single element)

**First pass**: `freq = {1: 1}`, `n = 1`

**Second pass**:
- `(1, 1)`: `1 > 1 / 2 = 0` → **Return `1`**

**Result**: `1` (single element is always the majority)

## Notes

- The hash map approach is straightforward and easy to understand
- We use `unordered_map` for O(1) average-case insertion and lookup
- The problem guarantees that a majority element exists, so the `return -1` case is technically unreachable but good practice
- The threshold `n / 2` uses integer division, which automatically floors the result
- **Alternative approaches**:
  - **Boyer-Moore Voting Algorithm**: O(n) time, O(1) space - more space-efficient but less intuitive
  - **Sorting**: O(n log n) time - sort and return the middle element
  - **Randomized algorithm**: O(n) expected time - randomly pick an element and verify
- The hash map approach is optimal in terms of time complexity and is the most intuitive solution
- This solution works well when you need to understand the frequency distribution of all elements

---

# Valid Anagram

## Problem
[LeetCode 242: Valid Anagram](https://leetcode.com/problems/valid-anagram/)

Given two strings `s` and `t`, return `true` *if* `t` *is an anagram of* `s`*, and* `false` *otherwise*.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

### Example
```
Input: s = "anagram", t = "nagaram"
Output: true
Explanation: Both strings contain the same characters with the same frequencies.
```

## Approach

This solution uses **two hash maps** to count character frequencies in both strings:

1. **Hash maps (`smap` and `tmap`)**: Store character frequencies for each string
2. **First pass**: Count frequencies of all characters in string `s`
3. **Second pass**: Count frequencies of all characters in string `t`
4. **Comparison**: Check if both hash maps are equal

**Key insight**: Two strings are anagrams if and only if they have the same character frequency distribution. If both hash maps contain the same key-value pairs, the strings are anagrams.

### Algorithm Steps
1. Initialize two empty `unordered_map<char, int>` called `smap` and `tmap`
2. **First pass** - Count characters in `s`:
   - Iterate through each character in `s`
   - Increment the count for each character in `smap`
3. **Second pass** - Count characters in `t`:
   - Iterate through each character in `t`
   - Increment the count for each character in `tmap`
4. **Compare**: Return `true` if `smap == tmap`, `false` otherwise

## Complexity Analysis

- **Time Complexity**: O(n + m)
  - First pass: O(n) to count characters in `s` where n is the length of `s`
  - Second pass: O(m) to count characters in `t` where m is the length of `t`
  - Comparison: O(k) where k is the number of unique characters (k ≤ min(n, m))
  - Overall: O(n + m)

- **Space Complexity**: O(k)
  - Where k is the number of unique characters in the strings
  - We store two hash maps, each with at most k entries
  - In the worst case, all characters are unique, so k = n = m
  - However, typically k < n and k < m, so space is O(min(n, m)) in practice
  - For lowercase English letters, k ≤ 26, so space is effectively O(1)

## Solution

```cpp
class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> smap, tmap;

        // Count frequencies in string s
        for(char c : s) {
            smap[c]++;
        }

        // Count frequencies in string t
        for(char c : t) {
            tmap[c]++;
        }

        // Compare the two frequency maps
        return tmap == smap;
    }
};
```

## Example Walkthrough

Given `s = "anagram"` and `t = "nagaram"`:

### First Pass - Count Characters in `s`:

1. **'a'**: `smap['a'] = 1`
2. **'n'**: `smap['n'] = 1`
3. **'a'**: `smap['a'] = 2`
4. **'g'**: `smap['g'] = 1`
5. **'r'**: `smap['r'] = 1`
6. **'a'**: `smap['a'] = 3`
7. **'m'**: `smap['m'] = 1`

**After first pass**: `smap = {'a': 3, 'n': 1, 'g': 1, 'r': 1, 'm': 1}`

### Second Pass - Count Characters in `t`:

1. **'n'**: `tmap['n'] = 1`
2. **'a'**: `tmap['a'] = 1`
3. **'g'**: `tmap['g'] = 1`
4. **'a'**: `tmap['a'] = 2`
5. **'r'**: `tmap['r'] = 1`
6. **'a'**: `tmap['a'] = 3`
7. **'m'**: `tmap['m'] = 1`

**After second pass**: `tmap = {'n': 1, 'a': 3, 'g': 1, 'r': 1, 'm': 1}`

### Comparison:

- `smap == tmap`?
- Both maps have: `{'a': 3, 'n': 1, 'g': 1, 'r': 1, 'm': 1}`
- **Return `true`** ✓

**Result**: `true` - The strings are anagrams.

### Alternative Example: `s = "rat"`, `t = "car"`

**First pass** (`s = "rat"`): `smap = {'r': 1, 'a': 1, 't': 1}`

**Second pass** (`t = "car"`): `tmap = {'c': 1, 'a': 1, 'r': 1}`

**Comparison**:
- `smap = {'r': 1, 'a': 1, 't': 1}`
- `tmap = {'c': 1, 'a': 1, 'r': 1}`
- Maps are different (`'t'` vs `'c'`)
- **Return `false`** ✗

**Result**: `false` - The strings are not anagrams.

### Edge Case: `s = ""`, `t = ""` (Both empty)

**First pass**: `smap = {}` (empty)

**Second pass**: `tmap = {}` (empty)

**Comparison**: `{} == {}` → **Return `true`** ✓

**Result**: `true` - Empty strings are considered anagrams of each other.

## Notes

- The hash map approach efficiently handles character frequency counting
- We use `unordered_map` for O(1) average-case insertion and lookup
- C++'s `unordered_map` supports direct comparison with `==`, which checks if both maps have the same key-value pairs
- The comparison `tmap == smap` automatically handles:
  - Different sizes (returns false)
  - Same keys with different values (returns false)
  - Same keys with same values (returns true)
- **Alternative approaches**:
  - **Sorting**: Sort both strings and compare - O(n log n + m log m) time, O(1) extra space
  - **Single hash map**: Count characters in `s`, then decrement for `t` - O(n + m) time, O(k) space
  - **Array-based counting**: Use an array of size 26 (for lowercase letters) - O(n + m) time, O(1) space
- The hash map approach is more general and works with any character set (not just lowercase letters)
- Edge cases handled: empty strings, strings of different lengths (automatically handled by map comparison), strings with same characters but different frequencies
