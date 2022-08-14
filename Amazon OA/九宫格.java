// "static void main" must be defined in a public class.
// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r5

// idea: greedy: cal frequency of each character and sort;
// put the most char at first grid, second most char at second grid...
// 
public class Main {
    public static int minClicksRepresentString_9(String s) {
        int res = 0;
        // count the freq using bucket
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a'] +=1;
        }
        
        // sort the array , most freq char at the end
        Arrays.sort(freq);
        // so traverse the freq array from end to begin 
        // 频率最高的九个字母分别占据每个格子的第一个位置，即[0-8]高频率字母 占据 第一的位子；
        //第 [9-17]名频率 的字母占据第二的位置（可以不考虑占据哪个格子， 只考虑占据第一，第二还是第三的位置即可）
        // res =  character‘s freq * (which digit(3 in total) the character is located)
        for(int i = 25; i>=0; i--){ // 从高频字母开始，所以倒序
            res += freq[i]*((25-i)/9+1); // 
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "abcdefghoo";
        String s3 = "abcdefghioo";
        System.out.println(minClicksRepresentString_9(s1));
        System.out.println(minClicksRepresentString_9(s2));   
        System.out.println(minClicksRepresentString_9(s3));
        
        System.out.println(minClicksRepresentString_9("abcdefghijklmnopqrstuvwxyz")); // 9 + 18 + 24 = 51
        System.out.println(minClicksRepresentString_9("aaabbbcccddd")); // 3 * 4
    }
}

/*
5
10
12
51
12
*/
