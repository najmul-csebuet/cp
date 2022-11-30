#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
  
  return 0;
}

#include <bits/stdc++.h>
using namespace std;

class IO {
  int nextInt() {
    int a;
    cin >> a;
    return a;
  }
};

class Dijkstra {
 private:
  int graph[10][10];

 public:
  void readGraph(string fileName) {
    ifstream fin(fileName);
    int vertexCount, edgeCount, u, v, w;
    fin >> vertexCount >> edgeCount;
    for (int i = 0; i < edgeCount; ++i) {
      fin >> u >> v >> w;
      graph[u][v] = w;
      graph[v][u] = w;
    }
    fin.close();
  }

  vector<int> findShortestPath(int start, int end) {}
};

int main(int argc, char const *argv[]) {
  Dijkstra dijkstra;
  dijkstra.readGraph("in.txt");
  vector<int> path = dijkstra.findShortestPath(1, 5);
  for (int i = 0; i < path.size() - 1; ++i) {
    cout << path[i] << ", ";
  }
  cout << path[path.size() - 1] << endl;
  return 0;
}