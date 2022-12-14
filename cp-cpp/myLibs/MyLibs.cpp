#include <bits/stdc++.h>
using namespace std;

#define HIDE_TEMPLATE true

#ifdef HIDE_TEMPLATE

#define dist(x1, y1, x2, y2) sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))

#define ll long long
#define V vector
#define P pair

#define si set<int>

#define vc vector<char>
#define vs vector<string>
#define vb vector<bool>
#define vi vector<int>
#define vd vector<double>
#define vll vector<ll>

#define pii pair<int, int>
#define vii vector<pair<int, int>>

#define vvi vector<vector<int>>

#define mii map<int, int>
#define msi map<string, int>

#define rep(i, a, b) for (auto i = (a); i <= (b); ++i)
#define repr(i, a, b) for (auto i = (a); i >= (b); --i)

#define INF LLONG_MAX
#define all(v) ((v).begin()), ((v).end())
#define sz(v) ((int)((v).size()))
#define pie acos(-1)
#define mod(n, m) ((n % m + m) % m)
#define eps (1e-9)
#define reset(n, m) memset(n, m, sizeof n)
#define endl '\n'

#define pb push_back
#define eb emplace_back
#define fi first
#define se second

#define var auto

#define tr(container, it) for (var it = container.begin(); it != container.end(); it++)
#define trr(container, it) for (var it = container.rbegin(); it != container.rend(); it++)
#endif

struct FastIO
{
    FastIO()
    {
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        // cout.tie(0);

        // flushes cout
        // cin.tie(NULL);

        // https://stackoverflow.com/questions/11019983/automatic-cout-flushing
        // cout << unitbuf;
    }

    string readLine()
    {
        string str;
        getline(cin, str);
        return str;
    }

    vi readInts()
    {
        int n;
        cin >> n;
        return readInts(n);
    }

    vi readInts(int n)
    {
        vi a(n);
        rep(i, 0, n) cin >> a[i];
        return a;
    }

    void print(vi n)
    {
        print(n, " ");
    }

    void print(vi n, string separator)
    {
        if (n.size() == 0)
            return;
        rep(i, 0, n.size() - 1) cout << n[i] << separator;
        cout << n[n.size() - 1] << "\n";
    }

    void reversePrint(vi n)
    {
        reversePrint(n, " ");
    }

    void reversePrint(vi n, string separator)
    {
        if (n.size() == 0)
            return;
        repr(i, n.size() - 1, 0) cout << n[i] << separator;
        cout << n[0] << "\n";
    }
};

struct Util
{
    vi getPrimeNumbers(int n)
    {

        vi list;

        if (n < 2)
            return list;

        vi isComposite(n + 1, 0);

        for (int j = 2 * 2; j <= n; j += 2)
            isComposite[j] = true;

        for (int i = 3; i * i <= n; i += 2)
        {
            if (isComposite[i])
                continue;
            for (int j = i * i; j <= n; j += i)
            {
                isComposite[j] = true;
            }
        }

        list.pb(2);
        for (int i = 3; i <= n; i += 2)
        {
            if (!isComposite[i])
                list.pb(i);
        }

        return list;
    }

    vi getPrefixSum(vi &a)
    {
        vi prefixSum(a.size() + 1);
        rep(i, 1, a.size() + 1) prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        return prefixSum;
    }

    vi getSuffixSum(vi &a)
    {
        vi suffixSum(a.size() + 1);
        rep(i, 1, a.size() + 1) suffixSum[i] = suffixSum[i - 1] + a[a.size() - i];
        return suffixSum;
    }

    int hexToInt(string &s)
    {
        int ans = 0;
        rep(i, 0, s.size())
        {
            if (s[i] >= '0' && s[i] <= '9')
                ans = ans * 16 + (s[i] - '0');
            else if (s[i] >= 'a' && s[i] <= 'f')
                ans = ans * 16 + (s[i] - 'a' + 10);
            else if (s[i] >= 'A' && s[i] <= 'F')
                ans = ans * 16 + (s[i] - 'A' + 10);
        }
        return ans;
    }

    int octToInt(string &s)
    {
        int ans = 0;
        rep(i, 0, s.size())
        {
            if (s[i] >= '0' && s[i] <= '7')
                ans = ans * 8 + (s[i] - '0');
        }
        return ans;
    }

    int binToInt(string &s)
    {
        int ans = 0;
        rep(i, 0, s.size())
        {
            if (s[i] >= '0' && s[i] <= '1')
                ans = ans * 2 + (s[i] - '0');
        }
        return ans;
    }

    string intToHex(int n)
    {
        string ans = "";
        while (n > 0)
        {
            int rem = n % 16;
            if (rem >= 0 && rem <= 9)
                ans = (char)(rem + '0') + ans;
            else if (rem >= 10 && rem <= 15)
                ans = (char)(rem - 10 + 'A') + ans;
            n /= 16;
        }
        return ans;
    }

    string intToOct(int n)
    {
        string ans = "";
        while (n > 0)
        {
            int rem = n % 8;
            ans = (char)(rem + '0') + ans;
            n /= 8;
        }
        return ans;
    }

