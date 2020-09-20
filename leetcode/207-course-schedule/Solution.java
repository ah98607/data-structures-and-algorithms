class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Set<Integer> courses = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(i);
        }
        Map<Integer, Set<Integer>> dep = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!dep.containsKey(prerequisites[i][0])) {
                dep.put(prerequisites[i][0], new HashSet<Integer>());
            }
            dep.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        while (!courses.isEmpty()) {
            int courseToRemove = -1;
            for (Integer course : courses) {
                boolean hasDep = false;
                if (dep.containsKey(course)) {
                    for (Integer depCourse : dep.get(course)) {
                        if (courses.contains(depCourse)) {
                            hasDep = true;
                            break;
                        }
                    }
                }
                if (!hasDep) {
                    courseToRemove = course;
                    break;
                }
            }
            if (courseToRemove == -1) {
                return false;
            }
            courses.remove(courseToRemove);
        }
        return true;
    }
}