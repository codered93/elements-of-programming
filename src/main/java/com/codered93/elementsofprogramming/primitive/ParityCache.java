package com.codered93.elementsofprogramming.primitive;

public class ParityCache {
	/**
	 * Check Parity of a word which is 64 bit long in O(1) time.
	 * Clearly, we cannot cache the parity of every 64-bit integer.
	 * we would need 264 bits of storage, which is of the order of ten trillion 
	 * exabytes. However, when computing the parity of a collection of bits, 
	 * it does not matterhow we group those bits, i.e., the computation is 
	 * associative.Therefore, we can compute the parity of a 64-bit integer 
	 * by grouping its bits into four nonoverlapping 16 bit subwords, 
	 * computing the parity of each subwords, and then computing the parity 
	 * of these four subresults. We choose 16 since 216 = 65536 is relatively small
	 */
	static int preComputedParity[]=new int[65536];
	
	public static void calcParityCache() {
		for(int i=0;i<65536;i++)
			preComputedParity[i]=ParityOfWord.checkParityK((long)i);
	}
	/**
	 * XOR of bits is a parity checker which returns 0 if number of 1's 
	 * are even else returns 1
	 */
	public static short parityCache(long n) {
		final int WORD_SIZE=16;
		final int BIT_MASK=0xFFFF;
		return(short)(
			preComputedParity[(int)((n >>> (3*WORD_SIZE)) & BIT_MASK)]
			^preComputedParity[(int)((n >>> (2*WORD_SIZE)) & BIT_MASK)]
			^preComputedParity[(int)((n >>> (1*WORD_SIZE)) & BIT_MASK)]
			^preComputedParity[(int)((n >>> (0*WORD_SIZE)) & BIT_MASK)]
		);
	}

	public static void main(String[] args) {
		calcParityCache();
		System.out.println(parityCache(555));

	}

}
