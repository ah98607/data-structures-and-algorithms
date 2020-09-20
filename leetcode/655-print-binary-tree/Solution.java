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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (root == null) {
            return result;
        }
        
        // bfs
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<TreeNode>> nodes = new ArrayList<List<TreeNode>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            //System.out.println("number of nodes in this row: " + qSize);
            List<TreeNode> nList = new ArrayList<TreeNode>();
            boolean rowHasLeaft = false;
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = queue.poll();
                //System.out.print(temp.val + " ");
                if (temp == null) {
                    nList.add(null);
                }
                else {
                    nList.add(temp);
                }
                if (temp != null && temp.left != null) {
                    queue.offer(temp.left);
                    rowHasLeaft = true;
                }
                else {
                    queue.offer(null);
                }
                if (temp != null && temp.right != null) {
                    queue.offer(temp.right);
                    rowHasLeaft = true;
                }
                else {
                    queue.offer(null);
                }
            }
            // this row are all null
            // so the previous row is the last one
            nodes.add(nList);
            if (!rowHasLeaft) {
                break;
            }
        }
        //System.out.println("BFS finished. node.size() = " + nodes.size());
        //display(nodes);

        // print to result
        int rows = nodes.size();
        int rowWidth = (int) Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> sList = new ArrayList<String>();
            for (int j = 0; j < rowWidth; j++) {
                sList.add(new String());
            }
            result.add(sList);
        }
        recAdd(result, nodes, 0, 0, 0, rowWidth - 1);
        return result;
    }
    private void recAdd(List<List<String>> result, List<List<TreeNode>> nodes, int row, int nodePos, int l, int r) {
        if (l > r || row == nodes.size()) {
            return;
        }
        //System.out.println("recAdd row=" + row + " nodePos=" + nodePos + " l=" + l + " r=" + r);

        TreeNode temp = nodes.get(row).get(nodePos);
        if (temp != null) {
            int mid = l + (r - l) / 2;
            //System.out.println("For row " + row + ", write " + temp.val + " to location " + mid);
            result.get(row).set(mid, String.valueOf(temp.val));
            if (row == nodes.size() - 1) {
                return;
            }
            // for, the value of nodePos, see below graph
            /*
         0
    0         1
  0   1     2   3
 0 1 2 3   4 5 6 7
            */
            recAdd(result, nodes, row + 1, 2 * nodePos, l, mid - 1);
            recAdd(result, nodes, row + 1, 2 * nodePos + 1, mid + 1, r);
        }
    }
    private void display(List<List<TreeNode>> nodes) {
        System.out.println("nodes:");
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.get(i).size(); j++) {
                if (nodes.get(i).get(j) == null) {
                    System.out.print("# ");
                }
                else {
                    System.out.print(nodes.get(i).get(j).val + " ");
                }
            }
            System.out.println("");
        }
    }
}