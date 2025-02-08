package DSA.Sorting;

import java.util.Arrays;

public class BubbleSortSimplerVersion {
    // This version contains more understandable namings like secondLastIdx and alreadySorted,
    // so this version is easier to understand.
    // It also contains a test function.
    public static void bubbleSort(int[] arr){
        int secondLastIdx = arr.length - 2;
        boolean alreadySorted;

        for(int i = 0; i <= secondLastIdx; i++) {

            alreadySorted = true; // assume it's sorted already

            for (int j = 0; j <= secondLastIdx - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    // When it's false it doesn't necessarily mean it's not sorted;
                    // it's just for escape the following if check.
                    alreadySorted = false;
                }
            }

            if (alreadySorted) break;
        }
    }

    public static void printArr(int[] arr){
        System.out.println("Here's the entire array: ");
        for(int num : arr)
            System.out.print(num + " ");

        System.out.println();
    }

    // Method to check if the array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Method to run tests
    public static void runTest(int[] arr, String testName) {
        System.out.println("Running test: " + testName);
        System.out.println("Original array: " + Arrays.toString(arr));

        // Make a copy to compare later
        int[] expected = arr.clone();
        Arrays.sort(expected); // Correctly sorted array

        // Run Bubble Sort
        bubbleSort(arr);

        System.out.println("Sorted array:   " + Arrays.toString(arr));

        // Check if it matches the expected output
        if (Arrays.equals(arr, expected) && isSorted(arr)) {
            System.out.println("✅ " + testName + " passed!\n");
        } else {
            System.out.println("❌ " + testName + " failed!\n");
        }
    }

    public static void main (String[] args){
//        int[] arr = {1, 10, 3, 8, 6, 5, 9};
//        printArr(arr);
//        System.out.println();
//        bubbleSort(arr);
//        printArr(arr);

        // Test cases
        runTest(new int[]{}, "Empty Array");
        runTest(new int[]{5}, "Single Element");
        runTest(new int[]{1, 2, 3, 4, 5}, "Already Sorted");
        runTest(new int[]{5, 4, 3, 2, 1}, "Reverse Sorted");
        runTest(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}, "Array with Duplicates");
        runTest(new int[]{10, -2, 4, 0, 8, 7, 1}, "Random Unsorted Array");
    }
}
