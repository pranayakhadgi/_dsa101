

# Two Sum

## Problem
[LeetCode 1: Two Sum](https://leetcode.com/problems/two-sum/)

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

### Example
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

## Approach

This solution uses a **two-pointer technique** after sorting the array:

1. **Preserve original array**: Create a copy of the original array to maintain original indices
2. **Sort the array**: Sort the array to enable the two-pointer approach
3. **Two-pointer search**: Use two pointers (one at start, one at end) to find the two numbers that sum to target
4. **Map back to original indices**: After finding the values, search the original unsorted array to get the correct indices

### Algorithm Steps
1. Create a copy of `nums` to preserve original order
2. Sort the original `nums` array
3. Initialize two pointers: `p1` at the start (0) and `p2` at the end (len(nums) - 1)
4. While `p1 < p2`:
   - Calculate the sum of elements at `p1` and `p2`
   - If sum equals target, store the values and break
   - If sum is less than target, move `p1` forward (increase sum)
   - If sum is greater than target, move `p2` backward (decrease sum)
5. Search the original array to find the indices of the two values found
6. Return the indices

## Complexity Analysis

- **Time Complexity**: O(n log n)
  - Sorting: O(n log n)
  - Two-pointer search: O(n)
  - Finding indices: O(n)
  - Overall: O(n log n)

- **Space Complexity**: O(n)
  - Copy of original array: O(n)
  - Additional arrays for storing values and indices: O(1)
  - Overall: O(n)

## Solution

```python
class Solution(object):
    def twoSum(self, nums, target):
        unsortedNum = nums[:]
        num3 = []
        num4 = []
        nums.sort()
        
        p1 = 0
        p2 = len(nums) - 1
        
        while p1 < p2:
            sum = nums[p1] + nums[p2]
            if sum == target:
                num3.append(nums[p1])
                num3.append(nums[p2])
                break
            elif sum < target:
                p1 += 1
            else:
                p2 -= 1
        
        for i in range(len(unsortedNum)):
            if unsortedNum[i] == num3[0]:
                num4.append(i)
            elif unsortedNum[i] == num3[1]:
                num4.append(i)
        
        return num4
```

## Example Walkthrough

Given `nums = [3, 2, 4]` and `target = 6`:

1. **Preserve original**: `unsortedNum = [3, 2, 4]`
2. **Sort**: `nums = [2, 3, 4]`
3. **Two-pointer search**:
   - `p1 = 0`, `p2 = 2`: `nums[0] + nums[2] = 2 + 4 = 6` ✓ (found!)
   - Store values: `num3 = [2, 4]`
4. **Find indices in original**:
   - `unsortedNum[0] = 3` ≠ 2, ≠ 4
   - `unsortedNum[1] = 2` == 2 → `num4 = [1]`
   - `unsortedNum[2] = 4` == 4 → `num4 = [1, 2]`
5. **Return**: `[1, 2]`

## Notes

- This approach works well when you need to find the values first, then map back to indices
- Alternative approaches include using a hash map for O(n) time complexity
- The current solution handles duplicate values correctly by checking both values separately when mapping back to indices

---

# Product of Array Except Self

## Problem
[LeetCode 238: Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operator.

### Example
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Explanation: 
- answer[0] = 2 * 3 * 4 = 24
- answer[1] = 1 * 3 * 4 = 12
- answer[2] = 1 * 2 * 4 = 8
- answer[3] = 1 * 2 * 3 = 6
```

## Approach

This solution uses a **left and right product arrays** technique:

1. **Left products**: Calculate the product of all elements to the left of each index
2. **Right products**: Calculate the product of all elements to the right of each index
3. **Combine**: Multiply corresponding left and right products to get the final answer

The key insight is that for any index `i`, the product except self is:
- Product of all elements before `i` (left product)
- Multiplied by
- Product of all elements after `i` (right product)

### Algorithm Steps
1. Initialize three arrays:
   - `left`: Stores products of all elements to the left of each index
   - `right`: Stores products of all elements to the right of each index
   - `answer`: Final result array
2. Calculate left products:
   - `left[0] = 1` (no elements to the left)
   - For each index `i` from 1 to n-1: `left[i] = left[i-1] * nums[i-1]`
3. Calculate right products:
   - `right[n-1] = 1` (no elements to the right)
   - For each index `i` from n-2 down to 0: `right[i] = right[i+1] * nums[i+1]`
4. Combine left and right products:
   - For each index `i`: `answer[i] = left[i] * right[i]`
5. Return the answer array

## Complexity Analysis

- **Time Complexity**: O(n)
  - First pass: Calculate left products - O(n)
  - Second pass: Calculate right products - O(n)
  - Third pass: Combine left and right - O(n)
  - Overall: O(n)

- **Space Complexity**: O(n)
  - `left` array: O(n)
  - `right` array: O(n)
  - `answer` array: O(n)
  - Overall: O(n)
  - Note: Can be optimized to O(1) extra space by using the answer array for one of the passes

## Solution

```cpp
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> left(n, 1);
        vector<int> right(n, 1);
        vector<int> answer(n);
        
        // Calculate left products
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        // Calculate right products
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        // Combine left and right products
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }
        
        return answer;
    }
};
```

## Example Walkthrough

Given `nums = [1, 2, 3, 4]`:

1. **Initialize arrays**:
   - `left = [1, 1, 1, 1]`
   - `right = [1, 1, 1, 1]`

2. **Calculate left products**:
   - `left[0] = 1` (no elements to the left)
   - `left[1] = left[0] * nums[0] = 1 * 1 = 1`
   - `left[2] = left[1] * nums[1] = 1 * 2 = 2`
   - `left[3] = left[2] * nums[2] = 2 * 3 = 6`
   - `left = [1, 1, 2, 6]`

3. **Calculate right products**:
   - `right[3] = 1` (no elements to the right)
   - `right[2] = right[3] * nums[3] = 1 * 4 = 4`
   - `right[1] = right[2] * nums[2] = 4 * 3 = 12`
   - `right[0] = right[1] * nums[1] = 12 * 2 = 24`
   - `right = [24, 12, 4, 1]`

4. **Combine products**:
   - `answer[0] = left[0] * right[0] = 1 * 24 = 24`
   - `answer[1] = left[1] * right[1] = 1 * 12 = 12`
   - `answer[2] = left[2] * right[2] = 2 * 4 = 8`
   - `answer[3] = left[3] * right[3] = 6 * 1 = 6`
   - `answer = [24, 12, 8, 6]`

## Notes

- This approach avoids division, which is important when dealing with zero values
- The solution runs in O(n) time with O(n) space
- Can be optimized to O(1) extra space (excluding output array) by using the answer array to store left products, then calculating right products on the fly
- Handles edge cases like arrays with zeros correctly