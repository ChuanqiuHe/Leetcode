题目： minimum shipping cost
link ： https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r26 
意思实际是leetcode 2195

 method2:  优化  时间最短， 最好解释
 

// method1:  超时

// class Solution {
//     public long minimalKSum(int[] parcels, int k) {
//       // TLE
//      //  add all elems in nums to set;
//      // start from i=1 to check, if i==num, if not, add; else skip.

//         HashSet<Integer> set = new HashSet<>();
//         for(int num : parcels){
//             set.add(num);
//         }      
//         int i = 1; // start from 1 to check
//         int res = 0;
        
//         while(k>0){
//             if(!set.contains(i)){
//                 res += i;
//                 k--;
//                 set.add(i);
//             }
//             i++;
//         }
        
//       return res;  
//     }
// }

// method2:  优化  时间最短， 最好解释
// class Solution {
//     public long minimalKSum(int[] parcels, int k) {
//       // 计算等差数列的和 【1，k】 
//         // [1,k]中一定有和num重合的，先计数，需要后续补回来的个数。比如重复了3个，后续再补三个
//         // note : 补的时候,从 k+1开始，一直++， 看是否有重复，有重复的，skip。直到补齐k哥数
//         long res = (long)k*(1+k)/2; // 先计算大部分需要补充的数
//         HashSet<Integer> set = new HashSet<>();
//         int need = 0;
//         // res 【1，k】中可能有和num一样的数，去除重复
//         for(int num : parcels){
//             if(!set.contains(num) && num<=k && num>=1){ // check current num happens to be within the range of [1,k], if it is, subtract from res. // !set.contains(num) 假如有两个一样的num 在【1，k】区间，只重复一次，那么只能减一次，避免重复减。
//                 res = res - (long)num;
//                 need ++;  
//             }
//             set.add(num);
//         }
        
//         int start = k+1;
//         while(need>0){
//             if(!set.contains(start)){
//                 res +=start;
//                 need--;
//             }
//             start++;
//         }
//         return res;
//     }
// }

// method3

class Solution {
    public long minimalKSum(int[] parcels, int k) {
       Arrays.sort(parcels);
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        // 把在【1，k】区间内的num加和，且重复一个，k就要+1补一个。
        for(int num : parcels){
            if(!set.contains(num) && num<=k ){ // check current num happens to be within the [1,k] ; !set.contains(num) 避免检测出重复的，重复加
                k++;
                sum +=num;
            }
            set.add(num);
        }
        
       long res = (long)k*(k+1)/2 - sum;
        return res;
    }
}
/*
直接计算 1~k 闭区间的和代表添加的数字的和。
如果中间有 x 个元素在 nums 中出现过，代表需要额外再添加 x 个元素，计算闭区间 1~k+x 的和，最后再减去 nums 中出现过的 x 个元素。
我们需要先对数组去重，再从小到大判断是不是 1~k 内出现的元素。

作者：mochi-ds
链接：https://leetcode.cn/problems/append-k-integers-with-minimal-sum/solution/zhi-xin-meng-nan-jian-dan-tan-xin-xi-jie-bkio/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
