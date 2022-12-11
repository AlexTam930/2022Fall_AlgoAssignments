package finalterm;

public class ObstacleGrid {

    public static void main(String[] args) {
        int[][] test1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] test2 = {{0, 1}, {0, 0}};

        System.out.println("The number of the paths is " + obstacleGrid(test2));
    }

    /**
     * The method apply dynamic path to traverse the matrix and mark down values it have traversed.
     * The complexity of the method is O(n), as it travers the matrix one time and not repeatedly.
     * @param grid
     * @return
     */
    private static int obstacleGrid(int[][] grid) {
        int[][] marks = new int[grid.length + 1][grid[0].length + 1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { // a obstacle
                    marks[i + 1][j + 1] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        marks[i + 1][j + 1] = 1;
                    } else {
                        marks[i + 1][j + 1] = marks[i][j + 1] + marks[i + 1][j];
                    }
                }
            }
        }

        return marks[marks.length - 1][marks[0].length - 1];
    }

}
