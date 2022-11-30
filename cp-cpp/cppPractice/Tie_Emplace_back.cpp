#include <bits/stdc++.h>

using namespace std;

#define mt make_tuple
#define eb emplace_back
typedef tuple<int, int, int> State; // operator< defined

int main()
{
    int a, b, c;
    tie(a, b, c) = mt(1, 2, 3);
    tie(a, b) = mt(b, a);

    vector<pair<int, int>> v;
    // vii v1;

    v.eb(a, b); // shorter and faster than pb(mp(a,b))

    tuple<int, int, int, char> t(3, 4, 5, 'g');
    tie(b, ignore, a, ignore) = t;
    cout << a << ' ' << b << '\n';

    return 0;
}