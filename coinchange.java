import java.lang.reflect.Array;
import java.util.*;

public class coinchange {
    public static void coinChangeCombTab(int denoms[], int amt) {
        int dp[] = new int[amt + 1];
        ArrayList<String>[] path = new ArrayList[amt + 1];

        for (int i = 0; i < path.length; i++) {
            path[i] = new ArrayList<>();
        }
        dp[0] = 1;
        path[0].add("");

        for (int i = 0; i < denoms.length; i++) {
            for (int j = denoms[i]; j <= amt; j++) {
                dp[j] = dp[j] + dp[j - denoms[i]];

                for (String str : path[j - denoms[i]]) {
                    String nstr = str + denoms[i];
                    path[j].add(nstr);
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
        System.out.println(path[path.length - 1]);

    }

    public static void coinChangePermTab(int denoms[], int amt) {
        int dp[] = new int[amt + 1];
        ArrayList<String>[] path = new ArrayList[amt + 1];

        for (int i = 0; i < path.length; i++) {
            path[i] = new ArrayList<>();
        }
        dp[0] = 1;
        path[0].add("");

        for (int j = 1; j <= amt; j++) {
            for (int i = 0; i < denoms.length; i++) {
                if (j >= denoms[i]) {
                    dp[j] = dp[j] + dp[j - denoms[i]];

                    for (String str : path[j - denoms[i]]) {
                        String nstr = str + denoms[i];
                        path[j].add(nstr);
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
        System.out.println(path[path.length - 1]);

    }
    public static ArrayList<String> coinChangePermMem(int denoms[],int amt,ArrayList[] dp)
    {
        if(amt==0)
        {
            ArrayList<String> baseRes=new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if(amt<0)
        {
            ArrayList<String> baseRes=new ArrayList<>();
            return baseRes;
        }
        if(dp[amt]!=null)
        {
            return dp[amt];
        }
        ArrayList<String> myAns=new ArrayList<>();
        for(int i=0;i<denoms.length;i++)
        {
            ArrayList<String> recAns=coinChangePermMem(denoms, amt-denoms[i], dp);

            for(String str:recAns)
            {
                String mstr=str+denoms[i];
                myAns.add(mstr);
            }
        }
        dp[amt]=myAns;
        return myAns;
    }
    public static ArrayList<String> coinChangeCombMem(int denoms[],int amt,int lpi,ArrayList[][] dp)
    {
        if(amt==0)
        {
            ArrayList<String> baseRes=new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if(amt<0)
        {
            ArrayList<String> baseRes=new ArrayList<>();
            return baseRes;
        }
        if(dp[amt][lpi]!=null)
        {
            return dp[amt][lpi];
        }
        ArrayList<String> myAns=new ArrayList<>();
        for(int i=0;i<denoms.length;i++)
        {
            ArrayList<String> recAns=coinChangeCombMem(denoms, amt-denoms[i],i,dp);

            for(String str:recAns)
            {
                String mstr=str+denoms[i];
                myAns.add(mstr);
            }
        }
        dp[amt][lpi]=myAns;
        return myAns;
    }

    public static void main(String[] args) {
        int denoms[] = { 2, 3, 5, 6 };
        int amt = 10;
        ArrayList<String>[][] dp=new ArrayList[amt+1][denoms.length];
        System.out.println(coinChangeCombMem(denoms, amt,0,dp));
    }
}