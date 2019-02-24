public class Solution2
{
    public ListNode removeElements(ListNode head, int val){

        // 创建一个虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 删除链表中指定的元素
        ListNode prev = dummyHead;
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

        return dummyHead.next;

    }
}
