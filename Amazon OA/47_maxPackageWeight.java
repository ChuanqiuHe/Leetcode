/* 
Consider n packages , where packageWeights[i] represents the weight of the i th package, You can combine i th and i+1 th pacage if packageWeights[i] <packageWeights[i+1] and then discard the i th package. After this operation number of packages reduces by 1 and weight of i+1 th package increases by packageWeights[i]. You can merge as many times as you want.
Find the max possible weight of the package that can be achieved after any sequence of merge operations
Eg packageWeights =[2,9,10,3, 7]
optimal order:
iteration 1 combine packages at index 2 and 3 ->new packageWeights =[2,19,3,7]
iteration 2 combine packages at index 1 and 2 ->new packageWeights =[21,3,7]
iteration 3 combine packages at index 2 and 3 ->new packageWeights =[21,10]
return 21

*/

https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r33

// IDEA:  sliding window (descending from rignt to left), 从后往前merge,不断更新 arr[right-1]和res


public class Main {
    public static int maxPackageWeight(int[] arr) {
        if (arr.length <= 1) return arr.length == 0 ? 0 : arr[0];
        int n = arr.length;
        int right = n-1;
        
        
        int res = 0;
        int sum = 0;
        while(right > 0){
            while(right >0 && arr[right] <= arr[right-1]){ //不符合条件的，就一直往前移动指针
                right--;
            }
            while(right > 0 && arr[right] > arr[right-1]){
                arr[right-1] += arr[right]; // update left one
                res = Math.max(res, arr[right-1]);
                right--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,9,10,3, 7};
        int[] arr2 = new int[]{};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{2,2,4,9,9,1,4};
        System.out.println(maxPackageWeight(arr1));
        System.out.println(maxPackageWeight(arr2));
        System.out.println(maxPackageWeight(arr3));
        System.out.println(maxPackageWeight(arr4));
    }
}
