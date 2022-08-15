// 题目：https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a
 题目详述： https://chowdera.com/2022/04/202204061315129900.html

/*

Array damage It is given. , It means that the points of blood loss in each level have been determined , 
Therefore, the total blood loss related to breaking through is also fixed, that is, array and , 
If not equipped , Then the blood needed at the beginning is the sum of the array plus 1. 
Now I have a blood replenishing equipment in my hand , Of course, I want to replenish blood as much as possible , 
It's better to fill up armor, In order to achieve this goal , Of course, you should use equipment on the level that loses the most blood . 
If the level that loses the most blood loses more blood than armor, Then you can fill up armor; 
If the level that loses the most blood loses less than armor, Then lose as much blood and make up as much .
*/
、、、为了把补血包尽可能多用，就要在遇到最大伤害值的时候用掉（两者取min）、、、
// list<>解法 : https://leetcode.com/playground/DFo4yDzt 
// https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=630bfaa7f2b84e5dbacd002253dc1b90&pm=s

// "static void main" must be defined in a public class.
public class Main {
    public static int minHealth_12(int[] damage, int armor) {
        int sum = 0;
        int maxblood = Integer.MIN_VALUE;
        for(int blood : damage){
            sum += blood;
            maxblood = Math.max(maxblood, blood);
        }
        
        return sum +1 - Math.min(maxblood, armor) ;
    }
    
    
    public static void main(String[] args) {
        int[] damage1 = {2,7,4,3};
        int armor1 = 4;
        
        int[] damage2 = {2,5,3,4};
        int armor2 = 7;
        
        int[] damage3 = {3,3,3};
        int armor3 = 0;
        System.out.println(minHealth_12(damage1, armor1));
        System.out.println(minHealth_12(damage2, armor2));
        System.out.println(minHealth_12(damage3, armor3));
    }
}

