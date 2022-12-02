#include <bits/stdc++.h>
using namespace std;

struct State {
  bool visited;
  int parent;
  int distance;
  State() {
    parent = -1;
    visited = false;
    distance = INT_MAX;
  }
};

class Dijkstra {
  int v, e;
  int graph[10][10];

 public:
  void read(string file) {
    ifstream fin(file);
    fin >> v >> e;
    int u, v, w;
    for (int i = 0; i < e; ++i) {
      fin >> u >> v >> w;
      graph[u][v] = w;
      graph[v][u] = w;
    }
  }

  vector<int> solve(int start, int end) {
    vector<State> state(v + 1);
    priority_queue<int> queue;
    queue.emplace(start);

    state[start].parent = -1;
    state[start].distance = 0;

    while (!queue.empty()) {
      int curr = queue.top();
      queue.pop();

      state[curr].visited = true;
      for (int i = 1; i <= v; ++i) {
        if (state[i].visited or graph[curr][i] == 0) {
          continue;
        }
        if (state[curr].distance + graph[curr][i] <
            state[i].distance) {
          state[i].distance = state[curr].distance + graph[curr][i];
          state[i].parent = curr;
          queue.emplace(i);
        }
      }
    }

    // build the path
    vector<int> path;
    while (state[end].parent != -1) {
      path.push_back(end);
      end = state[end].parent;
    }
    path.push_back(end);
    reverse(path.begin(), path.end());
    return path;
  }
};

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

  vector<int> nextInts() { return nextInts(nextInt()); }

  vector<int> nextInts(int n) {
    vector<int> a(n);
    for (int i = 0; i < n; ++i) cin >> a[i];
    return a;
  }

  void print(string message) { cout << message << endl; }

  void print(vector<int> n, string separator = " ") {
    if (n.size() == 0) {
      return;
    }
    for (int i = 0; i < n.size() - 1; ++i) cout << n[i] << separator;
    cout << n[n.size() - 1] << endl;
  }
} io;

int main(int argc, char const *argv[]) {
  Dijkstra d;
  d.read("in.txt");
  vector<int> path = d.solve(1, 6);
  io.print(path);
  return 0;
}
