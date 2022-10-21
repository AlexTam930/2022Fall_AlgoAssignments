package assignment3;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        printArray(result);
    }

    private static void printArray(List<String> array) {
        System.out.print("[");
        for (String i : array) {
            System.out.print(i + ",");
        }
        System.out.print("]");
    }

    private static List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<String>();
        processAString(resultList,"",0,0,n);

        return resultList;
    }

    private static void processAString(List<String> list, String str, int left, int right, int num) {
        if (num <= 0) {
            list.add(new String());
            return;
        }

        if(str.length() == num * 2) {
            list.add(str);
        }

        if(left < num) {
            processAString(list, str + "(", left + 1, right, num);
        }

        if(left > right) {
            processAString(list, str + ")", left, right + 1, num);
        }
    }

}
