package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/description/">Leet 14: Longest common prefix</a>
 */
public class LongestPrefix14 {
    public static void main(String[] args) {
        LongestPrefix14 lp14 = new LongestPrefix14();

        System.out.println(lp14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(lp14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(lp14.longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }

    public String longestCommonPrefix(final String[] strs) {
        final StringBuilder result = new StringBuilder();

        int currentVerifyingIndex = 0;
        int i = 0;
        while (true) {
            if(i >= strs.length) break;

            final String toCompare = strs[i];
            if (currentVerifyingIndex >= toCompare.length()) {
                i++;
                continue;
            }

            char currentChar = toCompare.charAt(currentVerifyingIndex);
            boolean shouldExit = false;

            // Loop to verify all other strings
            for (int j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }

                String toBeCompared = strs[j];
                if (currentVerifyingIndex == toBeCompared.length() || toBeCompared.charAt(currentVerifyingIndex) != currentChar) {
                    shouldExit = true;
                    break;
                }
            }

            if (shouldExit) break;
            result.append(currentChar);
            currentVerifyingIndex++;
        }

        return result.toString();
    }
}
