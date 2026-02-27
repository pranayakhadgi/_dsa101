public class sumOfSubsets {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 10;
        sumOfSubsets sos = new sumOfSubsets();
        sos.displaySumSet(array, sum);
    }

    public void displaySumSetRecursive(int[] array, String sumElems, final int target, int sumSoFar, int index) {
        if (sumSoFar == target) {
            System.out.println(sumElems.trim());
            return;
        }

        if (index >= array.length || sumSoFar > target) return;

        // Uses the current value in the sum set
        displaySumSetRecursive(array, sumElems + " " + array[index], target, sumSoFar + array[index], index + 1);

        // Does not use the current value
        displaySumSetRecursive(array, sumElems, target, sumSoFar, index + 1);
    }

    public void displaySumSet(int[] array, final int sum) {
        displaySumSetRecursive(array, "", sum, 0, 0);
    }
}

/*
 * Tracing the algorithm
 * 
 * 
 */