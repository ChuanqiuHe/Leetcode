
// number of distinct subarrays with at most k odd numbers 
// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r15

// Idea: hashSet for distinct subarray, slidewindow for subarray

public class Main {
    public static int distinctSubarraysAtMostKOdd(int[] nums, int k) {
        HashSet<String> distinctSubarray = new HashSet<>();
      
        for(int i = 0; i< nums.length; i++){ // shrink, left
            StringBuilder sb = new StringBuilder();
            int cntOdd = 0;
            for(int j = i; j< nums.length; j++){ // expand,  right
                if(nums[j] % 2 == 1) cntOdd++;
                if(cntOdd > k) break;
                sb.append(nums[j]);
                //sb.append("[").append(nums[j]).append("],"); //不用加括号之类的感觉
                distinctSubarray.add(sb.toString());  // 只要不break， 每次都能形成一个新subarray
            }       
        }
       return distinctSubarray.size(); 
    }
    
    public static void main(String[] args) {
        System.out.println(distinctSubarraysAtMostKOdd(new int[] {3, 2, 3, 2}, 1)); // expected: 5
        System.out.println(distinctSubarraysAtMostKOdd(new int[] {3, 2, 3, 4}, 1)); // expected: 7
        System.out.println(distinctSubarraysAtMostKOdd(new int[] {3, 2, 3, 4}, 2)); // expected: 9
    }
}
