class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return new int[0][0];
        }
        int colorToReplace = image[sr][sc];
        if (newColor == colorToReplace) {
            return image; // avoid replacing one color with the same color
        }
        recFind(image, sr, sc, colorToReplace, newColor);
        return image;
    }
    private void recFind(int[][] image, int sr, int sc, int colorToReplace, int newColor) {
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == colorToReplace) {
            recFind(image, sr - 1, sc, colorToReplace, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == colorToReplace) {
            recFind(image, sr + 1, sc, colorToReplace, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == colorToReplace) {
            recFind(image, sr, sc - 1, colorToReplace, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == colorToReplace) {
            recFind(image, sr, sc + 1, colorToReplace, newColor);
        }
    }
}