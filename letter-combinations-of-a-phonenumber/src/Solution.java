import java.util.*;

class Solution {
    public static Map<Integer, List<Character>> initKeyboard() {
        Map<Integer, List<Character>> keyboard = new HashMap<>();
        keyboard.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        keyboard.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        keyboard.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        keyboard.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        keyboard.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        keyboard.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        keyboard.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        keyboard.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        return keyboard;
    }

    public static List<String> findCombs(int ind, String currDigits, String digits,
                                  Map<Integer, List<Character>> keyBoard, List<String> combs) {
        if (ind == digits.length()) {
            return combs;
        }

        int currDigit = Integer.parseInt(String.valueOf(digits.charAt(ind)));
        List<Character> lets = keyBoard.get(currDigit);
        for (Character let: lets) {
            currDigits += let;
            findCombs(ind + 1, currDigits, digits, keyBoard, combs);
            if (currDigits.length() == digits.length()) {
                combs.add(currDigits);
            }
            currDigits = currDigits.substring(0, currDigits.length() - 1);
        }
        return combs;
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, List<Character>> keyboard = initKeyboard();
        return findCombs(0, "", digits, keyboard, new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}