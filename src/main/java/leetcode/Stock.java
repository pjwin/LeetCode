package leetcode;

public class Stock {

	public static void main(String[] args) {
		Stock s = new Stock();
		System.out.println(s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
	}
	
    public int maxProfit(int[] prices) {
    	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, profit = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] > max) max = prices[i];
        	if (prices[i] < min) {
        		min = prices[i]; 
        		max = prices[i];
        	}
        	if (max - min > profit) profit = max - min;
        }
    	return profit;
    }
}
