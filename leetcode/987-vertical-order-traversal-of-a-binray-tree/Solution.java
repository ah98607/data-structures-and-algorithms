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
class Elem {
    int y;
    int val;
    public Elem(int y, int val) {
        this.y = y;
        this.val = val;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer, List<Elem>> map = new HashMap<Integer, List<Elem>>();
        Queue<TreeNode> nq = new LinkedList<TreeNode>();
        Queue<Integer> iq = new LinkedList<Integer>();
        nq.offer(root);
        iq.offer(0);
        int minx = 0;
        int maxx = 0;
        int y = 0;
        while (!nq.isEmpty()) {
            int qSize = nq.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = nq.poll();
                int x = iq.poll();
                minx = Math.min(minx, x);
                maxx = Math.max(maxx, x);
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<Elem>());
                }
                map.get(x).add(new Elem(y, temp.val));
                if (temp.left != null) {
                    nq.offer(temp.left);
                    iq.offer(x - 1);
                }
                if (temp.right != null) {
                    nq.offer(temp.right);
                    iq.offer(x + 1);
                }
            }
            y++;
        }
        for (int i = minx; i <= maxx; i++) {
            Collections.sort(map.get(i), new Comparator<Elem>() {
                public int compare(Elem e1, Elem e2) {
                    if (e1.y != e2.y) {
                        return e1.y - e2.y;
                    }
                    return e1.val - e2.val;
                }
            });
            List<Integer> iList = new ArrayList<Integer>();
            for (int j = 0; j < map.get(i).size(); j++) {
                iList.add(map.get(i).get(j).val);
            }
            res.add(iList);
        }
        return res;
    }
}