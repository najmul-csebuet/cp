#include <bits/stdc++.h>

using namespace std;

int mult()
{
    return 1;
}

template <typename... T>
int mult(int a, T... args)
{
    return a * mult(args...);
}

int sum() { return 0; }

template <typename... T>
int sum(int a, T... args)
{
    return a + sum(args...);
}

int main()
{
    cout << sum(1, 2, 3) + sum(4, 5) << endl;
    cout << mult(1, 2, 3) + mult(4, 5) << endl;
    return 0;
}