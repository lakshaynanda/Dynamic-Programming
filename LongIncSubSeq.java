import java.util.*;
public class LongIncSubSeq {

    public static void longestIncSubSTab(int arr[])
    {
        int dp[]=new int[arr.length];
        String[] path=new String[arr.length];

        dp[0]=1;
        path[0]=arr[0]+ " ";

        int omax=0;
        String opath="";

        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<=i-1;j++)
            {
                if(arr[j]<arr[i])
                {
                    if(dp[j]>dp[i])
                    {
                        dp[i]=dp[j];
                        path[i]=path[j];
                    }
                }
            }
            dp[i]+=1;
                path[i]=path[i]+" "+arr[i];
                if(dp[i]>omax)
                {
                    omax=dp[i];
                    opath=path[i];
                }
        }
        System.out.println(omax);
        System.out.println(opath);
    }
    public static void lisstarting(int arr[]) //Largest Increasing SubSequence Memoised 
    {
        int dp[]=new int[arr.length];
        int omax=0;

        for(int i=0;i<arr.length;i++)
        {
            int lisendati=lisending(arr,i, dp);
            if(lisendati>omax)
            {
                omax=lisendati;
            }
        }
        System.out.println(omax);
    }
    public static int lisending(int arr[],int point,int dp[]) //Largest Increasing SubSequence Memoised 
    {
        if(point==0)
        {
            return 1;
        }
        if(dp[point]!=0)
        {
            return dp[point];
        }
        int lisendingpoint=0;
        for(int i=0;i<point;i++)
        {
            if(arr[i]<arr[point])
            {
                int lisendati=lisending(arr,i, dp);
                if(lisendati>lisendingpoint)
                {
                    lisendingpoint=lisendati;
                }
            }
        }
        lisendingpoint+=1;
        dp[point]=lisendingpoint;
        return lisendingpoint;
    }
    public static void main(String args[])
    {
        int arr[]={10,22,9,33,21,50,41,60,80,1};
        lisstarting(arr);
    }
}