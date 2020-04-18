import java.util.*;
public class countMPSlider {

    public static int countmpSlider(int dr,int dc)
    {
        int s[]=new int[dc+1];
        Arrays.fill(s, 1);

        for(int nors=1;nors<=dr;nors++)
        {
            for(int c=s.length-2;c>=0;c--)
            {
                int nv=s[c]+s[c+1];
                s[c]=nv;
            }
        }
        return s[0];

    }
    public static void main(String args[])
    {
        System.out.println(countmpSlider(2, 2));
    }

}