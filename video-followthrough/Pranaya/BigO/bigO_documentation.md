# Big O Notation Cheatsheet

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

