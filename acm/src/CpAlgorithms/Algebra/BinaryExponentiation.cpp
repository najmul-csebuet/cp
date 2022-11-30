#include<iostream>
using namespace std;

long long binPowRecursive(long long a, long long b) {
    if(b == 0) {
        return 1;
    }
    long long res = binPowRecursive(a, b / 2);
    return b%2 == 0? res * res : res * res * a;
}

long long binPowIterative(long long a, long long b) {
    long long res = 1;
    while(b > 0) {
        if(b & 1) {
            res *= a;
        }
        a *= a;
        b >>= 1;
    }
    return res;
}

int main() {
    cout << binPowRecursive(2, 62) << endl;
    cout << binPowIterative(2, 62) << endl;
    return 0;
}
