# Algorithmic Paradigms

## Greedy Algorithms

Greedy algorithms make the **locally optimal choice** at each step with the hope of finding a global optimum. They are intuitive and often used for optimization problems where a local decision leads to a good enough or optimal global result.

- **Key Concept**: "Take what looks best right now."
- **Examples**: 
  - Shortest path (Dijkstra's Algorithm)
  - Minimum Spanning Tree (Prim's and Kruskal's)
  - Fractional Knapsack Problem
- **Characteristics**: Simple to implement and generally fast, but they do not always yield the globally optimal solution for every problem type.

![Greedy Algorithm Diagram](/home/pranaya/.gemini/antigravity/brain/93ad0b8e-4be1-4bdb-a42c-168ab11a3ec0/greedy_algorithm_diagram_1770832116670.png)

## Dynamic Programming (DP)

Dynamic Programming is a method for solving complex problems by breaking them down into simpler **overlapping subproblems**. It differs from Divide and Conquer because the subproblems in DP overlap. DP solves each subproblem only once and stores the result (a technique called **memoization** or **tabulation**) to avoid redundant computations.

- **Key Concept**: "Don't repeat yourself. Solve once, store, and reuse."
- **Examples**: 
  - Fibonacci Sequence calculation
  - 0/1 Knapsack Problem
  - Longest Common Subsequence
- **Why it works**: By trying out all possibilities in an efficient way (brute force optimized with storage), it guarantees finding the optimal solution.

![Dynamic Programming Diagram](/home/pranaya/.gemini/antigravity/brain/93ad0b8e-4be1-4bdb-a42c-168ab11a3ec0/dynamic_programming_diagram_1770832136032.png)

## Backtracking

Backtracking is an algorithmic technique for solving problems recursively by trying to build a solution incrementally, one piece at a time. It removes (or **backtracks** from) those solutions that fail to satisfy the constraints of the problem at any point in time.

- **Key Concept**: "Trial and error. If a path leads to a dead end, go back and try another."
- **Examples**: 
  - N-Queens problem
  - Sudoku solver
  - Maze pathfinding
- **Process**: It performs an exhaustive search (often Depth-First Search). It explores a branch of the solution tree as far as possible; if it hits a dead end, it retreats to the previous node to try a different branch.

![Backtracking Diagram](/home/pranaya/.gemini/antigravity/brain/93ad0b8e-4be1-4bdb-a42c-168ab11a3ec0/backtracking_diagram_1770832151091.png)