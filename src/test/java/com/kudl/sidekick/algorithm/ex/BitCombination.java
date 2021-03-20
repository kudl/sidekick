package com.kudl.sidekick.algorithm.ex;

public class BitCombination {

	public static void main(final String[] args) {
		final int[] inputs = {2, 3, 5};

		for (int i = 0; i < inputs.length; i++) {
			final double caseCount = Math.pow(2, inputs[i]);

			printBits(inputs[i], caseCount);
			System.out.println("==========");
		}
	}

	private static void printBits(final int input, final double caseCount) {
		for (int i = 0; i < caseCount; i++) {
			System.out.println(String.format("%" + input + "s", Integer.toBinaryString(i)).replace(' ', '0'));
		}
	}
}
