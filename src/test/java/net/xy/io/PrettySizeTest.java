package net.xy.io;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * 创建人：xy
 * 创建时间：13-8-23
 *
 * @version 1.0
 */

public class PrettySizeTest {
	static public void testToPrettySize(){
		for (Long v:generateData()){
			String s = PrettySize.toPrettySize(BigInteger.valueOf(v));
			System.out.println(s);
		}
	}

	private static List<Long> generateData() {
		return Arrays.asList(new Long[]{0L,27L,999L,1000L,
										1023L,1024L,1728L,110592L,
										7077888L,452984832L,28991029248L,
										1855425871872L,9223372036854775807L});
	}

	public static void main(String[] args) {

		PrettySizeTest.testToPrettySize();
	}

}
