public class PatternPrinting {
	public static void hollowRectangle(int rows, int columns) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				if( i == 1 || i == rows || j == 1 || j == columns ) {
					System.out.print(" *");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void rightHalfPyramid(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=(rows-i); j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	public static void invertedHalfPyramidNum(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=(rows-i+1); j++) {
				System.out.print(" " + j);
			}
			System.out.println();
		}
	}
	public static void floyds_triangle(int rows) {
		int num = 1;
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(" " + num++);
			}
			System.out.println();
		}
	}
	public static void zeroOneTriangle(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=i; j++) {
				if((i + j) % 2 == 0) {
					System.out.print(" 1");
				}
				else {
					System.out.print(" 0");
				}
			}
			System.out.println();
		}
	}
	public static void butterfly(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(" *");
			}
			for(int j=1; j<=(rows-i)*2; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for(int i=rows; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print(" *");
			}
			for(int j=1; j<=(rows-i)*2; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	public static void solidRhombus(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=rows-i; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=rows; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	public static void hollowRhombus(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=rows-i; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=rows; j++) {
				if( i == 1 || i == rows || j == 1 || j == rows ) {
					System.out.print(" *");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void diamond(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=rows-i; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=i*2-1; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for(int i=rows; i>=1; i--) {
			for(int j=1; j<=rows-i; j++) {
				System.out.print("  ");
			}
			for(int j=1; j<=i*2-1; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	public static void pyramidNum(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=rows-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static void palyndromicPyramid(int rows) {
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=rows-i; j++) {
				System.out.print("  ");
			}
			for(int j=i; j>=1; j--) {
				System.out.print(" " + j);
			}
			for(int j=2; j<=i; j++) {
				System.out.print(" " + j);
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		zeroOneTriangle(4);
	}
}