    string intToBin(int n)
    {
        string ans = "";
        while (n > 0)
        {
            int rem = n % 2;
            ans = (char)(rem + '0') + ans;
            n /= 2;
        }
        return ans;
    }

    int gcd(int a, int b)
    {
        return __gcd(a, b);
    }

    int lcm(int a, int b)
    {
        return a * b / gcd(a, b);
    }

    int gcd(vi &a)
    {
        int ans = a[0];
        rep(i, 1, a.size()) ans = gcd(ans, a[i]);
        return ans;
    }

    int lcm(vi &a)
    {
        int ans = a[0];
        rep(i, 1, a.size()) ans = lcm(ans, a[i]);
        return ans;
    }

    int modInverse(int a, int m)
    {
        int ans = 1;
        int x = 0;
        int y = m;
        while (y > 0)
        {
            int q = a / y;
            int t = x;
            x = ans;
            ans = t - q * ans;
            t = y;
            y = a - q * y;
            a = t;
        }
        if (ans < 0)
            ans += m;
        return ans;
    }

    int modExp(int a, int b, int m)
    {
        int ans = 1;
        while (b > 0)
        {
            if (b & 1)
                ans = (ans * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return ans;
    }

    int modDiv(int a, int b, int m)
    {
        return (a * modInverse(b, m)) % m;
    }

    bool isPrime(int n)
    {
        if (n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    vi getPrimeFactors(int n)
    {
        vi ans;
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                ans.pb(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        if (n > 1)
            ans.pb(n);
        return ans;
    }

    vi getPrimeFactorsWithCount(int n)
    {
        vi ans;
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                int cnt = 0;
                while (n % i == 0)
                {
                    cnt++;
                    n /= i;
                }
                ans.pb(i);
                ans.pb(cnt);
            }
        }
        if (n > 1)
            ans.pb(n);
        return ans;
    }

    int getNumberOfDivisors(int n)
    {
        int ans = 1;
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                int cnt = 0;
                while (n % i == 0)
                {
                    cnt++;
                    n /= i;
                }
                ans *= (cnt + 1);
            }
        }
        if (n > 1)
            ans *= 2;
        return ans;
    }

    int getNumberOfDivisors(vi &a)
    {
        int ans = 1;
        for (int i = 0; i < a.size(); i++)
        {
            int cnt = 0;
            for (int j = i + 1; j < a.size(); j++)
            {
                if (a[i] == a[j])
                    cnt++;
            }
            ans *= (cnt + 1);
        }
        return ans;
    }

    vi getSuffixArray(string &s)
    {
        s += "$";
        int n = s.size();
        vi p(n), c(n);
        {
            vii a(n);
            rep(i, 0, n) a[i] = {s[i], i};
            sort(all(a));
            rep(i, 0, n) p[i] = a[i].second;
            c[p[0]] = 0;
            rep(i, 1, n) c[p[i]] = c[p[i - 1]] + (a[i].first != a[i - 1].first);
        }
        int k = 0;
        while ((1 << k) < n)
        {
            vector<pair<pii, int>> a(n);
            rep(i, 0, n) a[i] = {{c[i], c[(i + (1 << k)) % n]}, i};
            radix_sort(a);
            rep(i, 0, n) p[i] = a[i].second;
            c[p[0]] = 0;
            rep(i, 1, n) c[p[i]] = c[p[i - 1]] + (a[i].first != a[i - 1].first);
            ++k;
        }
        return p;
    }

    vi getLcpArray(string &s, vi &sa, vi &c)
    {
        int n = s.size();
        vi lcp(n);
        int k = 0;
        rep(i, 0, n - 1)
        {
            int pi = c[i];
            int j = sa[pi - 1];
            // lcp[i] = lcp(s[i..], s[j..])
            while (s[i + k] == s[j + k])
                ++k;
            lcp[pi] = k;
            k = max(k - 1, 0);
        }
        return lcp;
    }

    bool isSubString(string &s, vi &sa, string &sub)
    {
        // return s.find(t) != string::npos;
        int l = 0, r = sa.size() - 1;
        var flag = false;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            int idx = sa[mid];
            if (s.substr(idx, sub.size()) == sub)
            {
                return true;
            }
            else if (s.substr(idx, sub.size()) < sub)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return false;
    }

    int countSubString(string &s, vi &sa, string &sub)
    {

        int lower = -1, upper = -1;

        // find lower index in sa which is equal to sub
        int l = 0, r = sz(sa) - 1, lastMatch = -1;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            var exSub = s.substr(sa[mid], sub.length());
            if (exSub == sub)
            {
                lastMatch = mid;
                r = mid - 1;
            }
            else if (exSub < sub)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }

        if (lastMatch >= 0)
        {
            lower = lastMatch;
        }

        if (lower == -1)
        {
            return 0;
        }

        // find upper index in sa which is equal to sub
        l = 0, r = sz(sa) - 1;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            var exSub = s.substr(sa[mid], sub.length());
            if (exSub == sub)
            {
                lastMatch = mid;
                l = mid + 1;
            }
            else if (exSub < sub)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }

