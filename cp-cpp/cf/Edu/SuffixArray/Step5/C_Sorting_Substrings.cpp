#include <bits/stdc++.h>
using namespace std;

#define V vector
#define P pair

#define vi vector<int>
#define pii pair<int, int>
#define vii vector<pair<int, int>>

#define rep(i, a, b) for (auto i = (a); i < (b); ++i)

#define all(v) ((v).begin()), ((v).end())
#define sz(v) ((int)((v).size()))
#define endl '\n'

#define pb push_back

#define var auto

void radix_sort(vector<pair<pii, int>> &a) {
    int n = a.size();

    {
        vi cnt(n);
        for(var x : a) cnt[x.first.second]++;
        vi pos(n);
        pos[0] = 0;
        rep(i, 1, n) pos[i] = pos[i - 1] + cnt[i - 1];

        vector<pair<pii, int>> a_new(n);
        for(var x : a) {
            int i = x.first.second;
            a_new[pos[i]] = x;
            pos[i]++;
        }
        a = a_new;
        //a.swap(a_new);
    }

    {
        vi cnt(n);
        for(var x : a) cnt[x.first.first]++;
        vi pos(n);
        rep(i, 1, n) pos[i] = pos[i - 1] + cnt[i - 1];

        vector<pair<pii, int>> a_new(n);
        for(var x : a) {
            int i = x.first.first;
            a_new[pos[i]] = x;
            pos[i]++;
        }
        a = a_new;
    }
}

void suffixArray(string &s, V<vi> &allCnt) {

    s += (char)32;
    int n = s.size();
    vi sa(n);
    {
        vi c(n);
        vii a(n);
        rep(i, 0, n) a[i] = {s[i], i};
        sort(all(a));
        rep(i, 0, n) sa[i] = a[i].second;
        c[sa[0]] = 0;
        rep(i, 1, n) c[sa[i]] = c[sa[i - 1]] + (a[i].first != a[i - 1].first);
        allCnt.pb(c);
    }

    V<P<pii, int>> a(n);
    int k = 0;
    while((1 << k) < n) {
        var c = allCnt.back();
        rep(i, 0, n) a[i] = {{c[i], c[(i + (1 << k)) % n]}, i};
        radix_sort(a);
        rep(i, 0, n) sa[i] = a[i].second;
        vi new_c(n);
        new_c[sa[0]] = 0;
        rep(i, 1, n) new_c[sa[i]] = new_c[sa[i - 1]] + (a[i].first != a[i - 1].first);
        allCnt.pb(new_c);
        ++k;
    }
}

void getK(int n, vi &parts) {
    // 7 -> 4 -> 2 -> 1
    // 8 -> 8
    // 9 -> 8 -> 1
    // 10 -> 8 -> 2
    // 11 -> 8 -> 2 -> 1
    
    while(n) {
        int k = log(n) / log(2);
        parts.pb(k);
        n -= (1 << k);
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(0);

    string s;
    cin >> s;
    
    int t;
    cin >> t;
    vii queries(t);
    int a, b;
    
    //map<int, vi> m;

    //vi parts;

    rep(i, 0, t) {
        cin >> a >> b;
        queries[i].first = a;
        queries[i].second = b;
        /* int len = b - a + 1;
        parts = m[len];
        if(parts.empty()) {
            getK(len, parts);
            m[len] = parts;
        } */
    }

    V<vi> allCnt;
    suffixArray(s, allCnt);
    
    sort(all(queries), [&] (pii &a, pii &b) -> bool {

        int l1 = a.second - a.first + 1;
        int l2 = b.second - b.first + 1;
        int min = l1 <= l2 ? l1 : l2;
        
        int k = log(min) / log(2);

        int i = a.first - 1;
        int j = b.first - 1;
        if(allCnt[k][i] != allCnt[k][j]) {
            return allCnt[k][i] < allCnt[k][j];
        }

        i += min - (1 << k);
        j += min - (1 << k);

        if(allCnt[k][i] != allCnt[k][j]) {
            return allCnt[k][i] < allCnt[k][j];
        } 

        /* vi parts = m[min];

        int sum1 = a.first - 1;
        int sum2 = b.first - 1;

        rep(i, 0, parts.size()) {
            int k = parts[i];
            if(allCnt[k][sum1] != allCnt[k][sum2]) {
                return allCnt[k][sum1] < allCnt[k][sum2];
            }
            sum1 += (1 << k);
            sum2 += (1 << k);
        } */
        
        if(l1 != l2) {
            return l1 < l2;
        }

        if (a.first != b.first) {
            return a.first < b.first;
        }

        return a.second < b.second;
    });

    rep(i, 0, t) {
        cout << queries[i].first << " " << queries[i].second << endl;
    }

    return 0; 
}