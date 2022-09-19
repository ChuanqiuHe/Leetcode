// Problem
// https://leetcode.com/discuss/interview-question/1733741/Amazon-OA-or-SDE-Intern/1245814
// You are an amazon delivery and you have some boxes that you have to deliver, but there are some conditions -

// You can take 2 boxes of same weight in one round
// you can take 3 boxes of same weight in one round
// You have to find the minimum number of rounds to deliver the boxes or -1 if it is not possible to deliver them.

// Example cases -
// Input: boxes - [2, 2, 3, 3, 2, 4, 4, 4, 4, 4]
// Output: 4
// Explanation: 3 boxes of weight 2 in 1st round, 2 boxes of weight 3 in 2nd round, 3 boxes of wt 4 in 3rd and 2 boxes of wt 4 in 4th round.

// Input: boxes - [2, 3, 3]
// Output: -1
// Explanation: There is only one box with weight 2 and we can only take either 2 or 3 boxes in one round not lesser.

    // Analytic
        // method1 : Greedy 
        // if n==1 ans =-1
        // if n%3==0 ans =n/3
        // if n%3==2 ans =(n-2)/3+1
        // if n%3==1 ans =(n-4)/3+2

public class Main {
    

    // greedy 
    public static int minimumRounds(int[] nums) {
        int n = nums.length;
        int res =0 ;
        HashMap<Integer, Integer> map = new HashMap<>(); // num, frequency
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // go over the freq 
        for( Map.Entry<Integer, Integer> entry : map.entrySet()){
            int cnt = entry.getValue();
            if(cnt <2) return -1;
            if(cnt%3 == 0) res += cnt/3;
            if(cnt%3 == 2) res +=(cnt-2)/3 +1; // +1 就是余数2，够运一次的
            if(cnt%3 == 1) res +=(cnt-4)/3 +2; // +2 就是2个2，运2次
            
        }
        return res;                          
    }
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int[] arr2 = new int[]{2, 3, 3};
        int[] arr3 = new int[]{2,2,2,2,2,2,2,7,7,7,7};
        int[] arr4 = new int[]{3,3,3,3,3,3,3,3,5,5,5,5,5};
        System.out.println(Main.minimumRounds(arr1));
        System.out.println(Main.minimumRounds(arr2));
        System.out.println(Main.minimumRounds(arr3));
        System.out.println(Main.minimumRounds(arr4));
    }
}


//method 2 dp
        // use hashmap to record frequency,if smaller than 2 return -1;
        // iterate through all frequencies and calculate minimum number of rounds for that frequency.

        // this is similar to minimum number of coins to change the particular value where coins are 2 and 3
        // Let f is the maximum of frequency of any weight and there are c unique weights then
        // Time Complexity: O(max(f, c))
        // Space Complexity: O(f)

//     // dp
//     public static int minimumRounds(int[] nums) {
//         int n = nums.length, res = 0;
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num,0)+1);
//         }
//         int cnt = 0;
//         int[] boxes = new int[]{2,3};
//         for(int v : map.values()){
//             if(v == 1) return -1;
//             res += countRounds(v,boxes);  
//         }
//         return res;
//     }
    
//     public static int countRounds(int amount, int[] boxes) {
//         if(amount < 1) return 0;
//         int n = boxes.length;
//         int[] dp = new int[amount+1];
//         Arrays.fill(dp, amount+1);
//         dp[0]=0;
//         for(int i = 0; i< amount+1;++i){
//             for(int j = 0;j<n;++j){
//                 if(boxes[j] <= i){
//                     dp[i] = Math.min(dp[i], 1+dp[i-boxes[j]]);
//                 }
//             }
//         }
//         return dp[amount]>amount ? -1:dp[amount];
//     }
