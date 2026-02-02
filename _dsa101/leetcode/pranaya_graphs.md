# Island Perimeter Solution

## The Problem
Grid of 0s (water) and 1s (land). One island, no lakes. Find its perimeter.

## The Insight
Instead of "subtract shared edges," think: **"Count each time we hit water or grid boundary."**

Every time our search moves from land to water (or off the grid), that's +1 to perimeter.

## DFS Solution Explained
```java
private int dfs(int i, int j) {
    // If we're out of bounds or on water: FOUND PERIMETER!
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) {
        return 1;
    }
    
    // If we've been here before: skip
    if (visited[i][j]) return 0;
    
    // Mark visited
    visited[i][j] = true;
    
    // Explore all 4 directions, sum up what they find
    return dfs(i+1, j) + dfs(i-1, j) + dfs(i, j+1) + dfs(i, j-1);
}
```

## How It Works
1. Start at first land cell found
2. Recursively explore neighbors
3. Each step to water/boundary = +1 perimeter
4. Visited check prevents infinite loops

## Why It's Clean
- No messy boundary checks in loops
- Recursion handles exploration naturally
- Base cases do the counting automatically
- Works for any island shape/size

## Complexity
- Time: O(R×C) - visit each cell once
- Space: O(R×C) - visited array + recursion stack

## What I Learned
Reframe counting problems: "What events create what I'm counting?" Here: land→water transitions = perimeter edges.

Simple DFS can solve more than just connectivity—it can count things elegantly.