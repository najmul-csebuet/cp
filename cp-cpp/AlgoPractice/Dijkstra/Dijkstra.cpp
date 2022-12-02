#include <bits/stdc++.h>
using namespace std;

#define rep(i, a, b) for (auto i = (a); i < (b); ++i)

class Dijkstra {
  int vertexCount, edgeCount;
  int graph[10][10];

 public:
  void readGraph(string fileName) {
    ifstream fin(fileName);
    int u, v, w;
    fin >> vertexCount >> edgeCount;
    for (int i = 0; i < edgeCount; ++i) {
      fin >> u >> v >> w;
      graph[u][v] = w;
      graph[v][u] = w;
    }
    fin.close();
  }

  vector<int> findShortestPath(int start, int end) {
    vector<bool> visited(vertexCount + 1, false);
    vector<int> distance(vertexCount + 1, INT_MAX);
    vector<int> parent(vertexCount + 1, -1);

    distance[start] = 0;

    priority_queue<int> queue;
    queue.emplace(start);

    while (!queue.empty()) {
      int currentVertex = queue.top();
      queue.pop();
      visited[currentVertex] = true;
      rep(i, 1, vertexCount + 1) {
        if (graph[currentVertex][i] == 0) continue;
        if (visited[i]) continue;
        if (distance[currentVertex] + graph[currentVertex][i] < distance[i]) {
          distance[i] = distance[currentVertex] + graph[currentVertex][i];
          parent[i] = currentVertex;
          queue.emplace(i);
        }
      }
    }

    vector<int> ans;
    int last = end;
    while (parent[last] != -1) {
      ans.push_back(last);
      last = parent[last];
    }
    ans.push_back(last);
    // Reverse the vector
    reverse(ans.begin(), ans.end());
    return ans;
  }
};

int main(int argc, char const *argv[]) {
  Dijkstra dijkstra;
  dijkstra.readGraph("in.txt");
  vector<int> path = dijkstra.findShortestPath(1, 6);
  for (int i = 0; i < path.size() - 1; ++i) {
    cout << path[i] << ", ";
  }
  cout << path[path.size() - 1] << endl;
  return 0;
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
