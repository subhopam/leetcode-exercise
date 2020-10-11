import java.util.*;
public class PrintDiagnal {

	/**

	**/
	public static void main(String[] args) {
		int n = 3;
		int[][] matrix = {{6, 7, 8}, {3, 4, 5}, {1, 0, 9}};

		recursivePrint(matrix, 0, 0, n);
	}

	public static void recursivePrint(int[][] matrix, int row, int column, int n) {
		if ((row == 0) ) {
			System.out.println(matrix[row][row]);
		}
		if (row == n - 1) {
			System.out.println(matrix[row][row]);
			return;
		}

		recursivePrint(matrix, ++row, ++column, n);
	}

}