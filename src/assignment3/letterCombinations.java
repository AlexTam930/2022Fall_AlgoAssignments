package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations {

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");

        printArray(result);
    }

    private static void printArray(List<String> array) {
        System.out.print("[");
        for (String i : array) {
            System.out.print(i + ",");
        }
        System.out.print("]");
    }

    private static  List<String> res = new ArrayList<>();
    private static HashMap<Character, String> map = new HashMap<>();
    private static StringBuilder stb = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        recurse(digits, 0);

        return res;
    }

    public static void recurse(String digits, int index) {
        if(index >= digits.length()) {
            res.add(new String(stb)); // length of digits equal to the given string's, it is added into res.
            return;
        }

        char c = digits.charAt(index);
        String s = map.get(c);
        for(int j = 0; j < s.length(); j++) {
            stb.append(s.charAt(j));
            recurse(digits, index + 1);
            stb.setLength(stb.length() - 1);
        }
    }

}