        if (lastMatch >= 0)
        {
            upper = lastMatch;
        }

        // upper check not needed if lower chk done first.
        // if(upper == -1) {
        //     return 0;
        // }

        // return upper - lower + 1
        return upper - lower + 1;
    }

    ll getNumberOfDiffSubString(string &s, vi &sa, vi &c, vi &lcp)
    {
        // s.pop_back();
        ll ans = 0;
        // no need to calculate for n = 0 as it is $ and very first suffix in suffix array
        int n = s.size() - 1; // exclude $ from every suffix
        rep(i, 1, sa.size())
        {
            ans += (n - sa[i]);
            // ans -= lcp[c[sa[i]]]; // c and sa are inverse permutation of each other
            ans -= lcp[i];
        }
        return ans;
    }

    void radix_sort(vector<pair<pii, int>> &a)
    {
        int n = a.size();

        {
            vi cnt(n);
            for (var x : a)
                cnt[x.first.second]++;
            vi pos(n);
            pos[0] = 0;
            rep(i, 1, n) pos[i] = pos[i - 1] + cnt[i - 1];

            vector<pair<pii, int>> a_new(n);
            for (var x : a)
            {
                int i = x.first.second;
                a_new[pos[i]] = x;
                pos[i]++;
            }
            a = a_new;
            // a.swap(a_new);
        }

        {
            vi cnt(n);
            for (var x : a)
                cnt[x.first.first]++;
            vi pos(n);
            rep(i, 1, n) pos[i] = pos[i - 1] + cnt[i - 1];

            vector<pair<pii, int>> a_new(n);
            for (var x : a)
            {
                int i = x.first.first;
                a_new[pos[i]] = x;
                pos[i]++;
            }
            a = a_new;
        }
    }
};

struct DisjointSet
{
    vi p;
    vi rank;
    DisjointSet(int n)
    {
        p.resize(n);
        rank.resize(n);
        rep(i, 0, n)
        {
            p[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x)
    {
        if (p[x] == x)
            return x;
        return p[x] = find(p[x]);
    }

    void union_by_size(int x, int y)
    {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr)
            return;
        if (rank[xr] < rank[yr])
        {
            p[xr] = yr;
        }
        else
        {
            p[yr] = xr;
            if (rank[xr] == rank[yr])
                rank[xr]++;
        }
    }
};

class Trie
{

    struct TrieNode
    {
        char ch;
        // int branchCount;
        // int latestBranchIndex;
        vi branchIndexes;
        bool endOfWord;
        TrieNode *branches[26];

        TrieNode(char ch)
        {
            this->ch = ch;
            // branchCount = 0;
            // latestBranchIndex = -1;
            endOfWord = false;
            // for(int i = 0; i < 26; ++i) branches[i] = nullptr;
            for (auto &b : branches)
                b = nullptr;
        }
    };

    TrieNode *root;

public:
    Trie()
    {
        root = new TrieNode('$');
    }

    void insert(string word)
    {
        TrieNode *temp = root;
        for (char ch : word)
        {
            int i = ch - 'a';
            if (temp->branches[i] == nullptr)
            {
                temp->branches[i] = new TrieNode(ch);
                temp->branchIndexes.pb(i);
                // temp->branchCount++;
                // temp->latestBranchIndex = i;
            }
            temp = temp->branches[i];
        }
        temp->endOfWord = true;
    }

    bool search(string word)
    {
        TrieNode *temp = root;
        for (char ch : word)
        {
            int i = ch - 'a';
            if (temp->branches[i] == nullptr)
            {
                return false;
            }
            temp = temp->branches[i];
        }
        return temp->endOfWord;
    }

    bool deleteWord(string word)
    {
        TrieNode *temp = root;
        for (char ch : word)
        {
            int i = ch - 'a';
            if (temp->branches[i] == nullptr)
            {
                return false;
            }
            temp = temp->branches[i];
        }
        return temp->endOfWord;
    }

    bool startsWith(string prefix)
    {
        TrieNode *temp = root;
        for (char ch : prefix)
        {
            int i = ch - 'a';
            if (temp->branches[i] == nullptr)
            {
                return false;
            }
            temp = temp->branches[i];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */

struct ListNode
{
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class List
{
    int count = 0;
    ListNode *head, *tail;

public:
    List()
    {
        head = nullptr;
        tail = nullptr;
    }

    void addToHead(int n)
    {
        ++count;
        ListNode *temp = new ListNode(n);
        if (head == nullptr)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            temp->next = head;
            head = temp;
        }
    }

    void addToTail(int n)
    {
        ++count;
        ListNode *temp = new ListNode(n);
        if (tail == nullptr)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            tail->next = temp;
            tail = temp;
        }
    }
};

FastIO io;

void solve()
{
}

int main()
{
    /* int t;
    cin >> t;
    while(t--) {
        solve();
    } */
    solve();
}
