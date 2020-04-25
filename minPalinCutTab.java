import java.util.*;
public class minPalinCutTab {
    public static int mpc_tab(String str)
    {
        boolean[][] palin=new boolean[str.length()][str.length()];

        for(int gap=0;gap<str.length();gap++)
        {
            int i=0, j=i+gap;
            while(j<str.length())
            {
                if(gap==0)
                {
                    palin[i][j]=true;
                }
                else if(gap==1)
                {
                    palin[i][j]=str.charAt(i)==str.charAt(j);
                }
                else
                {
                    palin[i][j]=str.charAt(i)==str.charAt(j) && palin[i+1][j-1]==true;
                }
                i++;
                j++;
            }
        }
        int[][] mpc=new int[str.length()][str.length()];
    for(int gap=0;gap<str.length();gap++)
        {
            int i=0, j=i+gap;
            while(j<str.length())
            {
                if(gap==0)
                {
                    mpc[i][j]=0;
                }
                else if(gap==1)
                {
                    mpc[i][j]=palin[i][j]==true?0:1;
                }
                else
                {
                    if(palin[i][j]==true)
                    {
                        mpc[i][j]=0;
                        continue;
                    }
                    int minval=Integer.MIN_VALUE;
                    for(int cp=i;cp<j;cp++)
                    {
                        int fp=mpc[i][cp];
                        int sp=mpc[cp+1][j];

                        int factor=fp+sp+1;
                        if(factor<minval)
                        {
                            minval=factor;
                        }
                    }
                    mpc[i][j]=minval;
                }
                i++;
                j++;
            }
            
    }
    return mpc[0][str.length()-1];
    
        }
    public static void main(String args[])
    {
        String str="abccbc";
        int dp[][]=new int[str.length()][str.length()];
        System.out.println(mpc_tab(str));
    }

}