#include <bits/stdc++.h>
using namespace std;

#define HT true
#ifdef HT

#define vi vector<int>

#define all(v) ((v).begin()), ((v).end())
#define sz(v) ((int)((v).size()))
#define pie acos(-1)
#define eps (1e-9)
#define endl '\n'
#define var auto

#define eqd(a, b) (abs(a - b) < 1e-9)
#define mod(n, m) ((n % m + m) % m)
#define reset(n, m) memset(n, m, sizeof n)
#define dist(x1, y1, x2, y2) sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))

#define rep(i, a, b) for (auto i = (a); i < (b); ++i)
#define repr(i, a, b) for (auto i = (a); i > (b); --i)

struct IO {
  string next() {
    string str;
    cin >> str;
    return str;
  }

  string nextLine() {
    string str;
    getline(cin, str);
    return str;
  }

  int nextInt() {
    int n;
    cin >> n;
    return n;
  }

  vi nextInts() {
    int n;
    cin >> n;
    return nextInts(n);
  }

  vi nextInts(int n) {
    vi a(n);
    rep(i, 0, n) cin >> a[i];
    return a;
  }

  void print(vi n, string separator = " ") {
    if (n.size() == 0) return;
    rep(i, 0, n.size() - 1) cout << n[i] << separator;
    cout << n[n.size() - 1] << "\n";
  }
} io;

#endif

void solve() {
  // solve here
  cout << "Bismillah" << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int testCount = 1;
  // testCount = io.nextInt();
  while (testCount > 0) {
    solve();
    --testCount;
  }
}
