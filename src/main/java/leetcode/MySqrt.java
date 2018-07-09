package leetcode;

public class MySqrt {

	public static void main(String[] args) {
		// System.out.println(mySqrt(4));
		// System.out.println(mySqrt(8));
		// System.out.println(mySqrt(200000));
		// System.out.println(mySqrt(Integer.MAX_VALUE));
		// System.out.println(sqrt(4));
		// System.out.println(sqrt(8));
		System.out.println(sqrt(200000));
		System.out.println(sqrt(Integer.MAX_VALUE));
	}

	public static int mySqrt(int x) {
		long r = x;
		int i = 0;
		while (r * r > x) {
			// System.out.println("r: " + r + " r * r: " + r * r);
			r = (r + x / r) / 2;
			i++;
		}
		// System.out.println("r: " + r + " r * r: " + r * r);
		System.out.println("x: " + x + " i: " + i);
		return (int) r;
	}

	public static int sqrt(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = x;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) { // mid * mid > x ?
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

}
