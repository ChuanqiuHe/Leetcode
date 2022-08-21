// "static void main" must be defined in a public class.
// description:   https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=10077d355be9474486b8ac8b842f079e&pm=s
/*
其他链接： https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=10077d355be9474486b8ac8b842f079e&pm=s
*/

// Idea: 用两个counter统计s和t的字母出现频率，然后遍历t的所有字母，找到s中出现次数/t中出现次数的最小值（向下取整）

public class Main {
    public static int countMaxOperations_14(String s, String t) {
        // cuz s, t only contain lowercase letter, so new[26]
        int[] freq_s = new int[26];
        int[] freq_t = new int[26];
        for(char ch : s.toCharArray()){
            freq_s[ch-'a'] +=1;
        }
        for(char chr : t.toCharArray()){
            freq_t[chr-'a'] +=1;
        }
        
        int minOccur = Integer.MAX_VALUE; // i.e. MaxOperations
        // traverse all letters in t
        for(char ch : t.toCharArray()){
            minOccur = Math.min(minOccur, freq_s[ch-'a']/freq_t[ch-'a']);
        }
        return minOccur;
        
    }
    
    
    public static void main(String[] args) {
        String s1 = "mononom", t1 = "mon";
        System.out.println(countMaxOperations_14(s1, t1));
        
        System.out.println(countMaxOperations_14("fafeggeddefgfgef", "fg"));
        System.out.println(countMaxOperations_14("fafeggeddefgfgef", "efg"));
        System.out.println(countMaxOperations_14("fafeggeddefgfgef", "fe"));
    }
}
