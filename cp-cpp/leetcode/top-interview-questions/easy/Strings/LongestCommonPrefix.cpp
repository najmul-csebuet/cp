/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>

using namespace std;

struct Trie {
    char ch;
    int branchCount;
    int latestBranchIndex;
    bool endOfWord;
    Trie *branches[26];
    
    void insert(string s, int i) {
        if(i == s.size()) {
            this->endOfWord = true;
            return;
        }

        char c = s[i];
        int index = c - 'a';
        
        if(this->branches[index] == nullptr) {
            this->branches[index] = new Trie();

            this->branches[index]->endOfWord = false;
            this->branches[index]->ch = c;

            this->branches[index]->branchCount = 0;

            for (int i = 0; i < 26; i++) this->branches[index]->branches[i] = nullptr;

            this->branchCount++;
            this->latestBranchIndex = index;
        }
        this->branches[index]->insert(s, i + 1);
    }
};

class Solution {
public:
    
    string longestCommonPrefix(vector<string>& strs) {
        
        for(string s : strs) {
            if(s.size() == 0) return "";
        }

        Trie root;
        root.ch = '$';
        root.branchCount = 0;
        root.endOfWord = false;
        for (int i = 0; i < 26; i++) root.branches[i] = nullptr;

        for(string s : strs) {
            //cout << s << endl;
            root.insert(s, 0);
        }
        
        int len = -1;
        string ans = "";
        Trie* temp = &root;
        while(temp != nullptr) {
            ++len;
            if(temp->ch != '$') ans += temp->ch;
            if(temp->endOfWord || temp->branchCount == 0 || temp->branchCount > 1) break;
            int i = temp->latestBranchIndex;
            temp = temp->branches[i];
        }
        return ans;
    }
};

int main()
{
    Solution s;
    //vector<string> v = {"flower","flow","flight"};
    vector<string> v = {"ab", "a"};
    string ans = s.longestCommonPrefix(v);
    cout << ans << endl;
    return 0;
}
