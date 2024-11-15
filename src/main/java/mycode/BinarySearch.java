package mycode;

public class BinarySearch {

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

}
