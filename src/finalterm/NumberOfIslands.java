package finalterm;

public class NumberOfIslands {


    public static void main(String[] args) {
        String[][] grid1 = {
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };

        String[][] grid2 = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        System.out.println("The number of islands is " + findNumOfIslands(grid1));
    }


    /**
     * It uses bfs to find out number of islands.
     * The complexity of the method is O(n), as it uses another matrix to mark the way it has traversed and hence it
     * would only traverse evey cell for one time.
     * @param island
     * @return
     */
    private static int findNumOfIslands(String[][] island) {
        boolean[][] trip = new boolean[island.length][island[0].length];

        int res = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if(island[i][j].equals("0") || trip[i][j]) continue;;
                recurse(island, trip, i, j);
                res++;
            }
        }

        return res;
    }

    private static void recurse(String[][] island, boolean[][] trip, int i, int j) {
        if (i < 0 || j < 0 || i >= island.length || j >= island[0].length || island[i][j].equals("0") || trip[i][j]) {
            return;
        }

        trip[i][j] = true;
        recurse(island, trip, i - 1, j);
        recurse(island, trip, i + 1, j);
        recurse(island, trip, i, j - 1);
        recurse(island, trip, i, j + 1);
    }

}
