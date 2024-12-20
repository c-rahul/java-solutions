package mycode;

public class Palindrome {

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();

        while (start < end) {
            while (start < end && !isAlphaNumeric(s.charAt(start))) {
                start++;
            }
            while (start < end && !isAlphaNumeric(s.charAt(end))) {
                end--;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric (char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(p.isPalindrome("race a car"));
        System.out.println(p.isPalindrome(" "));
    }
}
