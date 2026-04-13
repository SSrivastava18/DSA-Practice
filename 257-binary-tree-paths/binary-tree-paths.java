class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            constructPaths(root, "", res);
        }
        return res;
    }

    private void constructPaths(TreeNode node, String path, List<String> res) {
        if (node != null) {
            path += node.val;  
            if (node.left == null && node.right == null) {
                res.add(path);  
            } else {
                path += "->"; 
                constructPaths(node.left, path, res);
                constructPaths(node.right, path, res);
            }
        }
    }
}