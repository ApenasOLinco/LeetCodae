package com.apenasolinco.leetcodae;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/description/">Leet 15: Valid Parentheses</a>
 */
public class ValidParentheses15 {
    public static void main(String[] args) {
        ValidParentheses15 vp15 = new ValidParentheses15();

        System.out.println(vp15.isValid("()"));
        System.out.println(vp15.isValid("()[]{}"));
        System.out.println(vp15.isValid("(]"));
        System.out.println(vp15.isValid("([])"));
        System.out.println(vp15.isValid("([)]"));
    }

    public boolean isValid(String s) {
        final LinkedList<Character> closingBrackets = new LinkedList<>();
        final HashMap<Character, Character> possibleBrackets = getPossibleBrackets();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (possibleBrackets.containsKey(currentChar)) {
                closingBrackets.addFirst(possibleBrackets.get(currentChar));
                continue;
            }

            if (closingBrackets.isEmpty() || currentChar != closingBrackets.pop()) return false;
        }

        return closingBrackets.isEmpty();
    }

    private static HashMap<Character, Character> getPossibleBrackets() {
        final HashMap<Character, Character> possibleBrackets = new HashMap<>(3);
        possibleBrackets.put('(', ')');
        possibleBrackets.put('{', '}');
        possibleBrackets.put('[', ']');

        return possibleBrackets;
    }
}
