package finalterm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinRemoveParentheses {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
//        String s1 = "a)b(c)d";
//        String s2 = "))((";
        System.out.println("print out result: " + minRemoveParentheses(s));
    }

    /**
     * Minimum remove brackets, and return the correct one.
     * The complexity of the method is O(n), as it traverse the string once.
     * @param string
     * @return
     */
    private static String minRemoveParentheses(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }

        List<Integer> leftBrackets = new ArrayList<>();
        List<Integer> rightBrackets = new ArrayList<>();


        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                leftBrackets.add(i);
            } else if (ch == ')') {
                if (leftBrackets.size() > 0) {
                    leftBrackets.remove(leftBrackets.size() - 1);
                } else {
                    rightBrackets.add(i);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        set.addAll(leftBrackets);
        set.addAll(rightBrackets);

        StringBuilder sbd = new StringBuilder();

        for (int j = 0; j < string.length(); j++) {
            if (!set.contains(j)) {
                sbd.append(string.charAt(j));
            }
        }

        if (sbd.length() > 0) {
            return sbd.toString();
        } else {
            return "";
        }

    }

}
