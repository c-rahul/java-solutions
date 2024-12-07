package mycode;

import java.util.Arrays;

public class SherlockValidString {
    public static void main(String[] args) {
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abbccddeeffgg"));
    }

    private static String isValid(String s) {
        if (s.length() == 1) {
            return "YES";
        }
        int[] freqMap = new int[26];

        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }
        Arrays.sort(freqMap);

        int i = 0;
        // removing 0s
        for (; i < freqMap.length; i++) {
            if (freqMap[i] != 0) {
                break;
            }
        }
        int freq = freqMap[i];
        // all index have the same frequency
        if (freq == freqMap[freqMap.length - 1]) {
            return "YES";
        }
        // all index till last but one have the same frequency and last index has 1 more
        if (freq == freqMap[freqMap.length - 2] && freqMap[freqMap.length - 1] - freqMap[freqMap.length - 2] == 1) {
            return "YES";
        }
        // there is a character with 1 frequency at the beginning and remaining all characters have same frequency
        if (i < freqMap.length - 1 && freq == 1 && freqMap[i + 1] == freqMap[freqMap.length - 1]) {
            return "YES";
        }
        return "NO";
    }
}
