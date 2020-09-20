/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        Map<TreeNode, Set<TreeNode>> adj = new HashMap<TreeNode, Set<TreeNode>>();
        recFind(root, adj);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        q.offer(target);
        vis.add(target);
        while (!q.isEmpty() && K >= 0) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.poll();
                if (K == 0) {
                    res.add(temp.val);
                }
                for (TreeNode neighbor : adj.get(temp)) { // no need to check containsKey
                    if (!vis.contains(neighbor)) {
                        q.offer(neighbor);
                        vis.add(neighbor);
                    }
                }
            }
            K--;
        }
        return res;
    }
    private void recFind(TreeNode node, Map<TreeNode, Set<TreeNode>> adj) {
        if (!adj.containsKey(node)) {
            adj.put(node, new HashSet<TreeNode>());
        }
        if (node.left != null) {
            if (!adj.containsKey(node.left)) {
                adj.put(node.left, new HashSet<TreeNode>());
            }
            adj.get(node).add(node.left);
            adj.get(node.left).add(node);
            recFind(node.left, adj);
        }
        if (node.right != null) {
            if (!adj.containsKey(node.right)) {
                adj.put(node.right, new HashSet<TreeNode>());
            }
            adj.get(node).add(node.right);
            adj.get(node.right).add(node);
            recFind(node.right, adj);
        }
    }
}