#include <bits/stdc++.h>
using namespace std;

#define rep(i, a, b) for (auto i = (a); i < (b); ++i)

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

  vector<int> nextInts() {
    int n;
    cin >> n;
    return nextInts(n);
  }

  vector<int> nextInts(int n) {
    vector<int> a(n);
    rep(i, 0, n) cin >> a[i];
    return a;
  }

  void print(vector<int> n, string separator = " ") {
    if (n.size() == 0) return;
    rep(i, 0, n.size() - 1) cout << n[i] << separator;
    cout << n[n.size() - 1] << endl;
  }
} io;

int main(int argc, char const *argv[]) { return 0; }