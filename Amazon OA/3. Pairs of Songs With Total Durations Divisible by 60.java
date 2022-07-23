// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

// https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/li-yong-qu-mo-te-xing-ji-shu-by-zhouziho-2b43/
/*
整数对60取模，可能有60种余数。故初始化一个长度为60的数组，统计各余数出现的次数。[0,59]
把动态的东西化为静态：（数组长度固定在60）
*/
class Solution {
 public int numPairsDivisibleBy60(int[] time) {
      // 统计每个余数值（0-59）出现的个数。
        int[] seconds = new int[60];
        int res = 0;
        for(int t : time) {
            int i = 60 - t % 60;// 待找余数i
            res += seconds[ i == 60 ? 0 : i];
            // 统计原数组的余数的个数
            seconds[t % 60] += 1;
        }
        return res;
    }
}
/*
# 整数对60取模，可能有60种余数。故初始化一个长度为60的数组，统计各余数出现的次数。遍历time数组，每个值对60取模，并统计每个余数值（0-59）出现的个数。注意一定要先累计，再添加到统计数组中。这样做的正确性很好理解：第一次遇到一个余数时，是无法凑成歌曲对的。以后每次遇到一个特定余数时，都能和所有对应余数的歌曲形成新的歌曲对.


res += seconds[ i == 60 ? 0 : i];
seconds[t % 60] += 1;
 //累计符合条件的组合数。注意一定要先累计，再添加。这样做的正确性很好理解：第一次遇到一个余数时，是无法凑成歌曲对的。以后每次遇到一个特定余数时，都能和所有对应余数的歌曲形成新的歌曲对。这也是为什么，res要累计当前所有对应余数的歌曲数量。     
*/
