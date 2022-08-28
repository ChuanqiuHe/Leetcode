// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
// https://docs.google.com/spreadsheets/d/1qmHisXc8oXzkEs2QY5C-8MrHiwB-GnPWGJtq8kS4Mw8/edit#gid=0
// 以1开始的数组，后面每两个相邻数组直接差距不能>1
// idea : sort + greedy
public class Main {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // sort 
        Arrays.sort(arr);
        int n = arr.length;
        if(n==1) return 1;
        if(arr[0]!=1) arr[0] =1;
        for(int i = 1; i<n; i++){
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
        }
        return arr[n-1];
    }
}
