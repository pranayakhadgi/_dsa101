# Documentation

## Problem #977: Squares of a Sorted Array

The first problem that I solved was **#977 Squares of the Sorted Array**.

Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

---

### Example 1

**Input:**

```
nums = [-4, -1, 0, 3, 10]
```

**Output:**

```
[0, 1, 9, 16, 100]
```

**Explanation:**
After squaring, the array becomes `[16, 1, 0, 9, 100]`.
After sorting, it becomes `[0, 1, 9, 16, 100]`.

---

### Example 2

**Input:**

```
nums = [-7, -3, 2, 3, 11]
```

**Output:**

```
[4, 9, 9, 49, 121]
```

---

### Constraints

* `1 <= nums.length <= 10^4`
* `-10^4 <= nums[i] <= 10^4`
* `nums` is sorted in non-decreasing order

---

### Initial Approach

As a beginner DSA learner, I had a straightforward solution that started with a `for` loop to square each element, followed by sorting the array using `Arrays.sort()`.

The time complexity was **O(n log n)** due to the sorting step, and it ran in around **2 ms**.

---

### Current Solution (O(n log n))

My current solution correctly squares all elements in **O(n)** time but then sorts the array using `Arrays.sort()`, resulting in an overall **O(n log n)** time complexity. While this works within the problem constraints, it is not the most efficient approach.

```java
import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
```

---

### Optimal Approach (O(n) Two-Pointer Strategy)

The elite solution leverages the fact that the input array is already sorted. Instead of sorting again, it uses a two-pointer technique to build the result array from the back, achieving **O(n)** time complexity.

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }
        return result;
    }
}
```

This solution processes each element exactly once (**O(n)** time). The space complexity is **O(n)** for the result array, but eliminating sorting makes it significantly faster for large inputs. The key insight is that the largest square must come from either the leftmost (negative) or rightmost (positive) element.

---

## Problem #560: Subarray Sum Equals K

Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals `k`.

A subarray is a contiguous, non-empty sequence of elements within an array.

---

### Example 1

**Input:**

```
nums = [1, 1, 1], k = 2
```

**Output:**

```
2
```

---

### Example 2

**Input:**

```
nums = [1, 2, 3], k = 3
```

**Output:**

```
2
```

---

### Constraints

* `1 <= nums.length <= 2 * 10^4`
* `-1000 <= nums[i] <= 1000`
* `-10^7 <= k <= 10^7`

---

### Initial Thought Process (Brute Force)

For this problem, I initially had a similar algorithmic thought process to the previous problem. However, I ran into logical condition breakage where index handling became incorrect. To resolve this, I implemented a nested loop approach.

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
```

---

### Drawbacks of Brute Force

* **Time Complexity:** `O(n^2)`
* **Why it's inefficient:** Checks every possible subarray. For `n = 20,000`, this results in roughly **400 million operations**, which fails for large inputs.

---

### Elite Approach (O(n) Using HashMap)

The optimized solution uses a prefix sum combined with a `HashMap` to track previously seen sums. This allows counting valid subarrays in a single pass.

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case: empty subarray sum = 0

        for (int num : nums) {
            prefixSum += num;
            count += prefixMap.getOrDefault(prefixSum - k, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
```

This approach achieves **O(n)** time complexity and efficiently handles large input sizes by avoiding redundant subarray checks.

