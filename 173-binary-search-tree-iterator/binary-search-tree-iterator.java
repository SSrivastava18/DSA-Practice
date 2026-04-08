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
class BSTIterator {
    private List<Integer> nodesSorted;
    private int index;

    public BSTIterator(TreeNode root) {
        // List to store the sorted nodes
        nodesSorted = new ArrayList<Integer>();
        index = -1;
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        nodesSorted.add(root.val);
        inOrderTraversal(root.right);
    }
    
    public int next() {
        return nodesSorted.get(++index);
    }
    
    public boolean hasNext() {
        return index + 1 < nodesSorted.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */