 // https://leetcode.com/discuss/interview-experience/1470686/amazon-online-assessment
 // 安装router

、、Time complexity of update here is improved to O(1).
// 自己idea: 先计算每个building能得几个router辐射，形成一个数组； 再把这个数组和原来buildingCount进行比较，如果辐射数大于等于buildingCount里的人数，那么就是可以。


public class Main {
    
    public static int buildingRouter_serve(int[] buildingCount, int[] routerLocation, int[] routerRange){
        int serveCnt = 0;
        // Create and fill difference Array
        // We use one extra space because
        // update(l, r, x) updates D[r+1]
        int[] serve = new int[buildingCount.length+1];
        
        // 根据int[] routerLocation, int[] routerRange计算serve array
        // routerLocation, routerRange是等长的
        // for each router, update left and right edge
        for(int i = 0; i < routerLocation.length; i++){
            int leftRange = Math.max(i - routerRange[i], 0);
            int rightRange = Math.min( buildingCount.length - 1, i + routerRange[i]);
            serve[leftRange] +=1;
            serve[rightRange + 1] -= 1;
            
        }
        
        // prefix sum
        for(int i = 1; i< buildingCount.length; i++){
            serve[i] += serve[i-1];
        }
        // compare
        for(int i = 0; i < buildingCount.length; i++){
            if(serve[i] >= buildingCount[i]){
                serveCnt++;
            }
        }
       return serveCnt;
    }
    
     public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 2, 2};
        int[] arr2 = {3, 1};
        int[] arr3 = {1, 2};
        System.out.println(buildingRouter_serve(arr1, arr2, arr3));
    }   
}

/*

    
/*
//第一题，给building配发router，
//给一个buildingCount array ，每个element代表一个building，上面的value代表这个building的人数，【1，4，2，3，2】就是第一个building有一个人，第二个有4个人，第三个有两个人...
//第二个array 叫 routerLocation， 每个element代表router在哪个building，eg【3，1】就是说第一个router在building3，第二个在building1
//第三个array叫router Range 里面代表那个router能辐射的范围。【2，3】第一个router能辐射前后两个building，如果它位于building3，那么就是1，2，3，4，5 都可以覆盖到。
//条件是，每个building被辐射的router的数量必须大于等于人数才能算能serve。问有几个building能被serve

// This can be solved with simple count array. Like for each router - increment count [ left boundary ] by one and decrement count [ right boundary + 1 ] by 1.
// Then do simple prefix sum of count array and compare with each building people count - see if it's more than enough then increment answer by one.
// This one is a normal easy to medium-ish atmost problem. ( No need for segment trees - O(log n) - even though complexity will be O(n) here - since 10^6 can be solved fine in given constraints)

*/
