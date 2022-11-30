package Codeforces.Easy_Problems_Bootcamp.day2;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class AlmostPrime {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !AlmostPrime.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int n = io.nextInt();
            new AlmostPrime().solution(n);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get("ans.txt")).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else {
                for (int i = 0; i < ansFileText.length; i++) {
                    if (i >= outFileText.length) {
                        System.out.println("<NO OUTPUT> ------> " + ansFileText[i]);
                    } else if (!ansFileText[i].equals(outFileText[i])) {
                        System.out.println(outFileText[i] + " ------> " + ansFileText[i]);
                    } else {
                        System.out.println(outFileText[i]);
                    }
                }
            }
        }
    }

    public void solution(int n) {
        var sieve = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    ++sieve[j];
                }
            }
        }

        int cnt = 0;
        for (int i = 6; i <= n; i++) {
            if (sieve[i] == 2) ++cnt;
        }

        io.println(cnt);
    }

    // Simple idea
    public void solution2(int n) {
        int almostPrimeCount = 0;
        for (int isAmp = 6; isAmp <= n; isAmp++) {
            int divisorCount = 0;
            int temp = isAmp;
            for (int divisor = 2; divisor <= isAmp; divisor++) {
                if (temp % divisor == 0) {
                    ++divisorCount;
                    // now reduce temp
                    while (temp % divisor == 0) {
                        temp /= divisor;
                    }
                }
            }
            if (divisorCount == 2) ++almostPrimeCount;
        }
        io.println(almostPrimeCount);
    }

    public void solution1(int n) {
        //6, 10, 12, 14, 15, 18, 20, 21
        List<Integer> primes = getAllPrimes(n);
        var set = new HashSet<Integer>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = 0; j < primes.size(); j++) {
                if (i == j) continue;
                int a = primes.get(i);
                while (a * primes.get(j) <= n) {
                    int b = primes.get(j);
                    while (a * b <= n) {
                        set.add(a * b);
                        b *= primes.get(j);
                    }
                    a *= primes.get(i);
                }
            }
        }
        io.println(set.size());
    }

    private List<Integer> getAllPrimes(int n) {

        var isComposite = new boolean[n + 1];

        isComposite[0] = isComposite[1] = true;
        int sqrtN = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrtN; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        var list = new ArrayList<Integer>();

        for (int i = 0; i <= n; i++) {
            if (!isComposite[i]) list.add(i);
        }

        return list;
    }

    static class FastIO extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        public FastIO(boolean fileInOut) throws FileNotFoundException {
            super(fileInOut ? new FileOutputStream("out.txt") : System.out, true);
            br = new BufferedReader(new InputStreamReader(fileInOut ? new FileInputStream("in.txt") : System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

/*
Simple Idea
n=int(input())
c2=0
for i in range(6,n+1):
    k=i
    c1=0
    for j in range(2,i):
        if k%j==0:
            while k%j==0:
                k=k/j
            c1+=1
    if c1==2:c2+=1
print(c2)
*/

/*
IDEA of Sieve: GOOD IDEA!
prime = [0 for i in range(3001)]
for i in range(2,3001):
    if(prime[i]):
        continue;
    prime[i]=1
    for x in range(2*i,3001,i):
        prime[x]+=1
n=int(input())
ans = 0
for i in range(1,n+1):
    if prime[i]==2:
        ans+=1
print(ans)
*/

/*
#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin>>n;

	int a[n +1];

	memset(a , 0 , sizeof(a));

	for(int i = 2 ; i <= n ; i++ )
	{
		if(!a[i])
		{

			for(int j = i; j<= n ; j+= i  )
			{
				a[j]++ ;
			}
		}
	}
	int count =0;

	for( int i =0 ; i <= n ; i++ )
	{

		if(a[i]== 2)
		{
			count++ ;
		}
	}

	cout<<count<<endl;

}
 */

/*

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> divisors(n+1); // prime divisors
    for (int i = 2; i < n+1; i++) {
        if (divisors[i] == 0) {
            for (int j = i; j < n+1; j += i) {
                divisors[j]++;
            }
        }
    }
    cout << count(devisors.begin(), devisors.end(), 2);
    return 0;
}

 */