#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    vector<int> v = {1, 2, 3, 4};
    // vector<int> w = move(v);
    vector<int> w = v;
    v.emplace_back(5);

    cout << "v: ";
    for (auto i : v)
        cout << i << ' ';

    cout << "\nw: ";
    for (auto i : w)
        cout << i << ' ';

    return 0;
}