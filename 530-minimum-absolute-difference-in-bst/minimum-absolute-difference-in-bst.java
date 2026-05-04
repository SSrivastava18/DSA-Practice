/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inOrderValues = new ArrayList<>();
        
        inorderTraversal(root, inOrderValues);
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < inOrderValues.size(); i++) {
            int diff = inOrderValues.get(i) - inOrderValues.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode node, List<Integer> inOrderValues) {
        if (node == null) return;
        
        inorderTraversal(node.left, inOrderValues);
        
        inOrderValues.add(node.val);
        
        inorderTraversal(node.right, inOrderValues);
        
    }
}