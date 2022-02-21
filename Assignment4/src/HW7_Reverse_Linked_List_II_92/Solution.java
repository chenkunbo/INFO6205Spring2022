package HW7_Reverse_Linked_List_II_92;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode current_node = head;

        while(left > 1){
            prev = current_node;
            current_node = current_node.next;
            left --;
            right --;
        }

        ListNode connection = prev;
        ListNode tail = current_node;

        while(right > 0){
            ListNode next_node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next_node;
            right --;
        }

        if(connection != null){
            connection.next = prev;
        }
        else{
            head = prev;
        }

        tail.next = current_node;
        return head;
    }

}
