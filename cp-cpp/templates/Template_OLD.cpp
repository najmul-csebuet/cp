#include <bits/stdc++.h>
using namespace std;

#define HIDE_TEMPLATE true
#ifdef HIDE_TEMPLATE

#define vb vector<bool>
#define vc vector<char>
#define vi vector<int>
#define vd vector<double>
#define vll vector<long long>
#define vs vector<string>
#define vii vector<pair<int, int>>
#define vvi vector<vector<int>>

#define sb set<bool>
#define sc set<char>
#define si set<int>
#define sd set<double>
#define sll set<long long>
#define ss set<string>

#define pii pair<int, int>
#define mii map<int, int>
#define msi map<string, int>

#define INF LLONG_MAX
#define all(v) ((v).begin()), ((v).end())
#define sz(v) ((int)((v).size()))
#define pie acos(-1)
#define eps (1e-9)
#define endl '\n'

#define pb push_back
#define eb emplace_back
#define x first
#define y second
#define ll long long
#define var auto
#define pf printf

#define mt make_tuple

#define mod(n, m) ((n % m + m) % m)
#define reset(n, m) memset(n, m, sizeof n)
#define dist(x1, y1, x2, y2) sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))

#define rep(i, a, b) for (auto i = (a); i < (b); ++i)
#define repr(i, a, b) for (auto i = (a); i > (b); --i)

#define tr(container, it) \
  for (auto it = container.begin(); it != container.end(); it++)
#define trr(container, it) \
  for (auto it = container.rbegin(); it != container.rend(); it++)

// https://codeforces.com/blog/entry/62393
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    // http://xorshift.di.unimi.it/splitmix64.c
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }

  size_t operator()(uint64_t x) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(x + FIXED_RANDOM);
  }
};

#define umii unordered_map<int, int, custom_hash>
#define ghtii gp_hash_table<int, int, custom_hash>
#define boost(a)           \
  a.max_load_factor(0.25); \
  a.reserve(1 << 20);

#define eqd(a, b) (abs(a - b) < 1e-9)

#define DB(x) cerr << __LINE__ << ": " << #x << " = " << (x) << endl

#define debug(args...)                       \
  {                                          \
    string _s = #args;                       \
    replace(_s.begin(), _s.end(), ',', ' '); \
    stringstream _ss(_s);                    \
    istream_iterator<string> _it(_ss);       \
    err(_it, args);                          \
  }

void err(istream_iterator<string> it) {}

template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << endl;
  err(++it, args...);
}

void read() {}

template <class Arg, class... Rest>
void read(Arg &arg, Rest &...rest) {
  cin >> arg;
  read(rest...);
}

class IO {
 public:
  IO() {
    // activate fast io
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
  }

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

  void print(string message) { cout << message << endl; }

  void print(vi n, string separator = " ") {
    if (n.size() == 0) return;
    rep(i, 0, n.size() - 1) cout << n[i] << separator;
    cout << n[n.size() - 1] << "\n";
  }
} io;

#endif

void solve() {
  // solve here
}

int main() {
  int testCount = 1;
  // testCount = io.nextInt();
  while (testCount > 0) {
    solve();
    --testCount;
  }
}
