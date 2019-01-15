package utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArrays {
	public static void main(String[] args) {
		long[] longList = new long[2000];
		
		Arrays.parallelSetAll(longList, index -> ThreadLocalRandom.current().nextInt(10000));

		Arrays.stream(longList).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		Arrays.parallelSort(longList);
		Arrays.stream(longList).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
}
