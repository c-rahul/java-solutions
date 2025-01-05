package mycode;

public class CountOccurrenceInSortedArray {

    private static int lowerBound(int[] arr, int target) {
        int res = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private static int upperBound(int[] arr, int target) {
        int res = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        int firstOccurrence = lowerBound(arr, target);
        int lastOccurrence = upperBound(arr, target) - 1;
        System.out.println("First Occurrence: " + firstOccurrence);
        System.out.println("Last Occurrence: " + lastOccurrence);
        System.out.println("Count: " + (lastOccurrence - firstOccurrence + 1));
    }
}
