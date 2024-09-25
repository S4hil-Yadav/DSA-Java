public class Basics {
	public static boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static int factorial(int num) {
		int fact = 1;
		for(int i=2; i<=num; i++) {
			fact *= i;
		}
		return fact;
	}
	public static int nCr(int n, int r) {
		if(r > (n - r)) {
			r = (n - r);
		}
		int nCr = 1;
		for(int i=1; i<=r; i++) {
			nCr *= n;
			n--;
		}
		nCr /= factorial(r);
		return nCr;
	}
	public static int binaryToDecimal(int binary) {
		int decimal = 0;
		for(int i=0; binary!=0; i++) {
			int lastDigit = binary % 10;
			decimal += lastDigit * Math.pow(2, i);
			binary /= 10;
		}
		return decimal;
	}
	public static int decimalToBinary(int decimal) {
		int binary = 0;
		for(int i=0; decimal!=0; i++) {
			int prevDigit = decimal % 2;
			binary += prevDigit * Math.pow(10, i);
			decimal /= 2;
		}
		return binary;
	}
}
