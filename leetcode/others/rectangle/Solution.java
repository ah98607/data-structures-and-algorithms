class Solution {
    public int maximalRectangle(char[][] matrix) {
        // change matrix to list
        List<Point> pList = new ArrayList<Point>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    pList.add(new Point(j, i));
                }
            }
        }
        // check all possible rectanges
        int maxArea = 0;
        for (int i = 0; i < pList.size(); i++) {
            Point currentPoint = pList.get(i);
            //System.out.println("Current point is " + currentPoint.x + "/" + currentPoint.y);
            List<Point> diagonalPoints = getDiagonalPointsOfRectangles(currentPoint, pList, matrix);
            //System.out.println("Number of valid diagonal points is " + diagonalPoints.size());
            for (Point p : diagonalPoints) {
                int tempArea = Math.abs(p.x - currentPoint.x) * Math.abs(p.y - currentPoint.y);
                maxArea = Math.max(maxArea, tempArea);
                System.out.println("Current rectangle has points [" + p.x + ", " + p.y + "] and [" + currentPoint.x + ", " + currentPoint.y + "]");
                System.out.println("Area is " + tempArea);
            }
        }
        return maxArea;
    }
    // returns diagonal points that can form valid rectangle with current point p
    private List<Point> getDiagonalPointsOfRectangles(Point p, List<Point> pList, char[][] matrix) {
        List<Point> diagonalPOintsOfRectangles = new ArrayList<Point>();
        for (Point temp : pList) {
            if (temp == p) {
                //System.out.println("Skipped the same point.");
                continue;
            }
            if (temp.x != p.x && temp.y != p.y && matrix[p.y][temp.x] == '1' && matrix[temp.y][p.x] == '1') {
                diagonalPOintsOfRectangles.add(temp);
                //System.out.println("Found a valid diagonal point: " + temp.x + "/" + temp.y);
            }
        }
        return diagonalPOintsOfRectangles;
    }
}
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}