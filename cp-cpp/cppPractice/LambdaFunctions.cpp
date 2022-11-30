#include <bits/stdc++.h>
using namespace std;

int main()
{
    auto f = [](int a, int b) -> int
    { return a + b; };
    cout << f(1, 2) << endl;

    vector<int> v = {3, 1, 2, 1, 8};
    sort(v.begin(), v.end(), [](int a, int b)
         { return a > b; });
    for (auto i : v)
        cout << i << ' ';

    return 0;
}