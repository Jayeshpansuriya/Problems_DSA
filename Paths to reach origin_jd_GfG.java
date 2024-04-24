/*
You are standing on a point (x, y) and you want to go to the origin (0, 0) by taking steps either left or down i.e. from each point you are allowed to move either in (x-1, y) or (x, y-1). Find the number of paths from point to origin.

Example 1:

Input:
x = 3, y = 0 
Output: 
1
Explanation: Path used was -  (3,0)  --> ( 2,0) --> (1,0) --> (0,0).We can see that there is no other path than this, so we return 1.
Example 2:

Input:
x = 3, y = 6
Output: 
84 
Explanation:
There are total 84 possible paths.
Your Task:
Since this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function ways() that takes integer x and y as parameters and returns the total number of paths from point(x,y) to the origin(0,0) % 1000000007.

Expected Time Complexity: O(x*y).
Expected Auxiliary Space: O(x*y).

Constraints:
0 ≤ x, y ≤ 500
*/

==================================================================================================================================
class Solution
{
    public static int ways(int n, int m)
    {
        // complete the function
        
        return solve(n,m);
    }
    
    public static int solve(int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 || j==0){
            return 1;
        }
      
        
        int l=solve(i-1,j);
        int r=solve(i,j-1);
        return l+r;
    }
}
====================================================================================================================================
    private static long moduloMultiplication(long a, long b, long mod) {

		long res = 0;

		a %= mod;

		while (b > 0) {

			if ((b & 1) != 0) {
				res = (res + a) % mod;
			}

			a = (2 * a) % mod;

			b >>= 1;
		}
		return res;
	}

	private static long x, y;

	private static long gcdExtended(long a, long b) {

		if (a == 0) {
			x = 0;
			y = 1;
			return b;
		}

		long gcd = gcdExtended(b % a, a);
	
		long x1 = x;
		
		long y1 = y;

		x = y1 - (b / a) * x1;
		
		y = x1;

		return gcd;
	}

	private static long modInverse(long a, long m) {
	
		long g = gcdExtended(a, m);

		if (g != 1)
			return -1;

		return (x % m + m) % m;
	}

	private static long modDivide(long a, long b, long m) {

		a = a % m;
		
		long inv = modInverse(b, m);
		
		if (inv == -1) {
			return 0;
		}
		else {
			return (inv * a) % m;
		}
	}

	private static long nCrModp(long n, long r, long p) {

		if (r > n)
			return 0;

		if (r > n - r)
			r = n - r;

		long x = 1;

		for (long i = 1L; i <= r; i++) {

			x = moduloMultiplication(x, (n + 1L - i), p);

			x = modDivide(x, i, p);
		}

		return x;
	}
