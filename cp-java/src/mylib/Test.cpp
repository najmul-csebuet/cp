#include<iostream>
#include<vector>
using namespace std;

#define endl '\n'
#define var auto

int main() {
    cout << "Bismillah" << endl;
    cout << endl;

    int a = 0;
    for(int i = 0; i < 3; ++i) {
        ++a;
    }

    cout << a << endl;

    vector<int> v;
    v.push_back(1);

    cout << v[0] << endl;
}