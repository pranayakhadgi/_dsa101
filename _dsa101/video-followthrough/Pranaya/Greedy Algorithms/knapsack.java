package Pranaya.GreedyAlgorithms; // Note: Folder name "Greedy Algorithms" has a space, which is invalid for packages. Consider renaming folder.

import java.util.Arrays;
import java.util.Comparator;

// The knapsack problem has two versions: Fractional Knapsack and 0/1 Knapsack
// This implementation uses the Greedy approach for Fractional Knapsack
// Time Complexity: O(N log N) for sorting, Space Complexity: O(1)
public class knapsack {
    public static void main(String[] args) {
        int knapsackCapacity = 15;// this is the capcacity that the knapsack can take
        // Create items with (weight, value)
        ItemValue[] arr = {//later will get foreach loop to compare the values in terms of cost
                new ItemValue(2, 10), // value/weight = 5.0
                new ItemValue(3, 5), // value/weight = 1.66
                new ItemValue(5, 15), // value/weight = 3.0
                new ItemValue(7, 7), // value/weight = 1.0
                new ItemValue(1, 6), // value/weight = 6.0
                new ItemValue(4, 18), // value/weight = 4.5
                new ItemValue(1, 3) // value/weight = 3.0
        };

        double maxValue = getMaxValue(arr, knapsackCapacity);//gets called with List[] and capacity
        System.out.println("Maximum Value possible: " + maxValue);//the output displayed
    }

    public static class ItemValue {//the value gets determined in a different class
        double weight;//entered on main
        double value;//entered on main
        double cost; // value per unit weight ratio

        public ItemValue(double weight, double value) {
            this.weight = weight;
            this.value = value;
            this.cost = value / weight;
        }
    }

    public static double getMaxValue(ItemValue[] arr, int capacity) {
        // Sort items by cost (value/weight) in descending order
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1, ItemValue item2) {
                // Use Double.compare to handle precision correctly
                return Double.compare(item2.cost, item1.cost);
            }
        });

        double totalValue = 0d;
        int currentCapacity = capacity;

        for (ItemValue item : arr) {
            // If the item can be fully picked
            if (currentCapacity - item.weight >= 0) {
                currentCapacity -= item.weight;
                totalValue += item.value;
            } else {
                // If item can't be fully picked, pick fractional part
                double fraction = (double) currentCapacity / item.weight;
                totalValue += (item.value * fraction);
                currentCapacity = 0; // Knapsack is full
                break;
            }
        }

        return totalValue;
    }
}
