import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class countMP {
    static int count=0;
    public static void cmp(int sr,int sc,int dr,int dc,String psf)
    {
        if(sr==dr && sc==dc)
        {
            count++;
            System.out.println(count+". "+psf);
            return;
        }
        if(sr>dr || sc>dc)
        {
            return;
        }
        cmp(sr+1, sc, dr, dc, psf+"V");
        cmp(sr, sc+1, dr, dc, psf+"H");
    }
    public static int cmpMem(int sr,int sc,int dr,int dc,int[][] dp,String psf)
    {
        if(sr==dr && sc==dc)
        {
            count++;
            System.out.println(count+". "+psf);
            return 1;
        }
        if(sc>dc || sr>dr)
        {
            return 0;
        }
        if(dp[sr][sc]!=0)
        {
            return dp[sr][sc];
        }
        int sum=0;
        int x=cmpMem(sr+1, sc, dr, dc, dp,psf+"V");
        int y=cmpMem(sr, sc+1, dr, dc, dp,psf+"H");
        sum=x+y;
        dp[sr][sc]=sum;

        return sum;

    }
    public static int cmpTab(int dr,int dc)
    {
        int [][]dp=new int[dr+1][dc+1];
        for(int r=dr;r>=0;r--)
        {
            for(int c=dc;c>=0;c--)
            {
                if(r==dr && c==dc)
                {
                    dp[r][c]=1;
                }
                else if(c==dc)
                {
                    dp[r][c]=dp[r+1][c];
                }
                else if(r==dr)
                {
                    dp[r][c]=dp[r][c+1];
                }
                else
                {
                    dp[r][c]=dp[r+1][c]+dp[r][c+1];
                }
            }
        }return dp[0][0];
    }
    public static void main(String args[])
    {
        int dp[][]=new int[16][16];
        System.out.print(cmpTab(15, 15));
    }

}