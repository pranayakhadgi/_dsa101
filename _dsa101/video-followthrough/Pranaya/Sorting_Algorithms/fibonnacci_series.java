public class fibonnacci_series {

    // Time Complexity: O(2^n) (Exponential)
    // Detailed Analysis:
    // The complexity is technically O(1.618^n), based on the Golden Ratio, which is
    // exponential.
    // Each call branches into two more calls (fib(n-1) and fib(n-2)), leading to a
    // massive
    // duplication of work.
    // For example, fib(6) recalculates the entire tree for fib(4) multiple times.
    //
    // Recurrence Relation: T(n) = T(n-1) + T(n-2) + C
    // This approach is computationally expensive for large 'n'.

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}