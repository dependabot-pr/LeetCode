class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        counts = 0
        stack = []
        dummy = ListNode(0)
        pre = dummy
        while head:
            counts += 1
            if counts < m:
                pre.next = head
                pre = pre.next
            elif counts >=m and counts <=n:
                stack.append(head)
            else:
                break
            head = head.next

        while stack:
            pre.next = stack.pop()
            pre = pre.next
        pre.next = head

        return dummy.next
