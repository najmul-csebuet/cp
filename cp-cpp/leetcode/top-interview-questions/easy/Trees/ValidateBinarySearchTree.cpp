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
public:
    int minValue(TreeNode *root)
    {
        if (root == nullptr)
            return INT_MAX;
        return min(min(minValue(root->left), minValue(root->right)), root->val);
    }

    int maxValue(TreeNode *root)
    {
        if (root == nullptr)
            return INT_MIN;
        return max(max(maxValue(root->left), maxValue(root->right)), root->val);
    }

    bool isValidBST(TreeNode *root)
    {

        if (!root)
            return true;
        if (!root->left && !root->right)
            return true;

        int lv = maxValue(root->left);
        if (lv >= root->val)
            return false;

        int rv = minValue(root->right);
        if (rv <= root->val)
            return false;

        if (!isValidBST(root->left))
            return false;
        if (!isValidBST(root->right))
            return false;

        return true;
    }
};

int main()
{
    Solution s;
    TreeNode *root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);
    cout << s.isValidBST(root) << endl;
}