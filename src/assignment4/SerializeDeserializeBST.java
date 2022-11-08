package assignment4;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeDeserializeBST {
    private final String SEPARATOR = "#$";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderTree(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> que = new LinkedList<String>();
        que.addAll(Arrays.asList(data.split(",")));
        return deserial(que);
    }

    public void preorderTree(TreeNode root, StringBuilder stringBuilder){
        if(root == null){
            stringBuilder.append(SEPARATOR).append(",");
            return;
        }
        
        stringBuilder.append(root.val).append(",");
        preorderTree(root.left, stringBuilder);
        preorderTree(root.right, stringBuilder);
    }

    public TreeNode deserial(LinkedList<String> que){
        String str = que.pollFirst();
        if(str.equals(SEPARATOR)){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = deserial(que);
        root.right = deserial(que);
        
        return root;
    }
    
}
