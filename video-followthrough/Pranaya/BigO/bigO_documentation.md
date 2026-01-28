# Big O Notation Cheatsheet
## Asymptotic Notation | Worst Upper-bound (more focused)

**Idea**: The asymtotic notation : Big O lets us answer the "How bad is it?" question by saying that it never gets any worse than a certain class of function. WHen the size of the input gets learge, the Big O is what counts. 
Running time differs in the hardware it's being executed. 

We're veery interested in performace of algrithms and how the cost of an algorithm increases as teh size of the problem incrases. The cost can include the time eeqruited, space required and the network bandwidth.  Big O is th edeciding factor in choosing a adata strcutreu or algorithm. We need to be cognizant of Big O when writing code, as even a ssingle line of code can raise the Big O of an application making the cde unusable.

**Common approach**:- If the input is small, *any algorithm* is okay (element # up until 100, 1000 is acceptable). 
**Note**:- 10000nLogn and 2nLogn time are asympototiacally the same as teh order of growth is teh same nLogn

Calculation overview is at the SiuuuuperNotee. 

## Time Complexity

### Common Complexities (Fastest to Slowest)
- **O(1)** - Constant time: Direct access, hash table lookup. Doesn't depend on input size. 
- **O(log n)** - Logarithmic: Binary search, balanced tree operations
- **O(n)** - Linear: Single loop, array traversal. 
- **O(n log n)** - Linearithmic: Efficient sorting (merge sort, quick sort)
- **O(n²)** - Quadratic: Nested loops, bubble sort, selection sort
- **O(n³)** - Cubic: Triple nested loops
- **O(2ⁿ)** - Exponential: Recursive algorithms (Fibonacci naive)
- **O(n!)** - Factorial: Permutations, traveling salesman brute force

'''
//constant time implementation 
int sumElemetns(int x, int y){// x = 1, y = 1 (where 1 is not a value but the time constant)
int sum = x + y; 1 + 1 = 2 //but the big O reduces the multiple to 1
return sum;//thus O(2) still gives you O(1) <-- which is our time complexity!! (best case)

//linear time implementation

int size = records.size();

int index = 0;
while(index < size) {
if(records[index] == sValue (n time - assumption condition is true))
{ 
posiiton = index; break; //executed once, thus O(1)
} 
index ++; (index goes n linear times)
}

//quadratic time implementation (O(n^2))
//common case : nested loop - linear within linear = quadratic

int sumArray(int ** table, int row, int col)
{
int sum = 0; 
for(unsigned i =0; i<row; i++){ // **n times**
  for(unsigned j=0; j<col; j++) { // n * n-1 ----> **n^2 times** [n^2 + n, j goes n i times]
  sum = sum + table[i][j]; .. 1st iteration row 1 colum 2 - 3rd row samma 6 total iterations // thus row (n) * column (n) = **n^2 times**
  }
}
return sum;
}

what if row ---> 3000 (constant), col -----> 4000 (constant) . Not dependant on the input size, just a provided constant. Thus, it rather becomes O(1). 
'''

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

