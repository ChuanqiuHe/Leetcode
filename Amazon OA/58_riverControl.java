// position = rowIdx * rowLength + colIdx

https://curly-oriole-764.notion.site/22ec8523c820410490092ace51489509?v=a65d5dfe1dae443385cd3bbd0aa3ce9a&p=1b30b5bbd490436dbe44a1b5e67baa0c&pm=s

（根据指令上下左右移动，返回最终位置）

// "static void main" must be defined in a public class.
public class RoverControl {
    
    public static int position(String[] cmds, int n) {
        int row = 0;
        int col = 0;
        for(String s: cmds) {
            if(s.equals("LEFT")) {
                if(col > 0) {
                    col = col - 1;
                }
            } else if(s.equals("RIGHT")) {
                if(col < n - 1) {
                    col = col + 1;
                }
            } else if(s.equals("UP")) {
                if(row > 0) {
                    row = row - 1;
                }
            } else {
                if(row < n - 1) {
                    row = row + 1;
                }
            }
        }
        return (row * n) + col;
    }
    
    
    public static void main(String[] args) {
        RoverControl rv = new RoverControl();
        rv.test1();
        rv.test2();
    }
    public void test1() {
        String[] cmds = new String[]{"RIGHT","UP","DOWN","LEFT","DOWN","DOWN"};
        int n = 4;
        System.out.println(position(cmds, n));
    }
    public void test2() {
        String[] cmds = new String[]{"RIGHT"};
        int n = 1;
        System.out.println(position(cmds, n));
    }
}
