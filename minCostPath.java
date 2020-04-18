import java.util.*;

public class minCostPath {
    public static int MinimumCostPath(int sr, int sc, int dr, int dc, int costs[][]) {
        if (sr == dr && sc == dc) {
            return costs[sr][sc];
        }
        int mcs2d = 0;
        int mchs2d = Integer.MAX_VALUE;
        int mcvs2d = Integer.MAX_VALUE;

        if (sr < dr) {
            mcvs2d = MinimumCostPath(sr + 1, sc, dr, dc, costs);
        }
        if (sc < dc) {
            mchs2d = MinimumCostPath(sr, sc + 1, dr, dc, costs);
        }
        mcs2d = costs[sr][sc] + Math.min(mcvs2d, mchs2d);
        return mcs2d;
    }

    public static int MinimumCostPathMem(int sr, int sc, int dr, int dc, int costs[][], int dp[][]) {
        if (sr == dr && sc == dc) {
            return costs[sr][sc];
        }
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int mcs2d = 0;
        int mchs2d = Integer.MAX_VALUE;
        int mcvs2d = Integer.MAX_VALUE;

        if (sr < dr) {
            mcvs2d = MinimumCostPathMem(sr + 1, sc, dr, dc, costs, dp);
        }
        if (sc < dc) {
            mchs2d = MinimumCostPathMem(sr, sc + 1, dr, dc, costs, dp);
        }
        mcs2d = costs[sr][sc] + Math.min(mcvs2d, mchs2d);
        dp[sr][sc] = mcs2d;
        return mcs2d;
    }

    public static void MinimumCostPathTab(int[][] costs) {
        int dp[][] = new int[costs.length][costs[0].length];
        String path[][] = new String[costs.length][costs[0].length];

        int dr = costs.length - 1;
        int dc = costs[0].length - 1;

        for (int r = dr; r >= 0; r--) {
            for (int c = dc; c >= 0; c--) {
                int rp1 = r + 1;
                int cp1 = c + 1;

                if (r == dr && c == dc) {
                    dp[r][c] = costs[r][c];
                    path[r][c] = ".";
                } else if (r == dr) {
                    dp[r][c] = costs[r][c] + dp[r][cp1];
                    path[r][c] = "H" + path[r][cp1];
                } else if (c == dc) {
                    dp[r][c] = costs[r][c] + dp[rp1][c];
                    path[r][c] = "V" + path[rp1][c];
                } else {
                    if (dp[r][cp1] < dp[rp1][c]) {
                        dp[r][c] = costs[r][c] + dp[r][cp1];
                        path[r][c] = "H"+ path[r][cp1];
                    } else {
                        dp[r][c] = costs[r][c] + dp[rp1][c];
                        path[r][c] = "V" + path[rp1][c];
                    }
                }
            }
        }
        System.out.println(dp[0][0]+"@ "+path[0][0]);
    }

    public static void main(String args[]) {
        int[][] costs = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2 } };
        int dp[][] = new int[costs.length][costs[0].length + 1];
        MinimumCostPathTab(costs);

    }
}