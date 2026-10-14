import java.util.HashMap;
import java.util.Map;

class Solution {
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderIndexMap.get(rootVal);

        root.left = helper(preorder, inStart, inIndex - 1);
        root.right = helper(preorder, inIndex + 1, inEnd);

        return root;
    }
}