Documentation

Problem #283: Move Zeroes

The first problem I worked on here is #283 Move Zeroes.
Given an integer array nums, the goal is to move all 0s to the end of the array while maintaining the relative order of the non-zero elements. The operation must be done in-place, without creating a copy of the array.
Example 1
Inputnums = [0,1,0,3,12]
Output[1,3,12,0,0]
Example 2
Inputnums = [0]
Output[0]
Constraints
* 1 <= nums.length <= 10^4
* -2^31 <= nums[i] <= 2^31 - 1

Initial Approach
As a beginner working through array manipulation problems, my first instinct was to scan the array and manually swap non-zero elements forward whenever I encountered them. This helped me understand how pointer movement works in-place without creating a new array.

Current Solution (O(n))
My current solution uses a single pass through the array and a pointer that tracks where the next non-zero element should be placed. Whenever a non-zero value is found, it is swapped forward.
Time Complexity: O(n)
Space Complexity: O(1)

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
This approach correctly preserves the order of non-zero elements and moves all zeros to the end using constant extra space.

Optimal Approach (O(n), Overwrite Strategy)
An alternative optimal approach avoids swaps entirely. Instead, it overwrites the array by first placing all non-zero values at the front, then filling the remaining positions with zeros.
Time Complexity: O(n)Space Complexity: O(1)

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
This method processes each element once and avoids unnecessary swaps, making it clean and efficient.


Problem #209: Minimum Size Subarray Sum

This problem focuses on finding the smallest length subarray whose sum is greater than or equal to a given target value.
If no such subarray exists, the function should return 0.

Examples
Example 1
Inputtarget = 7, nums = [2,3,1,2,4,3]
Output2
ExplanationThe subarray [4,3] has the minimum possible length.
Example 2
Inputtarget = 4, nums = [1,4,4]
Output1
Example 3
Inputtarget = 11, nums = [1,1,1,1,1,1,1,1]
Output0

Constraints
* 1 <= target <= 10^9
* 1 <= nums.length <= 10^5
* 1 <= nums[i] <= 10^4

Initial Thought Process
At first glance, it is tempting to check every possible subarray and calculate its sum. However, this brute-force approach quickly becomes inefficient as the input size grows.

Current Solution (Sliding Window, O(n))
The key observation is that all numbers in the array are positive. This allows the use of a sliding window technique that expands and shrinks dynamically while maintaining the sum.
Time Complexity: O(n)
Space Complexity: O(1)

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

Optimal Approach (O(n) Sliding Window)
This solution is already optimal.
* Each element is visited at most twice.
* The window expands to reach the target sum.
* The window shrinks to find the minimal length.
* No extra data structures are required.
Because all values are positive, once the sum exceeds the target, moving the left pointer forward is guaranteed to reduce the sum. This guarantees correctness and efficiency in a single pass.
