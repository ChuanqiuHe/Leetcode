// "static void main" must be defined in a public class.
/*
原题链接在这里：https://leetcode.com/problems/missing-ranges/

题目：

Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

[0, 1, 3, 50, 75]
["2", "4->49", "51->74", "76->99"]

---------
给定一个无重复数字的长n nn升序数组A AA，再给定一个区间[ l , u ] [l,u][l,u]，题目保证l ≤ A [ 0 ] , A [ n − 1 ] ≤ r l\le A[0], A[n-1]\le rl≤A[0],A[n−1]≤r。求所有[ l , r ] − A [l,r]-A[l,r]−A所剩的区间族。如果区间是单元集则就是它一个数，否则写成"a->b"的形式。
*/

public class Main {
    public static List<String> findMissingRanges ( int[] nums, int lower, int upper){
        List<String> res = new ArrayList<>();
        // if nums==null, add ranges
        int n = nums.length;
        if(n==0){
            group(res, lower, upper);
            return res;
        }
        
        // 超出nums数组的部分先补上( lower<nums[0])
        if(lower !=nums[0]){
            group(res, lower, nums[0]-1);
        }
        
        // iterative nums
        for(int i =1; i< n; i++){
            if(nums[i]!=nums[i-1]+1 && nums[i] !=nums[i-1]){
                group(res, nums[i-1] +1, nums[i]-1);
            }
        }
        
        // >upper
        if(nums[n-1] != upper){
            group(res, nums[n-1], upper);
        }
       return res; 
        
    }
    
    private static void group( List<String> res, int lower, int upper){
        StringBuilder sb = new StringBuilder();
        if(lower == upper){
            sb.append(lower);
        }else{
            sb.append(lower);
            sb.append("->");
            sb.append(upper);
        }
        res.add(sb.toString());
    }
    
    
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower =0;
        int upper = 90;
        System.out.println(findMissingRanges(nums,lower,upper));
    }
}
