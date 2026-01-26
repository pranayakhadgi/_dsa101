# Big O Notation Cheatsheet

**Idea**: The asymtotic notation : Big O lets us answer the "How bad is it?" question by saying that it never gets any worse than a certain class of function. WHen the size of the input gets learge, the Big O is what counts. 

We're veery instered in performace of  algrithms and how the cost of an algorithm increases as teh size of the problem incrases. The cost can include the time eeqruited, space required and the network bandwidth.  B ig O is th edeciding factor in choosing a adata strcutreu or algorithm. We need to be cognizant of Big O when writing code, as even a ssingle line of code can raise the Big O of an application making the cde unusable.

**Common approach**:- If the input is small, *any algorithm* is okay (element # up until 100, 1000 is acceptable). 

Calculation is at the SiuuuuperNotee. 

## Time Complexity

### Common Complexities (Fastest to Slowest)
- **O(1)** - Constant time: Direct access, hash table lookup
- **O(log n)** - Logarithmic: Binary search, balanced tree operations
- **O(n)** - Linear: Single loop, array traversal
- **O(n log n)** - Linearithmic: Efficient sorting (merge sort, quick sort)
- **O(n²)** - Quadratic: Nested loops, bubble sort, selection sort
- **O(n³)** - Cubic: Triple nested loops
- **O(2ⁿ)** - Exponential: Recursive algorithms (Fibonacci naive)
- **O(n!)** - Factorial: Permutations, traveling salesman brute force

## Space Complexity

- **O(1)** - Constant space: No extra space needed
- **O(n)** - Linear space: Array, list storage
- **O(n²)** - Quadratic space: 2D matrix

## Rules

- **Drop constants**: O(2n) → O(n)
- **Drop lower terms**: O(n² + n) → O(n²)
- **Different terms for inputs**: O(a + b) or O(a × b)
- **Same terms for inputs**: O(n + n) → O(n)

## Common Operations

- **Array access**: O(1)
- **Array search**: O(n)
- **Array insertion/deletion**: O(n)
- **Hash table operations**: O(1) average, O(n) worst case
- **Binary search**: O(log n)
- **Sorting**: O(n log n) best, O(n²) worst

