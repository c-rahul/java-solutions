package mycode;

import java.util.List;
import java.util.Stack;

public class EqualStacks {
    /*
  h1[] = 3 2 1 1 1
  h2[] = 4 3 2
  h3[] = 1 1 4 1
   */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int maxHeight = 0;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        fillStack(st1, h1, st2, h2, st3, h3);

        while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {
            int st1Height = st1.peek();
            int st2Height = st2.peek();
            int st3Height = st3.peek();

            if (st1Height == st2Height && st2Height == st3Height) {
                maxHeight = st1.peek();
                break;
            }

            if (st1Height >= st2Height && st1Height >= st3Height) {
                st1.pop();
            }
            if (st2Height >= st1Height && st2Height >= st3Height) {
                st2.pop();
            }
            if (st3Height >= st2Height && st3Height >= st1Height) {
                st3.pop();
            }
        }
        return maxHeight;
    }

    private static void fillStack(Stack<Integer> st1, List<Integer> h1,
                                  Stack<Integer> st2, List<Integer> h2,
                                  Stack<Integer> st3, List<Integer> h3) {

        int st1Height = 0;
        int st2Height = 0;
        int st3Height = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            st1Height += h1.get(i);
            st1.push(st1Height);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            st2Height += h2.get(i);
            st2.push(st2Height);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            st3Height += h3.get(i);
            st3.push(st3Height);
        }
    }

    public static void main(String[] args) {
        List<Integer> h1 = List.of(3, 2, 1, 1, 1);
        List<Integer> h2 = List.of(4, 3, 2);
        List<Integer> h3 = List.of(1, 1, 4, 1);

        System.out.println(equalStacks(h1, h2, h3));
    }
}
