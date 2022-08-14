 题目： https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r12
 
 // "static void main" must be defined in a public class.
public class Main {
    public static int findEaliestMonth_11 (int[] stockPrice) {
        // idea : presum
        // 1) cal overall sum of array
        // 2) cal presum and preave, at the same time, get postave.
        //    get abs of preave and postave;
        // 3) update min,once min get updated, we need to update the result index i; 
        //    then output the final res index. 
        int n = stockPrice.length;
        
        int min = Integer.MAX_VALUE;
        int res = -1;
        // cal overall sum
        int sum = 0;
        for(int i = 0; i< n; i++){
            sum += stockPrice[i];
        }
        
        int presum = stockPrice[0];
        for(int i = 1; i<n; i++){       
            int preave = presum/i;
            int postave = (sum-presum)/(n-i);
            
            int dif = Math.abs(preave-postave);
            if(dif < min){// update min
               min = dif;
               res = i; 
            }
            
            presum += stockPrice[i];
        }     
        return res;    
    }
    
    public static void main(String[] args) {
        int[] test1 = {1,3,2,3};
        System.out.println(findEaliestMonth_11(test1));
    }
}


// 其他人的答案： https://leetcode.com/playground/bNVFkLZm
