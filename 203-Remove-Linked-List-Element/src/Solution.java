public class Solution {
    public ListNode removeElements(ListNode head, int val){

        // 一直删除头结点为val的情况
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;

            // 上面三行可以写成： head = head.null;
        }

        // 头结点为空的情况
        if(head == null){
            return null;
        }

        // 删除链表中间的元素
        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;

                // 上面三行可以写成： prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return head;

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}
