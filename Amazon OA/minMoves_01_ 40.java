// "static void main" must be defined in a public class.
//https://leetcode.com/discuss/interview-question/903219/alarmcom-new-grad-oa-2021-grouping-digits
/*
Given an array of binary digits, 0 and 1, sort the array so that all zeros are at one end and all ones are at the other. Which end does not matter. To sort the array, swap any two adjacent elements. Determine the minimum number of swaps to sort the array.

Example
arr = [0, 1, 0, 1]
With 1 move, switching elements 1 and 2 yields [0, 0, 1, 1], a sorted array

Function Description
Complete the function minMoves

minMoves has the following parameter(s):
int arr[n]: an array of binary digits

Returns
int: the minimum number of moves necessarry

Constraints

1 <= n <= 10^5
arr[i] is in the set {0, 1}
Another Example
arr = [1, 1, 1, 1, 0, 0, 0 0]
We return 0 because we do not need to swap any elements
*/

// idea: 分0在前或后：a). 目标：0在左。 计算有多少1在0之前，就得swap多少次
//                  b). 目标：0在右。 计算有多少0在1之前，就得swap多少次     
public class Main {
    public static int minMoves_01(int[] nums) {
        int count0 = 0, count1 = 0;
        int distZero = 0;// 有多少1在0之前 --> a)
        for(int num : nums){
            if(num == 1){
                count1 ++;
            }else{
                count0++;
                distZero += count1;
            }
        }
        // 已知array中有count1 和count0 个元素，最大交换次数为count0 * count1;
        // 又知道0在左端的交换次数 distZero, 那么0在右端的交换次数 = count0 * count1 - distZero；
        int reverse_distZero = count0 * count1 - distZero;
        // 取最小
        return Math.min(reverse_distZero, distZero);
        
    }
    
    public static void main(String[] args) {
        System.out.println(minMoves_01(new int[]{ 1,0,1,0 }));
        System.out.println(minMoves_01(new int[]{ 1,1,0,1,0 }));
        System.out.println(minMoves_01(new int[]{ 1,0,0,1,0 }));
        System.out.println(minMoves_01(new int[]{ 0,1,1,0,0,1 }));
    }
}

// Time: O(N)
// Space: O(1)
