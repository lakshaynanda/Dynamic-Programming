import java.util.*;
public class fibo {
    public static int Fibo(int n)
    {
        if(n==0 ||n==1)
        {
            return n;
        }
        int fm1=Fibo(n-1);
        int fm2=Fibo(n-2);
        int ans=fm1+fm2;

        return ans;
    }
    public static int FiboMem(int n,int[] dp)
    {
        if(n==0 || n==1)
        {
            return n;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        int fm1=FiboMem(n-1,dp);
        int fm2=FiboMem(n-2,dp);
        int fm=fm1+fm2;

        dp[n]=fm;

        return fm;
    }
    public static int FiboTab(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int x=2;x<=n;x++)
        {
            dp[x]=dp[x-1]+dp[x-2];
        }
        return dp[n];
    }
    public static void main(String args[])
    {
        int n=10;
        // int dp[]=new int[n+1];
        System.out.println(FiboTab(n));
    }

}