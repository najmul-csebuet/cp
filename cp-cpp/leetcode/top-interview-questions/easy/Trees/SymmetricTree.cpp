/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
    bool isPalindrome(vector<TreeNode *> list)
    {
        for (int i = 0, j = list.size() - 1; i < j; ++i, --j)
        {
            if (list[i]->val != list[j]->val)
                return false;
        }
        return true;
    }

public:
    bool isSymmetric(TreeNode *root)
    {

        queue<TreeNode *> q;
        q.push(root);
        vector<TreeNode *> v = {root};

        while (!q.empty())
        {

            v.clear();
            while (!q.empty())
            {
                auto n = q.front();
                q.pop();
                v.push_back(n);
            }

            if (!isPalindrome(v))
                return false;

            for (auto node : v)
            {
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }
        }

        return true;
    }
};

int main()
{
    Solution s;
    TreeNode *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(2);

    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(4);

    root->right->left = new TreeNode(4);
    root->right->right = new TreeNode(3);

    auto res = s.isSymmetric(root);
    cout << res << endl;

    return 0;
}