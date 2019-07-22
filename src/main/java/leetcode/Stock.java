package leetcode;

public class Stock {

	public static void main(String[] args) {
		Stock s = new Stock();
		System.out.println(s.maxProfit2(new int[] {7, 1, 5, 3, 6, 4}));
		System.out.println(s.maxProfit2(new int[] {1, 2, 3, 4, 5}));
		System.out.println(s.maxProfit2(new int[] {7, 6, 4, 3, 1}));
		System.out.println(s.maxProfit2(new int[] {}));
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
    
    public int maxProfit2(int[] prices) {
    	if (prices.length == 0) return 0;
    	int min= Integer.MAX_VALUE, max = Integer.MIN_VALUE, profit = 0;
    	for (int i = 0; i < prices.length; i++) {
        	if (prices[i] > max) max = prices[i];
        	if (prices[i] < max) {
        		profit += max - min;
        		min = prices[i]; 
        		max = prices[i];
        	}
        	if (prices[i] < min) {
        		min = prices[i]; 
        		max = prices[i];
        	}
    	}
    	return profit += max - min;
    }
}
