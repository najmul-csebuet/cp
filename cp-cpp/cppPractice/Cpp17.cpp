#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    /* tuple<int, char, double> t;
    t = {1, 'A', 10.2};

    int i;
    char c;
    double d;
    tie(i, c, d) = t;

    int i1;
    char c1;
    double d1;
    auto [i1, c1, d1] = t; */

    std::map<std::string, int> m = {{"first", 1}, {"second", 2}};

    string key;
    int value;

    for (auto &[key, value] : m)
    {
        std::cout << key << " " << value << std::endl;
    }

    struct state
    {
        int a, b, c;
    };

    std::vector<state> v = {{1, 2, 3}, {4, 5, 6}};

    for (auto &it : v) 
    {
        // we can use this, instead of std::tie operator
        auto [a, b, c] = it;
        std::cout << a * b * c << std::endl;
    }

    return 0;
}