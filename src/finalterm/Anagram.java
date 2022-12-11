package finalterm;

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);

        printList(res);
    }

    /**
     * Sort out each String and find out the common ones.
     * The complexity of the method is O(n).
     * @param strs
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return null;
        } else {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for(String str : strs) {
                char[] arr = str.toCharArray();

                Arrays.sort(arr);   // sort the array and switch to a key of the map for storing Anagrams.

                String key = String.valueOf(arr);

                if(!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(str);  // add String to target list which has same key consisting of same letters.
            }

            List<List<String>> res = new ArrayList<List<String>>(map.values());
            return res;
        }
    }

    private static void printList(List<List<String>> list) {
        System.out.print("[");

        for (List<String> item : list) {
            for (int i = 0; i < item.size(); i++) {
                if (i == 0) {
                    System.out.print("[");
                }
                System.out.print(item.get(i) + ", ");
                if (i == item.size() - 1) {
                    System.out.print("], ");
                }
            }
        }

        System.out.print("]");
    }

}
