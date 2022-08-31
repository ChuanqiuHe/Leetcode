// leetcode 1492
  https://leetcode.com/submissions/detail/788302299/

  class Solution {
    public int kthFactor(int n, int k) {
        int res = -1;
        int cnt = 0;
        for(int i = 1; i<= n; i++){
            if(n % i == 0){
                cnt ++;
            }
            if(cnt == k){
                res = i;
                break;
            }
        }
        return res;
    }
}
