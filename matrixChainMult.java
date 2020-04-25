import java.util.*;

public class matrixChainMult {

    public static int matrixChainMultiplication(int[] dims, int si, int ei, int dp[][]) {
        if (ei - si == 1) {
            return 0;
        }
        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }
        int omin = Integer.MAX_VALUE;
        for (int cbp = si + 1; cbp <= ei - 1; cbp++) {
            int minCostPart1 = matrixChainMultiplication(dims, si, cbp, dp);
            int minCostPart2 = matrixChainMultiplication(dims, cbp, ei, dp);
            int pc = dims[si] * dims[ei] * dims[cbp];

            int totalCost = minCostPart1 + minCostPart2 + pc;

            if (totalCost < omin) {
                omin = totalCost;
            }
        }
        dp[si][ei]=omin;
        return omin;
    }

    public static void main(String args[]) {
        int dims[] = { 10, 20, 30, 40, 50, 60 };
        int dp[][]=new int[dims.length][dims.length];
        System.out.println(matrixChainMultiplication(dims, 0, dims.length - 1,dp));
    }
}