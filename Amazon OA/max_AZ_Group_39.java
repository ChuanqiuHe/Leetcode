 // https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r17
 // String在任意位置添加字符，组成多少个AZ

// how to get the max possible: 
    
/*
A肯定要加在开头才能尽可能多的和后面的Z组成AZZ肯定要加在最后才能尽可能多的和前面的A组成AZ所以要比较的就是A+string和string+Z两种情况然后就是数有多少个AZ从前往后遍历新的string每遇到一个Z这个Z就能和前面n个A组成n个AZ所以就是要记录到这个Z为止总共有多少个A就行了
*/


// Time complexity: O(n), Space complexity: O(1)

public class Main {
    
    public static int max_AZ_Group(String s){
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        String As = "A" + s;
        String sZ = s + "Z";
        // 求这两个新string组成AZ的大小
        return Math.max(helper(As), helper(sZ));
    }
    
    public static int helper(String s){
        int countAZ = 0;
        int countA = 0;
        for(Character ch : s.toCharArray()){
            if(ch == 'A') countA++;
            if(ch == 'Z') countAZ += countA;
                
        }
       return countAZ; 
    }
    
     public static void main(String[] args) {
        String s1 = "AKZ";
        String s2 = "A";
        String s3 = "ZZZZA";
        String s4 = "ZZZZAZZZZZZ"; 
        System.out.println(max_AZ_Group(s1));
        System.out.println(max_AZ_Group(s2));
        System.out.println(max_AZ_Group(s3));
        System.out.println(max_AZ_Group(s4));
    }   
}
