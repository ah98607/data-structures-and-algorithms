class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        // init indegree
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
        }
        // bfs
        Queue<Integer> q = new LinkedList<Integer>();
        // 1. start with courses that are dependency of others
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        // 2. keep removing courses
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (temp == prerequisites[i][0]) {
                    indegree[prerequisites[i][1]]--;
                    if (indegree[prerequisites[i][1]] == 0) {
                        q.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        // final check
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}