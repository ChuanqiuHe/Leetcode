// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r52

// solution : Sliding Window + priorityqueue
    // https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r52
  
leetcode https://leetcode.com/problems/maximum-number-of-robots-within-budget/discuss/2524838/JavaC%2B%2BPython-Sliding-Window-O(n)-Solutiohttps://leetcode.com/problems/maximum-number-of-robots-within-budget/discuss/2524838/JavaC%2B%2BPython-Sliding-Window-O(n)-Solution

// Use a priorityqueue to find the maximum value in a sliding window.
// Time Complexity: O(n * log(n)), Space complexity: O(n)
public class Main {
    public static int findMaximumSustainableClusterSize(int[] processingPower, int[] bootingPower, long powerMax) {
        int n = processingPower.length;
        int m = bootingPower.length;
        if (processingPower == null || bootingPower == null || n == 0 || m != n) {
            return 0;
        }
        
        // pq
        PriorityQueue<Integer> maxBootPower = new PriorityQueue<>((a,b) -> b-a);
        
        int left = 0;
        int right = 0;
        
        long sum = processingPower[0];
        maxBootPower.add(bootingPower[0]);
        
        int res = 0;
        int curlen = 1;
        while(right < n){
            int curBootPower = maxBootPower.peek();
            long curPower = curBootPower + sum*curlen;
            
            if(curPower <= powerMax){ // update res
                curlen = right -left +1;
                res = Math.max(res, curlen);
            }else{ //收缩窗口
                sum -= processingPower[left];
                maxBootPower.remove(bootingPower[left]);
                left ++;
            }
            right++; //在范围内（满足条件）可以继续扩大窗口
            
            if(right < n){
                sum += processingPower[right];
                maxBootPower.add(bootingPower[right]);
            }
        }
        return res;  
    }
    
    
    public static void main(String[] args) {
        int[] inpt1 = {3,6,1,3,4};
        int[] inpt2 = {2,1,3,4,5};
        long powerMax = 25;
        System.out.println(findMaximumSustainableClusterSize(inpt1,inpt2,powerMax));
    }
}
