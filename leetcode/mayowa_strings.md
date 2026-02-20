# Documentation

---

## [Problem #26: Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

The first problem I worked on here is **#26 Remove Duplicates from Sorted Array**.

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in `nums` to be `k`. After removing duplicates, return `k`.

The first `k` elements of `nums` should contain the unique numbers in sorted order. The remaining elements beyond index `k - 1` can be ignored.

---

### Custom Judge

The judge will test your solution with the following code:

```java
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then the solution is accepted.

---

### Examples

**Example 1**

**Input**
```
nums = [1,1,2]
```

**Output**
```
k = 2, nums = [1,2,_]
```

**Explanation**  
The first two elements of `nums` should be `1` and `2`. Anything after index `k - 1` does not matter.

**Example 2**

**Input**
```
nums = [0,0,1,1,1,2,2,3,3,4]
```

**Output**
```
k = 5, nums = [0,1,2,3,4,_,_,_,_,_]
```

**Explanation**  
The first five elements of `nums` should be `0, 1, 2, 3, 4`. Anything after index `k - 1` does not matter.

---

### Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in non-decreasing order

---

### Current Solution (O(n))

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int write = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[write] = nums[i];
                write++;
            }
        }

        return write;
    }
}
```

This solution works because the array is already sorted, so duplicates always appear next to each other.

---

---

## [Problem #49: Group Anagrams](https://leetcode.com/problems/group-anagrams/)

The second problem I worked on here is **#49 Group Anagrams**.

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

---

### Examples

**Example 1**

**Input**
```
strs = ["eat","tea","tan","ate","nat","bat"]
```

**Output**
```
[["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Explanation**  
- No word is an anagram of `"bat"`.
- `"nat"` and `"tan"` are anagrams.
- `"ate"`, `"eat"`, and `"tea"` are anagrams.

**Example 2**

**Input**
```
strs = [""]
```

**Output**
```
[[""]]
```

**Example 3**

**Input**
```
strs = ["a"]
```

**Output**
```
[["a"]]
```

---

### Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters

---

### Current Solution (O(n * k log k))

Here `n` is the number of strings and `k` is the maximum length of a string.

**Time Complexity:** O(n * k log k)  
**Space Complexity:** O(n * k)

```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
```

This works because sorting the letters of an anagram always produces the same key.

---

---

## [Problem #239: Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

The third problem I worked on here is **#239 Sliding Window Maximum**.

You are given an array of integers `nums`. A sliding window of size `k` moves from left to right. Each time the window moves right by one position, you need to output the maximum number inside the window.

Return the array of maximum values from each window.

---

### Example 1

**Input**
```
nums = [1,3,-1,-3,5,3,6,7], k = 3
```

**Output**
```
[3,3,5,5,6,7]
```

**Explanation**
```
[1  3  -1] -3  5  3  6  7   -> 3
 1 [3  -1  -3] 5  3  6  7   -> 3
 1  3 [-1  -3  5] 3  6  7   -> 5
 1  3  -1 [-3  5  3] 6  7   -> 5
 1  3  -1  -3 [5  3  6] 7   -> 6
 1  3  -1  -3  5 [3  6  7]  -> 7
```

---

### Example 2

**Input**
```
nums = [1], k = 1
```

**Output**
```
[1]
```

---

### Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= nums.length`

---

### Solution (Deque, O(n))

**Time Complexity:** O(n)  
**Space Complexity:** O(k)

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int out = 0;

        for (int i = 0; i < n; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                result[out++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
```

This solution keeps the deque in decreasing order of values, so the front of the deque is always the maximum in the current window.
