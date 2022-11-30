#include <iostream>

using namespace std;

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
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        if (list1 == nullptr)
            return list2;
        if (list2 == nullptr)
            return list1;
        ListNode *list3_head = nullptr, *list3_tail = nullptr;
        ListNode *temp;
        while (list1 && list2)
        {
            if (list1->val <= list2->val)
            {
                temp = list1;
                list1 = list1->next;
            }
            else
            {
                temp = list2;
                list2 = list2->next;
            }
            temp->next = nullptr;
            if (list3_tail != nullptr)
            {
                list3_tail->next = temp;
                list3_tail = temp;
            }
            else
            {
                list3_head = list3_tail = temp;
            }
        }

        while (list1)
        {
            list3_tail->next = list1;
            list3_tail = list1;
            list1 = list1->next;
        }

        while (list2)
        {
            list3_tail->next = list2;
            list3_tail = list2;
            list2 = list2->next;
        }

        return list3_head;
    }
};

int main()
{
    Solution solution;
    ListNode *l1, *l2;
    l1 = new ListNode(1, nullptr);
    l1->next = new ListNode(2, nullptr);
    l1->next->next = new ListNode(4, nullptr);

    l2 = new ListNode(1, nullptr);
    l2->next = new ListNode(3, nullptr);
    l2->next->next = new ListNode(4, nullptr);

    solution.mergeTwoLists(l1, l2);
    return 0;
}
