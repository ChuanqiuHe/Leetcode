/*
https://leetcode.com/discuss/interview-question/1232637/amazon-fulfillment-builder-amazon-oa-help
*/

import java.util.*;

class Main {
    public int Mintime(int[] parts) {
        int n = parts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        for(int i = 0; i< n; i++){
            pq.offer(parts[i]);
        }
        // calculate
        int sum = 0;
        while(pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b);
            sum +=  a+b;

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] parts = {8,4,6,12};

        int res = new Main().Mintime(parts);
        System.out.println(res);
    }
}
