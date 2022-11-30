/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

#include <iostream>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
    ListNode *getReversedList(ListNode *head)
    {
        ListNode *temp;
        while (head)
        {
            auto n = new ListNode(head->val);
            n->next = temp;
            temp = n;
            head = head->next;
        }
        return temp;
    }

public:
    int getLength(ListNode *head)
    {
        int length = 0;
        while (head)
        {
            length++;
            head = head->next;
        }
        return length;
    }

    ListNode *reverseList(ListNode *head)
    {
        ListNode *prev = nullptr, *curr = head, *next = nullptr;
        while (curr)
        {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    bool isPalindrome(ListNode *head)
    {
        if (!head || !head->next)
            return true;
        int count = getLength(head);
        int rp = (count + 1) / 2;

        ListNode *temp = head;
        while (rp--)
            temp = temp->next;
        temp = reverseList(temp);
        // 1 2 3 4
        // 1 2 3 4 5
        while (head && temp)
        {
            if (head->val != temp->val)
                return false;
            head = head->next;
            temp = temp->next;
        }
        return true;
    }

    bool isPalindrome11(ListNode *head)
    {
        if (!head)
            return true;
        ListNode *reversed_head = getReversedList(head);
        while (reversed_head && head)
        {
            if (reversed_head->val != head->val)
                return false;
            reversed_head = reversed_head->next;
            head = head->next;
        }
        return true;
    }
};

int main()
{
    Solution solution;
    ListNode *l1, *l2;
    l1 = new ListNode(1);
    l1->next = new ListNode(2);
    l1->next->next = new ListNode(2);
    l1->next->next->next = new ListNode(1, nullptr);

    auto ans = solution.isPalindrome(l1);
    cout << ans << endl;
}
