// "static void main" must be defined in a public class.
// description:   https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=f8093109aeaf47e3899273f2ad6e21c2&pm=s
// 其他解法： https://leetcode.com/playground/ZWWPkvvR

// Idea: 先记录原位置（set）; 再移除from, 加入to;
//       最后sort结果
public class Main {
    public static int[] moveDataLocation_16(int[] locations, int[] from, int[] to) {
        HashSet<Integer> location = new HashSet<>();
        for(int loc : locations){
            location.add(loc);
        }
        
        // remove from[i], add to[i]
        
        for(int i = 0; i< from.length; i++){
            location.remove(from[i]);
            location.add(to[i]);
        }
        
        // final res
        int[] res = new int[locations.length];
        int i =0;
        for(int loc: location){
            res[i] = loc;
            i++;
        }
        
        Arrays.sort(res);
      
        return res;
    }
    
    
    public static void main(String[] args) {
        int[] loc1 = {1,7,6,8};
        int[] from1 ={1,7,2};
        int[] to1 ={2,9,5};
        int[] res = moveDataLocation_16(loc1, from1,to1);
        for(int loc : res){
             System.out.println(loc);
        }
        
    }
}
