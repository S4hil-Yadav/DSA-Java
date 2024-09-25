public class BitManipulation {

	public static boolean isEven(int n) {
		n &= 1;
		if(n == 0) {
			return true;
		}
		return false;
	}
	
	public static byte ithBit(int n, int i) {
		n &= 1<<i;
		if(n == 0) {
			return 0;
		}
		return 1;
	}
	
	public static int setIthBit(int n, int i) {
		n |= 1<<i;
		return n; 
	}
	
	public static int clearIthBit(int n, int i) {
		n &= ~(1<<i);
		return n;
	}
	
	public static int updateIthBit(int n, int i, int newBit) {
		n = clearIthBit(n, i);
		n |= newBit<<i;
		return n;
	}
	
	public static int clearLastIBits(int n, int i) {
		n &= (~0)<<i;
		return n;
	}
	
	public static int clearBitsInRange(int n, int i, int j) {
		int bitMask1 = (~0)<<(j+1);
		int bitMask2 = ~((~0)<<i);
		int bitMask = bitMask1 | bitMask2;
		n &= bitMask;
		return n;
	}
	
	public static boolean isPowerOfTwo(int n) {
		return ((n & n-1) == 0);
	}
	
	public static int countSetBits(int n) {
		int count = 0;
		while(n > 0) {
			count += (n & 1);
			n >>= 1;
		}
		return count;
	}
	
	public static int fastExponentiation(int n, int exp) {		// O(log2(exp))
		int product = 1;
		while(exp > 0) {
			if((exp & 1) == 1) {
				product *= n;
			}
			exp >>= 1;
			n *= n;
		}
		return product;
	}
	
	// public static int modularExponentiation(int n, ine exp) {}
	
}
