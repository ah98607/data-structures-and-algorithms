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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> nq = new LinkedList<TreeNode>();
        Queue<Integer> iq = new LinkedList<Integer>();
        nq.offer(root);
        iq.offer(0);
        int minX = 0;
        int maxX = 0;
        while (!nq.isEmpty()) {
            TreeNode temp = nq.poll();
            int x = iq.poll();
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<Integer>());
            }
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            map.get(x).add(temp.val);
            if (temp.left != null) {
                nq.offer(temp.left);
                iq.offer(x - 1);
                
            }
            if (temp.right != null) {
                nq.offer(temp.right);
                iq.offer(x + 1);
            }
        }
        for (int i = minX; i <= maxX; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}