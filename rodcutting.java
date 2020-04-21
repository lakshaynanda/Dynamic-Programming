import java.util.*;

public class rodcutting {

    public static void rodCuttingTab(int arr[]) {
        int dp[] = new int[arr.length];
        String path[] = new String[arr.length];

        dp[0] = 0;
        dp[1] = arr[1];
        path[0] = "";
        path[1] = "1";

        for (int i = 2; i < arr.length; i++) {
            dp[i] = arr[i];
            path[i] = i + " ";

            int left = 1;
            int right = i - 1;
            while (left <= right) {
                if (dp[left] + dp[right] > dp[i]) {
                    dp[i] = dp[left] + dp[right];
                    path[i] = path[left] + path[right];
                }
                left++;
                right--;
            }
        }
        System.out.println(dp[arr.length - 1]);
        System.out.println(path[arr.length - 1]);
    }

    public static int rodCuttingMem(int arr[], int rl, int dp[]) {
        if (rl == 0) {
            return 0;
        }
        if (dp[rl] != 0) {
            return dp[rl];
        }
        int msp = arr[rl];
        int left = 1;
        int right = rl - 1;

        while (left <= right) {
            int mspl = rodCuttingMem(arr, left, dp);
            int mspr = rodCuttingMem(arr, right, dp);

            if (mspl + mspr > msp) {
                msp = mspl + mspr;
            }
            left++;
            right--;
        }
        dp[rl] = msp;
        return msp;
    }

    public static void main(String args[]) {
        int arr[] = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
        int dp[]=new int[arr.length];
        System.out.println(rodCuttingMem(arr,8,dp));
    }
}