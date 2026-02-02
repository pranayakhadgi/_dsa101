# Documentation

---

## [Problem #283: Move Zeroes](https://leetcode.com/problems/move-zeroes/)

The first problem I worked on here is **#283 Move Zeroes**.

Given an integer array `nums`, the goal is to move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.  
The operation must be done **in-place**, without creating a copy of the array.

---

### Example 1

**Input**
```
nums = [0,1,0,3,12]
```

**Output**
```
[1,3,12,0,0]
```

### Example 2

**Input**
```
nums = [0]
```

**Output**
```
[0]
```

---

### Constraints

- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

### Initial Approach

As a beginner working through array manipulation problems, my first instinct was to scan the array and manually swap non-zero elements forward whenever I encountered them. This helped me understand how pointer movement works in-place without creating a new array.

---

### Current Solution (O(n))

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int value = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temporaryArr = nums[value];
                nums[value] = nums[i];
                nums[i] = temporaryArr;
                value++;
            }
        }
    }
}
```

This approach correctly preserves the order of non-zero elements and moves all zeros to the end using constant extra space.

---

### Optimal Approach (O(n), Overwrite Strategy)

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[write++] = nums[i];
            }
        }

        while (write < nums.length) {
            nums[write++] = 0;
        }
    }
}
```

This approach avoids swaps entirely by overwriting values and is equally optimal.

---

---

## [Problem #209: Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

The second problem I worked on here is **#209 Minimum Size Subarray Sum**.

Given an array of **positive integers** `nums` and a positive integer `target`, the goal is to return the minimal length of a subarray whose sum is **greater than or equal to target**.  
If there is no such subarray, return `0`.

---

### Example 1

**Input**
```
target = 7, nums = [2,3,1,2,4,3]
```

**Output**
```
2
```

**Explanation**  
The subarray `[4,3]` has the minimal length under the problem constraint.

---

### Example 2

**Input**
```
target = 4, nums = [1,4,4]
```

**Output**
```
1
```

---

### Example 3

**Input**
```
target = 11, nums = [1,1,1,1,1,1,1,1]
```

**Output**
```
0
```

---

### Constraints

- `1 <= target <= 10^9`
- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`

---

### Initial Thought Process

My first thought was to try all subarrays and compute their sums, but that quickly becomes too slow for large arrays. Since every number is positive, I realized I could use a sliding window that grows and shrinks while tracking the sum.

---

### Current Solution (O(n), Sliding Window)

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int best = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                best = Math.min(best, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return best == Integer.MAX_VALUE ? 0 : best;
    }
}
```

This solution works because all values are positive, so expanding the window increases the sum and shrinking it decreases the sum. Each index moves forward at most once.

---

### Optimal Approach (O(n), Sliding Window)

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int best = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                best = Math.min(best, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return best == Integer.MAX_VALUE ? 0 : best;
    }
}
```

This is already the optimal approach because it solves the problem in one pass with constant extra space. Brute force would take O(n^2), which is too slow for large inputs.
