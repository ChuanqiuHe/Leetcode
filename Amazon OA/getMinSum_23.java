// "static void main" must be defined in a public class.
// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY
// 给一组数组, 删掉k个连续元素, 问剩下最小的和是多少? https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=342055cf41fa49b5b7d8af3ac7de2d6f&pm=s

// 意思就是求k个连续数组的最大和，这样保证剩下的和最小
// Idea : use two pointer: slidewindow

public class Main {
    public static int getMinSum (int[] A, int k) {
        int n = A.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(right < n){
            //expand window
            while(right - left<k){
                sum += A[right];
                right++;
            }
            if(sum >= max){
                max = sum; 
            }
            // shrink the window
            sum -= A[left];  
            left++;
        }
        
        // totalSum
        int totalSum = 0;
        for(int num : A){
            totalSum += num;
        }
        return totalSum - max;
    }
    
    public static void main(String[] args) {
        int[] arr1 = { 6, 2, 1, 9, 8 };  // 6+2+1 = 9
        int[] arr2 = { 7, 3, 6, 1 };  // 6+1 = 7
        int[] arr3 = { 1, 4, 4, 6, 9, 4 }; // 1+4+4+4 = 13
        System.out.println(getMinSum(arr1, 2));
        System.out.println(getMinSum(arr2, 2));
        System.out.println(getMinSum(arr3, 2));
    }
}


//  optimize: calculate the totalsum while get subSum.

public class Main {
    public static int getMinSum (int[] A, int k) {
        int n = A.length;
        int left = 0;
        int right = 0;
        int totalSum = 0; //  optimize: calculate the totalsum while get subSum.
        int subsum = 0;
        int max = Integer.MIN_VALUE;
        while(right < n){
            //expand window
            while(right - left<k){
                subsum += A[right];
                totalSum += A[right];
                right++;
            }
            if(subsum >= max){
                max = subsum; 
            }
            // shrink the window
            subsum -= A[left];  
            left++;
        }
        
        // totalSum
        // int totalSum = 0;
        // for(int num : A){
        //     totalSum += num;
        // }
        return totalSum - max;
    }
    
    public static void main(String[] args) {
        int[] arr1 = { 6, 2, 1, 9, 8 };  // 6+2+1 = 9
        int[] arr2 = { 7, 3, 6, 1 };  // 6+1 = 7
        int[] arr3 = { 1, 4, 4, 6, 9, 4 }; // 1+4+4+4 = 13
        System.out.println(getMinSum(arr1, 2));
        System.out.println(getMinSum(arr2, 2));
        System.out.println(getMinSum(arr3, 2));
    }
}


// 别人的解法

// 给一组数组，删掉连续k个元素，求剩下的最小和
// Sliding window 转化成求k个连续的最大和
// time On
// space O1
public class Main {
    public static int delete_process_to_free_memo(int[] arr, int k) {
        int maxSum = 0;
        int sum = 0;
        int total = 0;
        int left = 0, right = 0;

        while (right < arr.length) {
            total += arr[right];
            sum += arr[right];

            if (right >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return total - maxSum;
    }
    
    public static void main(String[] artg) {
        int[] arr1 = { 6, 2, 1, 9, 8 };  // 6+2+1 = 9
        int[] arr2 = { 7, 3, 6, 1 };  // 6+1 = 7
        int[] arr3 = { 1, 4, 4, 6, 9, 4 }; // 1+4+4+4 = 13
        System.out.println(delete_process_to_free_memo(arr1, 2));
        System.out.println(delete_process_to_free_memo(arr2, 2));
        System.out.println(delete_process_to_free_memo(arr3, 2));
    }
}
