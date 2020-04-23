import java.util.*;
public class palinCut 
{
    public static int MinPalinCut(String str, int si,int ei,int dp[][])
    {
        if(isPalin(str,si,ei))
        {
            return 0;
        }
        if(dp[si][ei]!=0)
        {
            return dp[si][ei];
        }
        int mpc=Integer.MAX_VALUE;

        for(int cp=si;cp<ei;cp++)
        {
            int substring1=MinPalinCut(str, si, cp,dp);
            int substring2=MinPalinCut(str, cp+1, ei,dp);

            int totalcost=substring1+substring2+1;

            if(totalcost<mpc)
            {
                mpc=totalcost;
            }
        }
        dp[si][ei]=mpc;
        return mpc;
    }

    public static boolean isPalin(String str,int si,int ei)
    {
        int left=si;
        int right=ei;

        while(left<right)
        {
            if(str.charAt(si)!=str.charAt(ei))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String args[])
    {
        String str="abccbc";
        int dp[][]=new int[str.length()][str.length()];
        System.out.println(MinPalinCut(str, 0, str.length()-1,dp));

    }

}