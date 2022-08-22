// "static void main" must be defined in a public class.

// description: https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=d462058e34dc4f56bcf23e3d6fbeb24b&pm=s

/*
ShipmentImbalance（leetcode 2104）子数组Max/Min求差值，再加和
*/
// O(n^2), o(1)
public class Main {
    public static long subArrayRanges(int[] weights) {
        int n = weights.length;
        long res = 0;
        for(int i = 0; i< n; i++){
            int max = weights[i], min = weights[i];
            for(int j = i+1; j<n; j++){
                max = Math.max(max, weights[j]); // 依次和nums[i]作比较
                min = Math.min(min, weights[j]);
                res += max - min;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] weights = {1,2,3};  
        System.out.println(subArrayRanges(weights));   
    }
}


// follow up 
// https://leetcode.cn/problems/sum-of-subarray-ranges/solution/gong-shui-san-xie-yi-ti-san-jie-qu-jian-wn84z/
// 单调栈解法 O(n)

class Solution {
    int n;
    public long subArrayRanges(int[] nums) {
        n = nums.length;
        // min[i] 为 nums[i] 作为区间最小值的次数；max[i] 为 nums[i] 作为区间最大值的次数
        long[] min = getCnt(nums, true), max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (max[i] - min[i]) * nums[i];
        return ans;
    }
    long[] getCnt(int[] nums, boolean isMin) {
        int[] a = new int[n], b = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] >= nums[i] : nums[d.peekLast()] <= nums[i])) d.pollLast();
            a[i] = d.isEmpty() ? -1 : d.peekLast();
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] > nums[i] : nums[d.peekLast()] < nums[i])) d.pollLast();
            b[i] = d.isEmpty() ? n : d.peekLast();
            d.addLast(i);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) ans[i] = (i - a[i]) * 1L * (b[i] - i);
        return ans;
    }
}

作者：AC_OIer
链接：https://leetcode.cn/problems/sum-of-subarray-ranges/solution/gong-shui-san-xie-yi-ti-san-jie-qu-jian-wn84z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
