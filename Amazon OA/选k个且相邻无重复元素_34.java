public class Main {
  // 01001 选k个且相邻无重复元素
  // 01234

  // k=2
  // 0 first case
  // [0,1].[2,4],[3,4]
  // 1 first case
  // [1,2] [1,3]

  // k=3
  // 0 first case
  // [0,1,2] [0,1,3]
  // 1 first case
  // [1,2,4] [1,3,4]

  //method1:
  //预处理sequence方法
  //01001
  //[0,1,0,1]
  //[1,1,2,1]
  //表示0出现了一次,1出现了2次等等

  //当k=3时
  //case 1: start with 0
  //1*1*2 说明有2种方法
  //case 2: start with 1
  //1*2*1 说明有2种方法

  //当k=2时
  //case 1: start with 0
  //1*1 +  2*1 = 3
  //case 2: start with 1
  //1*2 =2

    private static int calculate_0_1(String s,int k) {
    if(s.length()<k){ //如果长度没有k大，说明组成不了k个，自然为0
      return 0;
    }
    int size = s.length();
    List<Character> number = new ArrayList<>();
    List<Integer> frequency = new ArrayList<>();
    
    // 先把第一个数填进去
    number.add(s.charAt(0));
    frequency.add(1);

    //O(n) 预处理： 目的就是处理成相邻number不一样，自然选的时候就不同
    for(int i=1;i<size;i++){
      int last = number.size()-1;  // number list里最后一位索引last
      char prev = number.get(last); // pre一直是list里最后的那个字符，以便后续与之比较
      char curr = s.charAt(i);
      if(prev == curr){
        frequency.set(last,frequency.get(last)+1); //set() 方法用于替换动态数组中指定索引的元素。
      }else{
        number.add(curr);
        frequency.add(1);
      }
    }
    //[0,1,0,1]
    //[1,1,2,1]

    //O(n) 统计数据
    int count=0;
    for(int i=0;i<number.size();i++){
        //start with 1 or 0
        int product=1; // 初始值都设为1
        if(i+k>number.size()){ //剪枝
          break;
        }
        for(int j=0;j<k;j++){
          product*=frequency.get(i+j);
        }
        count+=product;
    }
    return count;
  }
    
     public static void main(String[] args) {
        int selection = calculate_0_1("01001",3);
        System.out.println(selection);
    }
    
}
