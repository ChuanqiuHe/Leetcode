/*
https://leetcode.com/discuss/interview-question/1232637/amazon-fulfillment-builder-amazon-oa-help
*/

// https://leetcode.com/playground/Z4ygyGZY
// "static void main" must be defined in a public class.
// o(nlogn) , o(n)
import java.util.*;

public class Main {
    public static int Mintime(int[] parts) {
        if(parts.length == 1) return parts[0];
        
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
        int[] test1 = {8,4,6,12};
        int[] test2 = {9,10};
        int[] test3 = {9};
        int[] test4 = {9,10,10,0,11};
        
        System.out.println(new Main().Mintime(test1));
        System.out.println(new Main().Mintime(test2));
        System.out.println(new Main().Mintime(test3));
        System.out.println(new Main().Mintime(test4));
    }
}


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


