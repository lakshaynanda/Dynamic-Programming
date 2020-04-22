import java.util.*;

public class LongestBitonicSubSeq
{
    public static void longestBitonicSubSTab(int arr[])
    {
        int dp[]=new int[arr.length];
        String[] path=new String[arr.length];

        dp[0]=1;
        path[0]=arr[0]+ " ";

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
        }

        int lds[]=new int[arr.length];
        String[] dpath=new String[arr.length];

        lds[arr.length-1]=1;
        path[arr.length-1]=arr[arr.length-1]+ " ";

        for(int i=arr.length-2;i>=0;i--)
        {
            for(int j=arr.length-1;j>=i+1;j--)
            {
                if(arr[j]<arr[i])
                {
                    if(lds[j]>lds[i])
                    {
                        lds[i]=lds[j];
                        dpath[i]=dpath[j];
                    }
                }
            }
            lds[i]+=1;
            dpath[i]=arr[i]+" "+dpath[i];
        }
        int omax=0;
        String opath="";
        for(int i=0;i<arr.length;i++)
        {
            if(dp[i]+lds[i]>omax)
            {
                omax=dp[i]+lds[i]-1;
                opath=path[i]+" "+dpath[i];
            }
        }
        System.out.println(opath);
        System.out.println(omax);
    }
    

    public static void main(String args[])
    {
        int arr[]={10,22,9,33,21,50,41,60,80,1};
        longestBitonicSubSTab(arr);
    }
}