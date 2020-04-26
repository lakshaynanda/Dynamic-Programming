import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class eggsdrop {

    public static int eggdrop(int eggs,int floors,int dp[][])
    {
        if(eggs==1)
        {
            return floors;
        }
        if(floors==1)
        {
            return 1;
        }
        if(floors==0)
        {
            return 0;
        }
        if(dp[eggs][floors]!=0)
        {
            return dp[eggs][floors];
        }
        int minVal=Integer.MAX_VALUE;
        for(int f=1;f<=floors;f++)
        {
           
            int mteggbreak=eggdrop(eggs-1, f-1,dp);
            int mteggsurvive=eggdrop(eggs, floors-f,dp);

            if(Math.max(mteggbreak, mteggsurvive)<minVal)
            {
                minVal=Math.max(mteggbreak, mteggsurvive);
            }
        }
        dp[eggs][floors]=minVal+1;
        return minVal+1;
    }
    public static int eggsdropTab(int eggs,int floors)
    {
        int dp[][]=new int[eggs+1][floors+1];

        for(int e=1;e<=eggs;e++)
        {
            for(int f=1;f<=floors;f++)
            {
                if(f==1)
                {
                    dp[e][f]=1;
                }
                else if(e==1)
                {
                    dp[e][f]=f;
                }
                else
                {
                    int min=Integer.MAX_VALUE;
                    for(int k=1;k<=f;k++)
                    {
                        int mteggbreak=dp[e-1][k-1];
                        int mteggsurvive=dp[e][f-k];

                        if(Math.max(mteggbreak,mteggsurvive)<min)
                        {
                            min=Math.max(mteggbreak,mteggsurvive);
                        }
                    }
                    dp[e][f]=min+1;
                }
            }
        }
        return dp[eggs][floors];
    }
    public static void main(String args[])
    {
        int dp[][]=new int[3][65];
        System.out.println(eggsdropTab(2, 64));
    }
}