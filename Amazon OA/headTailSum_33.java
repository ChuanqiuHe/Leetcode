
// https://coda.io/d/Offer_dm5fzh3MwOp/OA1_suMAY#OA1_tua4n/r10linkedlist
// 每次从头和尾各 去掉一个node直到去掉所有node，求头和尾相加的最大值，O(1) extra space
// 链表题汇集 https://blog.csdn.net/Bruce_0712/article/details/107598682

// Idea: 为了求首尾和： 先将后半段进行翻转；要翻转后半段就需要先找到后半部分划分点，就是middle之后就是后半段； 
                     //再把原先的前半段依次加上翻转的后半部分 ---> 所以先找middle, 再翻转，再相加


public class Main {
    public static int headTailSum(ListNode head) {
        ListNode middle = head;
        ListNode end = head;   
        int max = Integer.MIN_VALUE;
        // 为了翻转后半部分，先找到后半部分的前驱，也就是middle
        while(end !=null && end.next !=null){
            middle = middle.next;
            end = end.next.next;
        }
        // 翻转后半部分
        ListNode pre = null;
        ListNode cur = middle;
        
        ListNode reverseHead = null;
        while(cur != null){
            ListNode next = cur.next;
            // next为null的节点为尾节点（翻转后的头结点一定是原始链表的尾结点）
            if (next == null) reverseHead = cur;
            cur.next = pre;// reverse
            // 指针 pre,cur 后移
            pre = cur;
            cur = next; 
        }
        // add
        ListNode first = head;
        ListNode last = reverseHead;
        while(last !=null){
            int temp = first.val + last.val;
            if(temp >= max){
                max = temp;
                System.out.println(max);
            }
            first = first.next;
            last = last.next;
        }
       return max; 
        
    }
    
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode iterator = dummy;
        iterator.next = new ListNode(1);
        iterator=iterator.next;
        iterator.next = new ListNode(2);
        iterator=iterator.next;
        iterator.next = new ListNode(4);
        iterator=iterator.next;
        iterator.next = new ListNode(9);
        iterator=iterator.next;
        iterator.next = new ListNode(3);
        
        int max = middleNode(dummy);
        System.out.println(max); // {0,1,2,4,9,3} // expect 10
        
    }
}
