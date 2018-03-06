// Ayesha Saleem
// This program asks for a user input of a number n which is the number of grid squares on a side of a matrix. 
// The user then inputs 4n-4 numbers which are used to make the border of an n x n matrix. The program outputs the n x n matrix filled
//if there is a way to move from the start position (which is always one) to the last integer. If not, the program outputs "no alibi". 

import java.util.Scanner;

public class ayeshasa {
static Scanner scan= new Scanner(System.in);
static int n= scan.nextInt();

	public static void main(String args[]){
		int[][] grid= new int [n][n];
		ayeshasa.add(grid);
		int arr[] = ayeshasa.FindStart(grid);
		if(ayeshasa.backtracking(grid,arr[0],arr[1]))
		{
		for(int i=0; i< n; i++){
			for(int j=0; j<n; j++){
			System.out.print(grid[i][j] + " ");
			}
			System.out.println();
			}
		}
		else{
			System.out.println("No Alibi");
		}
	} //end of main method 
	/**
	 * POST CONDITIONS
	 *The method prints the 2 dimensional matrix (array) if backtracking was possible or prints "no alibi" if backtracking was not possible. 
	 */
	/**
	/**
	 * PRE CONDITIONS
	 *grid  is a two dimensional matrix (array) of size n 
	 */
	public static int[] FindStart(int[][] grid){
		int positionArr[]= new int[2];
		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid.length; j++){	
		 if(grid[i][j]==1){
			 positionArr[0]=i; 
			 positionArr[1]=j;
		 }
			}
		}
		return positionArr; 
		
	} //end of FindStart method
	/**
	 * POST CONDITIONS
	 *The method returns a single dimensional array of size 2 that contains the position of the start number (1) in the matrix. 
	 */
	/**
	 * PRE CONDITIONS
	 *grid  is a two dimensional matrix (array) of size n 
	 */
	public static int add(int[][] grid){	
		for (int i = 0; i < n; i++){
			grid[0][i]= scan.nextInt();
		}
		for (int j = 1; j < n; j++){
		 grid[j][n-1]= 	scan.nextInt();
		}
		for (int k = n-2; k >= 0; k--){
			grid[n-1][k]=scan.nextInt();
		}
		for (int m = n-2; m >= 1; m--){
			grid[m][0]= scan.nextInt();
		}
		return 0;
	} // end of add method
	/**
	 * POST CONDITIONS
	 *The method returns zero. 
	 */
	/**
	 * PRE CONDITIONS
	 *grid  is a two dimensional matrix (array) of size n , int row1 and int col1 are your current positions in your matrix. 
	 */
	public static boolean backtracking(int[][] grid, int row1, int col1)
	{
		int n = grid[0].length;
		int row2; 
		int col2;
		int N = n * n;
		if (grid[row1][col1] == N)
			return true;
		for (int i = -1; i <= 1; i++){
			row2 = row1 + i;
			if (row2 >= 0 && row2 < n){
				for (int j = -1; j <= 1; j++){
					col2 = col1 + j;
					if ((i == j) || ((i*-1) == j))
						continue;
					else if (col2 >= 0 && col2 < n){					
						int nextInt = grid[row1][col1] + 1;
						if (grid[row2][col2] == nextInt && backtracking(grid, row2, col2)){
							return true;
						}
						else if (grid[row2][col2] == 0){
							grid[row2][col2] = nextInt;
							if (!backtracking(grid, row2, col2))
								grid[row2][col2] = 0;
							else 
								return true;
						}
					}
				}
			}
		}
		return false;
		} //End of backtracking 
	/**
	 * POST CONDITIONS
	 *The method returns true if backtracking is possible (numbers can move from start number to nxn successfully). Returns false if not. 
	 */
	
} //end of class