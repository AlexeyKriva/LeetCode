import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head.next != null) {
            listNodes.add(head);
            head = head.next;
        }
        listNodes.add(head);
        int ind = listNodes.size() - n;
        listNodes.remove(ind);
        if (listNodes.isEmpty()) {
            return null;
        } else if (listNodes.size() == 1) {
            return new ListNode(listNodes.getFirst().val);
        } else {
            head = new ListNode(listNodes.getFirst().val);
            ListNode listNode = new ListNode(listNodes.get(1).val);
            head.next = listNode;
            for (int i = 2; i < listNodes.size(); i++) {
                listNode.next = new ListNode(listNodes.get(i).val);
                listNode = listNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode listNode = new ListNode(7);
        head.next = listNode;
        List<Integer> nums = new ArrayList<>(Arrays.asList(9, 3, 5, 8, 0));
        for (int i = 0; i < 5; i++) {
            listNode.next = new ListNode(nums.get(i));
            listNode = listNode.next;
        }
        System.out.println(removeNthFromEnd(head, 1));
    }
}