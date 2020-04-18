import java.util.*;
public class FiboSlider {

    public static int fibSlider(int n)
    {
        int s[]=new int[2];
        s[0]=0; //s[0]=f[0]
        s[1]=1; //s[1]=f[1]

        for(int nos=1;nos<=n;nos++)
        {
            int nf=s[0]+s[1];
            s[0]=s[1];
            s[1]=nf;
        }
        return s[0];
    }
    public static void main(String args[])
    {
        System.out.println(fibSlider(43));
    }

}