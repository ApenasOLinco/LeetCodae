package com.apenasolinco.leetcodae;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Leet 66: Plus One</a>
 */
public class PlusOne0066 {
    public static void main(String[] args) {
        final PlusOne0066 po66 = new PlusOne0066();

        // Expected result: [ 1, 2, 4 ]
        printResult(po66.plusOne(new int[]{1, 2, 3}));

        // Expected result: [ 1, 0 ]
        printResult(po66.plusOne(new int[]{9}));
    }

    private static void printResult(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];

        boolean carry = true;
        int i = digits.length - 1;
        while (i >= 0) {
            if (carry) {
                result[i + 1] = (digits[i] + 1) % 10;
                carry = result[i + 1] == 0;
            } else result[i + 1] = digits[i];

            i--;
        }

        if (carry) {
            result[0] = 1;
            return result;
        }

        return Arrays.copyOfRange(result, 1, result.length);
    }
}
