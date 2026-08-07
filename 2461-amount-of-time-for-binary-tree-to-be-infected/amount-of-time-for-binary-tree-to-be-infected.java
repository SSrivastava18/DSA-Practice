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
    public int amountOfTime(TreeNode root, int start) {
        
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        // find target node
        TreeNode target = buildParentMap(root, null, parentMap, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false; 

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                    spread = true;
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                    spread = true;
                }

                // parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                    spread = true;
                }
            }

            if (spread) time++; 
        }

        return time;
    }

    public TreeNode buildParentMap(TreeNode node, TreeNode parent,
        HashMap<TreeNode, TreeNode> map, int start) {

        if (node == null) return null;

        map.put(node, parent);

        TreeNode res = null;
        if (node.val == start) res = node;

        TreeNode left = buildParentMap(node.left, node, map, start);
        TreeNode right = buildParentMap(node.right, node, map, start);

        if (left != null) return left;
        if (right != null) return right;
        return res;
    }
}