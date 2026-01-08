package com.apenasolinco.leetcodae;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/description/">13. Roman to Integer</a>
 */
public class RomanNums13 {
    public static void main(String[] args) {
        final RomanNums13 rn13 = new RomanNums13();
        System.out.println(rn13.romanToInt("I"));
        System.out.println(rn13.romanToInt("V"));
        System.out.println(rn13.romanToInt("X"));
        System.out.println(rn13.romanToInt("C"));
        System.out.println(rn13.romanToInt("IV"));
        System.out.println(rn13.romanToInt("XCIII"));
        System.out.println(rn13.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;

        final HashMap<String, Integer> romanValues = getRomanValues();

        for (int i = 0; i < chars.length;) {
            // Compound numbers (Subtraction)
            String current = String.valueOf(Arrays.copyOfRange(chars, i, i + 2));
            if (romanValues.containsKey(current)) {
                result += romanValues.get(current);
                i += 2;
                continue;
            }

            // Simple numbers
            current = String.valueOf(chars[i]);
            result += romanValues.get(current);
            i ++;
        }

        return result;
    }

    private static HashMap<String, Integer> getRomanValues() {
        final HashMap<String, Integer> romanValues = new HashMap<>(13);
        romanValues.put("I", 1);
        romanValues.put("IV", 4);
        romanValues.put("IX", 9);
        romanValues.put("V", 5);
        romanValues.put("X", 10);
        romanValues.put("XL", 40);
        romanValues.put("XC", 90);
        romanValues.put("L", 50);
        romanValues.put("C", 100);
        romanValues.put("CD", 400);
        romanValues.put("CM", 900);
        romanValues.put("D", 500);
        romanValues.put("M", 1000);
        return romanValues;
    }
}
