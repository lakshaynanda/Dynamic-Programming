import java.util.*;

public class palindromicSubstring {
    public static int PalindromeSubString(String str)
    {
        boolean storage[][]=new boolean[str.length()][str.length()];
        
        int count=0;
        for(int diagonal=0;diagonal<str.length();diagonal++)
        {
            int si=0;
            int ei=diagonal;
            while(ei<str.length())
            {
                if(diagonal==0)
                {
                    storage[si][ei]=true;
                }
                else if(diagonal==1)
                {
                    if(str.charAt(si)==str.charAt(ei))
                    {
                        storage[si][ei]=true;
                    }
                }
                else
                {
                    if(str.charAt(si)==str.charAt(ei) && storage[si+1][ei-1]==true)
                    {
                        storage[si][ei]=true;
                    }
                }
                if(storage[si][ei]==true)
            {
                count++;
            }
            si++;
            ei++;
            }

            
        }
        return count;
    }
    public static void main(String[] args) {
        String str="abccbc";
        System.out.println(PalindromeSubString(str));
    }

}