#include <iostream>
using namespace std;

int main()
{
    cout << "Hello World!" << endl;
    int n = 45;
    int count[n + 1] = {0};
    count[1] = 1;
    count[2] = 2;
    count[3] = 3;
    for (int i = 4; i <= n; i++)
    {
        count[i] = count[i - 1] + count[i - 2];
    }
    cout << count[n] << endl;
    return 0;
}