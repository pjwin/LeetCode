package leetcode;

public class NumberCompliment {
	public static void main(String[] args) {
		findComplement(5);
	}
	
    public static void findComplement(int num) {
    	System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(Integer.highestOneBit(num)) + " highest one bit");
        System.out.println(Integer.toBinaryString(Integer.highestOneBit((num) << 1)) + " highest one bit left shift one");
        System.out.println(Integer.toBinaryString(Integer.highestOneBit((num) << 1) -1) + " highest one bit left shift one minus one");
        System.out.println(Integer.toBinaryString(Integer.highestOneBit((num)) -1) + " highest one bit minus one");
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        int mask2 = (Integer.highestOneBit(num) ) - 1;
        System.out.println(Integer.toBinaryString(mask) + " Mask");
        System.out.println(Integer.toBinaryString(mask2) + " Mask2");
        System.out.println(~num);
        num = ~num;
        System.out.println(Integer.toBinaryString(num) + " ~num");
        System.out.println(Integer.toBinaryString(num & mask)+ " ~num & mask");
        System.out.println(Integer.toBinaryString(num & mask2)+ " ~num & mask2");
    }
    
    public static void findComplement2(int num) {
    	System.out.println(num ^ (Integer.MAX_VALUE >>> Integer.numberOfLeadingZeros(num) - 1));
    }
}