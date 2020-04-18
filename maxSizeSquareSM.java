import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class maxSizeSquareSM {

    public static void MaxSizeSubMatTab(int [][]mat)
    {
        int store[][]=new int[mat.length][mat[0].length];
        int dr=mat.length-1;
        int dc=mat[0].length-1;
        int omax=0;
        int orow=-1;
        int ocol=-1;
        for(int r=dr;r>=0;r--)
        {
            for(int c=dc;c>=0;c--)
            {
                int rp1=r+1;
                int cp1=c+1;
                if(c== dc && r==dr)
                {
                    store[r][c]=mat[r][c];
                }
                else if(c==dc)
                {
                    store[r][c]=mat[r][c];
                }
                else if(r==dr)
                {
                    store[r][c]=mat[r][c];
                }
                else
                {
                    if(mat[r][c]==0)
                    {
                        store[r][c]=0;
                    }
                    else{
                        store[r][c]=1+Math.min(store[rp1][cp1],Math.min(store[rp1][c], store[r][cp1]));
                    }
                }
                if(store[r][c]>omax)
                {
                    omax=store[r][c];
                    orow=r;
                    ocol=c;
                }
            }        
        }
        System.out.println(omax+" @ ["+orow+", "+ocol+"]");
    }
    static int omax=0;
    static int orow=-1;
    static int ocol=-1;
    public static int MaxSizeSubMatMem(int mat[][],int sr,int sc,int [][]dp)
    {
        int dr=mat.length-1;
        int dc=mat[0].length-1;

        if(sr==dr || sc==dc)
        {
            return mat[sr][sc];
        }
        if(dp[sr][sc]!=0)
        {
            return dp[sr][sc];
        }
        if(mat[sr][sc]==0)
        {
            return 0;
        }
        else
        {
            int msh=MaxSizeSubMatMem(mat, sr, sc+1,dp);
            int msv=MaxSizeSubMatMem(mat, sr+1, sc,dp);
            int msd=MaxSizeSubMatMem(mat, sr+1, sc+1,dp);

            int res=1+Math.min(msv, Math.min(msh,msd));

            if(res>omax)
            {
                omax=res;
                orow=sr;
                ocol=sc;
            }
            dp[sr][sc]=res;
            return res;
        }
        
    }
    public static void main(String args[])
    {
        int [][]mat={{1,0,1,0,0,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,0,0},{1,1,1,1,1,1},{0,0,1,1,1,0}};
        int[][] dp=new int[mat.length][mat[0].length];
        MaxSizeSubMatMem(mat,0,0,dp);
        System.out.println(omax+" @ ["+orow+","+ocol+"]");
    }

}