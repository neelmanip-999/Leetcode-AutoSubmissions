class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; 
            } else {
                prev = curr; 
            }
            curr = curr.next;
        }
        return head;
    }
}
