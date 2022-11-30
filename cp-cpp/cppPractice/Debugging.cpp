#include <bits/stdc++.h>
using namespace std;

#define HIDE_TEMPLATE true
#ifdef HIDE_TEMPLATE

#define var auto
#define endl '\n'
#define vi vector<int>
#define rep(i, a, b) for (auto i = (a); i < (b); ++i)
#define repr(i, a, b) for (auto i = (a); i > (b); --i)

#define debug(args...)                           \
    {                                            \
        string _s = #args;                       \
        replace(_s.begin(), _s.end(), ',', ' '); \
        stringstream _ss(_s);                    \
        istream_iterator<string> _it(_ss);       \
        err(_it, args);                          \
    }

void err(istream_iterator<string> it)
{
}

template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args)
{
    cerr << *it << " = " << a << endl;
    err(++it, args...);
}

class IO
{
public:
    IO()
    {
        // activate fast io
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
    }

    string next()
    {
        string str;
        cin >> str;
        return str;
    }

    string nextLine()
    {
        string str;
        getline(cin, str);
        return str;
    }

    int nextInt()
    {
        int n;
        cin >> n;
        return n;
    }

    vi nextInts()
    {
        int n;
        cin >> n;
        return nextInts(n);
    }

    vi nextInts(int n)
    {
        vi a(n);
        rep(i, 0, n) cin >> a[i];
        return a;
    }

    void print(string message)
    {
        cout << message << endl;
    }

    void print(vi n, string separator = " ")
    {
        if (n.size() == 0)
            return;
        rep(i, 0, n.size() - 1) cout << n[i] << separator;
        cout << n[n.size() - 1] << "\n";
    }
} io;

#endif

void solve()
{
    // solve here
    int a = 1, b = 2, c = 3;
    debug(a, b, c);

    set<int> s;
    s = {1, 2, 3, 4};
    for (var a : s)
    {
        cout << a << ' ';
    }

    io.print("");

    for (int i = 1; i <= 10; i++)
    {
        for (int j = 1; j <= 10; j++)
        {
            cout << 'A' << " ";
        }
        cout << "\n";
    }

    for (int i = 1; i <= 10; i++)
    {
        for (int j = 1; j <= 10; j++)
        {
            cout << 'B' << " \n"[j == 10];
        }
    }
}

int main()
{
    int testCount = 1;
    // testCount = io.nextInt();
    while (testCount > 0)
    {
        solve();
        --testCount;
    }
}
