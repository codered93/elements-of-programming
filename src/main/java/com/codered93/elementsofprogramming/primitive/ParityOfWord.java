package com.codered93.elementsofprogramming.primitive;

public class ParityOfWord {
	/**
	 * Count the number of set bits in a number
	 * Complexity is O(n) as we traverse across all bits
	 */
	public static short countParity(long n) {
		short result=0;
		while(n!=0) {
			result+=n&1;// count the number of bits which are 1
			n>>>=1;
		}
		return result;
	}
	
	/**
	 * Check parity of a word(parity is 1 if number of set bits are odd else 0)
	 * Complexity is O(n) as we traverse across all bits
	 */
	public static short checkParity(long n) {
		short result=0;
		while(n!=0) {
			result^=n&1;// Set result to 1 if the set bit is 
						//   encountered for odd number of times and 0 if even.
			n>>>=1;
		}
		return result;
	}
	
	/**
	 * Check parity of a word(parity is 1 if number of set bits are odd else 0)
	 * Complexity is O(k) as we erase the lowest set bit in every iteration.
	 */
	public static short checkParityK(long n) {
		short result=0;
		while(n!=0) {
			result^=1;//Toggles the value of result between 0 and 1 after each iteration.
			n &= (n-1);//drop the lowest set bit of n
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(countParity(555));
		System.out.println(checkParity(555));
		System.out.println(checkParityK(555));
	}

}
