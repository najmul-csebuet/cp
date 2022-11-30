#include <bits/stdc++.h>
using namespace std;

// template <>
void read() {}

template <class Arg, class... Rest>
void read(Arg &arg, Rest &...rest)
{
    cin >> arg;
    read(rest...);
}

#define debug(args...)                           \
    {                                            \
        string _s = #args;                       \
        replace(_s.begin(), _s.end(), ',', ' '); \
        stringstream _ss(_s);                    \
        istream_iterator<string> _it(_ss);       \
        err(_it, args);                          \
    }

void err(istream_iterator<string> it)
{
}

template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args)
{
    cerr << *it << " = " << a << endl;
    err(++it, args...);
}

int main(int argc, char const *argv[])
{
    int a, b, c;
    read(a, b, c);
    debug(a, b, c);
    return 0;
}