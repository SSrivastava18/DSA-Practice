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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderlist = new LinkedList<>();
        inorder(root, inorderlist);
        return inorderlist.get(k - 1);
        
    }
    private void inorder(TreeNode node, List<Integer> inorderlist) {
        if (node == null) {
            return;
        }
        inorder(node.left, inorderlist);     
        inorderlist.add(node.val);                 
        inorder(node.right, inorderlist); 
    }
}