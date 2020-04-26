import java.util.*;

public class matrixChainMult {

    public static int matrixChainMultiplicationMem(int[] dims, int si, int ei, int dp[][]) {
        if (ei - si == 1) {
            return 0;
        }
        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }
        int omin = Integer.MAX_VALUE;
        for (int cbp = si + 1; cbp <= ei - 1; cbp++) {
            int minCostPart1 = matrixChainMultiplicationMem(dims, si, cbp, dp);
            int minCostPart2 = matrixChainMultiplicationMem(dims, cbp, ei, dp);
            int pc = dims[si] * dims[ei] * dims[cbp];

            int totalCost = minCostPart1 + minCostPart2 + pc;

            if (totalCost < omin) {
                omin = totalCost;
            }
        }
        dp[si][ei]=omin;
        return omin;
    }
    
    public static int matrixChainMultiplicationTab(int[] dims)
    {
        int [][]mcm=new int[dims.length][dims.length];
       
        for(int gap=1;gap<dims.length;gap++)
        {
            int i=0;int j=i+gap;

            while(j<dims.length)
            {
                if(gap==1)
                {
                    mcm[i][j]=0;
                }
                else
                {
                    int min=Integer.MAX_VALUE;
                    for(int cp=i+1;cp<=j-1;cp++)
                    {
                        int fp=mcm[i][cp];
                        int sp=mcm[cp][j];

                        int factor=dims[i]*dims[j]*dims[cp];

                        int totalCost=fp+sp+factor;
                        if(totalCost<min)
                        {
                            min=totalCost;
                        }
                        mcm[i][j]=min;
                    }
                }
                i++;
                j++;
            }
        }
        return mcm[0][dims.length-1];
        
    }
    public static void main(String args[]) {
        int dims[] = { 10, 20, 30, 40, 50, 60 };
        int dp[][]=new int[dims.length][dims.length];
        System.out.println(matrixChainMultiplicationTab(dims));
    }
}