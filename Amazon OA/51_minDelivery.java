// "static void main" must be defined in a public class.
// Problem description : https://leetcode.com/discuss/interview-question/1733741/Amazon-OA-or-SDE-Intern

/* Idea: count the frequency of each weight: map
 1) freq ==1, return -1;
 2) freq==2 || 3, cnt ++; 
 )3 freq>3 , freq%3 ==0? freq/3 : freq/3+1;
 
 O(1)
 */
//和42一样，这是自己的做法

public class Main {
    public static int minDelivery(int[] boxes) {
        if(boxes.length <=1) return -1;
        // build weight frequency set : <weight, frequency>
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int weight: boxes){
            map.put(weight, map.getOrDefault(weight,0)+1);
        }
        
        // check the frequency and count
        int count = 0;
        for(Integer freq: map.values()){
            if(freq == 1){
                return -1;
            }else if(freq ==2 || freq == 3 ){  // one round for these two cases
                count ++;
            }else if(freq >3){ // take the min interger of( greater and equal to freq/3), kind of round up:[2.3] = 3
                count += (freq%3 == 0)? freq/3: freq/3+1;
            }
        }
       return count; 
    }
    
    public static void main(String[] args) {
        int[] box0 = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4, 4};
        int[] box1 = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int[] box2 = {2, 3, 3};
        int[] box3 = {3, 2, 2};
        int[] box4 = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4, 4, 4};
        
        System.out.println(Main.minDelivery(box0));
        System.out.println(Main.minDelivery(box1));
        System.out.println(Main.minDelivery(box2));
        System.out.println(Main.minDelivery(box3));
        System.out.println(Main.minDelivery(box4));
        
    }
}
