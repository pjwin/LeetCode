package leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int mid = left + ((right - left) / 2);
        while (left <= right) {
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
            mid = left + ((right - left) / 2);
        }

        return left;
    }
    boolean isBadVersion(int version) {
        return false;
    }
}
