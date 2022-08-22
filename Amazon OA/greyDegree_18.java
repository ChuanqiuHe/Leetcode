// "static void main" must be defined in a public class.

// description: https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=46ae61ad0ee04a31b8e4fe623694f23a&pm=s

/*
给一个2D array，array[i][j]表示在(i, j)点处的灰度值，0为白1为黑，(i, j)处的灰度值为第i行所有点灰度值 + 第j列所有点灰度值之和 （黑+1，白-1），求array中灰度值最大的点的灰度值为多少，两层for 循环分别求出colsGrey[]和 rowsGrey[]然后再遍历一遍求max即可
*/

public class Main {
    public static int greyDegree_18(String[] grid) {
        // there are only lowercase letters, so count freq using array with 26 size
        int[] greyRow = new int[grid.length] ;
        int[] greyCol = new int[grid[0].length()] ;
        
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length();j++){
                if(grid[i].charAt(j) == '1'){
                    greyRow[i] += 1;
                    greyCol[j] += 1;
                }else{
                    greyRow[i] -= 1;
                    greyCol[j] -= 1;
                }
            }  
        }
        
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for(int r : greyRow){
            maxRow=Math.max(maxRow,r);
        }
         for(int c : greyCol){
            maxCol=Math.max(maxCol,c);
        }
        
        return maxRow + maxCol;
    }
    
    public static void main(String[] args) {
        String[] test1 = {"1101", "0101", "1010"};  
        String[] test2 = {"101", "110", "111"};
        String[] test3 = {"1001", "0111", "0001"};
        System.out.println(greyDegree_18(test1));
        System.out.println(greyDegree_18(test2));
        System.out.println(greyDegree_18(test3));
    }
}
