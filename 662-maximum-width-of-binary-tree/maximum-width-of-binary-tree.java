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

    static class Pair {
        TreeNode node;
        long idx; 

        public Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            long firstIdx = q.peekFirst().idx;
            long lastIdx = q.peekLast().idx;

            maxWidth = Math.max(maxWidth, (int)(lastIdx - firstIdx + 1));

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;

                long currIdx = curr.idx - firstIdx;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * currIdx + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * currIdx + 2));
                }
            }
        }

        return maxWidth;
    }
}