import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class lab1_simTemplate {

    static final int NOT_FOUND = -1;
    static long compCount = 0; // global comparison counter
    static Random rand = new Random();

    // generate random values between min and max (inclusive)
    static int randomValue(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    // linear search on sorted array
    static int linearSearch(ArrayList<Integer> array, int searchValue) {
        int posIndex = NOT_FOUND;
        int i = 0;

        while (i < array.size() && searchValue >= array.get(i)) {
            compCount++;
            if (array.get(i) == searchValue) {
                posIndex = i;
                break;
            }
            i++;
        }
        return posIndex;
    }

    // linear search on unsorted array
    static int linearSearchUnsorted(ArrayList<Integer> array, int searchValue) {
        int posIndex = NOT_FOUND;
        int i = 0;

        while (i < array.size()) {
            compCount++;
            if (array.get(i) == searchValue) {
                posIndex = i;
                break;
            }
            i++;
        }
        return posIndex;
    }

    public static void main(String[] args) {

        final long SIMUL_SIZE = 10000;
        final long VECTOR_SIZE = 1000;
        final int MIN = 10;
        final int MAX = 1000;

        ArrayList<Integer> array = new ArrayList<>();
        double averageSteps;
        long totalSteps = 0;
        long hits = 0;
        long miss = 0;

        // main simulation loop
        for (long simulIndex = 0; simulIndex < SIMUL_SIZE; simulIndex++) {

            compCount = 0;
            array.clear();

            // fill array with random values
            for (long i = 0; i < VECTOR_SIZE; i++) {
                array.add(randomValue(MIN, MAX));
            }

            // sort array
            Collections.sort(array);

            // generate search value
            int searchValue = randomValue(MIN, MAX);

            // perform search
            int searchIndex = linearSearch(array, searchValue);

            if (searchIndex == NOT_FOUND)
                hits++;
            else
                miss++;

            totalSteps += compCount;
        }

        averageSteps = totalSteps / (double) SIMUL_SIZE;

        System.out.println("\nNumber of hits: " + hits);
        System.out.println("Number of misses: " + miss);
        System.out.println("Average steps is: " + averageSteps);
    }
}