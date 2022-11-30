#include <bits/stdc++.h>

using namespace std;

int add() { return 0; }

template <typename T1, typename... T2>
auto add(T1 a, T2... args)
{
    return a + add(args...);
}

int main()
{
    cout << add(5, 7, 2, 2) + add(3.14, 4.89) << endl;
    // cout << add(1, 2, 3, 4, 5.5) << endl;

    return 0;
}
