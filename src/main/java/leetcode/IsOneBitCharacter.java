package leetcode;

class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) return true;

        boolean stack = false;
        if (bits[0] == 1) stack = true;

        for (int i = 1; i < bits.length - 1; i++) {
            if (stack == true) {
                stack = false;
            } else if (bits[i] == 1) {
                stack = true;
            }
        }
        return !stack;
    }
    public boolean isOneBitCharacter2(int[] bits) {
        int ones = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) ones++;
        System.out.println(ones);
        return ones % 2 == 0;
    }

    public static void main(String[] args) {
        IsOneBitCharacter ib = new IsOneBitCharacter();
//        System.out.println(ib.isOneBitCharacter2(new int[] {0, 0, 0})); //true
//        System.out.println(ib.isOneBitCharacter2(new int[] {1, 0, 0})); //true
//        System.out.println(ib.isOneBitCharacter2(new int[] {1, 1, 0})); //true
//        System.out.println(ib.isOneBitCharacter2(new int[] {1, 1, 1, 0})); //false
        System.out.println(ib.isOneBitCharacter2(new int[] {0, 0, 0, 1, 0, 1, 0}));

    }
}