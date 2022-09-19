
// 股票stock[]切一刀，切在哪里时左半边Avg和右半边Avg的差值最小，注意数组0-index，返回月份要+1


// https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=49829dd06006467996df67eb68603ea9&pm=s

// Idea: prefix sum
public class Main {
    public static int findEaliestMonth(int[] stockPrices) {
        int n = stockPrices.length;
        long[] prefixSum = new long[n];
        prefixSum[0] =  stockPrices[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + stockPrices[i];
        }
        long minDif = Integer.MAX_VALUE;
        int monthIdx = -1;
        for(int i = 0; i< n-1; i++){
            long leftAvg = prefixSum[i]/(long)(i+1);
            long rightAvg = (prefixSum[n-1]-prefixSum[i])/(long)(n-i-1);
            long curDif = Math.abs(leftAvg - rightAvg);
            if(minDif > curDif){
                minDif = curDif;
                monthIdx = i;
            }  
        }
        return monthIdx +1;
    }
    
    public static void main(String[] args) {
        
        System.out.println(findEaliestMonth(new int[] {1,3, 2, 3})); 
        System.out.println(findEaliestMonth(new int[] {1,3, 2, 4,5})); 
        System.out.println(findEaliestMonth(new int[] {1,1, 1, 1,1,1})); 
    }
}

// 别人解法

// Problem
// https://leetcode.com/problems/minimum-average-difference/    LC 2256
// You are given a 0-indexed integer array nums of length n.

// The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.

// Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.

// Note:

// The absolute difference of two numbers is the absolute value of their difference.
// The average of n elements is the sum of the n elements divided (integer division) by n.
// The average of 0 elements is considered to be 0.

// Example 1:

// Input: nums = [2,5,3,9,5,3]
// Output: 3
// Explanation:
// - The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
// - The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
// - The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
// - The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
// - The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
// - The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
// The average difference of index 3 is the minimum average difference so return 3.
// Example 2:

// Input: nums = [0]
// Output: 0
// Explanation:
// The only index is 0 so return 0.
// The average difference of index 0 is: |0 / 1 - 0| = |0 - 0| = 0.


// "static void main" must be defined in a public class.
public class Main {
    
    // Analytic
    // Calculate the sum first and then minus the left sum in te for loop.
    
    
    
// Complexity Analysis

// Time complexity: O(n)
// Space complexity: O(1)

    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            // n-i==1 is to check the last one ,that n-i-1 ==0,will cause false;
            long diff = Math.abs(leftSum / (i + 1) - (n - i == 1 ? 0 : rightSum / (n -i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{0,0,0,0};
        int[] arr3 = new int[]{2,5,3,9,5,3};
        int[] arr4 = new int[]{100,1,1000};
        System.out.println(Main.minimumAverageDifference(arr1));
        System.out.println(Main.minimumAverageDifference(arr2));
        System.out.println(Main.minimumAverageDifference(arr3));
        System.out.println(Main.minimumAverageDifference(arr4));
    }
}
