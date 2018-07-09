package leetcode;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(fib(1));
//		System.out.println(fib(2));
//		System.out.println(fib(3));
		System.out.println(fib(4));

	}

	public static int climb(int x) {
		
		
		return 0;
	}
	
	public static int climb2(int x, int y) {
		
		
		return 0;
	}
	
	public static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n + 1; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
