/*
 * CS310 lab: Sorting Algorithms Simulation
 * @author Pranaya Khadgi Shahi
 * @date 2/19/2026
 * runs the four sorting algorithms with different input sizes and orderings
 * (random, ascending, descending) and reports average steps for deliverable 2
 */
import java.util.Random;

public class Simulation {

    private static final int NUM_RUNS = 1000;
    private static final int[] SIZES = {1000, 5000, 10000, 15000, 20000};

    private static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private static void fillRandom(int[] arr, int n, Random rng){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rng.nextInt(n + 1);
        }
    }

    // sort ascending for pre-sorting (lab said we can do this)
    private static void sortAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int t = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = t;
            }
        }
    }

    private static void sortDescending(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            if (maxIdx != i) {
                int t = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = t;
            }
        }
    }

    private static long runInsertion(int[] data) {
        int[] arr = copyArray(data);
        InsertionSort.insertionSort(arr);
        return InsertionSort.getStepCount();
    }

    private static long runSelection(int[] data){
        int[] arr = copyArray(data);
        SelectionSort.selectionSort(arr);
        return SelectionSort.getStepCount();
    }

    private static long runMerge(int[] data) {
        int[] arr = copyArray(data);
        MergeSort.mergeSort(arr);
        return MergeSort.getStepCount();
    }

    private static long runQuick(int[] data) {
        int[] arr = copyArray(data);
        QuickSort.quickSort(arr);
        return QuickSort.getStepCount();
    }

    public static void main(String[] args) {
        Random rng = new Random(42); // fixed seed so results are reproducable

        long[][][] table = new long[SIZES.length][3][4];

        // si = which input size we're on (0 to 4 for 1K, 5K, 10K, 15K, 20K). use it to index into table and SIZES
        for (int si = 0; si < SIZES.length; si++) {
            int n = SIZES[si];
            int[] arr = new int[n];

            long sumIns = 0, sumSel = 0, sumMerge = 0, sumQuick = 0;
            for (int run = 0; run < NUM_RUNS; run++) {
                fillRandom(arr, n, rng);
                sumIns += runInsertion(arr);
                fillRandom(arr, n, rng);
                sumSel += runSelection(arr);
                fillRandom(arr, n, rng);
                sumMerge += runMerge(arr);
                fillRandom(arr, n, rng);
                sumQuick += runQuick(arr);
            }
            table[si][0][0] = sumIns / NUM_RUNS;
            table[si][0][1] = sumSel / NUM_RUNS;
            table[si][0][2] = sumMerge / NUM_RUNS;
            table[si][0][3] = sumQuick / NUM_RUNS;

            fillRandom(arr, n, rng);
            sortAscending(arr);
            table[si][1][0] = runInsertion(arr);
            fillRandom(arr, n, rng);
            sortAscending(arr);
            table[si][1][1] = runSelection(arr);
            fillRandom(arr, n, rng);
            sortAscending(arr);
            table[si][1][2] = runMerge(arr);
            fillRandom(arr, n, rng);
            sortAscending(arr);
            table[si][1][3] = runQuick(arr);

            fillRandom(arr, n, rng);
            sortDescending(arr);
            table[si][2][0] = runInsertion(arr);
            fillRandom(arr, n, rng);
            sortDescending(arr);
            table[si][2][1] = runSelection(arr);
            fillRandom(arr, n, rng);
            sortDescending(arr);
            table[si][2][2] = runMerge(arr);
            fillRandom(arr, n, rng);
            sortDescending(arr);
            table[si][2][3] = runQuick(arr);
        }

        String[] sizeLabels = {"1K", "5K", "10K", "15K", "20K"};

        System.out.println("Simulation results (random = avg of " + NUM_RUNS + " runs)");
        for (int si = 0; si < SIZES.length; si++) {
            System.out.println(sizeLabels[si] + " asc " + table[si][1][0] + " " + table[si][1][1] + " " + table[si][1][2] + " " + table[si][1][3] +
                    " desc " + table[si][2][0] + " " + table[si][2][1] + " " + table[si][2][2] + " " + table[si][2][3] +
                    " rand " + table[si][0][0] + " " + table[si][0][1] + " " + table[si][0][2] + " " + table[si][0][3]);
        }
        System.out.println("(order per row: insertion selection merge quick)");
    }
}
