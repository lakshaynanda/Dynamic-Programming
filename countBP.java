import java.util.*;
public class countBP {
    public static int cbp(int s,int d)
    {
        if(s>d)
        {
            return 0;
        }
        if(s==d)
        {
            return 1;
        }
        int cstod=0;
        for(int dice=1;dice<=6;dice++)
        {
            int i=s+dice;
            int citod=cbp(i, d);
            cstod+=citod;
        }
        return cstod;
    }
    public static int cbpMem(int s,int d,int dp[])
    {
        if(s>d)
        {
            return 0;
        }
        if(s==d)
        {
            return 1;
        }
        if(dp[s]!=0)
        {
            return dp[s];
        }
        int cstod=0;
        for(int dice=1;dice<=6;dice++)
        {
            int i=s+dice;
            int citod=cbpMem(i,d,dp);
            cstod+=citod;
        }
        dp[s]=cstod;
        return cstod;
    }
    public static int cbpTab(int d)
    {
        int dp[]=new int[d+1];
        dp[d]=1;

        for(int x=d-1;x>=0;x--)
        {
            for(int dice=1;dice<=6;dice++)
            {
                if(x+dice<=d)
                {
                    dp[x]+=dp[x+dice];
                }
            }
        }
        return dp[0];
    }
    public static void main(String args[])
    {
        int n=30;
        int []dp=new int[n+1];
        // System.out.println(cbpMem(0,n,dp));
        // System.out.println(cbp(0,n));
        System.out.println(cbpTab(30));

    }

}