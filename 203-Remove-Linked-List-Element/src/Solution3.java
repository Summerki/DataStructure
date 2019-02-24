public class Solution3 {
    public ListNode removeElements(ListNode head, int val){
        // 最终子问题
        if(head == null){
            return null;
        }

        ListNode res = removeElements(head.next, val); // 将头结点后面跟的链表中包含val的值删除后得到的链表
        if(head.val == val){
            return res;
        }else{
            head.next = res;
            return head;
        }

        /*
        可以简写为：
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
        */
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}
