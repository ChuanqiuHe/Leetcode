// "static void main" must be defined in a public class.

/*
findmaxpasswordstrength一个密码段如果同时含有至少一个元音和一个辅音称这个密码是strong的给定一个密码问这个密码的强壮度（每含有上述一个密码段强壮度+1）
input"thisisbeautiful"
output6
explain:thi si sbe aut iful
*/

// idea: 初始值把元音，辅音都设置为false，都为true时，加1；此时，把它们又重置为false；开启新的一轮。
     
public class Main {
    public static int max_password_len(String s) {
        int res = 0;
        boolean vowel = false, consonant = false;
        for(char ch : s.toCharArray()){
            if(ch == 'a' ||ch == 'o' ||ch == 'e' ||ch == 'i' ||ch == 'u' ){
                vowel = true;
            }else{
                consonant = true;
            }
            
            if(vowel &&consonant){
                res++;
                //重置,开启新一轮
                vowel = false;
                consonant = false; 
            }   
        }
        
      return res;  
    }
 
    
    public static void main(String[] args) {
        String s1 = "thisisbeautiful";
        System.out.println(max_password_len(s1));
        
        String s2 = "iloveyou";
        System.out.println(max_password_len(s2));
        
        String s3 = "bbaass";
        String c = "c";
        System.out.println(max_password_len(s3));
        System.out.println(max_password_len(c));
        
    }
}

