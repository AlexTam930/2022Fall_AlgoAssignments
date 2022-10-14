package assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class verticalOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        verticalOrder(root);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        if(root == null){
            return res;
        }

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> colus = new LinkedList<Integer>();

        int min = 0;
        int max = 0;

        nodes.add(root);
        colus.add(0);

        while(!nodes.isEmpty()){
            TreeNode tn = nodes.poll();
            int col = colus.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(tn.val);
            min = Math.min(min, col);
            max = Math.max(max, col);

            if(tn.left != null){
                nodes.add(tn.left);
                colus.add(col-1);
            }
            if(tn.right != null){
                nodes.add(tn.right);
                colus.add(col+1);
            }
        }

        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }

        return res;
    }

}
