package net.xy.io;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 创建人：xy
 * 创建时间：13-8-22
 *
 * @version 1.0
 *
 */

public class PrettySize {
	//每KB的字节数
	public static final BigInteger ONE_KB = BigInteger.valueOf(1024);

	//每MB的字节数
	public static final BigInteger ONE_MB = ONE_KB.multiply(ONE_KB);

	//每GB的字节数
	public static final BigInteger ONE_GB = ONE_KB.multiply(ONE_MB);

	//每TB的字节数
	public static final BigInteger ONE_TB = ONE_KB.multiply(ONE_GB);

	//每PB的字节数
	public static final BigInteger ONE_PB = ONE_KB.multiply(ONE_TB);

	//每EB的字节数
	public static final BigInteger ONE_EB = ONE_KB.multiply(ONE_PB);

	//每ZB的字节数
	public static final BigInteger ONE_ZB = ONE_KB.multiply(ONE_EB);

	//每YB的字节数
	public static final BigInteger ONE_YB = ONE_KB.multiply(ONE_ZB);


	/**
	 *	输入文件大小的字节数，返回一个可读性较好的文件大小
	 *  @param size 文件大小,单位：字节
	 *	@return prettyFileSize 可读性较好的文件大小(YB,ZB,EB,PB,TB,GB,MB,KB)
	 *
	 */
	public static String toPrettySize(BigInteger size){
		String displaySize;
		BigDecimal decimalSize = new BigDecimal(size);

		if (size.divide(ONE_YB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = String.valueOf(size.divide(ONE_YB)) + " YB";
		} else if (size.divide(ONE_ZB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_ZB))) + " ZB";
		} else if (size.divide(ONE_EB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_EB))) + " EB";
		} else if (size.divide(ONE_PB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_PB))) + " PB";
		} else if (size.divide(ONE_TB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_TB))) + " TB";
		} else if (size.divide(ONE_GB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_GB))) + " GB";
		} else if (size.divide(ONE_MB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_MB))) + " MB";
		} else if (size.divide(ONE_KB).compareTo(BigInteger.ZERO) > 0) {
			displaySize = getThreeSigFigs(decimalSize.divide(new BigDecimal(ONE_KB))) + " KB";
		} else {
			displaySize = String.valueOf(size) + " bytes";
		}
		return displaySize;
	}

	/**
	 * 保留3个有效数字
	 * 如：1.68KB，108GB
	 * @param displaySize
	 * @return
	 */
	private static String getThreeSigFigs(BigDecimal displaySize) {
		String number = String.valueOf(displaySize);
		StringBuffer trimmedNumber = new StringBuffer();
		int cnt = 0;
		for (char digit : number.toCharArray()) {
			if (cnt < 3) {
				trimmedNumber.append(digit);
			}
			if (digit != '.') {
				cnt++;
			}
		}
		return trimmedNumber.toString();
	}

}
