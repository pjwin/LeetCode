package leetcode;

public class IslandPerimeter {

	public static void main(String[] args) {
		
		islandPerimeter(new int [][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}});
	}

	public static void islandPerimeter(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		int area = height * width;
		int[] arr = new int[width * height];
		for (int i = 0; i < height; i++) { // for each row
			for (int j = 0; j < width; j++) { // for each column
				arr[width * i + j] = grid[i][j];
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count += 4;
				if ((i + 1 - width) > 0 && arr[i - width] == 1) {
					count--;
				}
				if ((i + 1 + width) <= area && arr[i + width] == 1) {
					count--;
				}
				if (((i + 1) % width > 0) && arr[i + 1] == 1) {
					count--;
				}
				if ((i % width > 0) && arr[i - 1] == 1) {
					count--;
				}
			}
		}
		System.out.println(count);
	}
}
