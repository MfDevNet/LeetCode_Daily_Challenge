import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Character, String> digitToLetters;

    public List<String> letterCombinations(String digits) {
        digitToLetters = createDigitToLettersMapping();
        List<String> combinations = new ArrayList<>();
        if (digits.length() > 0) {
            backtrack(combinations, digits, new StringBuilder(), 0);
        }
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, StringBuilder current, int index) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(combinations, digits, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    private Map<Character, String> createDigitToLettersMapping() {
        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
        return mapping;
    }
}