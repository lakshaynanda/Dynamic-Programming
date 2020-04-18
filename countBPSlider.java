import java.util.*;
public class countBPSlider {
    public static int countbpSlider(int d)
    {
        int s[]=new int[6];
        s[0]=1; //s[0]=f[d]

       // s1,2,3,4,5 coincide with f11,12,13,14,15
        for(int nos=1;nos<=d;nos++)
        {
            int nv=s[0]+s[1]+s[2]+s[3]+s[4]+s[5];
            s[5]=s[4];
            s[4]=s[3];
            s[3]=s[2];
            s[2]=s[1];
            s[1]=s[0];
            s[0]=nv;
        }
        return s[0];

    }
    public static void main(String args[])
    {
        System.out.println(countbpSlider(10));
    }

}