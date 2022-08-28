// "static void main" must be defined in a public class.
// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r23
// merge intervals
/*
最少merge几个区间, 返回的是int：
function 名字： getNonInclusiveRetailor
Input: [[1,2],[2,3],[3,5],[4,5]]
Output: 1，
[4， 5]  被merge掉了， 所以是结果是1
*/
// Idea : 

public class Main {
    public static int getNonInclusiveRetailor (int[][] intervals) {
        int n = intervals.length;
        // sort
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0] - b[0]);
        int count = 0;
        for(int i = 0; i< n-1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                count++;
            }
        }
        return count;
        
    }
    
    public static void main(String[] args) {
        int[][] arr1 = { {1,2}, {2,3},{3,5},{4,5} };  
        
        System.out.println(getNonInclusiveRetailor(arr1));
        
        int[][][] inputs = new int[][][]{
                {{1,2},{2,3},{3,5},{4,5}},
                {{1,2},{1,2},{3,5},{4,5}},
                {{1,3},{1,2},{2,5},{4,5}},
                {{1,2},{-1,3},{1,3},{3,5}},
            {{1,3},{2,6},{8,10},{15,18}}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(getNonInclusiveRetailor(inputs[i]));
        }
    }
}
