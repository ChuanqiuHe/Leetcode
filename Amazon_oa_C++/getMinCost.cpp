/*method1 
Question: Amazon ships millions of packages regularly. There are a number of parcels that need to be shipped. Compute the minimum possible sum of transportation costs incurred in the shipment of additional parcels in the following scenario.

A fully loaded truck carries k parcels.

It is most efficient for the truck to be fully loaded.

There are a number of parcels already on the truck as listed in parcels

There are parcels with a unique id that ranges from 1 through infinity.

The parcel id is also the cost to ship that parcel.

Given the parcel IDs which are already added in the shipment, find the minimum possible cost of shipping the items added to complete the load....

类似 leetcode 2195
觉得这题就是思维 + 贪心
nums里面重复的元素可以剔除，这样并不会影响答案
我们先选择(1到k)一共k个数的和作为答案
但(1到k) 中的数可能在nums里面存在
那我们就这个重复的数加起来， 让后面多的一个坑即 k + 1
最后利用高斯求和公式把1 ~ k 的数用 O(1) 的时间加起来 再减去重复的
主要开销来源于排序 所以复杂度取O(nlogn)

作者：do_hard_problems
链接：https://leetcode.cn/problems/append-k-integers-with-minimal-sum/solutions/1314662/zhe-ti-bi-sai-de-shi-hou-zhen-shi-zhe-mo-bor8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


so for this question, 
first, calculate how many space left(n) in k 
second, if parcels[i] not in [1~k]
        sum += parcels[i]



*/
class Solution{
    public:
    int getMinCost(vector<int> & parcels, int k){
        // corner case
        if (parcels.size() == 0 || k == 0 || k == parcels.size()) {
            return 0;
        }
        // how many parcels we need to load
        int n = k - parcels.size();
        
        int sum = 0;
        for(int start = 1; start <= n; start++){
            if(count(parcels.begin(), parcels.end(), start) == 0){
                sum += start;
            }else{
                n++;
            }
        }
        
        return sum;     
    }   
};

int main(){
    Solution s;
    vector<int> vec = {2,3,6,10,11};
    int k = 9;
    int res = s.getMinCost(vec, k);
    
    
    cout << "res = "<< res <<endl;
    
    return 0;
}




/*
method2: hash
*/

#include <iostream>
#include <vector>
#include <unordered_set>

class ParcelTruck {
public:
    int minCost(const std::vector<int>& parcels, int k) {
        // corner case
        if (parcels.empty() || k == 0 || k == parcels.size()) {
            return 0;
        }
 
        int additionalCount = k - parcels.size(); // more parcels needs to be carried
 
        // add existing parcels to the set
        std::unordered_set<int> set;
        for (int parcel : parcels) {
            set.insert(parcel);
        }
 
        int start = 1;
        int sum = 0;
 
        while (additionalCount > 0) {
            if (set.count(start) == 0) { // if we haven't added current one
                sum += start; // load to truck, update the sum
                additionalCount--; // decrement the more packages we needed
            }
            start++;
        }
        return sum;
    }
};
 
int main() {
    std::vector<int> parcels = {2, 3, 6, 10, 11};
    ParcelTruck test;
 
    std::cout << test.minCost(parcels, 9) << std::endl;
    return 0;
}
