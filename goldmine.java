import java.util.*;
public class goldmine {

    public static void goldmineTab(int [][]goldMine)
    {
        int dp[][]=new int[goldMine.length][goldMine[0].length];
        String[][] path=new String[goldMine.length][goldMine[0].length];
        int omax=0;
        int orow=-1;
        int ocol=-1;
        for(int c=goldMine[0].length-1;c>=0;c--)
        {
            for(int r=0;r<goldMine.length;r++)
            {
                int rp1=r+1;
                int rm1=r-1;
                int cp1=c+1;

                if(c==goldMine[0].length-1)
                {
                    dp[r][c]=goldMine[r][c];
                    path[r][c]=r+"_"+c+" ";
                }
                else if(r==0)
                {
                    if(dp[r][cp1]>dp[rp1][cp1])
                    {
                        dp[r][c]=goldMine[r][c]+dp[r][cp1];
                        path[r][c]=r+"_"+c+path[r][cp1]+" ";
                    }
                    else
                    {
                        dp[r][c]=goldMine[r][c]+dp[rp1][cp1];
                        path[r][c]=r+"_"+c+path[rp1][cp1]+" ";
                    }
                }
                else if(r==goldMine.length-1)
                {
                    if(dp[r][cp1]>dp[rm1][cp1])
                    {
                        dp[r][c]=goldMine[r][c]+dp[r][cp1];
                        path[r][c]=r+"_"+c+path[r][cp1]+" ";
                    }
                    else
                    {
                        dp[r][c]=goldMine[r][c]+dp[rm1][cp1];
                        path[r][c]=r+"_"+c+path[rm1][cp1]+" ";
                    }
                }
                else
                {
                    if(dp[r][cp1]>dp[rp1][cp1] && dp[r][cp1]>dp[rm1][cp1])
                    {
                        dp[r][c]=goldMine[r][c]+dp[r][cp1];
                        path[r][c]=r+"_"+c+path[r][cp1]+" ";
                    }
                    else if(dp[rm1][cp1]>dp[rp1][cp1] && dp[rm1][cp1]>dp[r][cp1])
                    {
                        dp[r][c]=goldMine[r][c]+dp[rm1][cp1];
                        path[r][c]=r+"_"+c+path[rm1][cp1]+" ";
                    }
                    else
                    {
                        dp[r][c]=goldMine[r][c]+dp[rp1][cp1];
                        path[r][c]=r+"_"+c+path[rp1][cp1]+" ";
                    }
                }
                if(dp[r][c]>omax)
                {
                    omax=dp[r][c];
                    orow=r;
                    ocol=c;
                }
                
            }
            
        }
        System.out.println(omax+" @ "+path[orow][ocol]);

    }
    public static int goldmineMem(int[][] mine,int r,int c,int dp[][])
    {
        if(c==mine[0].length-1)
        {
            return mine[r][c];
        }
        if(dp[r][c]!=0)
        {
            return dp[r][c];
        }
        int gstod=0;
        int grm1tod=Integer.MIN_VALUE;
        int grtod=Integer.MIN_VALUE;
        int grp1tod=Integer.MIN_VALUE;

        if(r>0)
        {
            grm1tod=goldmineMem(mine, r-1, c+1,dp);
        }
        grtod=goldmineMem(mine, r, c+1,dp);

        if(r<mine.length-1)
        {
            grp1tod=goldmineMem(mine, r+1, c+1,dp);
        }
        gstod=mine[r][c]+Math.max(grtod, Math.max(grm1tod, grp1tod));
        dp[r][c]=gstod;
        return gstod;
    }
    public static void main(String[] args) {
        int goldMine[][]={
            {2,6,0,5},
            {0,7,5,2},
            {3,0,3,7},
            {8,0,2,3},
        };
        int dp[][]=new int[goldMine.length][goldMine[0].length];
        int omax=0;
        for(int r=0;r<goldMine.length;r++)
        {
            int res=goldmineMem(goldMine, r, 0,dp);
            // System.out.println(res);
            if(res>omax)
            {
                omax=res;
            }

        }
        System.out.println(omax);
        // goldmineTab(goldMine);
    }
}