package mycode;

import java.util.Random;

public class BinarySearch {

    /**
     * Performs a binary search on a sorted array to find a specified number.
     *
     * @param arr the sorted array of integers to search in
     * @param numberToSearch the integer value to search for
     * @return true if the number is found in the array, false otherwise
     */
    static boolean binarySearch(int[] arr, int numberToSearch) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Find the mid index
            int mid = left + (right - left) / 2;
            // Check at mid index
            if (arr[mid] == numberToSearch)
                return true;
            // Update the terminal indices
            if (arr[mid] < numberToSearch) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int num = new Random().nextInt(20);
        System.out.println("num: " + num + " found: " + BinarySearch.binarySearch(new int[] {0, 1, 3, 5, 7, 8, 9, 11}, num));
    }
}
