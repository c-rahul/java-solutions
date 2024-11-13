package mycode;

import java.util.*;

public class Pairs {

    private boolean binarySearch(int[] arr, int numberToFind) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == numberToFind)
                return true;
            if (arr[mid] < numberToFind)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public int pairs(int k, int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        int result = 0;
        for (int i : arr) {
            int numberToSearch = i - k;
            if (binarySearch(arr, numberToSearch)) {
                result++;
            }
        }
        return result;
    }

    public int pairs(int k, List<Integer> list) {
        Collections.sort(list);
        int result = 0;
        for (int i : list) {
            int numberToSearch = i - k;
            if (Collections.binarySearch(list, numberToSearch) > -1) {
                result++;
            }
        }
        return result;
    }

    public int pairsWithSet(int k, List<Integer> list) {
        Collections.sort(list);
        int result = 0;
        Collections.reverse(list);
        Set<Integer> temp = new HashSet<>();
        for (int i : list) {
            if (temp.contains(i)) {
                result++;
            }
            temp.add(i - k);
        }
        return result;
    }

    public static void main(String[] args) {
        Pairs pairs = new Pairs();

        int[] arr = {1, 5, 3, 4, 2};
        System.out.println(pairs.pairs(2, arr));

        List<Integer> list = Arrays.asList(1, 5, 3, 4, 2);
        System.out.println(pairs.pairs(2, list));

        System.out.println(pairs.pairsWithSet(2, list));
    }
}
