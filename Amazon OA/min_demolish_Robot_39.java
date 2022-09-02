// clear robot:
// https://leetcode.com/discuss/interview-question/1257344/amazon-oa-demolition-of-robot
// 最短路线清除目标
// BFS -- Time Complexity： O(m*n), O(m*n)
public class Main {
    public static int min_demolish_Robot_path(int[][] lot) {
        int m = lot.length;
        int n = lot[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        // initial
        queue.offer(new int[]{0,0});
        visited[0][0] = true; // strat from [0,0]
        
        int[][] directions = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
        int minDistance = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow <0 || newRow>=m || newCol <0 || newCol>= n || visited[newRow][newCol] == true || lot[newRow][newCol] == 0){
                        continue;
                    }
                    if (lot[newRow][newCol] == 9){ // if find it
                        minDistance = Math.min(minDistance, lot[row][col]);
                    }
                    if(lot[newRow][newCol] == 1){
                        // update new lot
                        lot[newRow][newCol] = lot[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }  
                }
            }
        }       
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;    
    }

    public static void main(String[] args) {
       int[][]input = new int[][]
                {{1,0,0},{1,0,0},{1,9,1}};
           
         System.out.println(min_demolish_Robot_path(input));  
    }
}
