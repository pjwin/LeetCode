package leetcode;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(fib(1));
		// System.out.println(fib(2));
		// System.out.println(fib(3));
		 System.out.println(fib(100));
		System.out.println(climbStairs(100));

	}

	public static long fib(int n) {
		long a = 0, b = 1, c;
		if (n == 0)
			return a;
		for (int i = 2; i <= n + 1; i++) {
			System.out.println(i);
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static long climbStairs(int n) {
		long[][] q = { { 1, 1 }, { 1, 0 } };
		long[][] res = pow(q, n);
		return res[0][0];
	}

	public static long[][] pow(long[][] a, int n) {
		long[][] ret = { { 1, 0 }, { 0, 1 } };
		int i = 0;
		while (n > 0) {
			System.out.println(++i);
			if ((n & 1) == 1) {
				ret = multiply(ret, a);
			}
			n >>= 1;
			a = multiply(a, a);
		}
		return ret;
	}

	public static long[][] multiply(long[][] a, long[][] b) {
		long[][] c = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
			}
		}
		return c;
	}
}
