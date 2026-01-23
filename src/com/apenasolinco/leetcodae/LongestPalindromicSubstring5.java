package com.apenasolinco.leetcodae;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        LongestPalindromicSubstring5 lps5 = new LongestPalindromicSubstring5();
        String s, result;

        // Expected result: "bab"
        s = "babad";
        System.out.println(lps5.longestPalindrome(s));

        // Expected result: "ccc"
        s = "ccc";
        System.out.println(lps5.longestPalindrome(s));

        // Expected result: "aaaa"
        s = "aaaa";
        System.out.println(lps5.longestPalindrome(s));

        // Expected result: "racecar"
        s = "racecar";
        System.out.println(lps5.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd palindrome
            int currentOddPalindrome = findLongestPalindromeLengthFrom(s, i, i);

            // even palindrome
            int currentEvenPalindrome = findLongestPalindromeLengthFrom(s, i, i + 1);

            int currentLength = Math.max(currentOddPalindrome, currentEvenPalindrome);
            int greatestLength = end - start + 1;
            if (currentLength > greatestLength) {
                start = i - (currentLength - 1) / 2;
                end = i + currentLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int findLongestPalindromeLengthFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right ++;
        }

        return right - left - 1;
    }
}
