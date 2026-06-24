class Solution {
    private int maxLength = 0;

    private void dfs(TreeNode node, int leftLen, int rightLen) {
        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, Math.max(leftLen, rightLen));

        // Move to left child
        dfs(node.left, rightLen + 1, 0);

        // Move to right child
        dfs(node.right, 0, leftLen + 1);
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return maxLength;
    }
}