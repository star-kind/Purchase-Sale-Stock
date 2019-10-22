package com.allstargh.ssm.util;

import java.util.Scanner;

import com.allstargh.ssm.controller.kits.StockControllerUtil;

/**
 * 字符串生成暗号,暗号又还原为字符串
 * 
 * @author admin
 *
 */
public class GenerateCipher {
	StockControllerUtil scUtil = StockControllerUtil.getInstance();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串:");

		String line = null;
		if (scanner.hasNext()) {// 没输入就一直等待输入
			line = scanner.nextLine();
			System.out.println(line);
		}
		scanner.close();

		GenerateCipher cipher = new GenerateCipher();

		String string = cipher.recurringCompare(StockControllerUtil.chars, line.toCharArray());

		String string2 = cipher.reduceByCharIndex(string);

	}

	/**
	 * 在charArray长度范围内,遍历chars数组进行匹配,返回字符匹配一致的下标值, 并将下标值追加为一串字符串
	 * 
	 * @param chars
	 * @param charArray
	 * @return
	 */
	public String recurringCompare(char[] chars, char[] charArray) {
		System.out.println("\n");

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < charArray.length; i++) {
			for (int j = 0; j < chars.length; j++) {
				if (chars[j] == charArray[i]) {
					System.out.print(j);
					builder.append(j + "-");
				}
			}
		}

		System.out.println("\n");

		String build = builder.toString();
		System.out.println("builder: " + build);
		return build;
	}

	/**
	 * 将build字符串还原为原输入之字符串
	 * 
	 * @param build
	 * @return
	 */
	public String reduceByCharIndex(String build) {
		System.out.println("\n");

		StringBuilder b2 = new StringBuilder();

		String[] split = build.split("-");

		for (int i = 0; i < split.length; i++) {
			Integer place = Integer.valueOf(split[i]);
			// System.out.print(chars[place]);
			b2.append(scUtil.chars[place]);
		}

		System.out.println("\n");

		String input = b2.toString();
		System.out.println("复原结果: " + input);

		return input;
	}

}